package com.vietshop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vietshop.dto.ProductDTO;
import com.vietshop.entity.Category;
import com.vietshop.entity.Product;

public interface iProductService {

	ProductDTO findById(Long id);

	Optional<Product> findByIdProduct(long idProduct);

	List<ProductDTO> findAllPaging(int pageIndex, int pageSize);

	Page<Product> findByNameContaining(String name, Pageable pageable);

	List<Product> findByNameContaining(String name);

	<S extends Product> List<S> findAll(long pageIndex, long pageSize);

	Page<Product> findProducts(String status,Pageable pageable);

	Page<Product> searchProduct(String keyword, Pageable pageable);

	Product get(Long idProduct);

	<S extends Product> boolean exists(Example<S> example);

	void deleteAll();

	<S extends Product> List<S> findAll(Example<S> example);

	void delete(Iterable<? extends Product> entities);

	<S extends Product> long count(Example<S> example);

	Product getOne(Long id);

	void delete(Product entity);

	void deleteAllInBatch();

	void delete(Long id);

	<S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Product> entities);

	long count();

	<S extends Product> S saveAndFlush(S entity);

	void flush();

	<S extends Product> List<S> save(Iterable<S> entities);

	boolean exists(Long id);

	List<Product> findAll(Iterable<Long> ids);

	List<Product> findAll(Sort sort);

	Page<Product> findAllByIdCategory(String status,Long idCategory, Pageable pageable);
	
	Page<Product> findAllByIdCategoryAll(Category category, Pageable pageable);


	Product findOne(Long id);


	Optional<Product> findByIdProduct(Long idProduct);

	List<Product> findAll();

	Page<Product> listRelatedProduct(Long idCategory, Pageable pageable, Long idProduct,String status);

	Page<Product> findAllProduct(Pageable pageable);

	<S extends Product> S findOne(Example<S> example);

	<S extends Product> S save(S entity);

	

	

	

	
}
