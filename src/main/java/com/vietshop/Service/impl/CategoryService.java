package com.vietshop.Service.impl;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vietshop.Entity.Category;
import com.vietshop.Service.iCategoryService;
import com.vietshop.dto.CategoryDTO;
import com.vietshop.repository.CategoryRepository;

@Service // Để class có thể thực hiện cơ chế DI và IOC
public class CategoryService implements iCategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public <S extends Category> S save(S entity) {
		return categoryRepository.save(entity);
	}

	@Override
	public <S extends Category> S findOne(Example<S> example) {
		return categoryRepository.findOne(example);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findOne(Long id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}

	@Override
	public List<Category> findAll(Iterable<Long> ids) {
		return categoryRepository.findAll(ids);
	}

	@Override
	public boolean exists(Long id) {
		return categoryRepository.exists(id);
	}

	@Override
	public <S extends Category> List<S> save(Iterable<S> entities) {
		return categoryRepository.save(entities);
	}

	@Override
	public void flush() {
		categoryRepository.flush();
	}

	@Override
	public <S extends Category> S saveAndFlush(S entity) {
		return categoryRepository.saveAndFlush(entity);
	}

	@Override
	public long count() {
		return categoryRepository.count();
	}

	@Override
	public void deleteInBatch(Iterable<Category> entities) {
		categoryRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable) {
		return categoryRepository.findAll(example, pageable);
	}

	@Override
	public void delete(Long id) {
		categoryRepository.delete(id);
	}

	@Override
	public void deleteAllInBatch() {
		categoryRepository.deleteAllInBatch();
	}

	@Override
	public void delete(Category entity) {
		categoryRepository.delete(entity);
	}

	@Override
	public Category getOne(Long id) {
		return categoryRepository.getOne(id);
	}

	@Override
	public <S extends Category> long count(Example<S> example) {
		return categoryRepository.count(example);
	}

	@Override
	public void delete(Iterable<? extends Category> entities) {
		categoryRepository.delete(entities);
	}

	@Override
	public <S extends Category> List<S> findAll(Example<S> example) {
		return categoryRepository.findAll(example);
	}

	@Override
	public void deleteAll() {
		categoryRepository.deleteAll();
	}

	@Override
	public <S extends Category> boolean exists(Example<S> example) {
		return categoryRepository.exists(example);
	}

	@Override
	public <S extends Category> List<S> findAll(Example<S> example, Sort sort) {
		return categoryRepository.findAll(example, sort);
	}

	public void addCategory(CategoryDTO categoryDTO) {
		Category category = new Category();

//		String saveImgUrl = "/Users/macbook/eclipse-workspace/vietshop/src/main/webapp/resources/images";

		String saveImgUrl = "D:/Java/workspace/vietshop/src/main/webapp/resources/images";

		try {
			MultipartFile multipartFile = categoryDTO.getImageFile();
			String fileImg = multipartFile.getOriginalFilename();
			File file = new File(saveImgUrl, fileImg);
			multipartFile.transferTo(file);
			categoryDTO.setImgUrl("/resources/images/" + fileImg);// Set đường dẫn lưu trên DB

		} catch (Exception e) {
			System.out.println(e);
		}
		BeanUtils.copyProperties(categoryDTO, category);
		categoryRepository.save(category);
	}

	public Page<CategoryDTO> listCategory(Optional<Integer> p) {
		int currentPage = p.orElse(0);
		PageRequest page_req = new PageRequest(currentPage, 10);
		Pageable pageable = page_req;
		Page<CategoryDTO> categoryDTOpage = categoryRepository.findAll(pageable).map(Category -> {
			CategoryDTO categoryDTO = new CategoryDTO();
			BeanUtils.copyProperties(Category, categoryDTO);
			return categoryDTO;
		});

		return categoryDTOpage;
	}

	public CategoryDTO getCategoryDTO(Long idCategory) {
		CategoryDTO categoryDTO = new CategoryDTO();
		Category category = categoryRepository.findOne(idCategory);
		BeanUtils.copyProperties(category, categoryDTO);

		return categoryDTO;
	}

	public void updateCategory(CategoryDTO categoryDTO) {
		Category category = categoryRepository.getOne(categoryDTO.getIdCategory());
		
//		String saveImgUrl = "/Users/macbook/eclipse-workspace/vietshop/src/main/webapp/resources/images";
		String saveImgUrl = "D:/Java/workspace/vietshop/src/main/webapp/resources/images";

		try {
			MultipartFile multipartFile = categoryDTO.getImageFile();
			String fileImg = multipartFile.getOriginalFilename();
			File file = new File(saveImgUrl, fileImg);
			multipartFile.transferTo(file);
			categoryDTO.setImgUrl("/resources/images/" + fileImg);// Set đường dẫn lưu trên DB

		} catch (Exception e) {
			System.out.println(e);
		}
		
		if(categoryDTO.getImageFile().isEmpty()) {
			categoryDTO.setImgUrl(category.getImgUrl());
		}
		
		BeanUtils.copyProperties(categoryDTO, category);

		categoryRepository.save(category);
	}
}
