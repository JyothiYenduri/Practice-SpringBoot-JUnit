package com.example.junitspringboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.junitspringboot.entity.Contact;
import com.example.junitspringboot.repository.ContactRepository;

@SpringBootTest
public class ContactServiceTest {

	@MockBean
	private ContactRepository contactRepository;
	
	@Autowired
	private ContactService contactService;
	
	@Test
	public void test_saveContact() {
		Contact contact=new Contact(100L,"Charan","Yenduri","charan@gmail.com","98765");
		when(contactRepository.save(contact)).thenReturn(contact);
		assertEquals(contact, contactService.saveContact(contact));
	}
	
	@Test
	public void test_getContactById() {
		Contact contact=new Contact(100L,"Charan","Yenduri","charan@gmail.com","98765");
		when(contactRepository.findById(100L)).thenReturn(Optional.of(contact));
		assertEquals("charan@gmail.com", contactService.getContactById(100L).getEmail());
	}
	
	@Test
	public void test_getContactList() {
		List<Contact> contactList=Arrays.asList(new Contact(100L,"Charan","Yenduri","charan@gmail.com","98765"),new Contact(101L,"Vinay","Immadisetty","vinay@gmail.com","12345"));
		when(contactRepository.findAll()).thenReturn(contactList);
		assertEquals(2, contactService.getContactList().size());
	}
	
	@Test
	public void test_deleteContact() {
		Contact contact=new Contact(100L,"Charan","Yenduri","charan@gmail.com","98765");
		contactService.deleteContact(contact);
		verify(contactRepository,times(1)).delete(contact);
	}
}
