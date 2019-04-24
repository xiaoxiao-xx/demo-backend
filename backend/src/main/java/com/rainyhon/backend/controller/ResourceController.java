package com.rainyhon.backend.controller;

import com.microcore.center.model.Resource;
import com.microcore.center.service.ResourceService;
import com.microcore.center.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@GetMapping("getResourceList")
	public ResultVo getResourceList(@RequestParam Integer pageIndex,
	                           @RequestParam Integer pageSize) {
		return ResultVo.ok(resourceService.getResourceList(pageIndex, pageSize));
	}

	@PostMapping("addResource")
	public ResultVo addResource(@RequestBody Resource vo) {
		resourceService.addResource(vo);
		return ResultVo.ok();
	}

	@PostMapping("deleteResourceById")
	public ResultVo deleteResourceById(@RequestParam String id) {
		resourceService.deleteResourceById(id);
		return ResultVo.ok();
	}

	@PostMapping("batchDelete")
	public ResultVo batchDelete(@RequestBody List<String> idList) {
		resourceService.batchDelete(idList);
		return ResultVo.ok();
	}

	@PostMapping("updateResource")
	public ResultVo updateResource(@RequestBody Resource vo) {
		resourceService.updateResource(vo);
		return ResultVo.ok();
	}

}
