package com.rainyhon.task.job.v2.policy.checker;

import com.rainyhon.common.model.AlarmPolicy;
import com.rainyhon.common.model.AlarmResult;
import com.rainyhon.common.service.AlarmPolicyService;
import com.rainyhon.task.job.v2.policy.base.AbstractAlarmPolicyChecker;
import com.rainyhon.task.job.v2.policy.base.LocalExpiredCache;
import com.rainyhon.task.job.v2.policy.entity.AlarmEntity;
import com.rainyhon.task.job.v2.policy.entity.AlarmPolicyResult;
import com.rainyhon.task.job.v2.policy.entity.Record;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static com.rainyhon.common.util.CommonUtil.getUUID;

/**
 * 简单的告警策略检查者
 *
 * @author leizhenyang
 * @date 2019.04.29
 */
public class StayTimeoutAlarmPolicyChecker extends AbstractAlarmPolicyChecker {

    private LocalExpiredCache expired;

    private Map<String, String> addressList;

    public StayTimeoutAlarmPolicyChecker(Map<String, String> addressList) {
        this.expired = new LocalExpiredCache();
        this.addressList = addressList;
    }

    @Override
    public AlarmPolicyResult doCheck(AlarmPolicy policy, Record record) {
        AlarmPolicyResult result = new AlarmPolicyResult();
        String userId = record.getFace().getUserId();
        String areaId = record.getMaterial().getAreaId();
        Date captureTime = record.getFace().getCreateTime();
        // policy
        Integer duration = policy.getDuration();
        String expiredKey = userId + ":" + areaId;
        int expiredTime = duration * 60 * 1000;
        // 逗留时间，已存在则延长，否则指定时间过期
        expired.set(expiredKey, captureTime, expiredTime);
        if (isSameArea(policy, areaId)
                && isBetweenTimePeriod(policy, captureTime)
                && isStayTimeout(expiredKey, captureTime, expiredTime)) {
            String reason = "人员：" + record.getUserName()
                    + "，时间：" + new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(captureTime)
                    + "，在" + addressList.get(areaId) + "逗留超时";
            result.setSuccess(true);
            AlarmResult alarm = new AlarmResult();
            alarm.setId(getUUID());
            alarm.setRemark("");
            // 默认初始告警
            alarm.setState("初始");
            alarm.setTriggerTime(captureTime);
            alarm.setObjectId(userId);
            if (Double.parseDouble(record.getFace().getScore()) >= 60.00D) {
                alarm.setObjectType(AlarmPolicyService.ObjectType.TeamMember);
            } else {
                alarm.setObjectType(AlarmPolicyService.ObjectType.Stranger);
            }
            alarm.setAlarmModeType(policy.getAlarmModeId());
            alarm.setAlarmLevel(policy.getAlarmLevel());
            alarm.setAlarmPolicyId(policy.getId());
            //alarm.setRecId(record.getFace().get);
            alarm.setOperator(policy.getCrtUserId());
            alarm.setAlarmReason(reason);
            result.setResult(alarm);
            expired.remove(expiredKey);
        }
        return result;
    }

    private boolean isSameArea(AlarmPolicy policy, String areaId) {
        return policy.getAreaId().equals(areaId);
    }


    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    /**
     * 时间段内
     */
    private boolean isBetweenTimePeriod(AlarmPolicy policy, Date date) {
        String format = DATE_FORMAT.format(date);
        Date bTime = policy.getBeginTime();
        Date eTime = policy.getEndTime();
        Date cTime = new Date(format);
        // bTime < date < eTime
        return cTime.after(bTime) && cTime.before(eTime);
    }

    /**
     * 逗留超时
     *
     * @param expiredKey
     * @param currentTime
     * @param expiredTime
     * @return
     */
    private boolean isStayTimeout(String expiredKey, Date currentTime, int expiredTime) {
        AlarmEntity alarmEntity = expired.get(expiredKey);
        // 首次进入该区域时间
        long fTime = alarmEntity.getFirstTime().getTime();
        // 当前时间
        long cTime = currentTime.getTime();
        if (cTime - fTime > expiredTime) {
            // 逗留时间超过
            return true;
        }
        return false;
    }
}
