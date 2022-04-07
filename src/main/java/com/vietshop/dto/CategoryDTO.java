package com.vietshop.dto;

import java.util.List;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.vietshop.Entity.Product;

public class CategoryDTO {
private Long idCategory;

private String Category;
@Transient
private MultipartFile imageFile;

private String imgUrl;

private String descriptions;


private List<Product> ProductList;


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

public String getDescriptions() {
	return descriptions;
}

public void setDescriptions(String descriptions) {
	this.descriptions = descriptions;
}


}
