package com.example.demo.Dao;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Student;


@Mapper
public interface StudentDao extends BaseMapper<Student>{

}
