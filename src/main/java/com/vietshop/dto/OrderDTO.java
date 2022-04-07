package com.vietshop.dto;

import java.util.Date;
import java.util.List;

import com.vietshop.Entity.Account;
import com.vietshop.Entity.OrderDetails;
import com.vietshop.Entity.ShippingInfo;

public class OrderDTO {
private Long idOrder;
	

	private Date dateOrder;
	
	private String status;

	private double subTotal;

	private Account account;
	
	private List<OrderDetails> OrderDetailsList;
	
	private ShippingInfo shippingInfo;

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<OrderDetails> getOrderDetailsList() {
		return OrderDetailsList;
	}

	public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
		OrderDetailsList = orderDetailsList;
	}

	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}

	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
	
	
}
