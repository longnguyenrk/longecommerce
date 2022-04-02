package com.vietshop.controller.web;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vietshop.Entity.Account;
import com.vietshop.Entity.CartItem;
import com.vietshop.Entity.Category;
import com.vietshop.Entity.Product;
import com.vietshop.Service.iAccountService;
import com.vietshop.Service.impl.CategoryService;
import com.vietshop.Service.impl.ShoppingCartService;
import com.vietshop.repository.CartItemRepository;
import com.vietshop.repository.ProductRepository;
import com.vietshop.util.SecurityUtils;

@Controller
public class cartController {

	@Autowired
	private CategoryService categoryService;
	@Autowired

	private iAccountService accountService;
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private CartItemRepository cartItemRepository;
	@Autowired
	private ProductRepository productRepo;

	@GetMapping("/shopingcart")
	public String Cart(Model model,HttpSession session,@RequestParam(name = "msg" ,defaultValue = "") String msg) {
		
		
		List<Category> category = categoryService.findAll();
		model.addAttribute("category", category);
		
		Account account = accountService.findByUserName(SecurityUtils.getPrincipal().getUsername());
		List<CartItem> items = account.getCartItems();
		model.addAttribute("cartItems",items);
		model.addAttribute("account",account);
		model.addAttribute("msg",msg);
		// tính tôgnr giỏ hàng
				double priceTotal = 0;
				for (CartItem i:items) {
					priceTotal = priceTotal + i.getTotal();

				}
				//định dạng tiền tệ VND
				DecimalFormat formatter = new DecimalFormat("###,###,###.##");
				model.addAttribute("formatter",formatter);
				model.addAttribute("priceTotal",priceTotal);
					session.setAttribute("total",formatter.format(priceTotal));  //set thông tin giỏ hàng lên header
					session.setAttribute("quantity",items.size());
					
						
					
					
		return "web/shopingcart";
		}
	
	@GetMapping("/addProduct")
	public String addProduct(Model model,@RequestParam("idProduct") Long idProduct,@RequestParam("quantity") Long quantity,HttpSession session) {
		
		try {
		Account account = accountService.findByUserName(SecurityUtils.getPrincipal().getUsername());

		Long addQuantity = quantity ;
		Product product = productRepo.findByIdProduct(idProduct).get();
		CartItem cartItem = cartItemRepository.findByAccountAndProduct(account, product);
		
		if(cartItem !=null ) {
			addQuantity = cartItem.getQuantity()+quantity;
			cartItem.setQuantity(addQuantity);
			double total = cartItem.getQuantity()*product.getCost();
			cartItem.setTotal(total);
			
			
			
		}else {
			
			cartItem = new CartItem();
			cartItem.setAccount(account);
			cartItem.setProduct(product);
			cartItem.setQuantity(quantity);
			double total = cartItem.getQuantity()*product.getCost();
			cartItem.setTotal(total);
			System.out.println(quantity+"aasas");
		}
		cartItemRepository.save(cartItem);
		}
		catch (Exception e) {
			   return "redirect:/authen";
			}

		
		return "redirect:/shop-grid";
	}
	@PostMapping("/addProduct")
	public String addProductToCart(Model model,@RequestParam("idProduct") Long idProduct,
			@RequestParam("quantity") Long quantity) {
		Account account = accountService.findByUserName(SecurityUtils.getPrincipal().getUsername());
		Product product = productRepo.findByIdProduct(idProduct).get();
		CartItem cartItem = cartItemRepository.findByAccountAndProduct(account, product);
		if(cartItem !=null ) {
			cartItem.setQuantity(quantity);
			double total = cartItem.getQuantity()*product.getCost();
			cartItem.setTotal(total);
		}else {
			cartItem = new CartItem();
			cartItem.setAccount(account);
			cartItem.setProduct(product);
			cartItem.setQuantity(quantity);
			double total = cartItem.getQuantity()*product.getCost();
			cartItem.setTotal(total);
			
		}
		cartItemRepository.save(cartItem);
		
		
		
		return "redirect:shopingcart";
		
	}

	@GetMapping("/deleteProduct")
	public String deleteProduct(Model model,@RequestParam("idProduct") Long idProduct) {
		shoppingCartService.deteleProduct(idProduct);
		return "redirect:shopingcart";
	}
	
	@GetMapping("/deleteAllProduct")
	public String deleteAllProduct(Model model) {
		shoppingCartService.deleteAllInBatch();
		return "redirect:shopingcart";
	}
	
	

}
