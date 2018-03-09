package com.udemy.backendninja.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class HelloWorldController {

	@RequestMapping("/hello_world")
	public String helloWorld() {
		return "Hola Mundo";
	}
}
