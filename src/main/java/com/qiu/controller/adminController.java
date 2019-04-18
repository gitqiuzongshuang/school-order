package com.qiu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiu.pojo.Page;
import com.qiu.pojo.admin;
import com.qiu.pojo.adminExample;
import com.qiu.pojo.windows;
import com.qiu.pojo.windowsExample;
import com.qiu.service.adminServiceI;

@Controller
@RequestMapping("admin")
public class adminController {
	@Autowired
	adminServiceI adminServiceI;
	
	@ResponseBody
	@RequestMapping("adminShow.do")
	public Map<String, Object> windowShow(Page page,String context,HttpServletRequest request){
		adminExample example=new adminExample();
		if(context!=null) {
			example.createCriteria().andNameLike("%"+context+"%");
		}
		List<admin> list=adminServiceI.showAdmin(example);
		int tempMin = Math.min(list.size(), page.getPage() * page.getLimit());
        List<admin> adminPages = new ArrayList<>();
        for (int i = (page.getPage() - 1) * page.getLimit(); i < tempMin; i++) {
        	adminPages.add(list.get(i));
        }
        Map<String, Object> map=new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data", adminPages);
        return map;
	}
	@RequestMapping("addAdmin.do")
	@ResponseBody
	public String addadmin(admin admin) {
		admin.setAuthority(0);
		Date date=new Date();
		admin.setLastdate(date);
		int r=adminServiceI.addAdmin(admin);
		if (r>0) {
			return "success";
		}
		return "fail";
	}
	@RequestMapping("delAdmin.do")
	@ResponseBody
	public String delAdmin(int id) {
		int r=adminServiceI.delAdmin(id);
		if (r>0) {
			return "success";
		}
		return "fail";
	}
}
