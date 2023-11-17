package com.example.junitspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.junitspringboot.entity.Contact;
import com.example.junitspringboot.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@PostMapping("/savecontact")
	public ResponseEntity<Contact> saveContact(@RequestBody Contact contact){
		return ResponseEntity.ok(contactService.saveContact(contact));
	}
	
	@GetMapping("/contact/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable long id){
		return ResponseEntity.ok(contactService.getContactById(id));
	}
	
	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> getContactList(){
		return ResponseEntity.ok(contactService.getContactList());
	}
	
	@DeleteMapping
	public void delectContact(@RequestBody Contact contact) {
		contactService.deleteContact(contact);
	}
	
}
