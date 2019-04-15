package com.qiu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiu.dao.dishesMapper;
import com.qiu.pojo.dishes;
import com.qiu.pojo.dishesExample;
@Service
public class dishesServiceImpl implements dishesServiceI {
	@Autowired
	dishesMapper dishesMapper;

	@Override
	public int addDish(dishes dishes) {
		// TODO Auto-generated method stub
		return dishesMapper.insertSelective(dishes);
	}

	@Override
	public int delDish(int id) {
		// TODO Auto-generated method stub
		return dishesMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int modifyDish(dishes dishes) {
		// TODO Auto-generated method stub
		return dishesMapper.updateByPrimaryKeySelective(dishes);
	}

	@Override
	public dishes getDishById(Integer id) {
		// TODO Auto-generated method stub
		return dishesMapper.selectByPrimaryKey(id);
	}

	@Override
	public int countDish(dishesExample dishesExample) {
		// TODO Auto-generated method stub
		return dishesMapper.countByExample(dishesExample);
	}

	@Override
	public int delDishByExample(dishesExample dishesExample) {
		// TODO Auto-generated method stub
		return dishesMapper.deleteByExample(dishesExample);
	}


	@Override
	public List<dishes> showDish(dishesExample dishesExample) {
		// TODO Auto-generated method stub
		return dishesMapper.selectByExample(dishesExample);
	}

}
