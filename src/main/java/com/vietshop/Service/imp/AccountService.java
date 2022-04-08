package com.vietshop.Service.imp;

import java.util.List;
import java.util.Optional;

import org.omg.CORBA.UserException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vietshop.dto.AccountDTO;
import com.vietshop.entity.Account;
import com.vietshop.entity.Role;
import com.vietshop.repository.AccountRepository;
import com.vietshop.repository.RoleRepository;
import com.vietshop.Service.iAccountService;
@Service // Để class có thể thực hiện cơ chế DI và IOC
public class AccountService implements iAccountService{
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	public RoleService roleService;
	
	@Autowired
	
	public RoleRepository roleRepository;
	
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
	
	
	public AccountDTO findByIdAccountDTO(Long id) {
		Account account = accountRepository.findOne(id);
		
		AccountDTO accountDTO = new AccountDTO();

		BeanUtils.copyProperties(account, accountDTO);
		
		return accountDTO;
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
	public void updateAccount(AccountDTO accountDTO) {
		Account account = accountRepository.findOne(accountDTO.getId());
		BeanUtils.copyProperties(accountDTO, account);
		accountRepository.save(account);
	}
	@Override
	public void activeAccount(Long idAccount ) {
		Account account = accountRepository.findOne(idAccount);
		account.setStatus(1);
		accountRepository.save(account);
	}
	@Override
	public void deActiveAccount(Long idAccount ) {
		Account account = accountRepository.findOne(idAccount);
		account.setStatus(0);
		accountRepository.save(account);
	}
	
	public void register(AccountDTO accountDTO) {
		Role role = new Role();
		role = roleRepository.getOne(accountDTO.getidRole());
		Account newAcc = new Account();
		newAcc.setUserName(accountDTO.getUserName());
		newAcc.setPassword(passwordEncoder.encode(accountDTO.getNewpass()));
		newAcc.setDob(accountDTO.getDob());
		newAcc.setAddress(accountDTO.getAddress());
		newAcc.setFullName(accountDTO.getFullName());
		newAcc.setPhone(accountDTO.getPhone());
		newAcc.setEmail(accountDTO.getEmail());
		newAcc.setStatus(1);
		newAcc.setRole(role);
		accountRepository.save(newAcc);
	}
	
}
