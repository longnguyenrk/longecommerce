package com.vietshop.Service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vietshop.repository.ContactRepository;
import com.vietshop.Service.iContactService;
import com.vietshop.entity.Contact;

@Service // Để class có thể thực hiện cơ chế DI và IOC
public class ContactService implements iContactService{
@Autowired
private ContactRepository contactRepository;

@Override
public <S extends Contact> S save(S entity) {
	return contactRepository.save(entity);
}

@Override
public <S extends Contact> S findOne(Example<S> example) {
	return contactRepository.findOne(example);
}

@Override
public Page<Contact> findAll(Pageable pageable) {
	return contactRepository.findAll(pageable);
}

@Override
public List<Contact> findAll() {
	return contactRepository.findAll();
}

@Override
public Contact findOne(Long id) {
	return contactRepository.findOne(id);
}

@Override
public List<Contact> findAll(Sort sort) {
	return contactRepository.findAll(sort);
}

@Override
public List<Contact> findAll(Iterable<Long> ids) {
	return contactRepository.findAll(ids);
}

@Override
public boolean exists(Long id) {
	return contactRepository.exists(id);
}

@Override
public <S extends Contact> List<S> save(Iterable<S> entities) {
	return contactRepository.save(entities);
}

@Override
public void flush() {
	contactRepository.flush();
}

@Override
public <S extends Contact> S saveAndFlush(S entity) {
	return contactRepository.saveAndFlush(entity);
}

@Override
public long count() {
	return contactRepository.count();
}

@Override
public void deleteInBatch(Iterable<Contact> entities) {
	contactRepository.deleteInBatch(entities);
}

@Override
public <S extends Contact> Page<S> findAll(Example<S> example, Pageable pageable) {
	return contactRepository.findAll(example, pageable);
}

@Override
public void delete(Long id) {
	contactRepository.delete(id);
}

@Override
public void deleteAllInBatch() {
	contactRepository.deleteAllInBatch();
}

@Override
public void delete(Contact entity) {
	contactRepository.delete(entity);
}

@Override
public Contact getOne(Long id) {
	return contactRepository.getOne(id);
}

@Override
public <S extends Contact> long count(Example<S> example) {
	return contactRepository.count(example);
}

@Override
public void delete(Iterable<? extends Contact> entities) {
	contactRepository.delete(entities);
}

@Override
public <S extends Contact> List<S> findAll(Example<S> example) {
	return contactRepository.findAll(example);
}

@Override
public void deleteAll() {
	contactRepository.deleteAll();
}

@Override
public <S extends Contact> boolean exists(Example<S> example) {
	return contactRepository.exists(example);
}

@Override
public <S extends Contact> List<S> findAll(Example<S> example, Sort sort) {
	return contactRepository.findAll(example, sort);
}

}
