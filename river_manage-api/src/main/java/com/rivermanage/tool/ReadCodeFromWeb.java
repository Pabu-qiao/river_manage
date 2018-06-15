package com.rivermanage.tool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.rivermanage.pojo.base.City;

/**
 * 从国家统计局网站爬取2016年12位行政区划代码	精确到村级别
 * @author 谯雕
 *
 */

public class ReadCodeFromWeb {

	public static final String baseUrl = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2016/";
    //设置utf-8发现有部分字符有乱码
    public static final String CHARSET = "GBK";
    
    public static StringBuffer result = new StringBuffer();
    
    /**
     * 读省的信息
     * @param args
     * @throws Exception
     */
    public static List<City> readProvince(String provice) throws Exception {
        String url = baseUrl + "index.html";
        //如果需要设置代理
        //initProxy("10.10.13.200", "80");
        String str = getContent(url).toUpperCase();
        String[] strs = str.split("<A");
        
        List<City> countries=new ArrayList<>();

        for (String s : strs) {
            if (s.indexOf("HREF") != -1 && s.indexOf(".HTML") != -1) {
                
                String cityCode = s.substring(s.indexOf("HREF='")+6, s.indexOf(".HTML"));
                String name = s.substring(s.indexOf("'>")+2, s.indexOf("<BR/>"));
                System.out.println(format(cityCode)+":"+name);
                if(!provice.equals(name)){//这行代码代表只抓取指定省市
                    continue;
                }
                
                
                City city=new City();
                city.setId(new Long(format(cityCode)));
                city.setName(name);
                city.setParentid(0L);
                city.setIsleaf(false);
                city.setLevel((short) 1);
                countries.add(city);
                
                System.out.println("爬取:"+name);
                
                readShi(cityCode+".HTML",countries);
            }
        }
        return countries;
    }
    
    /**
     * 读市的数据
     * @param list
     * @throws Exception 
     */
    public static void readShi(String url,List<City> countries) throws Exception{
        String content = getContent(baseUrl+url).toUpperCase();
        String[] citys = content.split("CITYTR");
        //'><TD><A HREF='11/1101.HTML'>110100000000</A></TD><TD><A HREF='11/1101.HTML'>市辖区</A></TD></td><TR CLASS='
        City city=null;
        for(int c=1,len=citys.length; c<len; c++){
            String[] strs = citys[c].split("<A HREF='");
            String cityUrl = null;
            city=new City();
            
            for(int si = 1; si<3; si++){
                if(si==1){//取链接和编码
                    cityUrl = strs[si].substring(0, strs[si].indexOf("'>"));
                    String cityCode = strs[si].substring(strs[si].indexOf("'>")+2, strs[si].indexOf("</A>"));
                    //设置行政区划编码
                    city.setId(new Long(format(cityCode)));
                  //爬取父节点区划代码
                    String parentId="";
                    if (url.indexOf("/")!=-1) {
                    	parentId=url.substring(url.indexOf("/")+1, url.indexOf(".HTML"));
					}else {
						parentId=url.substring(0, url.indexOf(".HTML"));
					}
                    city.setParentid(new Long(format(parentId)));
                }else{
                	String name=strs[si].substring(strs[si].indexOf("'>")+2, strs[si].indexOf("</A>"));
                	city.setName(name);
                    System.out.println("爬取:"+name);
                }
            }
            city.setIsleaf(false);
            city.setLevel((short) 2);
            countries.add(city);
            readXian(cityUrl.substring(0, cityUrl.indexOf("/")+1),cityUrl,countries);
        }
    }
    
    /**
     * 读县的数据
     * @param url
     * @throws Exception 
     */
    public static void readXian(String prix,String url,List<City> countries) throws Exception{
        String content = getContent(baseUrl+url).toUpperCase();
        String[] citys = content.split("COUNTYTR");
        City city=null;
        
        for(int i=1; i<citys.length; i++){
            String cityUrl = null;
            city=new City();
            
            //发现石家庄有一个县居然没超链接，特殊处理
            if(citys[i].indexOf("<A HREF='")==-1){
                city.setId(new Long(citys[i].substring(6, 18)));
                
                city.setName(citys[i].substring(citys[i].indexOf("</TD><TD>")+9,citys[i].lastIndexOf("</TD>")));
            }else{
                String[] strs = citys[i].split("<A HREF='");
                for(int si = 1; si<3; si++){
                    if(si==1){//取链接和编码
                        cityUrl = strs[si].substring(0, strs[si].indexOf("'>"));
                        String cityCode = strs[si].substring(strs[si].indexOf("'>")+2, strs[si].indexOf("</A>"));
                        
                        city.setId(new Long(format(cityCode)));
                        //爬取父节点区划代码
                        String parentId="";
                        if (url.indexOf("/")!=-1) {
                        	parentId=url.substring(url.indexOf("/")+1, url.indexOf(".HTML"));
    					}else {
    						parentId=url.substring(0, url.indexOf(".HTML"));
    					}
                        city.setParentid(new Long(format(parentId)));
                    }else{
                    	String name=strs[si].substring(strs[si].indexOf("'>")+2, strs[si].indexOf("</A>"));
                        city.setName(name);
                    }
                }
    			city.setIsleaf(false);
            }
            city.setLevel((short) 3);
            countries.add(city);
            if(null!=cityUrl){
                readZhen(prix,cityUrl,countries);
            }
        }
    }
    
    /**
     * 读镇的数据
     * @param url
     * @throws Exception 
     */
    public static void readZhen(String prix,String url,List<City> countries) throws Exception{
        String content = getContent(baseUrl+prix+url).toUpperCase();
        String myPrix = (prix+url).substring(0, (prix+url).lastIndexOf("/")+1);
        String[] citys = content.split("TOWNTR");
        City city=null;
        for(int i=1; i<citys.length; i++){
            String[] strs = citys[i].split("<A HREF='");
            String cityUrl = null;
            city=new City();
            for(int si = 1; si<3; si++){
                if(si==1){//取链接和编码
                    cityUrl = strs[si].substring(0, strs[si].indexOf("'>"));
                    String cityCode = strs[si].substring(strs[si].indexOf("'>")+2, strs[si].indexOf("</A>"));
                    
                    city.setId(new Long(format(cityCode)));
                  //爬取父节点区划代码
                    String parentId="";
                    if (url.indexOf("/")!=-1) {
                    	parentId=url.substring(url.indexOf("/")+1, url.indexOf(".HTML"));
					}else {
						parentId=url.substring(0, url.indexOf(".HTML"));
					}
                    city.setParentid(new Long(format(parentId)));
                }else{
                	String name = strs[si].substring(strs[si].indexOf("'>")+2, strs[si].indexOf("</A>"));
                    city.setName(name);
                }
            }
            city.setIsleaf(false);
            city.setLevel((short) 4);
            countries.add(city);
            readCun(myPrix,cityUrl,countries);
        }
    }
    
    /**
     * 读村/街道的数据
     * @param url
     * @throws Exception 
     */
    public static void readCun(String prix,String url,List<City> countries) throws Exception{
        String content = getContent(baseUrl+prix+url).toUpperCase();
        String[] citys = content.split("VILLAGETR");
        City city=null;
        for(int i=1; i<citys.length; i++){
            String[] strs = citys[i].split("<TD>");
            String cityCode=strs[1].substring(0, strs[1].indexOf("</TD>"));
            city=new City();
            city.setId(new Long(format(cityCode)));
          //爬取父节点区划代码
            String parentId="";
            if (url.indexOf("/")!=-1) {
            	parentId=url.substring(url.indexOf("/")+1, url.indexOf(".HTML"));
			}else {
				parentId=url.substring(0, url.indexOf(".HTML"));
			}
            city.setParentid(new Long(format(parentId)));
            String name=strs[3].substring(0, strs[3].indexOf("</TD>"));
            city.setName(name);
            city.setIsleaf(true);
            city.setLevel((short) 5);
            countries.add(city);
        }
    }

    //设置代理
    public static void initProxy(String host, String port) {
        System.setProperty("http.proxyType", "4");
        System.setProperty("http.proxyPort", port);
        System.setProperty("http.proxyHost", host);
        System.setProperty("http.proxySet", "true");
    }

    //获取网页的内容
    public static String getContent(String strUrl) throws Exception {
        try {
            URL url = new URL(strUrl);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName(CHARSET)));
            String s = "";
            StringBuffer sb = new StringBuffer("");
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }

            br.close();
            return sb.toString();
        } catch (Exception e) {
            System.out.println("can't open url:"+strUrl);
            throw e;
        }
    }
    
    //将不足12位的编码后面加0，补足为12位编码，
    public static String format(String str){
    	char[] str1 = str.toCharArray();
		char[] temp=new char[12];
		for(int i=0;i<12;i++){
			if(i<str1.length){
				temp[i]=str1[i];
			}else {
				temp[i]='0';
			}
		}
    	return new String(temp);
    }
}
