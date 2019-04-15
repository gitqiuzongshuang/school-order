package com.qiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiu.service.adminServiceI;

@Controller
@RequestMapping("/admin")
public class adminController {
	@Autowired
	adminServiceI IAdminService;
	
	@ResponseBody
	@RequestMapping("/hello.do")
	public String test() {
		System.out.println(IAdminService.getAdminById(1).getName());
		return "";
	}

}
