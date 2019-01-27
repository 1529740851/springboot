package com.example.demo.Mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.C")
public class FanoutCReceiver {
	@RabbitHandler
    public void process(String hello) {
        System.out.println("C : " + hello);
    }
}
