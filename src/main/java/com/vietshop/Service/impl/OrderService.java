package com.vietshop.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.hibernate.SessionFactory;

import com.vietshop.Entity.Order;
import com.vietshop.Service.iOrderService;
import com.vietshop.repository.OrderRepository;

@Service // Để class có thể thực hiện cơ chế DI và IOC
public class OrderService implements iOrderService{
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public <S extends Order> S save(S entity) {
		return orderRepository.save(entity);
	}
	
	@Override
	public <S extends Order> S findOne(Example<S> example) {
		return orderRepository.findOne(example);
	}

	@Override
	public Page<Order> findAll(Pageable pageable) {
		return orderRepository.findAll(pageable);
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order findOne(Long id) {
		return orderRepository.findOne(id);
	}

	@Override
	public List<Order> findAll(Sort sort) {
		return orderRepository.findAll(sort);
	}

	@Override
	public List<Order> findAll(Iterable<Long> ids) {
		return orderRepository.findAll(ids);
	}

	@Override
	public boolean exists(Long id) {
		return orderRepository.exists(id);
	}

	@Override
	public <S extends Order> List<S> save(Iterable<S> entities) {
		return orderRepository.save(entities);
	}

	@Override
	public void flush() {
		orderRepository.flush();
	}

	@Override
	public <S extends Order> S saveAndFlush(S entity) {
		return orderRepository.saveAndFlush(entity);
	}

	@Override
	public long count() {
		return orderRepository.count();
	}

	@Override
	public void deleteInBatch(Iterable<Order> entities) {
		orderRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
		return orderRepository.findAll(example, pageable);
	}

	@Override
	public void delete(Long id) {
		orderRepository.delete(id);
	}

	@Override
	public void deleteAllInBatch() {
		orderRepository.deleteAllInBatch();
	}

	@Override
	public void delete(Order entity) {
		orderRepository.delete(entity);
	}

	@Override
	public Order getOne(Long id) {
		return orderRepository.getOne(id);
	}

	@Override
	public <S extends Order> long count(Example<S> example) {
		return orderRepository.count(example);
	}

	@Override
	public void delete(Iterable<? extends Order> entities) {
		orderRepository.delete(entities);
	}

	@Override
	public <S extends Order> List<S> findAll(Example<S> example) {
		return orderRepository.findAll(example);
	}

	@Override
	public void deleteAll() {
		orderRepository.deleteAll();
	}

	@Override
	public <S extends Order> boolean exists(Example<S> example) {
		return orderRepository.exists(example);
	}

	@Override
	public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
		return orderRepository.findAll(example, sort);
	}

	@Override
	public Order getOrderByUserName(String username) {
		return orderRepository.getOrderByUserName(username);
	}

	public Page<Order> findRecentOrder(Pageable page) {
		return orderRepository.findRecentOrder(page);
	}

	public Page<Order> searchOrder(String keyword, Pageable pageable) {
		return orderRepository.searchOrder(keyword, pageable);
	}

	public Page<Order> findRecentOrderByUsername(Pageable page, String username) {
		return orderRepository.findRecentOrderByUsername(page, username);
	}
	
	

}