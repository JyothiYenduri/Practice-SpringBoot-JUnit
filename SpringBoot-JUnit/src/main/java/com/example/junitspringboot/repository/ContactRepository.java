package com.example.junitspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.junitspringboot.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
