package com.example.junitspringboot.exception;

public class ContactNotFoundException extends RuntimeException{

	public ContactNotFoundException(String message) {
		super(message);
	}
}
