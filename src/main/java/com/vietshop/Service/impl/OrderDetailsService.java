package com.vietshop.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vietshop.Entity.CartItem;
import com.vietshop.Entity.Order;
import com.vietshop.Entity.OrderDetails;
import com.vietshop.Service.iOrderDetailsService;
import com.vietshop.repository.OrderDetailsRepository;
@Service // Để class có thể thực hiện cơ chế DI và IOC
public class OrderDetailsService implements iOrderDetailsService {
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Override
	public <S extends OrderDetails> S save(S entity) {
		return orderDetailsRepository.save(entity);
	}

	@Override
	public <S extends OrderDetails> S findOne(Example<S> example) {
		return orderDetailsRepository.findOne(example);
	}

	@Override
	public Page<OrderDetails> findAll(Pageable pageable) {
		return orderDetailsRepository.findAll(pageable);
	}

	@Override
	public List<OrderDetails> findAll() {
		return orderDetailsRepository.findAll();
	}

	@Override
	public OrderDetails findOne(Long id) {
		return orderDetailsRepository.findOne(id);
	}

	@Override
	public List<OrderDetails> findAll(Sort sort) {
		return orderDetailsRepository.findAll(sort);
	}

	@Override
	public List<OrderDetails> findAll(Iterable<Long> ids) {
		return orderDetailsRepository.findAll(ids);
	}

	@Override
	public boolean exists(Long id) {
		return orderDetailsRepository.exists(id);
	}

	@Override
	public <S extends OrderDetails> List<S> save(Iterable<S> entities) {
		return orderDetailsRepository.save(entities);
	}

	@Override
	public void flush() {
		orderDetailsRepository.flush();
	}

	@Override
	public <S extends OrderDetails> S saveAndFlush(S entity) {
		return orderDetailsRepository.saveAndFlush(entity);
	}

	@Override
	public long count() {
		return orderDetailsRepository.count();
	}

	@Override
	public void deleteInBatch(Iterable<OrderDetails> entities) {
		orderDetailsRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends OrderDetails> Page<S> findAll(Example<S> example, Pageable pageable) {
		return orderDetailsRepository.findAll(example, pageable);
	}

	@Override
	public void delete(Long id) {
		orderDetailsRepository.delete(id);
	}

	@Override
	public void deleteAllInBatch() {
		orderDetailsRepository.deleteAllInBatch();
	}

	@Override
	public void delete(OrderDetails entity) {
		orderDetailsRepository.delete(entity);
	}

	@Override
	public OrderDetails getOne(Long id) {
		return orderDetailsRepository.getOne(id);
	}

	@Override
	public <S extends OrderDetails> long count(Example<S> example) {
		return orderDetailsRepository.count(example);
	}

	@Override
	public void delete(Iterable<? extends OrderDetails> entities) {
		orderDetailsRepository.delete(entities);
	}

	@Override
	public <S extends OrderDetails> List<S> findAll(Example<S> example) {
		return orderDetailsRepository.findAll(example);
	}

	@Override
	public void deleteAll() {
		orderDetailsRepository.deleteAll();
	}

	@Override
	public <S extends OrderDetails> boolean exists(Example<S> example) {
		return orderDetailsRepository.exists(example);
	}

	@Override
	public <S extends OrderDetails> List<S> findAll(Example<S> example, Sort sort) {
		return orderDetailsRepository.findAll(example, sort);
	}

	@Override
	public OrderDetails getOrderDetailsByIdProduct(Long idProduct) {
		return orderDetailsRepository.getOrderDetailsByIdProduct(idProduct);
	}
	
	@Override
	public void insert(CartItem cartItem,Order order) {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setProduct(cartItem.getProduct());
		orderDetails.setQuantity(cartItem.getQuantity());
		orderDetails.setTotal(cartItem.getTotal());
		orderDetails.setOrder(order);
		orderDetailsRepository.save(orderDetails);
	}
	
}
