package com.example.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//EasyExcl学生表
@TableName(value = "Student")
public class Student extends BaseRowModel {
	public Student(){
		
	}
	public Student(Integer id,String name,Integer age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	 @ExcelProperty(value = {"学生表","姓名"},index = 0)//鍚堝苟鍗曞厓鏍�
	//@ExcelProperty(value = "濮撳悕", index = 0)
	private String name;
	
	 @ExcelProperty(value = {"学生表","姓名"},index = 0)//鍚堝苟鍗曞厓鏍�
	//@ExcelProperty(value = "骞撮緞", index = 1)
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
