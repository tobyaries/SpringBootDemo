package com.example.demo.controller;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {
	
	private Map<String, Object> params = new HashMap<String, Object>();
	/**
	 * 功能描述： 测试restful
	 * @return
	 */
	@RequestMapping(path = "/{city_id}/{user_id}", method = RequestMethod.GET)
    public Object findUser(@PathVariable("city_id") String cityId,
    		@PathVariable("user_id") String userId) {
		params.put("cityId", cityId);
		params.put("userId", userId);
        return params;
    }
	/***
	 * 功能描述： 测试GatMapping
	 */
	@GetMapping(value="/v1/page_user1")
	public Object pageUser(int from, int size) {
		params.clear();
		params.put("from", from);
		params.put("size", size);
		return params;
	}
}