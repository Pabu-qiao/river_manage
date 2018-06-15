package com.rivermanage.service;

import java.util.List;

import com.rivermanage.pojo.base.City;
import com.rivermanage.pojo.base.WqWqmonitorB;

public interface MyService {

	void add(String province);
	List<City> getNode(Long parentid);
	
	List<WqWqmonitorB> getMonitor();
}
