package com.example.demo.Mq;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Ii;


//消息发送者
@Component
public class HelloSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(int i) {
		String context = "hello " +i;
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("hello", context);
	}
	
	// message 和messages都能接收到
	public void send1() {
		String context = "hi, i am message 1";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
	}
	
	//messages都能接收到
	public void send2() {
		String context = "hi, i am messages 2";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
	}
	
	//一条信息 3个监听收到
	public void send3() {
		String context = "hi, fanout msg ";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
	}

}
