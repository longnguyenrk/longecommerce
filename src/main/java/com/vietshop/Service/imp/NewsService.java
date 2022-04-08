package com.vietshop.Service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vietshop.repository.NewsRepository;
import com.vietshop.Service.iNewsService;
import com.vietshop.entity.News;

@Service // Để class có thể thực hiện cơ chế DI và IOC
public class NewsService implements iNewsService{
	@Autowired
	private NewsRepository newsRepository;

	@Override
	public <S extends News> S save(S entity) {
		return newsRepository.save(entity);
	}

	@Override
	public <S extends News> S findOne(Example<S> example) {
		return newsRepository.findOne(example);
	}

	@Override
	public Page<News> findAll(Pageable pageable) {
		return newsRepository.findAll(pageable);
	}

	@Override
	public List<News> findAll() {
		return newsRepository.findAll();
	}

	@Override
	public News findOne(Long id) {
		return newsRepository.findOne(id);
	}

	@Override
	public List<News> findAll(Sort sort) {
		return newsRepository.findAll(sort);
	}

	@Override
	public List<News> findAll(Iterable<Long> ids) {
		return newsRepository.findAll(ids);
	}

	@Override
	public boolean exists(Long id) {
		return newsRepository.exists(id);
	}

	@Override
	public <S extends News> List<S> save(Iterable<S> entities) {
		return newsRepository.save(entities);
	}

	@Override
	public void flush() {
		newsRepository.flush();
	}

	@Override
	public <S extends News> S saveAndFlush(S entity) {
		return newsRepository.saveAndFlush(entity);
	}

	@Override
	public long count() {
		return newsRepository.count();
	}

	@Override
	public void deleteInBatch(Iterable<News> entities) {
		newsRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends News> Page<S> findAll(Example<S> example, Pageable pageable) {
		return newsRepository.findAll(example, pageable);
	}

	@Override
	public void delete(Long id) {
		newsRepository.delete(id);
	}

	@Override
	public void deleteAllInBatch() {
		newsRepository.deleteAllInBatch();
	}

	@Override
	public void delete(News entity) {
		newsRepository.delete(entity);
	}

	@Override
	public News getOne(Long id) {
		return newsRepository.getOne(id);
	}

	@Override
	public <S extends News> long count(Example<S> example) {
		return newsRepository.count(example);
	}

	@Override
	public void delete(Iterable<? extends News> entities) {
		newsRepository.delete(entities);
	}

	@Override
	public <S extends News> List<S> findAll(Example<S> example) {
		return newsRepository.findAll(example);
	}

	@Override
	public void deleteAll() {
		newsRepository.deleteAll();
	}

	@Override
	public <S extends News> boolean exists(Example<S> example) {
		return newsRepository.exists(example);
	}

	@Override
	public <S extends News> List<S> findAll(Example<S> example, Sort sort) {
		return newsRepository.findAll(example, sort);
	}
	

}
