package com.qiu.service;

import java.util.List;

import com.qiu.pojo.admin;
import com.qiu.pojo.adminExample;

public interface adminServiceI {
    public int addAdmin(admin admin);
    public int delAdmin(int id);
    public int modifyAdmin(admin admin);
    public admin getAdminById(Integer id);
    public int countAdmin(adminExample adminExample);
    public int delAdminByExample(adminExample adminExample);
    public admin login(admin admin);
    public admin getAdminByaccount(String account);
    public List<admin> showAdmin(adminExample adminExample);

}
