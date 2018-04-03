package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
	
	private static final String VISTA = "404";

//	@GetMapping("/muestravista")
	@RequestMapping(method=RequestMethod.GET, path="/muestravista")
	public String obtenerVista(){
		
		return VISTA;
	}

}
