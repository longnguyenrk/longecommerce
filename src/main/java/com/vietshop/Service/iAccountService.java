package com.vietshop.Service;

import java.util.List;
import java.util.Optional;

import org.omg.CORBA.UserException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vietshop.Entity.Account;
import com.vietshop.dto.AccountDTO;

public interface iAccountService {

	

	Page<Account> findByUserName(String keyword, Pageable pageable);

	Account findByUserName(String userName);

	Account findByEmail(String email);

	Account findOneByUserNameAndStatus(String name, int status);

	boolean userExist(String username);

	boolean emailExist(String email);

	Account registerNewUserAccount(AccountDTO accountDto) throws UserException;

	void deleteInBatch(Iterable<Account> entities);

	long count();

	void flush();

	boolean exists(Long id);

	List<Account> findAll(Iterable<Long> ids);

	List<Account> findAll(Sort sort);

	Account findOne(Long id);

	List<Account> findAll();

	Page<Account> findAll(Pageable pageable);

	Optional<Account> findByIdAccount(Long id);

	void deleteByIdAccount(Long id);

	<S extends Account> S save(S entity);

	Account getOne(Long id);

	void delete(Long id);



	
}
