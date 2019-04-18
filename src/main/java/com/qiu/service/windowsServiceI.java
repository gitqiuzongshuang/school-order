package com.qiu.service;


import java.util.List;

import com.qiu.pojo.windows;
import com.qiu.pojo.windowsExample;

public interface windowsServiceI {
	public int addWindow(windows windows);
    public int delWindow(int id);
    public int modifyWindow(windows windows);
    public windows getWindowById(Integer id);
    public int countWindow(windowsExample windowsExample);
    public int delWindowByExample(windowsExample windowsExample);
    public windows getWindowByName(String name);
    public List<windows> showWindows(windowsExample windowsExample);
}
