package com.example.demo.Mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//绑定交换机
@Configuration
public class TopicRabbitConfig {
	
		final static String message = "topic.message";
	    final static String messages = "topic.messages";

	    @Bean
	    public Queue queueMessage() {
	        return new Queue(TopicRabbitConfig.message);
	    }

	    @Bean
	    public Queue queueMessages() {
	        return new Queue(TopicRabbitConfig.messages);
	    }

	    @Bean
	    TopicExchange exchange() {
	        return new TopicExchange("exchange");
	    }
	    //topic.message和 topic messages接收到信息
	    @Bean
	    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
	        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	    }
	    
	    // topic #接收到信息
	    @Bean
	    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
	        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
	    }
	}
	


