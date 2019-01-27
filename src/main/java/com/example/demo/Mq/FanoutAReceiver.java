package com.example.demo.Mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.A")
public class FanoutAReceiver {
	
		@RabbitHandler
	    public void process(String hello) {
	        System.out.println("A  : " + hello);
	    }
}
