package com.udemy.backendninja.service;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;

public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel contactModel);

}
