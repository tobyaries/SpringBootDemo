package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import com.example.demo.bean.JsonData;
import com.example.demo.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class SampleController {

	private final String filePath = getCurrentPath() + "\\src\\main\\resources\\static\\images\\";

	private String getCurrentPath() {
		String classUrl = this.getClass().getResource("/").getPath();
		File file = new File(classUrl);
		String projectUrl = file.getParentFile().getParentFile().getPath();
		return projectUrl;
	}

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
		return new User(111, "abc123", "18572231222", new Date());
	}

	@RequestMapping(value = "upload")
	@ResponseBody
	public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {

		String name = request.getParameter("name");
		System.out.println("用户名" + name);

		// 获取文件名
		String fileName = file.getOriginalFilename();
		System.out.println("上传的文件名为：" + fileName);

		// 获取文件的后缀名 比如图片的jpeg ， png
		String suffixName = file.getOriginalFilename();
		System.out.println("上传的文件名为：" + suffixName);

		// 文件上传后的路径
		fileName = UUID.randomUUID() + suffixName;
		File dest = new File(filePath + fileName);

		System.out.println(getCurrentPath());
		try {
			file.transferTo(dest);
			return new JsonData(0, fileName);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new JsonData(-1, "fail to save file!");
	}
}