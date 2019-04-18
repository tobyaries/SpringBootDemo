package com.example.demo.controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.bean.ServerSetting;
import com.example.demo.bean.User;

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
	/***
	 * 功能描述： 测试defalut value
	 */
	@GetMapping(value="/v2/page_user1")
	public Object pageUserV2(@RequestParam(defaultValue = "0", name="page") int from, int size) {
		params.clear();
		params.put("from", from);
		params.put("size", size);
		return params;
	}
	/***
	 * 功能描述： 测试java bean
	 * 指定http头为 content-type为application/json
	 * 使用body传输数据
	 */
	@GetMapping(value="/v1/save_user")
	public Object saveUser(@RequestBody User user) {
		params.clear();
		params.put("user", user);
		return params;
	}
	/***
	 * 功能描述： 测试获取http头信息
	 * accessToken
	 */
	@GetMapping(value="/v1/get_header")
	public Object getHeader(@RequestHeader("access_token") String accessToken, String id ) {
		params.clear();
		params.put("access_token", accessToken);
		params.put("id", id);
		return params;
	}
	/***
	 * 功能描述： 测试获取servlet request
	 * accessToken
	 */
	@GetMapping(value="/v1/test_request")
	public Object testRequest(HttpServletRequest request ) {
		params.clear();
		String id = request.getParameter("id");
		params.put("id", id);
		return params;
	}

	@Autowired
	private ServerSetting serverSettings;
	@GetMapping(value="/v1/test_properties")
	public Object testProperty(HttpServletRequest request ) {
		return serverSettings;
	}
}