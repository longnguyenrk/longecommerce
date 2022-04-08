package com.vietshop.Service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vietshop.entity.Category;

public interface iCategoryService {

	<S extends Category> List<S> findAll(Example<S> example, Sort sort);

	<S extends Category> boolean exists(Example<S> example);

	void deleteAll();

	<S extends Category> List<S> findAll(Example<S> example);

	void delete(Iterable<? extends Category> entities);

	<S extends Category> long count(Example<S> example);

	Category getOne(Long id);

	void delete(Category entity);

	void deleteAllInBatch();

	void delete(Long id);

	<S extends Category> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Category> entities);

	long count();

	<S extends Category> S saveAndFlush(S entity);

	void flush();

	<S extends Category> List<S> save(Iterable<S> entities);

	boolean exists(Long id);

	List<Category> findAll(Iterable<Long> ids);

	List<Category> findAll(Sort sort);

	Category findOne(Long id);

	List<Category> findAll();

	Page<Category> findAll(Pageable pageable);

	<S extends Category> S findOne(Example<S> example);

	<S extends Category> S save(S entity);

}
