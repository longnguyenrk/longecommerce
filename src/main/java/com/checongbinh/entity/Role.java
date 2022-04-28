package com.checongbinh.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	Integer id;
	@Column(name = "name", length = 45)
	String name;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	Set<UsersRoles> usersRoleses = new HashSet<UsersRoles>(0);

	public Role() {
	}

	public Role(String name, Set<UsersRoles> usersRoleses) {
		this.name = name;
		this.usersRoleses = usersRoleses;
	}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Set<UsersRoles> getUsersRoleses() {
		return this.usersRoleses;
	}

	public void setUsersRoleses(Set<UsersRoles> usersRoleses) {
		this.usersRoleses = usersRoleses;
	}

}
