package com.vietshop.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vietshop.Service.imp.CategoryService;
import com.vietshop.entity.Category;

@Controller("categoryControllerOfClient")
//@RequestMapping("/client")

public class categoryController {
	@Autowired
	CategoryService categoryService;
	/*
	 * @GetMapping("/list-category") public String listCategory(Model model) {
	 * List<Category> list = categoryService.findAll();
	 * model.addAttribute("category",list); return "web/home"; }
	 */
}
