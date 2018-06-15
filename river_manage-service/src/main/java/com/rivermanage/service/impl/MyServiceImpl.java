package com.rivermanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rivermanage.mapper.base.CityMapper;
import com.rivermanage.pojo.base.City;
import com.rivermanage.pojo.base.CityExample;
import com.rivermanage.service.MyService;
import com.rivermanage.tool.ReadCodeFromWeb;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private CityMapper mapper;

	@Override
	@Transactional
	public void add(String province) {
		// TODO Auto-generated method stub
		List<City> list=null;
		try {
			list = ReadCodeFromWeb.readProvince(province);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (City country : list) {
			mapper.insert(country);
		}
	}

	@Override
	public List<City> getNode(Long parentid) {
		// TODO Auto-generated method stub
		CityExample example=new CityExample();
		example.createCriteria().andParentidEqualTo(parentid);
		return mapper.selectByExample(example);
	}
	
	

}
