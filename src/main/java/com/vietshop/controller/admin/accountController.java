package com.vietshop.controller.admin;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vietshop.Entity.Account;
import com.vietshop.Service.impl.AccountService;
import com.vietshop.dto.AccountDTO;

@Controller
public class accountController {
	@Autowired
	private AccountService accountService;

	@Autowired
	public PasswordEncoder passwordEncoder;

	@Autowired
	public JavaMailSender emailSender;

	@GetMapping("/admin/list-account")
	public String listAccount(Model model, @RequestParam("p") Optional<Integer> p,
			@RequestParam(name = "sort", defaultValue = "id") Optional<String> sort,
			@RequestParam(name = "updown", defaultValue = "ASC") String updown,
			@RequestParam("keyword") Optional<String> keyword) {
		int currentPage = p.orElse(0);
		Pageable pageable = null;

		// Sort ASC
		if (updown.equals("ASC")) {
			PageRequest page_req = new PageRequest(currentPage, 10, Sort.Direction.ASC, sort.orElse("id"));
			pageable = page_req;
		}

		// Sort DESC
		if (updown.equals("DESC")) {
			PageRequest page_req = new PageRequest(currentPage, 10, Sort.Direction.DESC, sort.orElse("id"));
			pageable = page_req;
		}

		Page<Account> accountPage;

		// Tìm kiếm
		if (keyword.isPresent()) {
			accountPage = accountService.findByUserName(keyword.get(), pageable);
			model.addAttribute("keyword", keyword.get());

		}

		else {
			accountPage = accountService.findAll(pageable);
		}

		long size = accountPage.getTotalElements();
		model.addAttribute("size", size);
		model.addAttribute("accounts", accountPage);
		model.addAttribute("sorter", sort.get());
		model.addAttribute("updown", updown);
		model.addAttribute("p", currentPage);
		return "/admin/accountUser/listAccount";
	}


	   @PostMapping("/admin/doregisteramdin")
	public String doregisteramdin(Model model, @ModelAttribute("account") @Valid AccountDTO accountDTO,BindingResult bindingResult) {
		   
		   if (bindingResult.hasErrors()) {
			   Map<String, String> errors= new HashMap<>();

	            bindingResult.getFieldErrors().forEach(
	                    error -> errors.put(error.getField(), error.getDefaultMessage())
	            );

	            String errorMsg= "";

	            for(String key: errors.keySet()){
	                errorMsg+= "Lỗi ở: " + key + ", lí do: " + errors.get(key) + "\n";
	            }
	            return errorMsg;
	    } 
		try {
			
			// Check user đã tồn tại
			if (accountService.userExist(accountDTO.getUserName())) {
				model.addAttribute("messageUser", "Tài khoản đã tồn tại, vui lòng chọn tên khác");
				return "/admin/accountUser/listAccount";
			}
			// Check email đã được sử dụng
			if (accountService.emailExist(accountDTO.getEmail())) {
				model.addAttribute("messageEmail", "Email đã được sử dụng");
				return "/admin/accountUser/listAccount";
			}
			
			accountService.register(accountDTO);

			MimeMessage message = emailSender.createMimeMessage();
			boolean multipart = true;

			MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
			String htmlMsg = "<a>Đăng ký tài khoản vShop thành công</a>" + "<br>"
					+ "<a href='http://localhost:8080/vietshop/trang-chu'>Go to vShop</a>";

			message.setContent(htmlMsg, "text/html");
			helper.setTo(accountDTO.getEmail());
			helper.setSubject("Đăng ký tài khoản vShop thành công");

			this.emailSender.send(message);
		} catch (Exception e) {
			return "redirect:/admin/list-account";
		}
		return "redirect:/admin/list-account";
	}



	@GetMapping("admin/updateAccount")
	public String updateAccount(Model model, @RequestParam("id") Long id) {
		AccountDTO accountDTO = accountService.findByIdAccountDTO(id);
		model.addAttribute("account", accountDTO);
		return "/admin/accountUser/updateAccount";
	}

	@PostMapping("admin/doUpdateAccount")
	public String doUpdateAccount(Model model, @Valid @ModelAttribute("account") AccountDTO accountDTO,
			BindingResult result) {
		accountService.updateAccount(accountDTO);
		return "redirect:/admin/list-account";
	}

	@GetMapping("admin/activeAccount")
	public String activeAccount(Model model, @RequestParam("idAccount") Long idAccount,
			@RequestParam("p") Optional<Integer> p) {
		int page = p.orElse(0);
		accountService.activeAccount(idAccount);
		return "redirect:/admin/list-account?p=" + page;
	}

	@GetMapping("admin/deactiveAccount")
	public String deactiveAccount(Model model, @RequestParam("idAccount") Long idAccount,
			@RequestParam("p") Optional<Integer> p) {
		int page = p.orElse(0);
		accountService.deActiveAccount(idAccount);
		return "redirect:/admin/list-account?p=" + page;
	}
}
