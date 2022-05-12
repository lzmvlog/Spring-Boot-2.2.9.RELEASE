package com.example.springbootmytest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangweijian@gridsum.com
 * @since 2022-05-12
 */
@RestController
public class TestController {

	@GetMapping("test")
	public String test(){
		System.out.println("源码环境搭建成功...");
		return "源码环境搭建成功";
	}
}
