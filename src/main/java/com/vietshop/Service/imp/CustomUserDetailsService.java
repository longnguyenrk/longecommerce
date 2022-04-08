package com.vietshop.Service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vietshop.constant.SystemConstant;
import com.vietshop.dto.MyUserDTO;
import com.vietshop.entity.Account;
import com.vietshop.entity.Role;
import com.vietshop.repository.AccountRepository;

@Service // Để class có thể thực hiện cơ chế DI và IOC
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);

		// Nếu username hoặc mk sai
		if (account == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		// Tạo list các authortiteis từ class GrantedAuthority của Spring Security
		List<GrantedAuthority> authorities = new ArrayList<>();
		// Duyệt qua các account và lấy ra role tương ứng

		// Set giá trị code tương ứng của role cho authorities
		authorities.add(new SimpleGrantedAuthority(account.getRole().getCode()));

		// Put thông tin vào Security, duy trì thông tin khi user login vào hệ thống

		MyUserDTO myUser = new MyUserDTO(account.getUserName(), account.getPassword(), true, true, true, true,
				authorities);
		myUser.setFullName(account.getFullName());
		return myUser; // Vì UserDetail là 1 interface mà class User implements, trong khi myUser
						// extends User nên kết quả trả về là myUser
	}

}
