package com.qiu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiu.pojo.Page;
import com.qiu.pojo.orderDetail;
import com.qiu.service.orderDetailServiceI;

@Controller
@RequestMapping("orderDetail")
public class orderDetailController {
	@Autowired
	orderDetailServiceI orderDetailServiceI;
	@RequestMapping("detailShow.do")
	@ResponseBody
	public Map<String, Object> detailShow(Page page,String context,HttpServletRequest request,int belong) {
		List<orderDetail> list=orderDetailServiceI.getOrderDetailByBelong(belong);
		System.out.println(list.size());
		int tempMin = Math.min(list.size(), page.getPage() * page.getLimit());
        List<orderDetail> orderPages = new ArrayList<>();
        for (int i = (page.getPage() - 1) * page.getLimit(); i < tempMin; i++) {
        	orderPages.add(list.get(i));
        }
		Map<String, Object> map=new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data", orderPages);
		return map;
	}
}
