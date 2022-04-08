package com.vietshop.Service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vietshop.entity.Account;
import com.vietshop.entity.CartItem;
import com.vietshop.repository.CartItemRepository;

@Service
public class ShoppingCartService {
	@Autowired
	private CartItemRepository cartItemRepository;

	public List<CartItem> cartItems(Account account){
		return cartItemRepository.findByAccount(account);
	}
	public void deteleProduct(Long idProduct) {
		 cartItemRepository.deleteByIdProduct(idProduct);
	}
	public void deleteAll() {
		cartItemRepository.deleteAll();
	}
	public void deleteAllInBatch() {
		cartItemRepository.deleteAllInBatch();
	}
	
	
}
