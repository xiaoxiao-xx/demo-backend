package com.rainyhon.backend.controller;

import com.rainyhon.common.model.WorkAttendance;
import com.rainyhon.common.service.WorkService;
import com.rainyhon.common.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

	@PostMapping("updateWorkAttendanceRecord")
	public ResultVo updateWorkAttendanceRecord(@RequestBody WorkAttendance workAttendance) {
		workService.updateWorkAttendance(workAttendance);
		return ResultVo.ok();
	}

}
