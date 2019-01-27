package com.example.demo.Main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Mq.HelloSender;
import com.example.demo.Mq.IiSender;
import com.example.demo.entity.Ii;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

	@Autowired
	private HelloSender helloSender;
	
	@Autowired
	private IiSender iiSender;
	
	//传输对象
	@Test
	public void hello1() throws Exception {
		iiSender.send(new Ii("1","2","2"));
	}

	//根据转化机发布信息给多个监听者
	@Test
	public void hello() throws Exception {
		helloSender.send3();
	}
	
	
	@Test
	public void oneToMany() throws Exception {
		for (int i=0;i<50;i++){
			helloSender.send1();
		}
	}
}
