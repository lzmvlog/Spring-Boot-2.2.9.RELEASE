package com.example.springbootmytest.controller;

import com.example.springbootstartermytest.pojo.SimpleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangweijian@gridsum.com
 * @since 2022-05-12
 */
@RestController
public class TestController {

	@Autowired
	public SimpleBean simpleBean;

	@GetMapping("/")
	public String test(){
		System.out.println(simpleBean);
		System.out.println("源码环境搭建成功...");
		return "源码环境搭建成功";
	}
}
