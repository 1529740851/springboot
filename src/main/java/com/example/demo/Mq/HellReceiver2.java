package com.example.demo.Mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//消息接收者
@Component
@RabbitListener(queues = "hello")
public class HellReceiver2{

  @RabbitHandler
  public void process(String hello) {
      System.out.println("Receiver2  : " + hello);
  }

}