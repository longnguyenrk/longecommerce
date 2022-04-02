package com.vietshop.dto;

import java.util.ArrayList;
import java.util.List;

import com.vietshop.Entity.Account;

public class RoleDTO extends AbstractDTO<RoleDTO>{
	private String name;
	private String code;
	private List<Account> accs= new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Account> getAccs() {
		return accs;
	}
	public void setAccs(List<Account> accs) {
		this.accs = accs;
	}
	

}
