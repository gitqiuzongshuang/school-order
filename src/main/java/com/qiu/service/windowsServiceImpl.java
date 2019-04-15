package com.qiu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiu.dao.windowsMapper;
import com.qiu.pojo.windows;
import com.qiu.pojo.windowsExample;
@Service
public class windowsServiceImpl implements windowsServiceI {

	@Autowired
	windowsMapper windowsMapper;
	@Override
	public int addWindow(windows windows) {
		// TODO Auto-generated method stub
		return windowsMapper.insert(windows);
	}

	@Override
	public int delWindow(int id) {
		// TODO Auto-generated method stub
		return windowsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int modifyWindow(windows windows) {
		// TODO Auto-generated method stub
		return windowsMapper.updateByPrimaryKeySelective(windows);
	}

	@Override
	public windows getWindowById(Integer id) {
		// TODO Auto-generated method stub
		return windowsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int countWindow(windowsExample windowsExample) {
		// TODO Auto-generated method stub
		return windowsMapper.countByExample(windowsExample);
	}

	@Override
	public int delWindowByExample(windowsExample windowsExample) {
		// TODO Auto-generated method stub
		return windowsMapper.deleteByExample(windowsExample);
	}

	@Override
	public windows getWindowByName(String name) {
		// TODO Auto-generated method stub
		windowsExample example=new windowsExample();
		example.createCriteria().andNameEqualTo(name);
		List<windows> list=windowsMapper.selectByExample(example);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

}
