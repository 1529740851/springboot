package com.example.demo.Mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//消息接收者
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver1 {

		@RabbitHandler
		public void process(String message) {
	    System.out.println("topic.message : " + message);
		}

	
}
