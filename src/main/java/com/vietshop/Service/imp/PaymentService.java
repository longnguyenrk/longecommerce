package com.vietshop.Service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vietshop.entity.Payment;
import com.vietshop.repository.PaymentRepository;
@Service
public class PaymentService {
@Autowired
private PaymentRepository paymentRepo;

public <S extends Payment> S save(S entity) {
	return paymentRepo.save(entity);
}

public <S extends Payment> S findOne(Example<S> example) {
	return paymentRepo.findOne(example);
}

public Page<Payment> findAll(Pageable pageable) {
	return paymentRepo.findAll(pageable);
}

public List<Payment> findAll() {
	return paymentRepo.findAll();
}

public Payment findOne(Long id) {
	return paymentRepo.findOne(id);
}

public List<Payment> findAll(Sort sort) {
	return paymentRepo.findAll(sort);
}

public List<Payment> findAll(Iterable<Long> ids) {
	return paymentRepo.findAll(ids);
}

public boolean exists(Long id) {
	return paymentRepo.exists(id);
}

public <S extends Payment> List<S> save(Iterable<S> entities) {
	return paymentRepo.save(entities);
}

public void flush() {
	paymentRepo.flush();
}

public <S extends Payment> S saveAndFlush(S entity) {
	return paymentRepo.saveAndFlush(entity);
}

public long count() {
	return paymentRepo.count();
}

public void deleteInBatch(Iterable<Payment> entities) {
	paymentRepo.deleteInBatch(entities);
}

public <S extends Payment> Page<S> findAll(Example<S> example, Pageable pageable) {
	return paymentRepo.findAll(example, pageable);
}

public void delete(Long id) {
	paymentRepo.delete(id);
}

public void deleteAllInBatch() {
	paymentRepo.deleteAllInBatch();
}

public void delete(Payment entity) {
	paymentRepo.delete(entity);
}

public Payment getOne(Long id) {
	return paymentRepo.getOne(id);
}

public <S extends Payment> long count(Example<S> example) {
	return paymentRepo.count(example);
}

public void delete(Iterable<? extends Payment> entities) {
	paymentRepo.delete(entities);
}

public <S extends Payment> List<S> findAll(Example<S> example) {
	return paymentRepo.findAll(example);
}

public void deleteAll() {
	paymentRepo.deleteAll();
}

public <S extends Payment> boolean exists(Example<S> example) {
	return paymentRepo.exists(example);
}

public <S extends Payment> List<S> findAll(Example<S> example, Sort sort) {
	return paymentRepo.findAll(example, sort);
}



}
