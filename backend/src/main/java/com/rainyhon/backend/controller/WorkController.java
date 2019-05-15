package com.rainyhon.backend.controller;

import com.rainyhon.common.model.WorkAttendance;
import com.rainyhon.common.service.WorkService;
import com.rainyhon.common.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 考勤
 */
@RestController
@RequestMapping("work")
public class WorkController {

	@Autowired
	private WorkService workService;

	@ApiOperation(value = "查询某人在某天的考勤记录", notes = "查询某人在某天的考勤记录")
	@GetMapping("getWorkAttendanceList")
	public ResultVo getAlarmMode(@RequestParam String personId, @RequestParam Date checkDate) {
		return ResultVo.ok(workService.getWorkAttendanceByPersonIdAndCheckDate(personId, checkDate));
	}

	@ApiOperation(value = "查询某人在某月的考勤记录", notes = "查询某人在某月的考勤记录")
	@GetMapping("getWorkAttendanceListByMonth")
	public ResultVo getWorkAttendanceListByMonth(@RequestParam String personId, @RequestParam Integer year, @RequestParam Integer month) {
		return ResultVo.ok(workService.getWorkAttendanceListByMonth(personId, year, month));
	}

	@GetMapping("getWorkList")
	public ResultVo getWorkAttendanceList(@RequestParam(required = false) String personName,
	                                      @RequestParam(required = false) String orgId,
	                                      @RequestParam(required = false) String history,
	                                      @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
	                                      @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
	                                      @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
	                                      @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		return workService.getWorkAttendanceList(personName, orgId, history, startDate, endDate, pageIndex, pageSize);
	}

	@GetMapping("getWorkStatInfo")
	public ResultVo getWorkStatInfo(@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkDate) {
		return ResultVo.ok(workService.getWorkStatInfo(checkDate));
	}

	@PostMapping("updateWorkAttendance")
	public ResultVo updateWorkAttendanceRecord(@RequestBody WorkAttendance workAttendance) {
		workService.updateWorkAttendance(workAttendance);
		return ResultVo.ok();
	}

}
