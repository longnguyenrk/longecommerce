package com.vietshop.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {
	@Id
	@Column(name = "idContact")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContact;
	
	@Column(name = "namecontact")
	private String namecontact;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "subjectcontact")
	private String subjectcontact;
	
	@Column(name = "messenger",columnDefinition="longtext")
	private String messenger;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(Long idContact, String namecontact, String email, String subjectcontact, String messenger) {
		super();
		this.idContact = idContact;
		this.namecontact = namecontact;
		this.email = email;
		this.subjectcontact = subjectcontact;
		this.messenger = messenger;
	}

	public Long getIdContact() {
		return idContact;
	}



	public String getNamecontact() {
		return namecontact;
	}

	public void setNamecontact(String namecontact) {
		this.namecontact = namecontact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubjectcontact() {
		return subjectcontact;
	}

	public void setSubjectcontact(String subjectcontact) {
		this.subjectcontact = subjectcontact;
	}

	public String getMessenger() {
		return messenger;
	}

	public void setMessenger(String messenger) {
		this.messenger = messenger;
	}

	@Override
	public String toString() {
		return "contact [idContact=" + idContact + ", namecontact=" + namecontact + ", email=" + email
				+ ", subjectcontact=" + subjectcontact + ", messenger=" + messenger + "]";
	}

}
