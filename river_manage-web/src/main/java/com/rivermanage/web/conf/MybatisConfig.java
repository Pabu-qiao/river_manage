package com.rivermanage.web.conf;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootConfiguration
public class MybatisConfig {

	@Autowired
	private DataSource dataSource;
		
	@Bean
	@ConditionalOnMissingBean
	public SqlSessionFactoryBean sqlSessionFactoryBean(){
		SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
		
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		Resource mybatisConfigXml=new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis.xml");
		sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);
		
		return sqlSessionFactoryBean;
	}
}
