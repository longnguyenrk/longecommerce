package com.vietshop.controller.admin;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vietshop.Entity.Account;
import com.vietshop.Entity.Order;
import com.vietshop.Entity.Product;
import com.vietshop.Service.impl.AccountService;
import com.vietshop.Service.impl.OrderService;
import com.vietshop.Service.impl.ProductService;

@Controller(value = "homeControllerOfAdmin")
public class homeController {
  @Autowired
  private OrderService orderService;
  
  @Autowired
  private ProductService productService;
  
  @Autowired
  private AccountService accountService;
  
   @RequestMapping(value = "/admin/trang-chu", method = RequestMethod.GET)
   public String homePage(Model model) {
      List<Order> listOrder = orderService.findAll();
      
      List<Product> listProduct = productService.findAll();
      
      List<Account> listAccount = accountService.findAllCustomer();
      
      model.addAttribute("amountOrders",listOrder.size());
      
      model.addAttribute("amountProducts",listProduct.size());
      
      model.addAttribute("amountAccount",listAccount.size());
      
    //định dạng tiền tệ VND
		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
		model.addAttribute("formatter",formatter);
      
      // Get order mới nhất
      PageRequest page_req = new PageRequest(0, 5);// Get page hiện tại là 0 và số Orders là 5
      Pageable page = page_req;
      Page<Order> pageOrder = orderService.findRecentOrder(page);
      
      model.addAttribute("pageOrders",pageOrder);
      return "admin/home";
   }
   
  
   
}