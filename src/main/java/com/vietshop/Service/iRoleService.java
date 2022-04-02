package com.vietshop.Service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vietshop.Entity.OrderDetails;
import com.vietshop.Entity.Role;

public interface iRoleService {

	<S extends Role> List<S> findAll(Example<S> example, Sort sort);

	<S extends Role> boolean exists(Example<S> example);

	void deleteAll();

	<S extends Role> List<S> findAll(Example<S> example);

	void delete(Iterable<? extends Role> entities);

	<S extends Role> long count(Example<S> example);

	Role getOne(Long id);

	void delete(Role entity);

	void deleteAllInBatch();

	void delete(Long id);

	<S extends Role> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Role> entities);

	long count();

	<S extends Role> S saveAndFlush(S entity);

	void flush();

	<S extends Role> List<S> save(Iterable<S> entities);

	boolean exists(Long id);

	List<Role> findAll(Iterable<Long> ids);

	List<Role> findAll(Sort sort);

	Role findOne(Long id);

	List<Role> findAll();

	Page<Role> findAll(Pageable pageable);

	<S extends Role> S findOne(Example<S> example);

	<S extends Role> S save(S entity);

	
}
