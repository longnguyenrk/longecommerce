package com.checongbinh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "usersroles")
public class UsersRoles{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	Integer id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role")
	private Role role;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NHANVIEN")
	private NhanVien nhanVien;

	
	public UsersRoles() {
	}
	

	public UsersRoles(Role role, NhanVien nhanVien) {
		this.role = role;
		this.nhanVien = nhanVien;
	}

	

	

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	
	public NhanVien getNhanVien() {
		return nhanVien;
	}


	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}


	
	/*public User getUsers() {
		return this.users;
	}

	public void setUsers(User users) {
		this.users = users;
	}*/

}
