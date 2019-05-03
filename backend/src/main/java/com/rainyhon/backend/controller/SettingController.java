package com.rainyhon.backend.controller;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.model.WorkCheckTime;
import com.rainyhon.common.model.WorkExemption;
import com.rainyhon.common.model.WorkHolidayCalendar;
import com.rainyhon.common.service.SettingService;
import com.rainyhon.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("setting")
public class SettingController {

	@Autowired
	private SettingService settingService;

	@PostMapping("addCheckTime")
	public ResultVo<?> setCheckTime(@RequestBody WorkCheckTime checkTime) {
		settingService.addCheckTime(checkTime);
		return ResultVo.ok();
	}

	@PostMapping("deleteCheckTime")
	public ResultVo<?> deleteCheckTime(@RequestParam String id) {
		settingService.deleteCheckTime(id);
		return ResultVo.ok();
	}

	@PostMapping("updateCheckTime")
	public ResultVo<?> updateCheckTime(@RequestBody WorkCheckTime workCheckTime) {
		settingService.updateCheckTime(workCheckTime);
		return ResultVo.ok();
	}

	@GetMapping("getCheckTime")
	public ResultVo<?> updateCheckTime() {
		return ResultVo.ok(settingService.getCheckTime());
	}

	@PostMapping("addExemptionPerson")
	public ResultVo<?> addExemptionPerson(@RequestBody WorkExemption exemption) {
		settingService.addExemptionPerson(exemption);
		return ResultVo.ok();
	}

	@PostMapping("addExemptionPersonList")
	public ResultVo<?> addExemptionPerson(@RequestBody List<WorkExemption> exemptionList) {
		settingService.addExemptionPersonList(exemptionList);
		return ResultVo.ok();
	}

	@PostMapping("deleteExemptionPerson")
	public ResultVo<?> deleteExemptionPerson(@RequestParam String id) {
		settingService.deleteExemptionPerson(id);
		return ResultVo.ok();
	}

	@PostMapping("updateExemptionPerson")
	public ResultVo<?> updateExemptionPerson(@RequestBody WorkExemption workExemption) {
		settingService.updateExemptionPerson(workExemption);
		return ResultVo.ok();
	}

	@GetMapping("getExemptionPersonList")
	public ResultVo<?> getExemptionPersonList(@RequestParam Integer pageIndex,
	                                          @RequestParam Integer pageSize) {
		return ResultVo.ok(settingService.getExemptionPersonList(pageIndex, pageSize));
	}

	@GetMapping("getAllExemptionPersons")
	public ResultVo<?> getAllExemptionPersons() {
		return ResultVo.ok(settingService.getAllExemptionPersons());
	}

	@PostMapping("addHolidayCalendar")
	public ResultVo<?> addHolidayCalendar(@RequestBody WorkHolidayCalendar calendar) {
		settingService.addHolidayCalendar(calendar);
		return ResultVo.ok();
	}

	@PostMapping("updateHolidayCalendar")
	public ResultVo<?> updateHolidayCalendar(@RequestBody WorkHolidayCalendar calendar) {
		settingService.updateHolidayCalendar(calendar);
		return ResultVo.ok();
	}

	@PostMapping("deleteHolidayCalendar")
	public ResultVo<?> deleteHolidayCalendar(@RequestParam String id) {
		settingService.deleteHolidayCalendar(id);
		return ResultVo.ok();
	}

	@GetMapping("getHolidayCalendarList")
	public ResultVo<PageInfo<WorkHolidayCalendar>> getHolidayCalendarList(@RequestParam Integer pageIndex,
	                                                                      @RequestParam Integer pageSize) {
		return ResultVo.ok(settingService.getHolidayCalendarList(pageIndex, pageSize));
	}

}
