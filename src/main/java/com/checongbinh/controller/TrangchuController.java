package com.checongbinh.controller;




import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.checongbinh.entity.DanhMucSanPham;
import com.checongbinh.entity.SanPham;
import com.checongbinh.service.DanhMucService;
import com.checongbinh.service.SanPhamService;

@Controller
@RequestMapping("/")
public class TrangchuController {

	
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	DanhMucService danhMucService;
	
	@GetMapping
	@Transactional
	public String Default( ModelMap modelMap, HttpSession httpSession) {
		
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc();
		
		if(httpSession.getAttribute("user")!= null){
			String email = (String) httpSession.getAttribute("user");
			String chucaidau =  email.substring(0,1);
			modelMap.addAttribute("chucaidau", chucaidau);
		}
		
		List<SanPham> listSanPhams = sanPhamService.LayDanhSachSanPhamLimit(0);
		modelMap.addAttribute("listSanPham",listSanPhams);
		modelMap.addAttribute("danhmuc",danhMucSanPhams);
		return "trangchu";
	}

}
