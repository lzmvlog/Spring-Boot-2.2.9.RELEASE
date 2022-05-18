package com.example.springbootmytest;

import com.example.springbootstartermytest.annotation.EnableRegisterServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhang.xiao
 */
@SpringBootApplication
@EnableRegisterServer
public class SpringBootMyTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyTestApplication.class, args);
	}

}
