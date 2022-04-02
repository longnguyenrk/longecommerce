package com.vietshop.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vietshop.Entity.CartItem;
import com.vietshop.Service.iCartItemService;
import com.vietshop.repository.CartItemRepository;

@Service
public class CartItemService implements iCartItemService{
	@Autowired 
	public CartItemRepository cartItemRepo;

	@Override
	public void deleteAll() {
		cartItemRepo.deleteAll();
	}

	@Override
	public <S extends CartItem> S save(S entity) {
		return cartItemRepo.save(entity);
	}

	@Override
	public <S extends CartItem> List<S> save(Iterable<S> entities) {
		return cartItemRepo.save(entities);
	}

	@Override
	public void deleteByIdAccount(Long idAccount) {
		cartItemRepo.deleteByIdAccount(idAccount);
	}
	
	
	
	

}
