package com.vietshop.controller.web;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vietshop.Service.iAccountService;
import com.vietshop.Service.imp.OrderService;
import com.vietshop.Service.imp.ShoppingCartService;
import com.vietshop.dto.AccountDTO;
import com.vietshop.entity.Account;
import com.vietshop.entity.Order;
import com.vietshop.entity.OrderDetails;
import com.vietshop.repository.CartItemRepository;
import com.vietshop.repository.ProductRepository;
import com.vietshop.util.SecurityUtils;

@Controller
public class profileController {

	
	@Autowired
	public PasswordEncoder passwordEncoder;
	@Autowired
	private iAccountService accountService;
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private CartItemRepository cartItemRepository;
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private OrderService orderService;

	@GetMapping("/profile")
	public String profile(Model model,@RequestParam(name = "mess",defaultValue = " ") String mess) {
		Account account = accountService.findByUserName(SecurityUtils.getPrincipal().getUsername());
		model.addAttribute("account",account);
		model.addAttribute("mess",mess);// mess cho method post change password
		SecurityUtils.getPrincipal().getPassword();
		return "web/profile";
	}
	@PostMapping("/updateProfile")
	public String updateProfile(Model model,@ModelAttribute("account") Account account) {
		Account acc = accountService.findOne(account.getId());
		acc.setFullName(account.getFullName());
		acc.setEmail(account.getEmail());
		acc.setPhone(account.getPhone());
		acc.setAddress(account.getAddress());
		accountService.save(acc);
		
		return "redirect:/profile";
	}
	
	@PostMapping("/changePassword")
	public String changePassword(Model model,@ModelAttribute("account") AccountDTO account) {
		Account acc = accountService.findOne(account.getId());
		
		if(account.getOldpass().equals(account.getNewpass())) {
		acc.setPassword(passwordEncoder.encode(account.getNewpass()));
		accountService.save(acc);
		model.addAttribute("mess","Đổi mật khẩu thành công !");
		return "redirect:/profile";
		}else { 
		model.addAttribute("mess","Mật khẩu mới không khớp !");
		return "redirect:/profile";
		}
	}
	@GetMapping("/myorderdetail")
	public String myorderdetail(Model model,@RequestParam("idOrder") Long idOrder) {
		List<OrderDetails> items = orderService.findOne(idOrder).getOrderDetailsList();
		model.addAttribute("items",items);
		model.addAttribute("order",orderService.findOne(idOrder));
	
		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
		model.addAttribute("formatter",formatter);
		return "web/myOrder";
	}
	
	@GetMapping("/mylistorder")
	public String mylistorder(Model model,@RequestParam("p") Optional<Integer> p ) {
		int currentPage = p.orElse(0);
		 PageRequest page_req = new PageRequest(currentPage, 10);
	      Pageable page = page_req;
	      Page<Order> pageOrder = orderService.findRecentOrderByUsername(page,SecurityUtils.getPrincipal().getUsername());
	      model.addAttribute("pageOrders",pageOrder);
	      model.addAttribute("elements",pageOrder.getTotalElements());
	    //định dạng tiền tệ VND
			DecimalFormat formatter = new DecimalFormat("###,###,###.##");
			model.addAttribute("formatter",formatter);
		return "web/mylistOrder";
	}
}
