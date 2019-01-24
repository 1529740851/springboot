package com.example.demo.job;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//spring boot 启动后预加载文件
@Component
@Order(1) 
public class Runner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("预加载......");		
	}

}
