package com.udemy.backendninja.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.udemy.backendninja.model.Person;

@Service
public class PersonaServiceMock implements IPersonaService {

	@Override
	public List<Person> listPersons() {
		List<Person> listPersons = new ArrayList<>();
		
		listPersons.add(createPerson("Luis",36));
		listPersons.add(createPerson("Brenda",30));
		listPersons.add(createPerson("Ale",28));
		
		return listPersons;
	}

	private Person createPerson(String name, int age) {
		Person person = new Person(name, age);
		return person;
	}
	
}
