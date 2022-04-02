package com.vietshop.Service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vietshop.Entity.CartItem;
import com.vietshop.Entity.Order;
import com.vietshop.Entity.OrderDetails;

public interface iOrderDetailsService {

	<S extends OrderDetails> List<S> findAll(Example<S> example, Sort sort);

	<S extends OrderDetails> boolean exists(Example<S> example);

	void deleteAll();

	<S extends OrderDetails> List<S> findAll(Example<S> example);

	void delete(Iterable<? extends OrderDetails> entities);

	<S extends OrderDetails> long count(Example<S> example);

	OrderDetails getOne(Long id);

	void delete(OrderDetails entity);

	void deleteAllInBatch();

	void delete(Long id);

	<S extends OrderDetails> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<OrderDetails> entities);

	long count();

	<S extends OrderDetails> S saveAndFlush(S entity);

	void flush();

	<S extends OrderDetails> List<S> save(Iterable<S> entities);

	boolean exists(Long id);

	List<OrderDetails> findAll(Iterable<Long> ids);

	List<OrderDetails> findAll(Sort sort);

	OrderDetails findOne(Long id);

	List<OrderDetails> findAll();

	Page<OrderDetails> findAll(Pageable pageable);

	<S extends OrderDetails> S findOne(Example<S> example);

	<S extends OrderDetails> S save(S entity);

	OrderDetails getOrderDetailsByIdProduct(Long idProduct);

	void insert(CartItem cartItem,Order order);

}
