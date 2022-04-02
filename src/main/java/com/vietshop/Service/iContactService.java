package com.vietshop.Service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vietshop.Entity.Contact;

public interface iContactService {

	<S extends Contact> List<S> findAll(Example<S> example, Sort sort);

	<S extends Contact> boolean exists(Example<S> example);

	void deleteAll();

	<S extends Contact> List<S> findAll(Example<S> example);

	void delete(Iterable<? extends Contact> entities);

	<S extends Contact> long count(Example<S> example);

	Contact getOne(Long id);

	void delete(Contact entity);

	void deleteAllInBatch();

	void delete(Long id);

	<S extends Contact> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Contact> entities);

	long count();

	<S extends Contact> S saveAndFlush(S entity);

	void flush();

	<S extends Contact> List<S> save(Iterable<S> entities);

	boolean exists(Long id);

	List<Contact> findAll(Iterable<Long> ids);

	List<Contact> findAll(Sort sort);

	Contact findOne(Long id);

	List<Contact> findAll();

	Page<Contact> findAll(Pageable pageable);

	<S extends Contact> S findOne(Example<S> example);

	<S extends Contact> S save(S entity);

}
