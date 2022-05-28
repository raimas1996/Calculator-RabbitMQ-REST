package com.pedroraimundo.calculator;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest
class CalculatorApplicationTests {

	@Value("${REST_GET_REQUEST_URL}")
	private String URL;

	@Test
	void sumTest() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		HashMap<?, ?> result = testRestTemplate.getForObject(
				URL + "/sum?a=1&b=2",
				HashMap.class);
		
		assert(result.get("result").equals(3));
	}
	
	@Test
	void subtractTest() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		HashMap<?, ?> result = testRestTemplate.getForObject(
				URL + "/subtract?a=4&b=7",
				HashMap.class);
		
		assert(result.get("result").equals(-3));
	}
	
	@Test
	void multiplyTest() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		HashMap<?, ?> result = testRestTemplate.getForObject(
				URL + "/multiply?a=-3&b=4",
				HashMap.class);
		
		assert(result.get("result").equals(-12));
	}
	
	@Test
	void divideTest() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		HashMap<?, ?> result = testRestTemplate.getForObject(
				URL + "/divide?a=10&b=-5",
				HashMap.class);
		
		assert(result.get("result").equals(-2));
	}
	
	@Test
	void divideByZeroTest() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		HashMap<?, ?> result = testRestTemplate.getForObject(
				URL + "/divide?a=1&b=0",
				HashMap.class);
		
		assert(result.get("result").equals("NaN"));
	}
}
