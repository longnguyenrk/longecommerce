package com.vietshop.Service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vietshop.Entity.News;

public interface iNewsService {

	<S extends News> List<S> findAll(Example<S> example, Sort sort);

	<S extends News> boolean exists(Example<S> example);

	void deleteAll();

	<S extends News> List<S> findAll(Example<S> example);

	void delete(Iterable<? extends News> entities);

	<S extends News> long count(Example<S> example);

	News getOne(Long id);

	void delete(News entity);

	void deleteAllInBatch();

	void delete(Long id);

	<S extends News> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<News> entities);

	long count();

	<S extends News> S saveAndFlush(S entity);

	void flush();

	<S extends News> List<S> save(Iterable<S> entities);

	boolean exists(Long id);

	List<News> findAll(Iterable<Long> ids);

	List<News> findAll(Sort sort);

	News findOne(Long id);

	List<News> findAll();

	Page<News> findAll(Pageable pageable);

	<S extends News> S findOne(Example<S> example);

	<S extends News> S save(S entity);

}
