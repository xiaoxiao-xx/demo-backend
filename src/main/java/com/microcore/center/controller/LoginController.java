package com.microcore.center.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microcore.center.vo.ResultVo;

@RestController
@RequestMapping("login")
public class LoginController {
	
	public ResultVo login(String username,String password) {
		
		
		
		
		
		return null ;
	}
	
	public ResultVo logout(String username,String password) {
		return null ;
	}
	
}
