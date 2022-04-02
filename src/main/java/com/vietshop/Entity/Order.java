package com.vietshop.Entity;

import java.util.List;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "orders")
public class Order {
	@Id
	@Column(name = "idOrder")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrder;
	
	@Column(name = "dateOrder")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOrder;
	
	@Column(name = "status")
	private String status;

	@Column(name = "sub_total")
	private double subTotal;

	@ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "id_account")
	private Account account;
	
	@OneToMany(mappedBy = "order")
	private List<OrderDetails> OrderDetailsList;
	
	@OneToOne(mappedBy = "order")
	private ShippingInfo shippingInfo;
	

	public Order() {

	}

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

	public double getPriceTotal() {
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

	public double getSubTotal() {
		return subTotal;
	}

	

	
}
