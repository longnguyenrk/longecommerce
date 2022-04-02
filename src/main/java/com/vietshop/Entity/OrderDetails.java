package com.vietshop.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderdetails")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrderdetails;
	
	@Column(name="quantity")
	private Long quantity;
	
	@Column(name="subTotal")
	private double total;
	
	@JoinColumn(name="id_Product")
	@ManyToOne
	private Product product;
	
	@JoinColumn(name="id_Order")
	@ManyToOne(cascade = {CascadeType.MERGE })
	private Order order;
	
	

	public Long getIdOrderdetails() {
		return idOrderdetails;
	}

	public void setIdOrderdetails(Long idOrderdetails) {
		this.idOrderdetails = idOrderdetails;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
	
	
}
