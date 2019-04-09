package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class FileController {

	@RequestMapping(value="/api/v1/file")
    public Object index() {
		return "index";
    }
}