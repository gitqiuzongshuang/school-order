package com.qiu.service;

import java.util.List;
import com.qiu.pojo.orders;
import com.qiu.pojo.ordersExample;

public interface orderServiceI {
	public int addorder(orders orders);
    public int delorder(int id);
    public int modifyorder(orders orders);
    public orders getOrderById(Integer id);
    public orders getOrderByWindow(Integer window);
    public orders getOrderByUser(Integer user);
    public int countOrder(ordersExample ordersExample);
    public int delOrderByExample(ordersExample ordersExample);
    public List<orders> showOrder(ordersExample ordersExample);
}
