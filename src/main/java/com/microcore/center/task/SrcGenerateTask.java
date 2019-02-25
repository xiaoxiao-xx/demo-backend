package com.microcore.center.task;

import java.text.SimpleDateFormat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.microcore.center.model.PsmPersonInfo;
import com.microcore.center.model.PsmSrcRecord;
import com.microcore.center.service.DealResultDetailService;
import com.microcore.center.service.PersonService;
import com.microcore.center.service.RealAlarmService;
import com.microcore.center.service.SrcRecordService;
import com.microcore.center.util.CommonUtil;
import com.microcore.center.util.RabbitMQUtil;
import com.microcore.center.vo.PsmDealResDetailVo;
import com.microcore.center.vo.PsmRealAlarmVo;

/**
 * 素材记录产生任务
 *
 * @author Administrator
 *
 */
@Component
public class SrcGenerateTask {

	private static BlockingQueue<PsmSrcRecord> QUEUE_SRC = new LinkedBlockingQueue<>();

	@Autowired
	private SrcRecordService srcRecordService;
	@Autowired
	private DealResultDetailService dealResultDetailService ;
	@Autowired
	private RabbitMQUtil rabbitMQUtil ;
	@Autowired
	private PersonService personService ;
	@Autowired
	private RealAlarmService realAlarmService ;
	/**
	 * 初始化加载素材
	 */
	/*
	@PostConstruct
	public void init() {
		List<PsmSrcRecord> list = srcRecordService.getPsmSrcRecord("1");
		list.forEach((srcRecord) -> QUEUE_SRC.offer(srcRecord));
	}
	*/

	/**
	 * 5秒心跳一次
	 *      创建素材
	 */
	@Scheduled(fixedRate = 5000)
	public void gnerate() {
		PsmSrcRecord srcRecord = new PsmSrcRecord();
		srcRecord.setCreateType(random("自动采集","主动采集"));
		srcRecord.setSrcType(random("图像","视频","位置"));
		srcRecord.setGetEventId(random("电子点名","记录点名"));
		srcRecord.setSrcAddress(random("食堂","教学楼","教师宿舍","仓库","生物园地","门卫室","乒乓球台","篮球场","少年宫","办公楼"));
		srcRecord.setSrcState("1");
		srcRecord.setSrcDevice(CommonUtil.getUUID());
		if (QUEUE_SRC.offer(srcRecord)) {
			srcRecordService.add(srcRecord);
		}
	}

	/**
	 * 1秒心跳一次
	 */
	@Scheduled(fixedRate = 1000)
	public void analysis() {
		try {
			PsmSrcRecord psmSrcRecord = QUEUE_SRC.poll(1, TimeUnit.SECONDS);
			if(psmSrcRecord == null || returnFlag()) {
				return;
			}
			psmSrcRecord.setSrcState("2");
			srcRecordService.update(psmSrcRecord);
			PsmDealResDetailVo vo = new PsmDealResDetailVo() ;
			vo.setAddress(random("食堂","教学楼","教师宿舍","仓库","生物园地","门卫室","乒乓球台","篮球场","少年宫","办公楼"));
			vo.setAlarmState(random("是","否"));
			vo.setAlarmType(random("警告弹出框","警报声音"));
			PsmPersonInfo psmPersonInfo = personService.getRadomPerson();
			vo.setPsmPersonInfo(psmPersonInfo);
			vo.setCharacterInfo(psmPersonInfo.getPersonId());
			vo.setEventInfo("人员："+psmPersonInfo.getName() + "，时间："
					+ new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(CommonUtil.getCurrentTime())
					+ random(
							"，进入非法区域(" + random("食堂", "教学楼", "教师宿舍", "仓库", "生物园地", "门卫室", "乒乓球台", "篮球场", "少年宫", "办公楼")
									+ ")！",
							"，区域："+random("食堂", "教学楼", "教师宿舍", "仓库", "生物园地", "门卫室", "乒乓球台", "篮球场", "少年宫", "办公楼") + "，集合缺勤"));
			vo.setResId(CommonUtil.getUUID());
			vo.setSrcId(psmSrcRecord.getId());
			vo.setTime(CommonUtil.getCurrentTime());
			vo.setValidState(random("是","否"));
			dealResultDetailService.add(vo);
			// vo to json
			rabbitMQUtil.sendMsg(vo.getEventInfo());

			PsmRealAlarmVo alarmVo = new PsmRealAlarmVo();
			alarmVo.setAlarmReason(vo.getEventInfo());
			alarmVo.setAlarmType(random("1","2"));
			alarmVo.setObjectId(psmPersonInfo.getPersonId());
			alarmVo.setObjectType(random("1","2"));
			alarmVo.setTriggerTime(CommonUtil.getCurrentTime());
			alarmVo.setState("0");
			realAlarmService.add(alarmVo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private boolean returnFlag() {
	  if (Math.random() * 100 > 10) { // 10%的概率
		  return true;
	  }
	  return false;
	}

	private String random(String... type) {
		return type[(int) (Math.random() * type.length)];
	}
}
