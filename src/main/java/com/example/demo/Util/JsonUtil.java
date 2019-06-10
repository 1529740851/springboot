package com.example.demo.Util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;


public class JsonUtil {
	
	//@JSONField(format="yyyy-MM-dd")สนำร
	public static List<?> toList(String s,Class zlass){
		return JSON.parseArray(s, zlass);
	}
}
