package com.sainath.springbootdcb.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	@Value("${hello.message}")
	private String helloMessage;
	@GetMapping("/")
	public String helloWorld() {
		return helloMessage;
	}
}
