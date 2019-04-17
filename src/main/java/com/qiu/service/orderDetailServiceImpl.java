package com.qiu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiu.dao.orderDetailMapper;
import com.qiu.pojo.orderDetail;
import com.qiu.pojo.orderDetailExample;

@Service
public class orderDetailServiceImpl implements orderDetailServiceI {

	@Autowired
	orderDetailMapper odm;
	@Override
	public int addorderDetail(orderDetail orderDetail) {
		// TODO Auto-generated method stub
		return odm.insertSelective(orderDetail);
	}

	@Override
	public int delorderDetail(int id) {
		// TODO Auto-generated method stub
		return odm.deleteByPrimaryKey(id);
	}

	@Override
	public int modifyorderDetail(orderDetail orderDetail) {
		// TODO Auto-generated method stub
		return odm.updateByPrimaryKeySelective(orderDetail);
	}

	@Override
	public orderDetail getOrderDetailById(Integer id) {
		// TODO Auto-generated method stub
		return odm.selectByPrimaryKey(id);
	}

	@Override
	public int countOrderDetail(orderDetailExample orderDetailExample) {
		// TODO Auto-generated method stub
		return odm.countByExample(orderDetailExample);
	}

	@Override
	public int delOrderDetailByExample(orderDetailExample orderDetailExample) {
		// TODO Auto-generated method stub
		return odm.deleteByExample(orderDetailExample);
	}

	@Override
	public List<orderDetail> showOrderDetail(orderDetailExample orderDetailExample) {
		// TODO Auto-generated method stub
		List<orderDetail> list=odm.selectByExample(orderDetailExample);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	@Override
	public List<orderDetail> getOrderDetailByBelong(Integer belong) {
		// TODO Auto-generated method stub
		orderDetailExample example=new orderDetailExample();
		example.createCriteria().andBelongEqualTo(belong);
		List<orderDetail> list=odm.selectByExample(example);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

}
