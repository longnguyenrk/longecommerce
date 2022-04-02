package com.vietshop.Service.impl;

import java.util.List;
import java.util.Optional;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vietshop.Entity.Account;
import com.vietshop.Entity.Product;
import com.vietshop.Service.iAccountService;
import com.vietshop.dto.AccountDTO;
import com.vietshop.repository.AccountRepository;
@Service // Để class có thể thực hiện cơ chế DI và IOC
public class AccountService implements iAccountService{
	public List<Account> findAllCustomer() {
		return accountRepository.findAllCustomer();
	}

	@Autowired
	AccountRepository accountRepository;
	@Override
	public Page<Account> findAll(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account findOne(Long id) {
		return accountRepository.findOne(id);
	}

	@Override
	public List<Account> findAll(Sort sort) {
		return accountRepository.findAll(sort);
	}

	@Override
	public List<Account> findAll(Iterable<Long> ids) {
		return accountRepository.findAll(ids);
	}

	@Override
	public boolean exists(Long id) {
		return accountRepository.exists(id);
	}

	@Override
	public void flush() {
		accountRepository.flush();
	}


	@Override
	public long count() {
		return accountRepository.count();
	}

	@Override
	public void deleteInBatch(Iterable<Account> entities) {
		accountRepository.deleteInBatch(entities);
	}

	@Override
	public Account registerNewUserAccount(AccountDTO accountDto) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean emailExist(String email) {
        return accountRepository.findByEmail(email) != null;
    }
	@Override
	public boolean userExist(String username) {
        return accountRepository.findByUserName(username) != null;
    }

	@Override
	public Account findOneByUserNameAndStatus(String name, int status) {
		return accountRepository.findOneByUserNameAndStatus(name, status);
	}

	@Override
	public Account findByEmail(String email) {
		return accountRepository.findByEmail(email);
	}

	@Override
	public Account findByUserName(String userName) {
		return accountRepository.findByUserName(userName);
	}

	@Override
	public Page<Account> findByUserName(String keyword, Pageable pageable) {
		return accountRepository.findByUserName(keyword,pageable);
	}

	@Override
	public Optional<Account> findByIdAccount(Long id) {
		return accountRepository.findByIdAccount(id);
	}

	@Override
	public void deleteByIdAccount(Long id) {
		accountRepository.deleteByIdAccount(id);
	}
	@Override
	public <S extends Account> S save(S entity) {
		return accountRepository.save(entity);
	}
	@Override
	public Account getOne(Long id) {
		return accountRepository.getOne(id);
	}

	@Override
	public void delete(Long id) {
		accountRepository.delete(id);
	}
	
	
}
