package com.vietshop.dto;

public class ShippingInfoDTO {
	private Long id;
	
	private String customer;
	
	private String phone;
	
	private String address;
	
	private String shippingType;
	
	private double shippingCost;
	
	private OrderDTO orderDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShippingType() {
		return shippingType;
	}

	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public OrderDTO getOrder() {
		return orderDTO;
	}

	public void setOrder(OrderDTO orderDTO) {
		this.orderDTO = orderDTO;
	}
	
	
	
	
	
	
}
