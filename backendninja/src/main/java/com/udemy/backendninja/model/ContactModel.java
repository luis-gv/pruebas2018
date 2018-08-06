package com.udemy.backendninja.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactModel {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String telephone;
	
	private String city;
}
