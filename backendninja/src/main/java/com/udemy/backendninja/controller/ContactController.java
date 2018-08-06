package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.entity.Contact;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	@GetMapping("/contactForm")
	public String redirectContactForm(Model model){
		model.addAttribute("contactModel",new Contact());
		
		return ViewConstant.CONTACT_FORM;
	}
	
	@GetMapping("/cancel")
	public String cancel(){
		return ViewConstant.CONTACTS;
	}
}
