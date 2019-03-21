package com.example.demo.Controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
	/**
	 * 保存定时任务
	 */

	@RequestMapping("/save")	
	public void save1(){
		Student s=new Student();
		s.setAge(23);
		s.setName("小");
		stuService.save(s);
		stuService.list(new QueryWrapper<Student>().eq(true, "name", "小"));
	}
	
	@RequestMapping("/Vuedemo")
	public String vue(){
		return "stu/Vuedemo";
	}
	
	@RequestMapping("/getexcl")
	public void exclStudent(HttpServletRequest request, HttpServletResponse response){
			try {
					ServletOutputStream out = response.getOutputStream();
			        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
			        String fileName = new String(("UserInfo " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
				        .getBytes(), "UTF-8");
			         	Sheet sheet1 = new Sheet(1, 0,Student.class);
			         	sheet1.setSheetName("sheet1");
				        List<Student> student=    stuService.getStudents();
				        writer.write(student, sheet1);				     
				        response.setContentType("multipart/form-data");
				        response.setCharacterEncoding("utf-8");
				        response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");
				        writer.finish();
				        out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        
	}
}
