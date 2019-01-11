package com.example.demo.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Ii;
import com.example.demo.entity.Mnoticeconfig;
import com.example.demo.entity.Tabletmp;
@Mapper
public interface I2Mapper {

	void delete(@Param("id") String id);
	
	 List<Ii> Select();
	  
 //   void insert(Ii i);
	 void insert(Tabletmp Tabletmp);
    
	 void updateMnoticeconfig(Mnoticeconfig mcofig);
	 
    Ii select2(@Param("id") String id);
}
