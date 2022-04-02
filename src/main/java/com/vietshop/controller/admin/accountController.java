package com.vietshop.controller.admin;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.vietshop.Entity.Account;
import com.vietshop.Entity.Category;
import com.vietshop.Entity.Product;
import com.vietshop.Service.iAccountService;
import com.vietshop.dto.AccountDTO;
import com.vietshop.dto.ProductDTO;

@Controller
public class accountController {
	@Autowired
	private iAccountService accountService;
	@GetMapping("/admin/list-account")
	public String listAccount(Model model,@RequestParam("p") Optional<Integer> p,
			@RequestParam(name = "sort", defaultValue = "id") Optional<String> sort,
			@RequestParam(name = "updown", defaultValue = "ASC") String updown,
			@RequestParam("keyword") Optional<String> keyword) {
		int currentPage = p.orElse(0);
		Pageable pageable = null;

		if (updown.equals("ASC")) {
			PageRequest page_req = new PageRequest(currentPage, 10, Sort.Direction.ASC, sort.orElse("id"));
			pageable = page_req;
		}
		if (updown.equals("DESC")) {
			PageRequest page_req = new PageRequest(currentPage, 10, Sort.Direction.DESC, sort.orElse("id"));
			pageable = page_req;
		}
		Page<Account> accountPage;
		if(keyword.isPresent()) {
			accountPage = accountService.findByUserName(keyword.get(), pageable);
			model.addAttribute("keyword",keyword.get());

		}
		else {

		accountPage = accountService.findAll(pageable);
		}
		long size = accountPage.getTotalElements();
		System.out.println(size);
		model.addAttribute("size", size);
		model.addAttribute("accounts", accountPage);
		model.addAttribute("sorter", sort.get());
		model.addAttribute("updown", updown);
		model.addAttribute("p",currentPage);
		return "/admin/accountUser/listAccount";
		
	}
	@GetMapping("admin/deleteAccount")
	public String deleteAccount(Model model,@RequestParam("id") Long id) {
		Optional<Account> opt = accountService.findByIdAccount(id);
		if(opt.isPresent()) {
			accountService.delete(id);
		}
		return "redirect:/admin/list-account";
	}
	@GetMapping("admin/updateAccount")
	public String updateAccount(Model model, @RequestParam("id") Long id) {
		Optional<Account> account = accountService.findByIdAccount(id);
		model.addAttribute("account", account.get());
		return "/admin/accountUser/updateAccount";

	}
	@PostMapping("admin/doUpdateAccount")
	public String doUpdateAccount(Model model, @Valid @ModelAttribute("account") AccountDTO account,
			BindingResult result) {

		Account acc = accountService.findOne(account.getId());
				
			BeanUtils.copyProperties(account,acc);
			System.out.println(account.getFullName()+" "+ account.getEmail()+" "+ account.getPhone()+" "+ account.getUsername()+" "+account.getAddress()+" "+account.getStatus());
			accountService.save(acc);

		return "redirect:/admin/list-account";
	}
	
	@GetMapping("admin/activeAccount")
	public String activeAccount(Model model,@RequestParam("idAccount")Long idAccount,@RequestParam("p")Optional<Integer> p) {
		
		int page = p.orElse(0);
		Account account = accountService.findOne(idAccount);
		account.setStatus(1);
		accountService.save(account);
		return "redirect:/admin/list-account?p="+page;
	}
	
	@GetMapping("admin/deactiveAccount")
	public String deactiveAccount(Model model,@RequestParam("idAccount")Long idAccount,@RequestParam("p")Optional<Integer> p) {
		
		int page = p.orElse(0);
		Account account = accountService.findOne(idAccount);
		account.setStatus(0);
		accountService.save(account);
		return "redirect:/admin/list-account?p="+page;
	}
}
