package com.vietshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.vietshop.Entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{
	Account findOneByUserNameAndStatus(String name,int status);
	
	Account findByEmail(String email);
	
	Account findByUserName(String userName);
	
	@Query("SELECT u FROM Account u WHERE u.userName LIKE %:keyword%")
	Page<Account> findByUserName(@Param("keyword")String keyword,Pageable pageable);
	
	@Query("SELECT u FROM Account u WHERE u.role.idRole = 2")
	List<Account> findAllCustomer();
	
	@Query("SELECT u FROM Account u WHERE u.id = :id")
	Optional<Account> findByIdAccount(@Param("id")Long id);
	
	@Transactional 
	@Modifying
	@Query("delete from Account b where b.id=:id")
	void deleteByIdAccount(@Param("id") Long id);
}
