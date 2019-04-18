package com.qiu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiu.dao.adminMapper;
import com.qiu.pojo.admin;
import com.qiu.pojo.adminExample;

@Service
public class adminServiceImpl implements adminServiceI {
	@Autowired
	adminMapper adminMapper;

	@Override
	public int addAdmin(admin admin) {
		// TODO Auto-generated method stub
		return adminMapper.insert(admin);
	}

	@Override
	public int delAdmin(int id) {
		// TODO Auto-generated method stub
		return adminMapper.deleteByPrimaryKey(id);
	}

	@Override
	public admin getAdminById(Integer id) {
		// TODO Auto-generated method stub
		return adminMapper.selectByPrimaryKey(id);
	}

	@Override
	public int countAdmin(adminExample adminExample) {
		// TODO Auto-generated method stub
		return adminMapper.countByExample(adminExample);
	}

	@Override
	public int delAdminByExample(adminExample adminExample) {
		// TODO Auto-generated method stub
		return adminMapper.deleteByExample(adminExample);
	}

	@Override
	public int modifyAdmin(admin admin) {
		// TODO Auto-generated method stub
		return adminMapper.updateByPrimaryKeySelective(admin);
	}

	@Override
	public admin login(admin admin) {
		// TODO Auto-generated method stub
		adminExample example=new adminExample();
		example.createCriteria().andAccountEqualTo(admin.getAccount())
		.andPasswordEqualTo(admin.getPassword());
		List<admin> list=adminMapper.selectByExample(example);
		if(list.size()>0) {
			return list.get(0);
		}
		else {
			return null;
		}
	}

	@Override
	public admin getAdminByaccount(String account) {
		// TODO Auto-generated method stub
		adminExample example=new adminExample();
		example.createCriteria().andAccountEqualTo(account);
		List<admin> list=adminMapper.selectByExample(example);
		if(list.size()>0) {
			return list.get(0);
		}
		else {
			return null;
		}
	}

	@Override
	public List<admin> showAdmin(adminExample adminExample) {
		// TODO Auto-generated method stub
		return adminMapper.selectByExample(adminExample);
	}

}
