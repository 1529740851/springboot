package com.example.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class Student extends BaseRowModel {
	public Student(){
		
	}
	public Student(int id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	
	private int id;
	
	@ExcelProperty(value = "姓名", index = 0)
	private String name;
	
	@ExcelProperty(value = "年龄", index = 1)
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
