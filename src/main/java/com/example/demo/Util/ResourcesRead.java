package com.example.demo.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.Service.PropConf;



@SpringBootApplication
public class ResourcesRead {

	
	public static void main(String[] args) throws Exception{
		
		 // 获取 Spring Boot 上下文
        ConfigurableApplicationContext ctx = SpringApplication.run(ResourcesRead.class, args);
       
        // ctx.getEnvironment(); // 获取 边境变量
        System.out.println(ctx.getEnvironment().getProperty("spring.datasource.username"));
		
	}
	
}
