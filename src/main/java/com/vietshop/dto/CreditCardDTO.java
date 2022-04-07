package com.vietshop.dto;

import java.util.List;


public class CreditCardDTO {
	private Long id;
	
	private String name;
	
	private String cardNumber;
	
	private int expMonth;
	
	private int expYear;
	
	private int cvcCode;
	
	private double balance;
		
	private List<PaymentDTO> paymentDTOList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	public int getCvcCode() {
		return cvcCode;
	}

	public void setCvcCode(int cvcCode) {
		this.cvcCode = cvcCode;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}



	public List<PaymentDTO> getPaymenpaymentDTOListtList() {
		return paymentDTOList;
	}

	public void setPaymentpaymentDTOListList(List<PaymentDTO> paymentDTOList) {
		this.paymentDTOList = paymentDTOList;
	}
	
	
	
	
	
}
