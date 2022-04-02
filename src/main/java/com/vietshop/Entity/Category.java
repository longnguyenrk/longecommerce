package com.vietshop.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@Column(name = "idCategory")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategory;
	
	private String descriptions;
		
	private String imgUrl;
	
	@Column(name = "Category")
	@NotBlank(message = "Name is required")
	private String Category;
	
	@OneToMany(mappedBy = "category")
	private List<Product> ProductList;

	public Category() {
	}

	public Long getIdCategory() {
		return idCategory;
	}
	

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public List<Product> getProductList() {
		return ProductList;
	}

	public void setProductList(List<Product> productList) {
		ProductList = productList;
	}
	
	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", Category=" + Category + ", ProductList=" + ProductList + "]";
	}

}
