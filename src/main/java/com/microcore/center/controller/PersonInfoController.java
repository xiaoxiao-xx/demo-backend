package com.microcore.center.controller;

import com.microcore.center.service.PersonService;
import com.microcore.center.vo.PersonInfoVo;
import com.microcore.center.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("personInfoController")
public class PersonInfoController {
    //TODO 操作记录

	@Autowired
	private PersonService personService;

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
    public ResultVo getPersonList(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String deptId,
                                  @RequestParam(name = "pageIndex") Integer pageIndex,
                                  @RequestParam(name = "pageSize") Integer pageSize){
        return personService.getPersonList(name, deptId, pageIndex, pageSize);
    }

	@PostMapping("importantCare")
	public ResultVo importantCare(@RequestBody PersonInfoVo personInfoVo) {
		return personService.importantCare(personInfoVo);
	}

	@PostMapping("imageAcquisition")
	public ResultVo imageAcquisition(@RequestBody PersonInfoVo personInfoVo) {
		return personService.imageAcquisition(personInfoVo);
	}

}
