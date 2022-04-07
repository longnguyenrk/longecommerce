package com.vietshop.controller.admin;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vietshop.Entity.Order;
import com.vietshop.Entity.OrderDetails;
import com.vietshop.Service.impl.OrderService;

@Controller
public class ordersController {
	
	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("admin/listOrder")
	public String listOrder(Model model,@RequestParam("p") Optional<Integer> p,
			@RequestParam(name = "sort", defaultValue = "idOrder") Optional<String> sort,
			@RequestParam(name = "updown", defaultValue = "DESC") String updown,
			@RequestParam("keyword") Optional<String> keyword ) {
		int currentPage = p.orElse(0);
		Pageable pageable = null;

		if (updown.equals("ASC")) {
			PageRequest page_req = new PageRequest(currentPage, 10, Sort.Direction.ASC, sort.orElse("idOrder"));
			pageable = page_req;
		}
		if (updown.equals("DESC")) {
			PageRequest page_req = new PageRequest(currentPage, 10, Sort.Direction.DESC, sort.orElse("idOrder"));
			pageable = page_req;
		}
		Page<Order> orderPage;
		if (keyword.isPresent()) {
			orderPage = orderService.searchOrder(keyword.get(), pageable);// Thực hiện chức năng tìm kiếm sản phẩm
			model.addAttribute("keyword", keyword.get());

		} else {

			orderPage = orderService.findAll(pageable);
		}
		long size = orderPage.getTotalElements();
		model.addAttribute("size", size);
		model.addAttribute("orders", orderPage);
		model.addAttribute("sorter", sort.get());
		model.addAttribute("updown", updown);
		model.addAttribute("p", currentPage);
		
		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
		model.addAttribute("formatter",formatter);
		return "admin/order/listOrder";
	}
	
	@GetMapping("admin/detailsOrder")
	public String detailsOrder(Model model,@RequestParam("idOrder") Long idOrder) {
		List<OrderDetails> items = orderService.findOne(idOrder).getOrderDetailsList();
		model.addAttribute("items",items);
		model.addAttribute("order",orderService.findOne(idOrder));
	
		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
		model.addAttribute("formatter",formatter);

		return "admin/order/detailsOrder";
	}
	@GetMapping("admin/successStatusHome")
	public String successStatusHome(Model model,@RequestParam("idOrder") Long idOrder) {
		Order order = orderService.findOne(idOrder);
		order.setStatus("Đã thanh toán");
		orderService.save(order);
		return "redirect:/admin/trang-chu";
	}
	
	@GetMapping("admin/pendingStatusHome")
	public String pendingStatusHome(Model model,@RequestParam("idOrder") Long idOrder) {
		Order order = orderService.findOne(idOrder);
		order.setStatus("Thanh toán khi nhận hàng");
		orderService.save(order);
		return "redirect:/admin/trang-chu";
	}
	
	@GetMapping("admin/successStatus")
	public String successStatus(Model model,@RequestParam("idOrder") Long idOrder,@RequestParam("p")Optional<Integer> p) {
		
		int page = p.orElse(0);
		Order order = orderService.findOne(idOrder);
		order.setStatus("Đã thanh toán");
		orderService.save(order);
		return "redirect:/admin/listOrder?p="+page;
	}
	
	@GetMapping("admin/pendingStatus")
	public String pendingStatus(Model model,@RequestParam("idOrder") Long idOrder,@RequestParam("p")Optional<Integer> p) {
		
		int page = p.orElse(0);
		Order order = orderService.findOne(idOrder);
		order.setStatus("Thanh toán khi nhận hàng");
		orderService.save(order);
		return "redirect:/admin/listOrder?p="+page;
	}
	
}
