package com.vietshop.Service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vietshop.entity.CreditCard;
import com.vietshop.repository.CreditCardRepository;

@Service
public class CreditCardService {
@Autowired

private CreditCardRepository careditCardRepo;

public <S extends CreditCard> S save(S entity) {
	return careditCardRepo.save(entity);
}

public <S extends CreditCard> S findOne(Example<S> example) {
	return careditCardRepo.findOne(example);
}

public Page<CreditCard> findAll(Pageable pageable) {
	return careditCardRepo.findAll(pageable);
}

public List<CreditCard> findAll() {
	return careditCardRepo.findAll();
}

public CreditCard findOne(Long id) {
	return careditCardRepo.findOne(id);
}

public List<CreditCard> findAll(Sort sort) {
	return careditCardRepo.findAll(sort);
}

public List<CreditCard> findAll(Iterable<Long> ids) {
	return careditCardRepo.findAll(ids);
}

public boolean exists(Long id) {
	return careditCardRepo.exists(id);
}

public <S extends CreditCard> List<S> save(Iterable<S> entities) {
	return careditCardRepo.save(entities);
}

public void flush() {
	careditCardRepo.flush();
}

public <S extends CreditCard> S saveAndFlush(S entity) {
	return careditCardRepo.saveAndFlush(entity);
}

public long count() {
	return careditCardRepo.count();
}

public void deleteInBatch(Iterable<CreditCard> entities) {
	careditCardRepo.deleteInBatch(entities);
}

public <S extends CreditCard> Page<S> findAll(Example<S> example, Pageable pageable) {
	return careditCardRepo.findAll(example, pageable);
}

public void delete(Long id) {
	careditCardRepo.delete(id);
}

public void deleteAllInBatch() {
	careditCardRepo.deleteAllInBatch();
}

public void delete(CreditCard entity) {
	careditCardRepo.delete(entity);
}

public CreditCard getOne(Long id) {
	return careditCardRepo.getOne(id);
}

public <S extends CreditCard> long count(Example<S> example) {
	return careditCardRepo.count(example);
}

public void delete(Iterable<? extends CreditCard> entities) {
	careditCardRepo.delete(entities);
}

public <S extends CreditCard> List<S> findAll(Example<S> example) {
	return careditCardRepo.findAll(example);
}

public void deleteAll() {
	careditCardRepo.deleteAll();
}

public <S extends CreditCard> boolean exists(Example<S> example) {
	return careditCardRepo.exists(example);
}

public <S extends CreditCard> List<S> findAll(Example<S> example, Sort sort) {
	return careditCardRepo.findAll(example, sort);
}

public CreditCard findByCardNumber(String cardNumber) {
	return careditCardRepo.findByCardNumber(cardNumber);
}


}
