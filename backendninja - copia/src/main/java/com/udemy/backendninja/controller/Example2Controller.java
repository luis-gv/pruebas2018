package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {

	
	private static final String EXAMPLE2_VIEW = "example2";

	//@GetMapping("/request1")
	@RequestMapping(value="/request1", method=RequestMethod.GET)
	public ModelAndView request1(@RequestParam(name="nm", required=false, defaultValue="Default")String name){
		ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);		
		mav.addObject("nm_in_model",name);
		return mav;
	}
	
	@RequestMapping(value="/request2/{nm}", method=RequestMethod.GET )
	public ModelAndView request2(@PathVariable(name="nm")String name){
		ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
		mav.addObject("nm_in_model",name);
		return mav;
	}

}
