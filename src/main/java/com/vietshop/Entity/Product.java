package com.vietshop.Entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Product")
public class Product {
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Id
	@Column(name="idProduct")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduct;
	
	@NotBlank
	private String Product;
	
	@NotNull
	private double Cost;
	
	@NotBlank
	private String shortdescription;
	
	private String descriptions;
	
	@NotBlank
	private String unit;
	
	private Long weight;
	
	private String imgUrl;
	
	private Long quantity;
	
	private Long soldQuantity;
	
	private String status;
	
	@JoinColumn(name="idCategory")
	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy="product")
	private List<OrderDetails> listOrderDetail;
	
	@OneToMany(mappedBy="product",cascade = {CascadeType.ALL})
	private List<CartItem> cartItems;
	

	public Product() {
		this.soldQuantity = 0L; //set gia tri ban dau cho soldQuantity
	}
	public Long getIdProduct() {
		return idProduct;
	}

	public String getProduct() {
		return Product;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Category getcategory() {
		return category;
	}
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	public List<OrderDetails> getListOrderDetail() {
		return listOrderDetail;
	}

	public void setListOrderDetail(List<OrderDetails> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
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
