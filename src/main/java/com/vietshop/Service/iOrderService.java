package com.vietshop.Service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vietshop.Entity.Order;

public interface iOrderService {

	

	<S extends Order> boolean exists(Example<S> example);

	void deleteAll();


	void delete(Iterable<? extends Order> entities);

	<S extends Order> long count(Example<S> example);

	Order getOne(Long id);

	void delete(Order entity);

	void deleteAllInBatch();

	void delete(Long id);

	<S extends Order> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Order> entities);

	long count();

	<S extends Order> S saveAndFlush(S entity);

	void flush();

	<S extends Order> List<S> save(Iterable<S> entities);

	boolean exists(Long id);

	

	Order findOne(Long id);


	Page<Order> findAll(Pageable pageable);

	<S extends Order> S findOne(Example<S> example);

	<S extends Order> S save(S entity);

	Order getOrderByUserName(String username);


}
