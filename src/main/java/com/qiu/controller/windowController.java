package com.qiu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiu.pojo.admin;
import com.qiu.pojo.windows;
import com.qiu.service.adminServiceI;
import com.qiu.service.windowsServiceI;

@Controller
@RequestMapping("window")
public class windowController {
	@Autowired
	adminServiceI adminServiceI;
	@Autowired
	windowsServiceI windowsServiceI;
	
	@RequestMapping("getWindow.do")
	@ResponseBody
	public windows getWindows(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Integer id=(Integer) session.getAttribute("adminId");
		if(id!=null) {
			admin admin=adminServiceI.getAdminById(id);
			windows windows=windowsServiceI.getWindowById(admin.getWindow());
			return windows;
		}
		return null;
	}
	@RequestMapping("editWindow.do")
	@ResponseBody
	public String edit(windows windows) {
		int r=windowsServiceI.modifyWindow(windows);
		if(r>0) {
			return "success";
		}
		return null;
	}

}
