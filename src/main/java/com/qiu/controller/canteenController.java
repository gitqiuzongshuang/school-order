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
import com.qiu.pojo.canteen;
import com.qiu.pojo.canteenExample;
import com.qiu.service.canteenServiceI;

@Controller
@RequestMapping("canteen")
public class canteenController {

	@Autowired
	canteenServiceI csi;
	@RequestMapping("getCanteen.do")
	@ResponseBody
	public List<canteen> getCanteen(){
		canteenExample example=new canteenExample();
		return csi.showCanteens(example);
	}
	
	@RequestMapping("canteenShow.do")
	@ResponseBody
	public Map<String, Object> windowShow(Page page,HttpServletRequest request){
		canteenExample example=new canteenExample();
		List<canteen> list=csi.showCanteens(example);
		int tempMin = Math.min(list.size(), page.getPage() * page.getLimit());
        List<canteen> canteensPages = new ArrayList<>();
        for (int i = (page.getPage() - 1) * page.getLimit(); i < tempMin; i++) {
        	canteensPages.add(list.get(i));
        }
        Map<String, Object> map=new HashMap<String,Object>();
        map.put("code", 0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data", canteensPages);
        return map;
	}
	@RequestMapping("addCanteen.do")
	@ResponseBody
	public String addCanteen(canteen canteen) {
		int r=csi.addCanteen(canteen);
		if (r>0) {
			return "success";
		}
		return "fail";
	}
	@RequestMapping("delCanteen.do")
	@ResponseBody
	public String delCanteen(int id) {
		int r=csi.delCanteen(id);
		if (r>0) {
			return "success";
		}
		return "fail";
	}
}
