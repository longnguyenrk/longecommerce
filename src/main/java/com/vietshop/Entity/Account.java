package com.vietshop.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Username is required")
	private String userName;
	
	@NotBlank(message = "Password is required")
	private String password;
	
	@NotBlank(message = "Fullname is required")
	private String fullName;
	
	/*
	 * @NotNull(message = "DoB is required")
	 */	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "DoB must in the past")
	private LocalDate dob;
	
	@NotBlank(message = "Address is required")
	private String address;
	
	@NotBlank(message = "Phone number is required")
	private String phone;
	
	@NotBlank(message = "Email is required")
	private String email;
	
	@Column(name = "status")
	private Integer status;
	
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private List<Order> Orders;
	
	@JoinColumn(name = "idRole")
	@ManyToOne(cascade = {CascadeType.MERGE })
	private Role role;
	
	@OneToMany(mappedBy="account",cascade = CascadeType.ALL)
	private List<CartItem> cartItems;
	
	private double totalPrice;
	
	public Account() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
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

	public Integer getStatus() {
		return status;
	}
	

	public void setStatus(Integer status) {
		this.status = status;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Order> getOrders() {
		return Orders;
	}

	public void setOrders(List<Order> orders) {
		Orders = orders;
	}

	public void setId(String username2) {
		// TODO Auto-generated method stub
		
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	

}