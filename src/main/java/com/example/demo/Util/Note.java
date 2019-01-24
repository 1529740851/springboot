package com.example.demo.Util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
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
