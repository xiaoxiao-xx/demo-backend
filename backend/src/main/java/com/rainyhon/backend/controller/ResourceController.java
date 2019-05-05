package com.rainyhon.backend.controller;

import com.rainyhon.common.model.Resource;
import com.rainyhon.common.service.ResourceService;
import com.rainyhon.common.vo.ResultVo;
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

	@GetMapping("getAllResources")
	public ResultVo getAllResources() {
		return ResultVo.ok(resourceService.getAllResources());
	}

	@PostMapping("addResource")
	public ResultVo addResource(@RequestBody Resource resource) {
		resourceService.addResource(resource);
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
