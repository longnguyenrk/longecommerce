package com.vietshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vietshop.Entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long>{

}
