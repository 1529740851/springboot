package com.example.demo.Main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Util.RedisUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private RedisUtil redisUtil;

	@Test
	public void test() throws Exception {
		System.out.println("xxx");
		redisUtil.set("xx", "11");
		System.out.println(redisUtil.get("xx"));
	}

	//添加订单号
	@Test
	public void indexTest(){
		String name="reg";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String format = simpleDateFormat.format(new Date());
		String key = name+format;
		Long num = redisUtil.incr(key,1L);
		System.out.println("xx");
		System.out.println(num);
	}

}
