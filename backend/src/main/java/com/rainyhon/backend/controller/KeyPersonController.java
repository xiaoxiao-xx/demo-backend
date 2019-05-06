package com.rainyhon.backend.controller;

import com.github.pagehelper.PageInfo;
import com.rainyhon.common.model.KeyPerson;
import com.rainyhon.common.service.KeyPersonService;
import com.rainyhon.common.vo.KeyPersonVo;
import com.rainyhon.common.vo.PersonDeleteVo;
import com.rainyhon.common.vo.ResultVo;
import com.rainyhon.common.vo.IdVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("keyPerson")
public class KeyPersonController {

	@Autowired
	private KeyPersonService keyPersonService;

	@ApiOperation(value = "", notes = "")
	@PostMapping("addKeyPerson")
	public ResultVo addKeyPerson(@RequestBody KeyPerson keyPerson) {
		keyPersonService.addKeyPerson(keyPerson);
		return ResultVo.ok();
	}

	@PostMapping("batchDelete")
	public ResultVo batchDelete(@RequestBody PersonDeleteVo vo) {
		keyPersonService.batchDelete(vo);
		return ResultVo.ok();
	}

	@PostMapping("removeConcern")
	public ResultVo removeConcern(@RequestBody IdVo vo) {
		keyPersonService.deleteById(vo.getId());
		return ResultVo.ok();
	}

	@PostMapping("update")
	public ResultVo update(@RequestBody KeyPerson keyPerson) {
		keyPersonService.update(keyPerson);
		return ResultVo.ok();
	}

	@GetMapping("getKeyPersonList")
	public ResultVo<PageInfo<KeyPersonVo>> getKeyPersonList(@RequestParam Integer pageIndex,
	                                                        @RequestParam Integer pageSize) {
		return ResultVo.ok(keyPersonService.getKeyPersonList(pageIndex, pageSize));
	}

}
