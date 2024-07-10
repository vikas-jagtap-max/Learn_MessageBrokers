package com.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.MessageProducer;

@RestController
@RequestMapping("/send")
public class MessageProducerAPI {

	@Autowired
	private MessageProducer messageProducer;

	// http://localhost:8095/send/message?message=hello
	@GetMapping("/message")
	public String sendMessage(@RequestParam("message") String msg) {
		messageProducer.produceMessage(msg);
		return "Message sent successfully";

	}

}
