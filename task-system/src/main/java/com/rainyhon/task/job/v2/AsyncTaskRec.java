package com.rainyhon.task.job.v2;

import com.google.gson.Gson;
import com.rainyhon.common.cllient.HttpTemplate;
import com.rainyhon.common.mapper.AlarmResultMapper;
import com.rainyhon.common.mapper.InOutRecordMapper;
import com.rainyhon.common.model.*;
import com.rainyhon.common.mq.rabbit.RabbitMQUtil;
import com.rainyhon.common.service.*;
import com.rainyhon.common.service.AlarmPolicyService;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.util.EntityUtils;
import com.rainyhon.common.util.JedisPoolUtil;
import com.rainyhon.common.vo.AlarmResultVo;
import com.rainyhon.common.vo.FaceSdkRecVo;
import com.rainyhon.common.vo.DealResDetailVo;
import com.rainyhon.common.vo.FaceVo;
import com.rainyhon.task.job.v2.policy.AlarmPolicyManager;
import com.rainyhon.task.job.v2.policy.base.IAlarmPolicyChecker;
import com.rainyhon.task.job.v2.policy.entity.AlarmPolicyResult;
import com.rainyhon.task.job.v2.policy.entity.Record;
import com.rainyhon.task.websocket.WebSocketTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.rainyhon.common.constant.Constants.*;
import static com.rainyhon.common.util.CommonUtil.*;

/**
 *
 */
@Component
@Slf4j
public class AsyncTaskRec {

    public static final int Timeout = 3;

    private final HttpTemplate httpTemplate;

    private final MaterialService materialService;

    private final JedisPoolUtil redisUtil;

    private final PersonInfoService personInfoService;

    private final RabbitMQUtil rabbitMQUtil;

    private final AlarmResultService alarmResultService;

    @Autowired
    private InOutRecordMapper inOutRecordMapper;

    @Autowired
    private ScheduleDetailService scheduleDetailService;

    @Autowired
    private RollCallService rollCallService;

    private Gson gson = new Gson();

    @Value("${face.api.ip}")
    private String faceApiIp;

    @Value("${face.api.port}")
    private String faceApiPort;

    private final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(()
            -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"));

    @Autowired
    private WorkService workService;

    @Autowired
    private AlarmPolicyService alarmPolicyService;

    @Autowired
    private AlarmPolicyManager policyManager;

    @Autowired
    private AlarmResultMapper alarmResultMapper;

    @Autowired
    public AsyncTaskRec(HttpTemplate httpTemplate, MaterialService materialService,
                        JedisPoolUtil redisUtil, PersonInfoService personInfoService,
                        RabbitMQUtil rabbitMQUtil, AlarmResultService alarmResultService) {
        this.httpTemplate = httpTemplate;
        this.materialService = materialService;
        this.redisUtil = redisUtil;
        this.personInfoService = personInfoService;
        this.rabbitMQUtil = rabbitMQUtil;
        this.alarmResultService = alarmResultService;
    }

    /**
     * 人脸识别
     */
    @Async
    public void rec(String materialId, String detectResultId, FaceSdkRecVo faceSdkRec) {
        String ret = "";

        try {
            long t1 = System.currentTimeMillis();
            ret = httpTemplate.post(faceApiIp, faceApiPort, "/face/api/v2/rec", faceSdkRec, String.class);
            long time = System.currentTimeMillis() - t1;
            // log.info("rec: {} ms", time);
        } catch (Exception e) {
            log.error("Face detection error", e);
        }

        // 保存人脸识别结果
        DataStructure.DetectResult2 result = gson.fromJson(ret, DataStructure.DetectResult2.class);

        List<DataStructure.FaceInfo> faces = result.getData().getResult();
        if (faces == null) {
            faces = new ArrayList<>();
        }

        List<FaceVo> faceList = convertFaces(materialId, detectResultId, faces);
        if (faceList.size() > 0) {
            // log.info("faceList2 size: {}", faceList2.size());
        }

        for (Face face : faceList) {
            try {
                // Drop the faces which scores under 60
                if (Double.parseDouble(face.getScore()) < 60.00D) {
                    continue;
                }
            } catch (Exception e) {
                log.error("{}", e);
            }

            Material material = materialService.getMaterial(materialId);
            String areaId = material.getAreaId();
            String userId = face.getUserId();
            PersonInfo personInfo = personInfoService.getPersonInfo(userId);

            sendEvent(face);

            // log.info("name: {}", face.getUserId());
            log.info("检测到人脸: {}, 分数: {}", personInfoService.getPersonInfoName(userId), face.getScore());
            // log.info(">>> detect cost=" + (System.currentTimeMillis() - ctm) + "ms, ret=" + ret);

            alarm(face, personInfo.getName());

            // 上次捕获记录
            CaptureRecord captureRecord = getLastOneCaptureRecord(face.getUserId());

            // TODO Test
            // 生成进出记录
            String lastInRecordId = generateInOutRecord(captureRecord, face, areaId);

            // 更新考勤记录
            updateWorkAttendanceRecord(face.getUserId());

            // 更新日程记录
            updateScheduleDetailRecord(face, material);

            // 更新电子点名记录
            updateRollCallResultRecord(face, material);

            // 更新Redis中的记录
            updateRedisRecord(areaId, userId, material, lastInRecordId);

            // 推送人员位置移动信息
            pushPersonMoveInfo(captureRecord, areaId);
        }

        List<Face> faceList1 = listPo2VO(faceList, Face.class);
        materialService.addFaceList(faceList1);
        // log.info("thread id= {}", Thread.currentThread().getName());
    }

    @Autowired
    private WebSocketTask webSocketTask;

    private void pushPersonMoveInfo(CaptureRecord captureRecord, String newAreaId) {
        int timeOut = 4 * 60;

        String oldAreaId = captureRecord.getAreaId();
        String captureTime = captureRecord.getCaptureTime();

        // 区域变动或者捕获时间距离现在超过四分钟就推送一次
        try {
            if (!newAreaId.equals(oldAreaId) ||
                    new DateTime(dateFormat.get().parse(captureTime)).plusSeconds(timeOut).toDate().getTime()
                            < new Date().getTime()) {

                webSocketTask.sendDetailList();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private CaptureRecord getLastOneCaptureRecord(String userId) {
        String key = "user:" + userId;
        List<String> result = redisUtil.hmget(key, "areaId", "lastInRecordId", "captureTime");
        String areaId = result.get(0);
        // 获取上一条数据的记录
        String lastInRecordId = result.get(1);
        String captureTime = result.get(2);

        return new CaptureRecord(areaId, lastInRecordId, captureTime);
    }

    /**
     * 更新Redis中的记录
     */
    private void updateRedisRecord(String areaId, String userId, Material material, String lastInRecordId) {
        // 更新Redis中的记录
        // k-v  k: user_id, v: area_id & capture_time
        // user: xxx
        Map<String, String> map = new HashMap<>();
        map.put("userName", personInfoService.getPersonInfoName(userId));
        map.put("areaId", areaId);
        map.put("captureTime", dateFormat.get().format(material.getCreateTime()));
        map.put("teamId", personInfoService.getPersonInfo(userId).getOrgId());
        map.put("lastInRecordId", lastInRecordId);
        redisUtil.hmset("user:" + userId, map);

        // k-v  k: area_id, v: user_id set
        // area: xxx
        String areaKey = "area:" + areaId;
        // Remove the user from other areas
        for (int i = 1; i < 6; i++) {
            redisUtil.srem("area:" + i, userId);
        }

        // Add the user to the current area
        redisUtil.sadd(areaKey, userId);
    }

    private void updateRollCallResultRecord(Face face, Material material) {
        String userId = face.getUserId();
        String orgId = personInfoService.getPersonInfo(userId).getOrgId();
        String areaId = material.getAreaId();
        Date time = material.getCreateTime();

        List<ScheduleDetail> detailList = scheduleDetailService.getScheduleDetailByTimeForRollCall(orgId, time, areaId);
        if (CommonUtil.isNotEmpty(detailList)) {
            detailList.forEach(scheduleDetail -> {
//				if (scheduleDetail.getRealStartTime() == null) {
//					scheduleDetail.setRealStartTime(time);
//				}
//
//				scheduleDetail.setRealEndTime(time);
//				scheduleDetail.setResult(Constants.ATTENDANCE_RESULT_OK);
//				scheduleDetailService.update(scheduleDetail);

                List<RollCallResult> callResultList = rollCallService.getRollCallResultList(scheduleDetail.getId(), face.getUserId());
                if (CommonUtil.isNotEmpty(callResultList)) {
                    RollCallResult result = callResultList.get(0);
                    result.setResult(ATTENDANCE_RESULT_OK);
                    rollCallService.updateRollCall(result);
                }
            });
        }
    }

    /**
     * 更新日程记录
     *
     * @param face
     * @param material
     */
    private void updateScheduleDetailRecord(Face face, Material material) {
        // 时间，地点，人物
        String userId = face.getUserId();
        String areaId = material.getAreaId();
        Date time = material.getCreateTime();

        List<ScheduleDetail> detailList = scheduleDetailService.getScheduleDetailByTimeAndArea(userId, time, areaId);
        if (CommonUtil.isNotEmpty(detailList)) {
            detailList.forEach(scheduleDetail -> {
                if (scheduleDetail.getRealStartTime() == null) {
                    scheduleDetail.setRealStartTime(time);
                }

                scheduleDetail.setRealEndTime(time);
                scheduleDetail.setResult(ATTENDANCE_RESULT_OK);
                scheduleDetailService.update(scheduleDetail);
            });
        }
    }

    /**
     * 更新考勤记录
     *
     * @param personId
     */
    private void updateWorkAttendanceRecord(String personId) {
        Date checkDate = new Date();
        WorkAttendance attendance = workService.getWorkAttendanceByPersonIdAndCheckDate(personId, checkDate);
        if (attendance == null) {
            WorkAttendance workAttendance = new WorkAttendance();
            workAttendance.setId(CommonUtil.getUUID());
            workAttendance.setPersonId(personId);
            workAttendance.setCheckDate(new Date());
            EntityUtils.setCreateAndUpdateInfo(workAttendance);
            workService.addWorkAttendance(workAttendance);
            attendance = workAttendance;
        }

        if (attendance.getOnWorkTime() == null) {
            attendance.setOnWorkTime(new Date());
        }

        attendance.setQuitTime(new Date());

        WorkCheckTime workCheckTime = workService.getWorkCheckTime();
        Date inTime = workCheckTime.getInTime();
        Date outTime = workCheckTime.getOutTime();

        Date realInTime = attendance.getOnWorkTime();
        Date realOutTime = attendance.getQuitTime();

        LocalTime inTime1 = new LocalTime(inTime);
        LocalTime outTime1 = new LocalTime(outTime);
        LocalTime realInTime1 = new LocalTime(realInTime);
        LocalTime realOutTime1 = new LocalTime(realOutTime);

        // 时间的较只能用时分秒这种LocalTime
        String result = judge(inTime1, outTime1, realInTime1, realOutTime1);
        attendance.setResult(result);

        workService.updateWorkAttendance(attendance);
    }

    /**
     * 判断是否出勤状况
     *
     * @param inTime
     * @param outTime
     * @param realInTime
     * @param realOutTime
     * @return
     */
    private String judge(LocalTime inTime, LocalTime outTime, LocalTime realInTime, LocalTime realOutTime) {
        String result = "";
        // 宽限10分钟
        if (realInTime.isBefore(inTime.plusMinutes(10)) && realOutTime.isAfter(outTime)) {
            // 正常
            result = result + ATTENDANCE_RESULT_OK;
        } else {
            // 迟到
            if (realInTime.isAfter(inTime.plusMinutes(10))) {
                result = result + ATTENDANCE_RESULT_LATE;
            }

            // 早退
            if (realOutTime.isBefore(outTime)) {
                result = result + ATTENDANCE_RESULT_LEAVE_EARLY;
            }
        }
        return result;
    }

    private List<FaceVo> convertFaces(String materialId, String detectResultId, List<DataStructure.FaceInfo> faceInfoList) {
        return faceInfoList.stream().map(faceInfo -> {
            FaceVo face = new FaceVo();

            face.setId(CommonUtil.getUUID());
            face.setMaterialId(materialId);
            face.setCreateTime(getCurrentTime());

            face.setAngle(faceInfo.getAngle());
            face.setCenterX(faceInfo.getCenter_x());
            face.setCenterY(faceInfo.getCenter_y());
            face.setGroupId(faceInfo.getGroup_id());
            face.setUserId(faceInfo.getUser_id());
            face.setHeight(faceInfo.getHeight());
            face.setWidth(faceInfo.getWidth());
            face.setScore(faceInfo.getScore());
            face.setBase64(faceInfo.getBase64());
            face.setDetectResultId(detectResultId);

            return face;
        }).collect(Collectors.toList());
    }

    private String generateInOutRecord(CaptureRecord captureRecord, Face face, String newAreaId) {
        // 距离上次捕获时间太久就认为已经离开
        int timeOut = 5 * 60;

        String areaId = captureRecord.getAreaId();
        // 获取上一条数据的记录
        String lastInRecordId = captureRecord.getLastInRecordId();
        String captureTime = captureRecord.getCaptureTime();

        try {
            if (newAreaId.equals(areaId)
                    && new DateTime(dateFormat.get().parse(captureTime)).plusSeconds(timeOut).toDate().getTime()
                    >= new Date().getTime()) {
                return lastInRecordId;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // TODO 多个线程可能都会读到area == null
        // out record
        if (areaId != null) {
            InOutRecord outRecord = new InOutRecord();
            outRecord.setId(lastInRecordId);
            outRecord.setAreaId(areaId);
            // in_out_record 表 rec_id 字段是 face.id， 即导致进入离开/记录产生的第一条数据的ID
            outRecord.setOutTime(getCurrentTime());
            outRecord.setRecId(face.getId());
            outRecord.setUserId(face.getUserId());
            inOutRecordMapper.updateByPrimaryKeySelective(outRecord);
        }

        // in record
        InOutRecord inRecord = new InOutRecord();
        String inRecordId = CommonUtil.getUUID();
        inRecord.setId(inRecordId);
        inRecord.setAreaId(newAreaId);
        inRecord.setInTime(getCurrentTime());
        inRecord.setRecId(face.getId());
        inRecord.setUserId(face.getUserId());
        inOutRecordMapper.insert(inRecord);

        return inRecordId;
    }

    /**
     * 推送消息
     */
    private void sendEvent(Face face) {
        DealResDetailVo vo = new DealResDetailVo();
        String materialId = face.getMaterialId();
        Material material = materialService.getMaterial(materialId);
        String areaId = material.getAreaId();
        vo.setAddress(((Map<String, String>) alarmPolicyService.getAlarmAddress().getData()).get(areaId));

        vo.setAlarmState(random("是", "否"));
        vo.setAlarmType(random("警告弹出框", "警报声音"));

        String userId = face.getUserId();
        PersonInfo personInfo = personInfoService.getPersonInfo(userId);
        if (personInfo == null) {
            personInfo = new PersonInfo();
        }

        vo.setPersonInfo(personInfo);
        vo.setCharacterInfo(personInfo.getId());

        Date d = face.getCreateTime();
        // 某人离开或者进入区域也要推送消息
        String personName = personInfo.getName();
        vo.setEventInfo("人员：" + personName
                + "，时间：" + new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(d)
                + "，进入" + getAreaName(areaId) + ""
        );

        vo.setResId(CommonUtil.getUUID());
        vo.setSrcId("");
        vo.setTime(getCurrentTime());
        vo.setValidState(random("是", "否"));

        try {
            if (Double.parseDouble(face.getScore()) >= 60.00D) {
                rabbitMQUtil.sendMsg(gson.toJson(vo));
                //
                // String alarmAreaId = "5";
                // if ("1".equals(personInfo.getCurrentOrgId()) && alarmAreaId.equals(areaId)) {
                //     generateAlarmMessage(face, personName);
                // }
            }
        } catch (Exception e) {
            log.error("{}", e);
        }
    }

    private String getAreaName(String areaId) {
        return ((Map<String, String>) alarmPolicyService.getAlarmAddress().getData()).get(areaId);
    }

    /**
     * 告警监测
     *
     * @param face
     * @param personName
     */
    private void alarm(Face face, String personName) {
        Material material = materialService.getMaterial(face.getMaterialId());
        IAlarmPolicyChecker checker = policyManager.getChecker();
        policyManager.getPolicies().forEach(policy -> {
            Record record = new Record(personName, face, material);
            AlarmPolicyResult result = checker.doCheck(policy, record);
            if (result.isSuccess()) {
                alarmResultMapper.insertSelective(result.getResult());
            }
        });
    }

    private void generateAlarmMessage(Face face, String personName) {
        Material material = materialService.getMaterial(face.getMaterialId());
        String areaId = material.getAreaId();
        Date captureTime = material.getCreateTime();

        String reason = "人员：" + personName
                + "，时间：" + new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(captureTime)
                + "，进入" + getAreaName(areaId);

        AlarmResultVo alarm = new AlarmResultVo();
        String uuid = CommonUtil.getUUID();
        alarm.setId(uuid);
        alarm.setOperator("");
        alarm.setRemark("");
        alarm.setState("0");
        alarm.setTriggerTime(getCurrentTime());
        alarm.setObjectId(face.getUserId());
        alarm.setObjectType(random("1", "2"));
        alarm.setAlarmModeType(random("1", "2"));
        alarm.setAlarmReason(reason);
        alarmResultService.add(alarm);
    }

    @Data
    @AllArgsConstructor
    private static class CaptureRecord {

        private String areaId;

        private String lastInRecordId;

        private String captureTime;

    }

}

