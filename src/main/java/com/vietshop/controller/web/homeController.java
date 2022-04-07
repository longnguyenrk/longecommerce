package com.vietshop.controller.web;

import java.text.DecimalFormat;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vietshop.Entity.Account;
import com.vietshop.Entity.CartItem;
import com.vietshop.Entity.Category;
import com.vietshop.Entity.Product;
import com.vietshop.Entity.Role;
import com.vietshop.Service.iAccountService;
import com.vietshop.Service.impl.CategoryService;
import com.vietshop.Service.impl.OrderService;
import com.vietshop.Service.impl.ProductService;
import com.vietshop.Service.impl.RoleService;
import com.vietshop.repository.CartItemRepository;
import com.vietshop.util.SecurityUtils;


@Controller(value = "homeControllerOfWeb")
public class homeController {
  @Autowired
  public iAccountService accountService;
  @Autowired
	CategoryService categoryService;
	@Autowired
	public PasswordEncoder passwordEncoder;
	@Autowired
	public RoleService roleService;
	@Autowired
	public OrderService orderService;
	@Autowired
	public ProductService productService;
	@Autowired
	private CartItemRepository cartItemRepository;
	@Autowired
    public JavaMailSender emailSender;

   @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
   public String homePage(Model model,HttpSession session) {
	   List<Category> list = categoryService.findAll();
		model.addAttribute("category",list);

				List<Category> cate = categoryService.findAll();
				model.addAttribute("category",cate);
				// code hien thi thong tin gio hang tren header
				try {
				Account account = accountService.findByUserName(SecurityUtils.getPrincipal().getUsername());
				List<CartItem> items = account.getCartItems();
				model.addAttribute("cartItems",items);
				model.addAttribute("account",account);
				// tính tôgnr giỏ hàng
						double priceTotal = 0;
						for (CartItem i:items) {
							priceTotal = priceTotal + i.getTotal();

						}
						//định dạng tiền tệ VND
						DecimalFormat formatter = new DecimalFormat("###,###,###.##");
						model.addAttribute("formatter",formatter);
						
							session.setAttribute("total",formatter.format(priceTotal));  //set thông tin giỏ hàng lên header
							session.setAttribute("quantity",items.size());						

				}catch (Exception e) {
					//định dạng tiền tệ VND
					DecimalFormat formatter = new DecimalFormat("###,###,###.##");
					model.addAttribute("formatter",formatter);
					// Get sp bán chạy
				      PageRequest page_req = new PageRequest(0, 8);
				      Pageable page = page_req;
				      Page<Product> topProduct = productService.findTopProduct("display",page);
				      model.addAttribute("topProduct",topProduct);
				   // Get sp mới nhất			      
				      Page<Product> lastProduct = productService.findLastProduct("display",page);
				      model.addAttribute("lastProduct",lastProduct);
					return "web/home";
				}
				// Get sp bán chạy
			      PageRequest page_req = new PageRequest(0, 8);
			      Pageable page = page_req;
			      Page<Product> topProduct = productService.findTopProduct("display",page);
			      model.addAttribute("topProduct",topProduct);
			      
			   // Get sp mới nhất			      
			      Page<Product> lastProduct = productService.findLastProduct("display",page);
			      model.addAttribute("lastProduct",lastProduct);
      return "web/home";
   }
   
   
   @GetMapping("/authen/register")
	public String showFormRegister(Model model) {
		model.addAttribute("account", new Account());
		return "register";
	}
   
   
   @PostMapping("/authen/doregister")
   public String doregister(Model model,@ModelAttribute("account") @Valid Account account,BindingResult result) {
	  
	try {
		if(result.hasErrors()) {
			model.addAttribute("account",account);
			return "register";
		}
		// Check user đã tồn tại
		if(accountService.userExist(account.getUserName())) {
			model.addAttribute("messageUser","Tài khoản đã tồn tại, vui lòng chọn tên khác");
			return "register";
		}
		// Check email đã được sử dụng
		if(accountService.emailExist(account.getEmail())) {
			model.addAttribute("messageEmail","Email đã được sử dụng");
			return "register";
		}
		   Account newAcc=new Account();
		   Role role = new Role();
		   role.setIdRole(2);
		   newAcc.setUserName(account.getUserName());
		   newAcc.setPassword(passwordEncoder.encode(account.getPassword()));
		   newAcc.setDob(account.getDob());
		   newAcc.setAddress(account.getAddress());
		   newAcc.setFullName(account.getFullName());
		   newAcc.setPhone(account.getPhone());
		   newAcc.setEmail(account.getEmail());
		   newAcc.setStatus(1);
		   newAcc.setRole(role);
		   accountService.save(newAcc);
		   
		   MimeMessage message = emailSender.createMimeMessage();
			boolean multipart = true;
			
			MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
			String htmlMsg = "<a>Đăng ký tài khoản vShop thành công</a>"+ "<br>"+
					"<a href='http://localhost:8080/vietshop/trang-chu'>Go to vShop</a>";   
	        message.setContent(htmlMsg, "text/html");
	        helper.setTo(newAcc.getEmail());
	        
	        helper.setSubject("Đăng ký tài khoản vShop thành công");
	        

	        this.emailSender.send(message);
	} catch(Exception e) {
		return "Error";
	}

	  
	   return "redirect:/authen";
	   
   }
   @RequestMapping(value = "/authen", method = RequestMethod.GET)
   public String loginPage(Model model) {
	   //Khac phuc bug vao duoc trang login khi da login
	  try {
		  Account account = accountService.findByUserName(SecurityUtils.getPrincipal().getUsername());
	  }catch ( Exception e) {
		  return "login";
	  }
	  return "redirect:trang-chu";
	  
   }
   @RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/authen?accessDenied");
	}
	@GetMapping("/addProductHome")
	public String addProductHome(Model model,@RequestParam("idProduct") Long idProduct,@RequestParam("quantity") Long quantity,HttpSession session) {
		
		try {
		Account account = accountService.findByUserName(SecurityUtils.getPrincipal().getUsername());

		Long addQuantity = quantity ;
		Product product = productService.findByIdProduct(idProduct).get();
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

		
		return "redirect:/trang-chu";
	}
}