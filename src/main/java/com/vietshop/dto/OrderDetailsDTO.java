package com.vietshop.dto;

public class OrderDetailsDTO {

	private Long idOrderdetails;

	private Long quantity;

	private double total;

	private ProductDTO productDTO;

	private OrderDTO orderDTO;

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

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public OrderDTO getOrderDTO() {
		return orderDTO;
	}

	public void setOrderDTO(OrderDTO orderDTO) {
		this.orderDTO = orderDTO;
	}

}
