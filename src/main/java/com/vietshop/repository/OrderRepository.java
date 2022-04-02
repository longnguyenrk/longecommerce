package com.vietshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vietshop.Entity.Order;
import com.vietshop.Entity.Product;

public interface OrderRepository extends JpaRepository<Order,Long>{
	@Query("SELECT p FROM Order p WHERE p.account.userName = :userName")
	public Order getOrderByUserName(@Param("userName") String username);
	
	@Query("SELECT p FROM Order p order by idOrder DESC")
	public Page<Order> findRecentOrder(Pageable page);
	
	@Query("SELECT u FROM Order u WHERE u.account.fullName LIKE %:keyword%")
	public Page<Order> searchOrder(@Param("keyword")String keyword,Pageable pageable);
	
	@Query("SELECT p FROM Order p WHERE p.account.userName = :userName order by idOrder DESC")
	public Page<Order> findRecentOrderByUsername(Pageable page,@Param("userName") String username);
}
