package com.example.demo.Util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.poi.ss.formula.functions.T;


public class JsonUtil {

	//@JSONField(format="yyyy-MM-dd")使用
	public static List<?> toList(String s,Class zlass){
		return JSON.parseArray(s, zlass);
	}


	public  static  String toString(T t){
		return  JSON.toJSONString(t);
	}
}
