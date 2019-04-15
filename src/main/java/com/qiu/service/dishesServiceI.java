package com.qiu.service;

import java.util.List;

import com.qiu.pojo.dishes;
import com.qiu.pojo.dishesExample;

public interface dishesServiceI {

	public int addDish(dishes dishes);
    public int delDish(int id);
    public int modifyDish(dishes dishes);
    public dishes getDishById(Integer id);
    public int countDish(dishesExample dishesExample);
    public int delDishByExample(dishesExample dishesExample);
    public List<dishes> showDish(dishesExample dishesExample);
}
