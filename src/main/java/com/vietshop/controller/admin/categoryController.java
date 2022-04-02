package com.vietshop.controller.admin;

import java.io.File;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.vietshop.Entity.Category;
import com.vietshop.Service.impl.CategoryService;
import com.vietshop.dto.CategoryDTO;

@Controller(value = "categoryControllerOfAdmin")
public class categoryController {
	
	@Autowired
	public CategoryService categoryService;

	/*
	 * @Autowired public ProductRepository productRepository;
	 */
	@GetMapping("/admin/addCategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "admin/category/createNewCategory";
	}
   @PostMapping("/admin/doAddCategory")
   public String doAddCategory(Model model,@ModelAttribute(name="category") @Valid CategoryDTO categoryDto, BindingResult result) {
	   if (result.hasErrors()) {
			return "admin/addCategory";
		}
	   Category category = new Category();
		String saveImgUrl = "/Users/macbook/eclipse-workspace/vietshop/src/main/webapp/resources/images";

//		String saveImgUrl = "D:/Java/workspace/vietshop/src/main/webapp/resources/images";
		
		try {
			MultipartFile multipartFile = categoryDto.getImageFile();
			String fileImg = multipartFile.getOriginalFilename();
			File file = new File(saveImgUrl, fileImg);
			multipartFile.transferTo(file);
			categoryDto.setImgUrl("/resources/images/" + fileImg);// Set đường dẫn lưu trên DB
			model.addAttribute("imgUrl", categoryDto.getImgUrl());

		} catch (Exception e) {
			System.out.println("cate");
			return "redirect:/admin/addCategory";
		}
		System.out.println(categoryDto.getImgUrl()+"DTOcate");
		BeanUtils.copyProperties(categoryDto, category);

		categoryService.save(category);


      return "redirect:/admin/list-category";
   }
   @GetMapping("/admin/list-category")
   public String listCategory(Model model, @RequestParam("p") Optional<Integer> p) {
	   int currentPage = p.orElse(0);
		PageRequest page_req = new PageRequest(currentPage, 10);
		Pageable pageable = page_req;
	   Page<Category> list = categoryService.findAll(pageable);
	   model.addAttribute("category",list);
	   return "admin/category/listCategory";
   }
   
   @GetMapping("/admin/updateCategory")
	public String updateCategory(Model model,@RequestParam("idCategory") Long idCategory ) {
	   Category category = categoryService.getOne(idCategory);
	   model.addAttribute("category",category);
		return "admin/category/updateCategory";
	}
   @PostMapping("/admin/doUpdateCategory")
   public String doUpdateCategory(Model model,@ModelAttribute("category") CategoryDTO categoryDto,@RequestParam("p") Optional<Integer> p) {
	   Category category = categoryService.getOne(categoryDto.getIdCategory());
//	   BeanUtils.copyProperties(categoryDto, category);
		String saveImgUrl = "/Users/macbook/eclipse-workspace/vietshop/src/main/webapp/resources/images";

//		String saveImgUrl = "D:/Java/workspace/vietshop/src/main/webapp/resources/images";
		
		try {
			MultipartFile multipartFile = categoryDto.getImageFile();
			String fileImg = multipartFile.getOriginalFilename();
			File file = new File(saveImgUrl, fileImg);
			multipartFile.transferTo(file);
			categoryDto.setImgUrl("/resources/images/" + fileImg);// Set đường dẫn lưu trên DB
			model.addAttribute("imgUrl", categoryDto.getImgUrl());

		} catch (Exception e) {
			categoryDto.setImgUrl(category.getImgUrl());
			BeanUtils.copyProperties(categoryDto, category);

			categoryService.save(category);
			return "redirect:/admin/list-category";
		}
		category.setCategory(categoryDto.getCategory());
		System.out.println(categoryDto.getImgUrl()+"DTOcate");
		BeanUtils.copyProperties(categoryDto, category);

		categoryService.save(category);
	   model.addAttribute("category",category);
	   
	   return "redirect:/admin/list-category";
	   
   }

  
   
}