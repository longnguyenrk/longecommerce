package com.vietshop.dto;
import java.util.Date;


public class PaymentDTO {
	private Long id;
	
	private Date paymentDate;
	
	private double amount;
	
	private String status;
	
	private OrderDTO orderDTO;
	

	private CreditCardDTO creditCardDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrderDTO getOrderDTO() {
		return orderDTO;
	}

	public void setOrderDTO(OrderDTO orderDTO) {
		this.orderDTO = orderDTO;
	}

	public CreditCardDTO getCreditCardDTO() {
		return creditCardDTO;
	}

	public void setCreditCardDTO(CreditCardDTO creditCardDTO) {
		this.creditCardDTO = creditCardDTO;
	}


	
	
	
	
	
	
	 
}