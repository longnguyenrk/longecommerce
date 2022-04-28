package com.checongbinh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.checongbinh.entity.DanhMucSanPham;
import com.checongbinh.entity.GioHang;
import com.checongbinh.entity.NhanVien;
import com.checongbinh.entity.SanPham;
import com.checongbinh.service.DanhMucService;
import com.checongbinh.service.SanPhamService;

@Controller
@RequestMapping("/chitiet")
public class ChiTietController {
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	DanhMucService danhMucService;
	
	@GetMapping("/{masanpham}")
	public String Default(@PathVariable int masanpham ,ModelMap modelMap,HttpSession httpSession){
		SanPham sanpham = sanPhamService.LayDanhSachChiTietSanPhamTheoMa(masanpham);
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc();
		
		if(null != httpSession.getAttribute("giohang")){
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsanphamgiohang",gioHangs.size());
		}
		
		
		modelMap.addAttribute("sanpham", sanpham);
		modelMap.addAttribute("danhmuc",danhMucSanPhams);
		
		
		
		return "chitiet";
	}
	
}
