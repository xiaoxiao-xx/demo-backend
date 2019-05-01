package com.rainyhon.backend.controller;

import com.rainyhon.common.service.PersonService;
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

	private final PersonService personService;

	@Autowired
	public PersonInfoController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping("add")
	public ResultVo add(@RequestBody PersonInfoVo personInfoVo) {
		return personService.add(personInfoVo);
	}

	@PostMapping("update")
	public ResultVo update(@RequestBody PersonInfoVo personInfoVo) {
		return personService.update(personInfoVo);
	}

	@PostMapping("delete")
	public ResultVo delete(@RequestBody String id) {
		return personService.delete(id);
	}

	@GetMapping("getPersonList")
	public ResultVo getPersonList(@RequestParam(name = "name", required = false) String name,
	                              @RequestParam(name = "deptId", required = false) String deptId,
	                              @RequestParam(name = "pageIndex") Integer pageIndex,
	                              @RequestParam(name = "pageSize") Integer pageSize) {
		return personService.getPersonList(name, deptId, pageIndex, pageSize);
	}

	@GetMapping("list")
	public ResultVo list() {
		return personService.list();
	}

	@PostMapping("importantCare")
	public ResultVo importantCare(@RequestBody PersonInfoVo personInfoVo) {
		return personService.importantCare(personInfoVo);
	}

	@PostMapping("imageAcquisition")
	public ResultVo imageAcquisition(@RequestBody PersonInfoVo personInfoVo) {
		return personService.imageAcquisition(personInfoVo);
	}

	@ApiOperation(value = "首页人员搜索", notes = "首页人员搜索")
	@PostMapping("getPersonInfoByName")
	public ResultVo getPersonInfoByName(@RequestBody SearchVo vo) {
		return personService.getPersonInfoByName(vo);
	}

}
