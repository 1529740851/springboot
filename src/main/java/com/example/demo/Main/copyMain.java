package com.example.demo.Main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Student;

public class copyMain {

	public static void main(String[] args) {
		Student stu = new Student(1, "张三", 33);
		Student stu1 = new Student(2, "李四", 22);
		Student stu2 = new Student(3, null, 33);
		Student stu3 = new Student(4, "孙六", 24);
		stu.setDate(new Date());
		List<Student> stus = new ArrayList<Student>();
		stus.add(stu);
		stus.add(stu1);
		stus.add(stu2);
		stus.add(stu3);
		
		//将LIst<Student>转成LIst<Student1>
		String json= JSON.toJSONString(stus);
		List<Student> stus1=JSONObject.parseArray(json, Student.class);
		System.out.println(stus1.size());
		
		//stu1的值赋值给stu
	    BeanUtils.copyProperties(stu1,stu);
	    System.out.println(stu.getName());
	}
}
