package com.vietshop.Entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRole;
	
	@Column(name="name")
	private String name;
	
	@Column(name="code")
	private String code;
	
	@OneToMany(mappedBy="role")
	private List<Account> accountList;
	
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

	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public List<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	
	
	
	 
}