           package com.vietshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vietshop.Entity.Order;
import com.vietshop.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("SELECT e FROM Product e")
	Page<Product> findProducts(Pageable pageable);
	@Query("SELECT e FROM Product e")
	List<Product> findAll(Sort sort);
	@Query("SELECT u FROM Product u WHERE u.idProduct = :idProduct")
	Optional<Product> findByIdProduct(@Param("idProduct")Long idProduct); // findByIdProduct tương ứng field idProduct. Nếu field là id thì findById
	@Transactional /* Sử dụng khi muốn sửa đổi bản ghi trong DB, áp dụng cho method void hoặc int/integer*/
	@Modifying
	@Query("delete from Product b where b.idProduct=:idProduct")
	void deleteByIdProduct(@Param("idProduct") Long idProduct);
	@Query("SELECT p FROM Product p WHERE p.category.idCategory = :idCategory")
	public Page<Product> findAllByIdCategory(@Param("idCategory")Long idCategory,Pageable pageable);
	@Query("SELECT p FROM Product p WHERE p.category.idCategory = :idCategory AND p.idProduct <> :idProduct")
	public Page<Product> listRelatedProduct(@Param("idCategory")Long idCategory,Pageable pageable,@Param("idProduct")Long idProduct);
	@Query("SELECT u FROM Product u WHERE u.Product LIKE %:keyword%")
	public Page<Product> searchProduct(@Param("keyword")String keyword,Pageable pageable);
	
	@Query("SELECT p FROM Product p order by soldQuantity DESC")
	public Page<Product> findTopProduct(Pageable page);
	
	@Query("SELECT p FROM Product p order by idProduct DESC")
	public Page<Product> findLastProduct(Pageable page);	
}
