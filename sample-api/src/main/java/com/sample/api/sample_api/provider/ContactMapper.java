package com.sample.api.sample_api.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sample.api.sample_api.BO.Contact;

public class ContactMapper {
	
	public static List<Contact> personMapper(List<Map<String, Object>> mapList){
		List<Contact> contacts = new ArrayList<Contact>();
		for(Map<String, Object> map:mapList){
		Contact contact = new Contact();
		
		contact.setAddress((String) map.get("address"));
		contact.setCity((String) map.get("city"));
		contact.setEmail((String) map.get("email"));
		contact.setFirstname((String) map.get("firstName"));
		contact.setLastName((String) map.get("lastName"));
		contact.setPhone((String) map.get("phone"));
		contacts.add(contact);
		}
		return contacts;
		
		
		
	}

}
