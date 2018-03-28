package com.udemy.backendninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.service.IPersonaService;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	public static final String EXAMPLE_VIEW="example";
	
	@Autowired
	private IPersonaService personaService;
	
	//@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	@GetMapping("/exampleString")
	public String exampleString(Model model){
		model.addAttribute("listPeople", personaService.listPersons());
		return EXAMPLE_VIEW;
	}
	
	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	public ModelAndView example(){
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("listPeople", personaService.listPersons());
		return mav;
	}
}
