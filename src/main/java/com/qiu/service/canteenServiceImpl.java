package com.qiu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiu.dao.canteenMapper;
import com.qiu.pojo.canteen;
import com.qiu.pojo.canteenExample;
@Service
public class canteenServiceImpl implements canteenServiceI {

	@Autowired
	canteenMapper cm;
	@Override
	public int addCanteen(canteen canteen) {
		// TODO Auto-generated method stub
		return cm.insertSelective(canteen);
	}

	@Override
	public int delCanteen(int id) {
		// TODO Auto-generated method stub
		return cm.deleteByPrimaryKey(id);
	}

	@Override
	public int modifyCanteen(canteen canteen) {
		// TODO Auto-generated method stub
		return cm.updateByPrimaryKeySelective(canteen);
	}

	@Override
	public canteen getCanteenById(Integer id) {
		// TODO Auto-generated method stub
		return cm.selectByPrimaryKey(id);
	}

	@Override
	public int countCanteen(canteenExample canteenExample) {
		// TODO Auto-generated method stub
		return cm.countByExample(canteenExample);
	}

	@Override
	public int delCanteenByExample(canteenExample canteenExample) {
		// TODO Auto-generated method stub
		return cm.deleteByExample(canteenExample);
	}

	@Override
	public List<canteen> showCanteens(canteenExample canteenExample) {
		// TODO Auto-generated method stub
		return cm.selectByExample(canteenExample);
	}

}
