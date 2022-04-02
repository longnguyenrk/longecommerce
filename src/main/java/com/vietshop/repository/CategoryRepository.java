package com.vietshop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vietshop.Entity.Category;
import com.vietshop.Entity.Product;



@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
	@Query("select c from Category c")

	public List<Category> findAll();
	@Query("select c from Category c where id = ?1")
	public Category findOne(int id);
	/*
	 * public Page<Product> findByCategoriesIdOrderByDescriptionAsc(Long
	 * idCategory);
	 */}
