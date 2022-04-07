package com.vietshop.controller.admin;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vietshop.Entity.Category;
import com.vietshop.Service.impl.CategoryService;
import com.vietshop.dto.CategoryDTO;

@Controller(value = "categoryControllerOfAdmin")
public class categoryController {
	
	@Autowired
	public CategoryService categoryService;


	@GetMapping("/admin/addCategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "admin/category/createNewCategory";
	}
	
	
   @PostMapping("/admin/doAddCategory")
   public String doAddCategory(Model model,@ModelAttribute(name="category") @Valid CategoryDTO categoryDTO, BindingResult result) {
	   
	   if (result.hasErrors()) {
			return "admin/addCategory";
		}
	   
	  categoryService.addCategory(categoryDTO);
      return "redirect:/admin/list-category";
   }
   
   
   @GetMapping("/admin/list-category")
   public String listCategory(Model model, @RequestParam("p") Optional<Integer> p) {
	   
	  Page<CategoryDTO> categoryPage = categoryService.listCategory(p);
	  model.addAttribute("categoryPage",categoryPage);
	  return "admin/category/listCategory";
   }
   
   
   @GetMapping("/admin/updateCategory")
	public String updateCategory(Model model,@RequestParam("idCategory") Long idCategory ) {
	  
	   CategoryDTO categoryDTO = categoryService.getCategoryDTO(idCategory);
	   model.addAttribute("category",categoryDTO);
	   return "admin/category/updateCategory";
		
		
	}
   @PostMapping("/admin/doUpdateCategory")
   public String doUpdateCategory(Model model,@ModelAttribute("category") CategoryDTO categoryDTO) {
	   
	   categoryService.updateCategory(categoryDTO);
	   return "redirect:/admin/list-category";
	   
   }

  
   
}