package com.vietshop.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.vietshop.Entity.CartItem;
import com.vietshop.Entity.Order;
import com.vietshop.Entity.Role;

/*@PasswordMatches*/
public class AccountDTO {
	
	private Long id;
	
	@NotBlank(message = "username không được trống")
	private String userName;
	
	@NotBlank(message = "fullname không được trống")
	@Pattern(regexp = "[a-zA-Z][a-zA-Z ]+")
	private String fullName;
	
	@NotBlank(message = "address không được trống")
	private String address;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "DoB must in the past")
	private LocalDate dob;
	
	@NotBlank(message = "phone không được trống")
	private String phone;
	
	@Length(min = 6,message = "Password phải từ 6 kí tự trở lên")
	private String oldpass;
	
	@Length(min = 6,message = "Password phải từ 6 kí tự trở lên")
	private String newpass;
	
	private Integer idRole;
	
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
	public Integer getidRole() {
		return idRole;
	}
	public void setidRole(Integer idRole) {
		this.idRole = idRole;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	
}
