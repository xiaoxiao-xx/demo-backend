package com.microcore.center.controller;

import com.microcore.center.service.TrackService;
import com.microcore.center.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("track")
public class TrackController {
    
    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("getTrackInfo")
    public ResultVo getTrackInfo(@RequestParam String userId){
        return trackService.getTrackInfo(userId);
    }

}
