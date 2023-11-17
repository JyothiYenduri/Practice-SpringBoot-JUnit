package com.example.junitspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.junitspringboot.entity.Contact;
import com.example.junitspringboot.exception.ContactNotFoundException;
import com.example.junitspringboot.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	public Contact saveContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactRepository.save(contact);
	}

	public Contact getContactById(long id) {
		// TODO Auto-generated method stub
		return contactRepository.findById(id).orElseThrow(()->new ContactNotFoundException("Contact not found "+id));
	}

	public List<Contact> getContactList() {
		// TODO Auto-generated method stub
		return contactRepository.findAll();
	}

	public void deleteContact(Contact contact) {
		// TODO Auto-generated method stub
		contactRepository.delete(contact);
	}

	
}
