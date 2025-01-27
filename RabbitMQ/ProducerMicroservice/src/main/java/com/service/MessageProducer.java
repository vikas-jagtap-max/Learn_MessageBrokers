package com.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configuration.RabbitMQConfig;

@Service
public class MessageProducer {

	private RabbitTemplate rabbitTemplate;

	@Autowired
	public MessageProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	//
	public void produceMessage(String msg) {

		rabbitTemplate.convertAndSend(RabbitMQConfig.exchange, RabbitMQConfig.routingKey, msg);
		System.out.println("Sent message: " + msg);

	}

}
