package com.qiu.service;

import java.util.List;

import com.qiu.pojo.canteen;
import com.qiu.pojo.canteenExample;

public interface canteenServiceI {
	public int addCanteen(canteen canteen);
    public int delCanteen(int id);
    public int modifyCanteen(canteen canteen);
    public canteen getCanteenById(Integer id);
    public int countCanteen(canteenExample canteenExample);
    public int delCanteenByExample(canteenExample canteenExample);
    public List<canteen> showCanteens(canteenExample canteenExample);
}
