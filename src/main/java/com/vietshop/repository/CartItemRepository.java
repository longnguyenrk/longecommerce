package com.vietshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vietshop.Entity.Account;
import com.vietshop.Entity.CartItem;
import com.vietshop.Entity.Product;
@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
	public List<CartItem> findByAccount(Account account);
	
	public CartItem findByAccountAndProduct(Account account,Product product);
	@Transactional /* Sử dụng khi muốn sửa đổi bản ghi trong DB, áp dụng cho method void hoặc int/integer*/
	@Modifying
	@Query("delete from CartItem b where b.product.idProduct = :product_id")
	void deleteByIdProduct(@Param("product_id") Long idProduct);
	@Transactional /* Sử dụng khi muốn sửa đổi bản ghi trong DB, áp dụng cho method void hoặc int/integer*/
	@Modifying
	@Query("delete from CartItem b where b.account.id = :account_id")
	void deleteByIdAccount(@Param("account_id") Long idAccount);
}
