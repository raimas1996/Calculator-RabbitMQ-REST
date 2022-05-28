package com.pedroraimundo.calculator.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedroraimundo.calculator.rest.RabbitRESTProducer;

@RestController
public class CalculatorController {

	@Autowired
	RabbitRESTProducer producer;
	
	@GetMapping("/sum")
	public ResponseEntity<Object> sum(@RequestParam(name="a") int a, @RequestParam(name="b") int b) {
		if (producer.sendMessageToBroker(String.valueOf(a))) {
			return ResponseEntity.ok("[a=" + a + ", b=" + b + "] has been sent to broker successfully!");
		} else {
			return ResponseEntity.status(500).body("Error: [a=" + a + ", b=" + b + "] has NOT been sent to broker!");
		}
	}
}
