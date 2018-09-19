package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	private static final Log LOGGER = LogFactory.getLog(ContactController.class);

	@GetMapping("/cancel")
	public String cancel(){
		return "redirect:/contacts/showcontacts";
	}
	
	@GetMapping("/contactForm")
	public String redirectContactForm(Model model, @RequestParam(name="id", required=false)int id){
		ContactModel contact = new ContactModel();			
		if( id > 0){
			contact = contactService.findContactById(id);
		}
		model.addAttribute("contactModel",contact);
		return ViewConstant.CONTACT_FORM;
	}
	
	@PostMapping("/addcontact")
	public String addcontact(@ModelAttribute(name="contactModel") ContactModel contactModel, Model model){
		LOGGER.info("METHOD: addcontact() -- PARAMS: " + contactModel.toString());
		if( null != contactService.addContact(contactModel)){
			model.addAttribute("result",1);
		}else{
			model.addAttribute("result",0);
		}
		
		return "redirect:/contacts/showcontacts";
	}
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacts(){
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		mav.addObject("contacts",contactService.listContacts());
		return mav;
	}
	
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id" )int id){
		contactService.removeContact(id);
		return showContacts();
	}
	
	
}
