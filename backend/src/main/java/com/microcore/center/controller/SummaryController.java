package com.microcore.center.controller;

import com.microcore.center.service.SummaryService;
import com.microcore.center.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 汇总结果
 */
@RestController
@RequestMapping("summary")
public class SummaryController {

	private final SummaryService summaryService;

	@Autowired
	public SummaryController(SummaryService summaryService) {
		this.summaryService = summaryService;
	}

	@ApiOperation(value = "", notes = "")
	@GetMapping("getSummary")
	public ResultVo getSummary(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
		return ResultVo.ok(summaryService.getSummary(pageIndex, pageSize));
	}

	@ApiOperation(value = "", notes = "")
	@GetMapping("getDetailList")
	public ResultVo getDetailList(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
		return ResultVo.ok(summaryService.getDetailList(pageIndex, pageSize));
	}

}
