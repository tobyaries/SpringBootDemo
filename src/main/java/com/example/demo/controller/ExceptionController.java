package com.example.demo.controller;

import java.util.Date;
import com.example.demo.bean.MyException;
import com.example.demo.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 功能描述：异常测试
 */
@RestController
public class ExceptionController {
	@RequestMapping("/api/v1/test_ext")
	public Object index() {
		// int i = 11/0;
		return new Person(11, "sasasa", "100000", new Date());
	}

	@RequestMapping("/api/v1/myext")
	public Object myexc() {
		throw new MyException("500", "my ext异常");
	}
}