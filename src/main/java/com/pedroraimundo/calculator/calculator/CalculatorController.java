package com.pedroraimundo.calculator.calculator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
		Map<String, Object> json = new HashMap<>();
		if (producer.sendMessageToBroker(String.valueOf(a))) {
			json.put("result", new BigDecimal(a + b));
			return ResponseEntity.ok(json);
		} else {
			json.put("result", "Error: [a=" + a + ", b=" + b + "] has NOT been sent to broker!");
			return ResponseEntity.status(500).body(json);
		}
	}
	
	@GetMapping("/subtract")
	public ResponseEntity<Object> subtract(@RequestParam(name="a") int a, @RequestParam(name="b") int b) {
		Map<String, Object> json = new HashMap<>();
		if (producer.sendMessageToBroker(String.valueOf(a))) {
			json.put("result", new BigDecimal(a - b));
			return ResponseEntity.ok(json);
		} else {
			json.put("result", "Error: [a=" + a + ", b=" + b + "] has NOT been sent to broker!");
			return ResponseEntity.status(500).body(json);
		}
	}
	
	@GetMapping("/multiply")
	public ResponseEntity<Object> multiply(@RequestParam(name="a") int a, @RequestParam(name="b") int b) {
		Map<String, Object> json = new HashMap<>();
		if (producer.sendMessageToBroker(String.valueOf(a))) {
			json.put("result", new BigDecimal(a * b));
			return ResponseEntity.ok(json);
		} else {
			json.put("result", "Error: [a=" + a + ", b=" + b + "] has NOT been sent to broker!");
			return ResponseEntity.status(500).body(json);
		}
	}
	
	@GetMapping("/divide")
	public ResponseEntity<Object> divide(@RequestParam(name="a") int a, @RequestParam(name="b") int b) {
		Map<String, Object> json = new HashMap<>();
		if (producer.sendMessageToBroker(String.valueOf(a))) {
			try {
				json.put("result", new BigDecimal(a / b));
			} catch (ArithmeticException e) {
				System.out.println("Error: Value cannot be divided by zero!");
				json.put("result", "NaN");
			}
			return ResponseEntity.ok(json);
		} else {
			json.put("result", "Error: [a=" + a + ", b=" + b + "] has NOT been sent to broker!");
			return ResponseEntity.status(500).body(json);
		}
	}
}
