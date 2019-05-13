package com.example.demo;

import com.example.demo.bean.User;
import com.example.demo.utils.JsonUtils;
import com.example.demo.utils.RedisClient;

// import org.junit.After;
// import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
// import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RunApplication.class})
public class DemoApplicationTests {

	// @Autowired
	// private StringRedisTemplate strTpl;

	@Autowired
	private RedisClient redis;

	@Test
	public void testOne() {
		User user = new User();
		user.setAge(1);
		user.setPhone("187232211111");
		user.setName("tony");
		String str = JsonUtils.obj2String(user);
		redis.set("test:user:111", str);
		System.out.println(str);
	}
	/* @Test
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
	} */
}
