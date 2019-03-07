package com.example.demo.Service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Student;

public interface StudentService extends IService<Student>{

	 List<Student> getStudents();
}
