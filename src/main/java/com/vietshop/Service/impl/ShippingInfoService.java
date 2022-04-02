package com.vietshop.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vietshop.Entity.ShippingInfo;
import com.vietshop.repository.ShippingInfoRepository;

@Service
public class ShippingInfoService {
@Autowired
private ShippingInfoRepository shippingInfoRepo;

public <S extends ShippingInfo> S save(S entity) {
	return shippingInfoRepo.save(entity);
}

public <S extends ShippingInfo> S findOne(Example<S> example) {
	return shippingInfoRepo.findOne(example);
}

public Page<ShippingInfo> findAll(Pageable pageable) {
	return shippingInfoRepo.findAll(pageable);
}

public List<ShippingInfo> findAll() {
	return shippingInfoRepo.findAll();
}

public ShippingInfo findOne(Long id) {
	return shippingInfoRepo.findOne(id);
}

public List<ShippingInfo> findAll(Sort sort) {
	return shippingInfoRepo.findAll(sort);
}

public List<ShippingInfo> findAll(Iterable<Long> ids) {
	return shippingInfoRepo.findAll(ids);
}

public boolean exists(Long id) {
	return shippingInfoRepo.exists(id);
}

public <S extends ShippingInfo> List<S> save(Iterable<S> entities) {
	return shippingInfoRepo.save(entities);
}

public void flush() {
	shippingInfoRepo.flush();
}

public <S extends ShippingInfo> S saveAndFlush(S entity) {
	return shippingInfoRepo.saveAndFlush(entity);
}

public long count() {
	return shippingInfoRepo.count();
}

public void deleteInBatch(Iterable<ShippingInfo> entities) {
	shippingInfoRepo.deleteInBatch(entities);
}

public <S extends ShippingInfo> Page<S> findAll(Example<S> example, Pageable pageable) {
	return shippingInfoRepo.findAll(example, pageable);
}

public void delete(Long id) {
	shippingInfoRepo.delete(id);
}

public void deleteAllInBatch() {
	shippingInfoRepo.deleteAllInBatch();
}

public void delete(ShippingInfo entity) {
	shippingInfoRepo.delete(entity);
}

public ShippingInfo getOne(Long id) {
	return shippingInfoRepo.getOne(id);
}

public <S extends ShippingInfo> long count(Example<S> example) {
	return shippingInfoRepo.count(example);
}

public void delete(Iterable<? extends ShippingInfo> entities) {
	shippingInfoRepo.delete(entities);
}

public <S extends ShippingInfo> List<S> findAll(Example<S> example) {
	return shippingInfoRepo.findAll(example);
}

public void deleteAll() {
	shippingInfoRepo.deleteAll();
}

public <S extends ShippingInfo> boolean exists(Example<S> example) {
	return shippingInfoRepo.exists(example);
}

public <S extends ShippingInfo> List<S> findAll(Example<S> example, Sort sort) {
	return shippingInfoRepo.findAll(example, sort);
}

}
