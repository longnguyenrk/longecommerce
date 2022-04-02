package com.vietshop.Service;

import java.util.List;

import com.vietshop.Entity.CartItem;

public interface iCartItemService {

	<S extends CartItem> List<S> save(Iterable<S> entities);

	<S extends CartItem> S save(S entity);

	void deleteAll();

	void deleteByIdAccount(Long idAccount);

}
