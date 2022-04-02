package com.vietshop.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;

import com.vietshop.Entity.CartItem;
import com.vietshop.Entity.Order;
import com.vietshop.Entity.Role;

/*@PasswordMatches*/
public class AccountDTO {
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	private Long id;

	private String userName;
	
	private String fullName;
	
	private String address;
	
	private String phone;
	
	private String oldpass;
	
	private String newpass;
	
	private int role;
	
	private Integer status;
	
	@Email
	private String email;
	
	private List<Order> Orders;
	
	private List<Role> roles= new ArrayList<>();
	
	private List<CartItem> cartItems = new ArrayList<>();
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/*
	 * public String getMatchingPassword() { return matchingPassword; } public void
	 * setMatchingPassword(String matchingPassword) { this.matchingPassword =
	 * matchingPassword; }
	 */
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Order> getOrders() {
		return Orders;
	}
	public void setOrders(List<Order> orders) {
		Orders = orders;
	}
	public String getOldpass() {
		return oldpass;
	}
	public void setOldpass(String oldpass) {
		this.oldpass = oldpass;
	}
	public String getNewpass() {
		return newpass;
	}
	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}
	
	
	
}
