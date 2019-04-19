package com.example.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RunApplication.class})
public class DemoApplicationTests {
	@Test
	public void testOne() {
		System.out.println("test hello");
		TestCase.assertEquals(1, 1);
	}

	@Before
	public void testBefore() {
		System.out.println("before");
	}

	@After
	public void testAfter() {
		System.out.println("after");
	}
}
