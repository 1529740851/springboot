package com.example.demo.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Dao.StudentDao;
import com.example.demo.Service.StudentService;
import com.example.demo.entity.Student;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService{
	
	public List<Student> getStudents(){
		List<Student> students=new ArrayList<Student>();
		students.add(new Student(1,"郭红东",22));
		students.add(new Student(2,"张志文",20));
		students.add(new Student(3,"老王",23));
		return students;		
	}
     
	
	
}
