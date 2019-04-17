package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.bean.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@PropertySource({"classpath:application.properties"})
public class FileController {

  @Value("${web.file.imagPath}")
  private String imagePath;

  private String getCurrentPath() {
    String classUrl = this.getClass().getResource("/").getPath();
    File file = new File(classUrl);
    String projectUrl = file.getParentFile().getParentFile().getPath();
    return projectUrl;
  }

  @RequestMapping(value = "/api/v1/file")
  public Object index() {
    return "index";
  }

  @RequestMapping(value = "upload")
  @ResponseBody
  public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {

    String name = request.getParameter("name");
    System.out.println("用户名" + name);

    String filePath = getCurrentPath() + imagePath; 

    // 获取文件名
    String fileName = file.getOriginalFilename();
    System.out.println("上传的文件名为：" + fileName);

    // 获取文件的后缀名 比如图片的jpeg ， png
    String suffixName = file.getOriginalFilename();
    System.out.println("上传的文件名为：" + suffixName);

    // 文件上传后的路径
    fileName = UUID.randomUUID() + suffixName;
    File dest = new File(filePath + fileName);

    System.out.println(filePath);
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