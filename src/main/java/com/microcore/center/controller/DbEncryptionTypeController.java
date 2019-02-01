package com.microcore.center.controller;

import com.microcore.center.model.DbEncryptionType;
import com.microcore.center.service.DbEncryptionTypeService;
import com.microcore.common.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("encryptionType")
public class DbEncryptionTypeController {

	@Autowired
	private DbEncryptionTypeService dbEncryptionTypeService;

	@PostMapping("addEncryptionType")
	public ResultVo<?> addEncryptionType(@RequestBody DbEncryptionType type) {
		dbEncryptionTypeService.addEncryptionType(type);
		return ResultVo.ok();
	}

	@PostMapping("updateEncryptionType")
	public ResultVo<?> updateEncryptionType(@RequestBody DbEncryptionType type) {
		dbEncryptionTypeService.updateEncryptionType(type);
		return ResultVo.ok();
	}

	@GetMapping("getEncryptionTypeList")
	public ResultVo<List<DbEncryptionType>> getEncryptionTypeList() {
		List<DbEncryptionType> encryptionTypeList = dbEncryptionTypeService.getEncryptionTypeList();
		return ResultVo.ok(encryptionTypeList);
	}

	@GetMapping("getEncryptionTypeById")
	public ResultVo<DbEncryptionType> getEncryptionTypeById(@RequestParam String id) {
		DbEncryptionType encryptionType = dbEncryptionTypeService.getEncryptionTypeById(id);
		return ResultVo.ok(encryptionType);
	}

	@GetMapping("deleteEncryptionType")
	public ResultVo<?> deleteEncryptionType(@RequestParam String id) {
		dbEncryptionTypeService.deleteEncryptionType(id);
		return ResultVo.ok();
	}

}

