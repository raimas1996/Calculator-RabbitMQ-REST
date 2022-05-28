package com.pedroraimundo.calculator.rest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitRESTProducer {

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public boolean sendMessageToBroker(String message) {
		try {
			rabbitTemplate.convertSendAndReceive("", null, message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
