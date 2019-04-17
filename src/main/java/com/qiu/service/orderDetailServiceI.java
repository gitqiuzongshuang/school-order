package com.qiu.service;

import java.util.List;

import com.qiu.pojo.orderDetail;
import com.qiu.pojo.orderDetailExample;

public interface orderDetailServiceI {

	public int addorderDetail(orderDetail orderDetail);
    public int delorderDetail(int id);
    public int modifyorderDetail(orderDetail orderDetail);
    public orderDetail getOrderDetailById(Integer id);
    public List<orderDetail> getOrderDetailByBelong(Integer belong);
    public int countOrderDetail(orderDetailExample orderDetailExample);
    public int delOrderDetailByExample(orderDetailExample orderDetailExample);
    public List<orderDetail> showOrderDetail(orderDetailExample orderDetailExample);
}
