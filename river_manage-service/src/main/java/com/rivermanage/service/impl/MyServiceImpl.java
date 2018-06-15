package com.rivermanage.service.impl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rivermanage.mapper.base.CityMapper;
import com.rivermanage.mapper.base.WqWqmonitorBMapper;
import com.rivermanage.pojo.base.City;
import com.rivermanage.pojo.base.CityExample;
import com.rivermanage.pojo.base.WqWqmonitorB;
import com.rivermanage.pojo.base.WqWqmonitorBExample;
import com.rivermanage.service.MyService;
import com.rivermanage.tool.ReadCodeFromWeb;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private CityMapper mapper;
	
	@Autowired
	private WqWqmonitorBMapper monitorMapper;

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

	@Override
	public List<WqWqmonitorB> getMonitor() {
		// TODO Auto-generated method stub
		WqWqmonitorBExample example=new WqWqmonitorBExample();
		example.createCriteria().andStcdEqualTo("510704002").andDevidEqualTo(32).andSptBetween("2017-12-19", "2017-12-20");
		List<WqWqmonitorB> list = monitorMapper.selectByExample(example);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		for (WqWqmonitorB wqWqmonitorB : list) {
			//System.out.println(wqWqmonitorB.getSpt());
			try {
				calendar.setTime(simpleDateFormat.parse(wqWqmonitorB.getSpt()));
				System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	

}
