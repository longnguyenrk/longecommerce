package com.vietshop.Service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vietshop.repository.RoleRepository;
import com.vietshop.Service.iRoleService;
import com.vietshop.entity.Role;

@Service // Để class có thể thực hiện cơ chế DI và IOC
public class RoleService implements iRoleService{
	@Autowired
	RoleRepository roleRepository;

	public Role getOne(Integer id) {
		return roleRepository.getOne(id);
	}

	
}
