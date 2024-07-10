package com.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

	@RabbitListener(queues = { "${queuename}" })
	public void consumeMessage(String msg) {
		System.out.println("Received message: " + msg);
	}

}
