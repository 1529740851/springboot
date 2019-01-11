package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:note.properties")
public class Note {
	
	@Value("${name}")
	private String name;
	@Value("${password}")
	private String password;
	
	@Override
	public String toString() {
		
		return "Note [name=" + name + ", password=" + password + "]";
	}
	
	
}
