package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
	
	private static final String VISTA = "vistax";

//	@GetMapping("/muestravista")
	@RequestMapping(method=RequestMethod.GET, path="/muestravista")
	public String obtenerVista(){
		int i = 6/0;
		return VISTA;
	}


}
