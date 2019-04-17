package com.qiu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiu.dao.ordersMapper;
import com.qiu.pojo.orders;
import com.qiu.pojo.ordersExample;

@Service
public class orderServiceImpl implements orderServiceI {

	@Autowired
	ordersMapper om;
	@Override
	public int addorder(orders orders) {
		// TODO Auto-generated method stub
		return om.insertSelective(orders);
	}

	@Override
	public int delorder(int id) {
		// TODO Auto-generated method stub
		return om.deleteByPrimaryKey(id);
	}

	@Override
	public int modifyorder(orders orders) {
		// TODO Auto-generated method stub
		return om.updateByPrimaryKeySelective(orders);
	}

	@Override
	public orders getOrderById(Integer id) {
		// TODO Auto-generated method stub
		return om.selectByPrimaryKey(id);
	}

	@Override
	public orders getOrderByWindow(Integer window) {
		// TODO Auto-generated method stub
		ordersExample example=new ordersExample();
		example.createCriteria().andWindowEqualTo(window);
		List<orders> orders=om.selectByExample(example);
		if(orders.size()>0) {
			return orders.get(0);
		}
		return null;
	}

	@Override
	public orders getOrderByUser(Integer user) {
		// TODO Auto-generated method stub
		ordersExample example=new ordersExample();
		example.createCriteria().andUserEqualTo(user);
		List<orders> orders=om.selectByExample(example);
		if(orders.size()>0) {
			return orders.get(0);
		}
		return null;
	}

	@Override
	public int countOrder(ordersExample ordersExample) {
		// TODO Auto-generated method stub
		return om.countByExample(ordersExample);
	}

	@Override
	public int delOrderByExample(ordersExample ordersExample) {
		// TODO Auto-generated method stub
		return om.deleteByExample(ordersExample);
	}

	@Override
	public List<orders> showOrder(ordersExample ordersExample) {
		// TODO Auto-generated method stub
		return om.selectByExample(ordersExample);
	}

}
