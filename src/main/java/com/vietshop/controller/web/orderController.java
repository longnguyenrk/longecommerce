package com.vietshop.controller.web;

import java.sql.Date;
import java.text.DecimalFormat;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vietshop.Entity.Account;
import com.vietshop.Entity.CartItem;
import com.vietshop.Entity.Category;
import com.vietshop.Entity.CreditCard;
import com.vietshop.Entity.Order;
import com.vietshop.Entity.OrderDetails;
import com.vietshop.Entity.Payment;
import com.vietshop.Entity.Product;
import com.vietshop.Entity.ShippingInfo;
import com.vietshop.Service.iCartItemService;
import com.vietshop.Service.impl.AccountService;
import com.vietshop.Service.impl.CategoryService;
import com.vietshop.Service.impl.CreditCardService;
import com.vietshop.Service.impl.OrderDetailsService;
import com.vietshop.Service.impl.OrderService;
import com.vietshop.Service.impl.ProductService;
import com.vietshop.Service.impl.ShippingInfoService;
import com.vietshop.repository.PaymentRepository;
import com.vietshop.util.SecurityUtils;

@Controller
public class orderController {
	@Autowired
	private AccountService accountService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderDetailsService orderDetailsService;

	@Autowired
	private iCartItemService cartItemService;

	@Autowired
	private ShippingInfoService shippingInfoService;

	@Autowired
	private CreditCardService creditcardService;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
    public JavaMailSender emailSender;

	@GetMapping("/checkOut")
	public String checkOut(Model model, @RequestParam("idAccount") Long idAccount) {
		List<Category> category = categoryService.findAll();
		model.addAttribute("category", category);

		Account account = accountService.findByUserName(SecurityUtils.getPrincipal().getUsername());
		List<CartItem> items = account.getCartItems();
		model.addAttribute("cartItems", items);
		model.addAttribute("account", account);
		for(CartItem j:items) {
			if(j.getQuantity() >= j.getProduct().getQuantity()) {
				model.addAttribute("msg","Số lượng " + j.getProduct().getProduct()+" không đủ theo yêu cầu.");
				return "redirect:/shopingcart";
			}
		}
		Date date = new Date(new java.util.Date().getTime());
		Order order = new Order();
		// Tính tổng tiền của Order
		double priceTotal = 0;
		for (CartItem i : items) {
			priceTotal = priceTotal + i.getTotal();
		}
		order.setAccount(accountService.findOne(idAccount));
		order.setDateOrder(date);
		order.setSubTotal(priceTotal);
		model.addAttribute("order", order);
		model.addAttribute("cartItems", items);

		// định dạng tiền tệ VND
		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
		model.addAttribute("formatter", formatter);
		// khi người dùng nhập sl sp nhiều hơn trong kho
		
		
		return "web/checkout";
	}

	@PostMapping("/checkOut")
	public String doCheckOut(Model model, @RequestParam("idAccount") Long idAccount,
			@RequestParam("methodPayment") String methodPayment, @ModelAttribute("Account") Account account)  throws MessagingException {
		List<Category> category = categoryService.findAll();
		model.addAttribute("category", category);

		Date date = new Date(new java.util.Date().getTime());
		Order order = new Order();
		List<CartItem> cartItems = accountService.findOne(idAccount).getCartItems();
		if(!cartItems.isEmpty()) { // giỏ hàng có sp
		model.addAttribute("cartItems", cartItems);
		model.addAttribute("account", account);

		// Tính tổng tiền của Order
		double priceTotal = 0;
		for (CartItem i : cartItems) {
			priceTotal = priceTotal + i.getTotal();
		}
		order.setAccount(accountService.findOne(idAccount));
		order.setDateOrder(date);
		order.setSubTotal(priceTotal);
		orderService.save(order);

		for (CartItem i : cartItems) {
			orderDetailsService.insert(i, order);
			;
		}

		// chọn phương thức thanh toán

		if (methodPayment.equalsIgnoreCase("cod")) { // về trang đặt hàng thành công với COD
			// thêm dữ liệu vào shipping info
			ShippingInfo shipInfo = new ShippingInfo();
			shipInfo.setCustomer(account.getFullName());
			shipInfo.setAddress(account.getAddress());
			shipInfo.setPhone(account.getPhone());
			shipInfo.setShippingCost(order.getSubTotal()); // Thanh toán tiền hàng khi ship
			shipInfo.setOrder(order);
			order.setStatus("Thanh toán khi nhận hàng");
			orderService.save(order);
			shippingInfoService.save(shipInfo);
			
			MimeMessage message = emailSender.createMimeMessage();
			boolean multipart = true;
			
			MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
			String htmlMsg = "<a>Cám ơn quý khách đã đặt hàng !</a>"+ 
					"<a href='http://localhost:8080/vietshop/thankOrder?idOrder="+order.getIdOrder()+"'>Xem chi tiết tại đây</a>";
	        
	        message.setContent(htmlMsg, "text/html");
	        helper.setTo("fviet295@gmail.com");
	        
	        helper.setSubject("Đặt hàng thành công, Mã đơn hàng: "+"000"+order.getIdOrder());
	        

	        this.emailSender.send(message);
			// Trừ đi số lượng còn lại trong kho
			for (CartItem i : cartItems) {
				Long quantited = i.getProduct().getQuantity() - i.getQuantity();
				Product product = i.getProduct();
				product.setSoldQuantity(product.getSoldQuantity()+i.getQuantity());// thêm vào số lượng sp đã bán
				product.setQuantity(quantited);
				productService.save(product);

			}
			
			cartItemService.deleteByIdAccount(idAccount); // clear giỏ hàng khi đã đặt hàng
			model.addAttribute("order", order);
			model.addAttribute("idOrder", order.getIdOrder());
			return "redirect:thankOrder";
		}
		if (methodPayment.equalsIgnoreCase("card")) { // về trang payment để nhập thẻ
			model.addAttribute("order", order);
			return "web/paymentCard";

		}
		}else { // giỏ hàng trống
			model.addAttribute("idAccount",idAccount);
			return "redirect:checkOut";
		}

		return "web/home";

	}

	@GetMapping("paymentCard")
	public String paymentCardPage(Model model, @RequestParam("idOrder") Long idOrder) {
		model.addAttribute("idOrder", idOrder);
		Account account = accountService.findByUserName(SecurityUtils.getPrincipal().getUsername());
		List<CartItem> items = account.getCartItems();
		model.addAttribute("cartItems", items);
		model.addAttribute("account", account);

		return "web/paymentCard";
	}

	@PostMapping("paymentCard")
	public String paymentCard(Model model, @RequestParam("cardNumber") String cardNumber,
			@RequestParam("cvcCode") int cvcCode, @RequestParam("expMonth") int expMonth,
			@RequestParam("expYear") int expYear, @RequestParam("name") String name,
			@RequestParam("idAccount") Long idAccount, @RequestParam("idOrder") Long idOrder) {
		Order order = orderService.findOne(idOrder);

		CreditCard creditCard = creditcardService.findByCardNumber(cardNumber);

		Account account = accountService.findOne(idAccount);
		try {
			double balance = creditCard.getBalance();

			double totalPrice = order.getSubTotal();

			double balanceAfter = balance - totalPrice;
			if (cardNumber.equals(creditCard.getCardNumber()) && name.equals(creditCard.getName())
					&& expMonth == creditCard.getExpMonth() && expYear == creditCard.getExpYear()
					&& cvcCode == creditCard.getCvcCode()) {
				// thêm dữ liệu vào shipping info
				if (balanceAfter >= 0) {

					ShippingInfo shipInfo = new ShippingInfo();
					shipInfo.setCustomer(account.getFullName());
					shipInfo.setAddress(account.getAddress());
					shipInfo.setPhone(account.getPhone());
					shipInfo.setShippingCost(0); // Đã thanh toán qua thẻ
					shipInfo.setOrder(order);
					creditCard.setBalance(balanceAfter);// set lai balance sau khi gioa dich
					order.setStatus("Đã thanh toán");
					
					Payment payment  = new Payment();
					payment.setAmount(order.getSubTotal());
					payment.setCreditCard(creditCard);
					payment.setOrder(order);
					Date date = new Date(new java.util.Date().getTime());
					payment.setPaymentDate(date);
					payment.setStatus("Thanh toán thành công");
					
					shippingInfoService.save(shipInfo);
					order.setShippingInfo(shipInfo);
					orderService.save(order);
					creditcardService.save(creditCard);
					paymentRepository.save(payment);

					// Trừ đi số lượng còn lại trong kho
					List<OrderDetails> listOrder = order.getOrderDetailsList();
					for (OrderDetails i : listOrder) {
						Long quantited = i.getProduct().getQuantity() - i.getQuantity();
						Product product = i.getProduct();
						product.setSoldQuantity(product.getSoldQuantity()+i.getQuantity());// thêm vào số lượng sp đã bán
						product.setQuantity(quantited);
						productService.save(product);

					}

					cartItemService.deleteByIdAccount(idAccount); // clear giỏ hàng khi đã đặt hàng thành công
					// Gửi mail
					MimeMessage message = emailSender.createMimeMessage();
					boolean multipart = true;
					
					MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
					String htmlMsg = "<a>Cám ơn quý khách đã đặt hàng !</a>"+ 
							"<a href='http://localhost:8080/vietshop/thankOrder?idOrder="+order.getIdOrder()+"'>Xem chi tiết tại đây</a>";
			        
			        message.setContent(htmlMsg, "text/html");
			        helper.setTo("fviet295@gmail.com");
			        
			        helper.setSubject("Đặt hàng thành công, Mã đơn hàng: "+"000"+order.getIdOrder());
			        

			        this.emailSender.send(message);
			        
					model.addAttribute("order", order);

					model.addAttribute("idOrder", order.getIdOrder());
					return "redirect:thankOrder";
				} else {
					model.addAttribute("msg", "Số tiền trong tài khoản không đủ để thực hiện thanh toán.");
					model.addAttribute("idOrder", order.getIdOrder());
					model.addAttribute("order", order);
					return "web/paymentCard";
				}

			}

			else {
				model.addAttribute("msg", "Thông tin thẻ không đúng, vui lòng nhập lại.");
				model.addAttribute("idOrder", order.getIdOrder());
				model.addAttribute("order", order);
				return "web/paymentCard";
			}
		} catch (Exception e) {
			model.addAttribute("msg", "Thông tin thẻ không đúng, vui lòng nhập lại.");
			model.addAttribute("idOrder", order.getIdOrder());
			model.addAttribute("order", order);
			return "web/paymentCard";
		}
	}

	@GetMapping("/thankOrder")
	public String thankOrder(Model model, @RequestParam("idOrder") Long idOrder,HttpSession session) {
		session.setAttribute("total",0);  //set thông tin giỏ hàng lên header sau khi thanh toán thành công thì giỏ hàng = 0
		session.setAttribute("quantity",0);

		List<OrderDetails> items = orderService.findOne(idOrder).getOrderDetailsList();
		model.addAttribute("items",items);
		model.addAttribute("order",orderService.findOne(idOrder));
	
		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
		model.addAttribute("formatter",formatter);


		model.addAttribute("dateOrder", orderService.findOne(idOrder).getDateOrder());
		return "web/thankOrder";
	}
}
