package com.vietshop.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.vietshop.Entity.CartItem;
import com.vietshop.Entity.Category;

public class ProductDTO {
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Transient
	private static final long serialVersionUID = -1975995400692617094L;
	private Long idProduct;
	private String Product;
	private double Cost;
	private String shortdescription;
	private String descriptions;
	@Transient
	private MultipartFile imageFile;
	private String imgUrl;
	private String unit;
	private Long quantity;
	private Long soldQuantity;
	private Long idCategory;
	private Category category;
	private Long weight;
	private String status;

	private List<ProductDTO> listResult = new ArrayList<>();
	private List<CartItem> cartItems;


	public Long getIdProduct() {
		return idProduct;
	}

	public String getProduct() {
		return Product;
	}
	
	public List<ProductDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<ProductDTO> listResult) {
		this.listResult = listResult;
	}

	public void setProduct(String product) {
		Product = product;
	}
	public double getCost() {
		return Cost;
	}
	public void setCost(double cost) {
		Cost = cost;
	}
	
	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getShortdescription() {
		return shortdescription;
	}
	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	
	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public Long getSoldQuantity() {
		return soldQuantity;
	}

	public void setSoldQuantity(Long soldQuantity) {
		this.soldQuantity = soldQuantity;
	}
	
	
}
