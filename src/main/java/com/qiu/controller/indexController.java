package com.qiu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiu.pojo.admin;
import com.qiu.service.adminServiceI;

@Controller
@RequestMapping("index")
public class indexController {
	@Autowired
	adminServiceI adminServiceI;
	
	@RequestMapping("getAdmin.do")
	@ResponseBody
	public admin getUsername(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Integer id=(Integer) session.getAttribute("adminId");
		if(id!=null) {
			admin admin=adminServiceI.getAdminById(id);
			return admin;
		}
		return null;
	}

}
