package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.example.demo.Util.ResourcesRead;

@Configuration
@PropertySource("classpath:note.properties")
public class PropConf{
	
	@Value("${name}")
	private String name;
	
	@Value("${password}")
	private String password;
	
	public void show(){
		System.out.println("name"+name);
		System.out.println("password"+password);
	}
	
	
}
