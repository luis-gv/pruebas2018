package com.udemy.backendninja.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.component.ContactConverter;
import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.repository.ContactRepository;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact_added = contactRepository.save(contactConverter.convertContactModelToContact(contactModel));
		return contactConverter.convertContactToContactModel(contact_added);
	}

	@Override
	public List<ContactModel> listContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<>();
		for (Contact contact : contacts) {
			contactsModel.add(contactConverter.convertContactToContactModel(contact));
		} 
		return contactsModel;
	}

	@Override
	public void removeContact(int id) {
		Contact contact = contactRepository.findById(id);
		if(contact != null){
			contactRepository.delete(contact);			
		}
	}

	@Override
	public ContactModel findContactById(int id) {
		Contact contact = contactRepository.findById(id);
		ContactModel contactModel = contactConverter.convertContactToContactModel(contact);
		return contactModel;
	}
	
	
	
}
