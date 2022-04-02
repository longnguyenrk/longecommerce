package com.vietshop.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vietshop.Entity.Order;
import com.vietshop.Entity.Role;
import com.vietshop.Service.iOrderService;
import com.vietshop.Service.iRoleService;
import com.vietshop.repository.OrderRepository;
import com.vietshop.repository.RoleRepository;

@Service // Để class có thể thực hiện cơ chế DI và IOC
public class RoleService implements iRoleService{
	@Autowired
	RoleRepository roleRepository;

	@Override
	public <S extends Role> S save(S entity) {
		return roleRepository.save(entity);
	}

	@Override
	public <S extends Role> S findOne(Example<S> example) {
		return roleRepository.findOne(example);
	}

	@Override
	public Page<Role> findAll(Pageable pageable) {
		return roleRepository.findAll(pageable);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findOne(Long id) {
		return roleRepository.findOne(id);
	}

	@Override
	public List<Role> findAll(Sort sort) {
		return roleRepository.findAll(sort);
	}

	@Override
	public List<Role> findAll(Iterable<Long> ids) {
		return roleRepository.findAll(ids);
	}

	@Override
	public boolean exists(Long id) {
		return roleRepository.exists(id);
	}

	@Override
	public <S extends Role> List<S> save(Iterable<S> entities) {
		return roleRepository.save(entities);
	}

	@Override
	public void flush() {
		roleRepository.flush();
	}

	@Override
	public <S extends Role> S saveAndFlush(S entity) {
		return roleRepository.saveAndFlush(entity);
	}

	@Override
	public long count() {
		return roleRepository.count();
	}

	@Override
	public void deleteInBatch(Iterable<Role> entities) {
		roleRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
		return roleRepository.findAll(example, pageable);
	}

	@Override
	public void delete(Long id) {
		roleRepository.delete(id);
	}

	@Override
	public void deleteAllInBatch() {
		roleRepository.deleteAllInBatch();
	}

	@Override
	public void delete(Role entity) {
		roleRepository.delete(entity);
	}

	@Override
	public Role getOne(Long id) {
		return roleRepository.getOne(id);
	}

	@Override
	public <S extends Role> long count(Example<S> example) {
		return roleRepository.count(example);
	}

	@Override
	public void delete(Iterable<? extends Role> entities) {
		roleRepository.delete(entities);
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> example) {
		return roleRepository.findAll(example);
	}

	@Override
	public void deleteAll() {
		roleRepository.deleteAll();
	}

	@Override
	public <S extends Role> boolean exists(Example<S> example) {
		return roleRepository.exists(example);
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
		return roleRepository.findAll(example, sort);
	}
	

}
