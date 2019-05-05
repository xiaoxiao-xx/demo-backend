package com.rainyhon.backend.controller;

import com.rainyhon.common.service.TrackService;
import com.rainyhon.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("track")
public class TrackController {

	private final TrackService trackService;

	@Autowired
	public TrackController(TrackService trackService) {
		this.trackService = trackService;
	}

	@GetMapping("getTrackInfo")
	public ResultVo getTrackInfo(@RequestParam String userId,
	                             @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss SSS") Date time) {
		return trackService.getTrackInfo2(userId, time);
	}

	@GetMapping("getInOutTrackInfo")
	public ResultVo getInOutTrackInfo(@RequestParam String userId) {
		return trackService.getInOutTrack(userId);
	}

	@GetMapping("getTrackPieChart")
	public ResultVo getPieChart(@RequestParam String userId,
	                            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss SSS") Date time) {
		return trackService.getPieChart(userId, time);
	}

	@GetMapping("getInOutTrackInfoList")
	public ResultVo getInOutTrackInfoList(@RequestParam(required = false) String areaId,
	                                      @RequestParam Integer pageIndex,
	                                      @RequestParam Integer pageSize) {
		return trackService.getInOutTrackList(areaId, pageIndex, pageSize);
	}

}
