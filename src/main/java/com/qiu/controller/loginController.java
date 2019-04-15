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
@RequestMapping("login")
public class loginController {
	@Autowired
	adminServiceI adminServiceI;
	
	@RequestMapping("login.do")
	@ResponseBody
	public String login(HttpServletRequest request,admin admin) {
		admin admin2 =adminServiceI.login(admin);
		if(admin2!=null) {
			admin2=adminServiceI.getAdminByaccount(admin2.getAccount());
			HttpSession session=request.getSession();
			session.setAttribute("adminId", admin2.getId());
			return "1";
		}
		else {
			return "fail";
		}
		
	}

	@RequestMapping("quit.do")
	@ResponseBody
	public String quit(HttpServletRequest request) {
		System.out.println("进入quit");
		HttpSession session=request.getSession();
		session.invalidate();
		return "success";
	}

}
