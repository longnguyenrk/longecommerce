package com.vietshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vietshop.Entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long>{
	@Query("SELECT p FROM OrderDetails p WHERE p.product.idProduct = :idProduct")
	public OrderDetails getOrderDetailsByIdProduct(@Param("idProduct") Long idProduct);
	
//	@Query("SELECT p FROM OrderDetails p WHERE p.product.idProduct = :idProduct")
//	public OrderDetails findByIdOrder(Long idOrder);
	
	
}
