package com.example.demo.Main;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.example.demo.entity.Student;

public class ReflexMain {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Student stu=new Student(1,"小明",33);
		Student stu1=new Student(2,"笑话",22);
		Student stu2=new Student(3,"无语",33);
		Student stu3=new Student(4,"小明",24);
		List<Student> stus=new ArrayList<Student>();
		stus.add(stu);
		stus.add(stu1);
		stus.add(stu2);
		stus.add(stu3);
		getField(stus);
	}
	
	public static void getField(List<?> list) throws IllegalArgumentException, IllegalAccessException{
		Class<?> entityClass = list.get(0).getClass();
		entityClass.getAnnotations();
		Iterator<?> iter = list.iterator();
		while (iter.hasNext()) {
			Object obj=iter.next();
			for (Field field : obj.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				Object Value = field.get(obj);
				if(Value !=null){
					if(field.getType()==String.class){
						System.out.println("String"+(String)Value);
					}
					if(field.getType()==Integer.class){
						System.out.println("Integer"+(Integer)Value);
					}
					if(field.getType()==Date.class){
						System.out.println("String"+(Date)Value);
					}
				}
			}
		}
	}

}
