package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Contact;
import com.example.demo.repositories.ContactRepository;

@Service
public class ContactService {
	private ContactRepository contactService;
	
	//constructor
	public ContactService(ContactRepository contactrepo) {
		this.contactService = contactrepo;
	}
	
	public List<Contact>getAllContacts(){
		return this.contactService.findAll();
	}
	
	public Contact getSingleContact(Long id) {
		return this.contactService.findById(id).orElse(null);
	}
	public Contact createContact(Contact newContact) {
		return this.contactService.save(newContact);
	}

}
