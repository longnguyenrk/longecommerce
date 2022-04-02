package com.vietshop.dto;

import java.util.Date;
import java.util.List;

import com.vietshop.Entity.Account;
import com.vietshop.Entity.OrderDetails;

public class OrderDTO {
	private Long idOrder;
	private Date dateOrder;
	private String status;
	private double priceTotal;
	private Account account;
	private List<OrderDetails> OrderDetailsList;

public Long getIdOrder() {
	return idOrder;
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

public double getPriceTotal() {
	return priceTotal;
}

public void setPriceTotal(double priceTotal) {
	this.priceTotal = priceTotal;
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

public void setIdOrder(Long idOrder) {
	this.idOrder = idOrder;
}


}
