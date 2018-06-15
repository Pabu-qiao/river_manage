package com.rivermanage.web.conf;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@AutoConfigureAfter(MybatisConfig.class)
public class MapperScannerConfig {

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(){
		MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
		
		mapperScannerConfigurer.setBasePackage("com.rivermanage.mapper");
		
		return mapperScannerConfigurer;
	}
}
