package com.vietshop.dto;

public class ContactDTO {
private Long idContact;
private String namecontact;
private String email;
private String subjectcontact;
private String messenger;
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

}
