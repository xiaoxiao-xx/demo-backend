package com.rainyhon.backend.controller;

import com.rainyhon.common.service.PersonInfoService;
import com.rainyhon.common.vo.PersonDeleteVo;
import com.rainyhon.common.vo.PersonInfoVo;
import com.rainyhon.common.vo.ResultVo;
import com.rainyhon.common.vo.SearchVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("personInfoController")
public class PersonInfoController {

	// TODO 操作记录

	private final PersonInfoService personInfoService;

	@Autowired
	public PersonInfoController(PersonInfoService personInfoService) {
		this.personInfoService = personInfoService;
	}

	@PostMapping("add")
	public ResultVo add(@RequestBody PersonInfoVo personInfoVo) {
		return personInfoService.add(personInfoVo);
	}

	@PostMapping("update")
	public ResultVo update(@RequestBody PersonInfoVo personInfoVo) {
		return personInfoService.update(personInfoVo);
	}

	@PostMapping("delete")
	public ResultVo delete(@RequestBody PersonDeleteVo vo) {
		return personInfoService.delete(vo);
	}

	@GetMapping("getPersonList")
	public ResultVo getPersonList(@RequestParam(name = "name", required = false) String name,
	                              @RequestParam(name = "deptId", required = false) String deptId,
	                              @RequestParam(name = "pageIndex") Integer pageIndex,
	                              @RequestParam(name = "pageSize") Integer pageSize) {
		return personInfoService.getPersonList(name, deptId, pageIndex, pageSize);
	}

	@GetMapping("getPersonListByOrgId")
	public ResultVo getPersonListByOrgId(@RequestParam(name = "orgId", required = false) String orgId) {
		return personInfoService.getPersonListByOrgId(orgId);
	}

	@GetMapping("list")
	public ResultVo list() {
		return personInfoService.list();
	}

	@PostMapping("importantCare")
	public ResultVo importantCare(@RequestBody PersonInfoVo personInfoVo) {
		return personInfoService.importantCare(personInfoVo);
	}

	@PostMapping("imageAcquisition")
	public ResultVo imageAcquisition(@RequestBody PersonInfoVo personInfoVo) {
		return personInfoService.imageAcquisition(personInfoVo);
	}

	@ApiOperation(value = "首页人员搜索", notes = "首页人员搜索")
	@PostMapping("getPersonInfoByName")
	public ResultVo getPersonInfoByName(@RequestBody SearchVo vo) {
		return personInfoService.getPersonInfoByName(vo);
	}

	@GetMapping("getPersonInfoById")
	public ResultVo<?> getPersonInfoById(@RequestParam String id) {
		return personInfoService.getPersonInfoById(id);
	}

}
