package com.example.demo.Mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Ii;



//消息接收者
@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceiver2 {

	

		@RabbitHandler
		public void process(String messages) {
	    System.out.println("topic.messages : " + messages);
		}

	
}
