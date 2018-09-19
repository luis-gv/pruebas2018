package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;

public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel contactModel);
	
	public List<ContactModel> listContacts();
	
	public abstract void removeContact(int id);
	
	public abstract ContactModel findContactById(int id);

}
