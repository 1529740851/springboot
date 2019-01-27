package com.example.demo.Mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Ii;

//消息接收者
@Component
@RabbitListener(queues = "object")
public class IiReceriver{

	@RabbitHandler
	public void process(Ii ii) {
    System.out.println("IiReceiver object : " + ii.toString());
	}

}