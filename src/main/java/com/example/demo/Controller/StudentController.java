package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Service.StudentService;
import com.example.demo.entity.Student;


//Vue.jsdemo
@Controller
@RequestMapping("/stu")
public class StudentController {
	
	@Autowired
	private StudentService stuService;
	
	@RequestMapping("/index")
	public String index(){
		return "stu/student";
	}
	
	@RequestMapping("/getStudent")
	@ResponseBody
	public List<Student> getStudent(){
		return stuService.getStudents();
	}
	
	@RequestMapping("/Vuedemo")
	public String vue(){
		return "stu/Vuedemo";
	}

}
