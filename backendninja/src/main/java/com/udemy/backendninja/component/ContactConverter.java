package com.udemy.backendninja.component;

import org.springframework.stereotype.Component;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {

	public Contact convertContactModelToContact(ContactModel contactModel){
		Contact contact = Contact.builder()
				.id(contactModel.getId())
				.firstName(contactModel.getFirstName())
				.lastName(contactModel.getLastName())
				.telephone(contactModel.getTelephone())
				.city(contactModel.getCity()).build();
		
		return contact;
	}
	
	public ContactModel convertContactToContactModel(Contact contact){
		ContactModel contactModel = ContactModel.builder()
				.id(contact.getId())
				.firstName(contact.getFirstName())
				.lastName(contact.getLastName())
				.telephone(contact.getTelephone())
				.city(contact.getCity()).build();
		
		return contactModel;
	}
}
