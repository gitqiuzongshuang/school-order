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
import com.qiu.pojo.orders;
import com.qiu.pojo.ordersExample;
import com.qiu.service.adminServiceI;
import com.qiu.service.orderServiceI;

@Controller
@RequestMapping("order")
public class orderController {
	@Autowired
	orderServiceI orderServiceI;
	@Autowired
	adminServiceI adminServiceI;
	@RequestMapping("orderShow.do")
	@ResponseBody
	public Map<String, Object> orderShow(Page page,String context,HttpServletRequest request) {
		
	        ordersExample example = new ordersExample();
	        Integer id=(Integer) request.getSession().getAttribute("adminId");
	        
	        if(id!=null&&context==null) {
	        	
	        	example.createCriteria().andWindowEqualTo(adminServiceI.getAdminById(id).getWindow());
	        }
	        else if(id!=null&&context!=null){
	        	example.createCriteria().andWindowEqualTo(adminServiceI.getAdminById(id).getWindow()).andNumEqualTo(Integer.valueOf(context));
	        }
	        List<orders> list = orderServiceI.showOrder(example);
	        for (orders orderItem : list) {  //订单状态
				if(orderItem.getStatus()==0) {
					orderItem.setStatusName("烹饪中");
				}else if (orderItem.getStatus()==1) {
					orderItem.setStatusName("烹饪完成");
				}else if (orderItem.getStatus()==2) {
					orderItem.setStatusName("已取餐");
				}
			}
	        int tempMin = Math.min(list.size(), page.getPage() * page.getLimit());
	        List<orders> orderPages = new ArrayList<>();
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
	
	@RequestMapping("delOrder.do")
	@ResponseBody
	public String delOrder(int id) {
		int r=orderServiceI.delorder(id);
		if (r>0) {
			
			return "success";
		}else {
			return "fail";
		}
	}
	
	@RequestMapping("gotIt.do")
	@ResponseBody
	public String gotIt(int id) {
		orders orders=orderServiceI.getOrderById(id);
		orders.setStatus(1);
		int r=orderServiceI.modifyorder(orders);
		if (r>0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
}
