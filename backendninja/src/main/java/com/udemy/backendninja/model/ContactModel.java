package com.udemy.backendninja.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContactModel {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String telephone;
	
	private String city;
}
