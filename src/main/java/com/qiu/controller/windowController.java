package com.qiu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiu.pojo.Page;
import com.qiu.pojo.admin;
import com.qiu.pojo.dishes;
import com.qiu.pojo.windows;
import com.qiu.pojo.windowsExample;
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
	@RequestMapping("windowShow.do")
	@ResponseBody
	public Map<String, Object> windowShow(Page page,String context,HttpServletRequest request){
		windowsExample example=new windowsExample();
		if(context!=null) {
			example.createCriteria().andNameLike("%"+context+"%");
		}
		List<windows> list=windowsServiceI.showWindows(example);
		int tempMin = Math.min(list.size(), page.getPage() * page.getLimit());
        List<windows> dishesPages = new ArrayList<>();
        for (int i = (page.getPage() - 1) * page.getLimit(); i < tempMin; i++) {
        	dishesPages.add(list.get(i));
        }
        Map<String, Object> map=new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data", dishesPages);
        return map;
	}
	@RequestMapping("addWindow.do")
	@ResponseBody
	public String addWindow(windows windows) {
		int r=windowsServiceI.addWindow(windows);
		System.out.println(windows.getName());
		System.out.println(windows.getCateen());
		System.out.println(windows.getLocation());
		System.out.println(windows.getNum());
		System.out.println(r);
		if(r>0) {
			System.out.println("成功");
			return "success";
		}
		System.out.println("失败");
		return null;
	}
	@RequestMapping("delWindow.do")
	@ResponseBody
	public String delWindow(int id) {
		int r=windowsServiceI.delWindow(id);
		if(r>0) {
			return "success";
		}
		return null;
	}
	@RequestMapping("getWindows.do")
	@ResponseBody
	public List<windows> getWindows(){
		windowsExample example=new windowsExample();
		List<windows> list=windowsServiceI.showWindows(example);
		return list;
	}

}
