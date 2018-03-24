package com.udemy.backendninja.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class HelloWorldController {

	@RequestMapping(path="/hello_world", method=RequestMethod.GET)
	public String helloWorld() {
		return "Hola Mundo";
	}
}
