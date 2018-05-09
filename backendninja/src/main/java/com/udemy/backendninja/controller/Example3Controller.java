package com.udemy.backendninja.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

	private static final String FORM_VIEW = "form";
	private static final String RESULT_VIEW = "result";
	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);

	@GetMapping("/")
	public String redirect() {
		return "redirect:/example3/showform";
	}
	
	@GetMapping("")
	public RedirectView redirectView() {
		return new RedirectView("/example3/showform");
	}
	
	@GetMapping("/showform")
	public String showform(Model model) {
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person")Person person, BindingResult bindingResult) {
		LOGGER.info("METHOD: 'addPerson' --- PARAMS: '" + person + "'");
		
		ModelAndView mav = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mav.setViewName(FORM_VIEW);
		}else {
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person",person);
			LOGGER.info("Adding person: '"+ person + "'");
		}
		return mav;
	}
}
