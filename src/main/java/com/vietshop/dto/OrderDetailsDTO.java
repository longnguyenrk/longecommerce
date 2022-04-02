package com.vietshop.dto;

public class OrderDetailsDTO {
	
private Long idOrderDetails;

private float price;

private int qTy;

private float subTotal;

private ProductDTO productDTO;

private OrderDTO orderDTO;

public Long getIdOrderDetails() {
	return idOrderDetails;
}
public void setIdOrderDetails(Long idOrderDetails) {
	this.idOrderDetails = idOrderDetails;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public int getqTy() {
	return qTy;
}
public void setqTy(int qTy) {
	this.qTy = qTy;
}
public float getSubTotal() {
	return subTotal;
}
public void setSubTotal(float subTotal) {
	this.subTotal = subTotal;
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
