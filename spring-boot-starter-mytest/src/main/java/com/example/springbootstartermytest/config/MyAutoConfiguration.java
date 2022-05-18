package com.example.springbootstartermytest.config;

import com.example.springbootstartermytest.pojo.SimpleBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangweijian@gridsum.com
 * @since 2022-05-18
 */
@Configuration
@ConditionalOnBean(ConfigMarker.class)// 在上下文中存在某个bean，才会自动配置生效
public class MyAutoConfiguration {

	static {
		System.out.println("myAutoConfiguration init ......");
	}

	@Bean
	public SimpleBean simpleBean() {
		return new SimpleBean();
	}

}
