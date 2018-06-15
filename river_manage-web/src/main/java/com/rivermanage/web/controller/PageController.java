package com.rivermanage.web.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rivermanage.pojo.base.City;
import com.rivermanage.pojo.base.WqWqmonitorB;
import com.rivermanage.service.MyService;

@Controller
public class PageController {

	@Autowired
	private MyService myservice;
	
	@RequestMapping("/")
	@ResponseBody
	public String index(){
		return "<h1>这是主页</h1>";
	}
	@RequestMapping("/readCode2Db/{province}")
	@ResponseBody
	public String readCountryCod2Db(@PathVariable String province){
		myservice.add(province);
		return "添加成功";
	}
	
	@RequestMapping("/water")
	public String water(){
		return "water";
	}
	
	
	@RequestMapping("/water2")
	public String water2(){
		return "water2";
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public List<City> search(@RequestParam(defaultValue="0") Long parentid){
		System.out.println(parentid);
		return myservice.getNode(parentid);
	}
	
	
	@RequestMapping("/monitor")
	@ResponseBody
	public List<WqWqmonitorB> monitor(){
		return myservice.getMonitor();
	}
	
	
	
	@Test
	public void fun1(){
		DecimalFormat df = new DecimalFormat("#.00");
		Double[] temp=new Double[4];
		double open =2300+100* Math.random();
		double a=40*Math.random();
		double end;
		if (Math.round(open)%2==1) {
			end=open+a;
		}else {
			end=open-a;
		}
		double b=10*Math.random();
		double c=10*Math.random();
		double max=Math.max(open, end);
		double min=Math.min(open, end);
		max=max+b;
		min=min-c;
		temp[0]=open;
		temp[1]=end;
		temp[2]=min;
		temp[3]=max;
		for(int j=3;j<13;j++){
			for(int i=1;i<31;i++){
				a=temp[1]*0.1*Math.random();
				if (Math.round(100* Math.random())%2==1) {
					open=temp[1]+a;
				}else {
					open=temp[1]-a;
				}
				b=temp[1]*0.1*Math.random();
				if (Math.round(100* Math.random())%2==1) {
					end=temp[1]+b;
				}else {
					end=temp[1]-b;
				}
				a=temp[1]*0.1*Math.random();
				b=temp[1]*0.1*Math.random();
				c=temp[1]+a;
				double d=temp[1]-b;
				//System.out.println(c+"  "+open+"  "+end+"  "+min);
				max=Math.max(c, open);
				//System.out.println(max+"  "+open+"  "+end+"  "+min);
				max=Math.max(c, end);
				//System.out.println(max+"  "+open+"  "+end+"  "+min);
				max=Math.max(c, min);
				//System.out.println(max+"  "+open+"  "+end+"  "+min);
				min=Math.min(d, open);
				min=Math.min(d, end);
				min=Math.min(d, max);
				temp[0]=open;
				temp[1]=end;
				temp[2]=min;
				temp[3]=max;
				System.out.println("['2018/"+j+"/"+i+"',"+df.format(temp[0])+","+df.format(temp[1])+","+df.format(temp[2])+","+df.format(temp[3])+"],");
				//System.out.println("["+"'2018/3/"+i+"',"+df.format(open)+","+df.format(end)+","+df.format(max)+","+df.format(min)+"],");
			}
		}
		
		
		
	}
	
}
