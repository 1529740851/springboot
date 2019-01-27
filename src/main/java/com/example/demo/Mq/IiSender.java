package com.example.demo.Mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Ii;


//消息发送者
@Component
public class IiSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send(Ii i) {
		String context = "Sender " + i.toString();
		System.out.println( context);
		this.rabbitTemplate.convertAndSend("object",i);
	}
}
