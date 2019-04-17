package com.qiu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.qiu.pojo.Page;
import com.qiu.pojo.dishes;
import com.qiu.pojo.dishesExample;
import com.qiu.pojo.tableResponse;
import com.qiu.service.adminServiceI;
import com.qiu.service.dishesServiceI;

@Controller
@RequestMapping("dishes")
public class dishesController {
	@Autowired
	dishesServiceI dishesServiceI;
	@Autowired
	adminServiceI adminServiceI;
    @RequestMapping("dishesShow.do")
    @ResponseBody
    public Map<String, Object> ShowPhoto(Page page,String context,HttpServletRequest request) {
        dishesExample example = new dishesExample();
        Integer id=(Integer) request.getSession().getAttribute("adminId");
        
        if(id!=null&&context==null) {
        	
        	example.createCriteria().andWindowEqualTo(adminServiceI.getAdminById(id).getWindow());
        }
        else if(id!=null&&context!=null){
        	example.createCriteria().andWindowEqualTo(adminServiceI.getAdminById(id).getWindow()).andNameLike("%"+context+"%");
        }
        List<dishes> list = dishesServiceI.showDish(example);
        int tempMin = Math.min(list.size(), page.getPage() * page.getLimit());
        List<dishes> dishesPages = new ArrayList<>();
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
    @RequestMapping("dishesDel.do")
    @ResponseBody
    public String delDishes(int id) {
    	int r=dishesServiceI.delDish(id);
    	String success="success";
    	String fail="fail";
    	if (r>0) {
			return success;
		}else {
			return fail;
		}
    }
    @RequestMapping("dishesUpload.do")
    @ResponseBody
    public Map<String, Object> imgUpload(@RequestParam(value = "file") MultipartFile img, dishes dishes,HttpSession session) throws IllegalStateException, IOException{
    	Map<String, Object> map=new HashMap<String,Object>();
          Integer id=(Integer) session.getAttribute("adminId");
          if(id!=null) {
        	 dishes.setWindow(adminServiceI.getAdminById(id).getWindow());
        	 String fileUrl=fileController.uploadFile("image",img);
             dishes.setPicurl(fileUrl);
             
             int r=dishesServiceI.addDish(dishes);
             System.out.println(r+"------------"+fileUrl);
             map.put("code", 0);
             map.put("msg", "");
             map.put("data", fileUrl);
          }
          
          
    	return map;
    }
    @RequestMapping("editDish.do")
    @ResponseBody
    public Map<String, Object> editDish(@RequestParam(value = "file") MultipartFile img, dishes dishes) throws IllegalStateException, IOException {
    	Map<String, Object> map=new HashMap<String,Object>();
        if(img!=null) {
      	 String fileUrl=fileController.uploadFile("image",img);
           dishes.setPicurl(fileUrl);
           
           int r=dishesServiceI.modifyDish(dishes);
           System.out.println(r+"------------"+fileUrl);
           map.put("code", 0);
           map.put("msg", "");
           map.put("data", fileUrl);
        }else if(img==null) {
        	
        	int r=dishesServiceI.modifyDish(dishes);
        	System.out.println(r+"------------");
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", "");
		}
             
  	return map;
    }
    @RequestMapping("getData.do")//修改菜品信息时负责赋初值的数据
    @ResponseBody
    public dishes getData(int id) {
    	dishes dishes=dishesServiceI.getDishById(id);
    	return dishes;
    }

}
