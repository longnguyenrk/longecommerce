package com.vietshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vietshop.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long>{
	
}
