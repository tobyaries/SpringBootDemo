package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.bean.Person;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot2!";
	}

	@RequestMapping("/test")
	public Map<String, String> testMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "yestin");
		return map;
	}

	@RequestMapping("/testjson")
	public Object testjson() {
		return new Person(111, "abc123", "18572231222", new Date());
	}
}