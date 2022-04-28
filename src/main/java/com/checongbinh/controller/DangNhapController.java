package com.checongbinh.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.checongbinh.entity.NhanVien;
import com.checongbinh.service.NhanVienService;

@Controller
@RequestMapping("dangnhap/")
public class DangNhapController {
	@Autowired
	NhanVienService nhanVienService;

	// cach nay dung phai co session truoc, neu ko se bi loi missing type of
	// string, chi dung de demo session
	@GetMapping
	public String Default() {

		return "dangnhap";
	}

	@PostMapping
	public String DangKy(@RequestParam String email, @RequestParam String matkhau, @RequestParam String nhaplaimatkhau,
			ModelMap map) {
		boolean ktmail = validate(email);
		if (ktmail) {
			if (matkhau.equals(nhaplaimatkhau)) {
				NhanVien nhanVien = new NhanVien();
				nhanVien.setEmail(email);
				nhanVien.setTendangnhap(email);
				nhanVien.setMatkhau(matkhau);

				boolean ktThem = nhanVienService.ThemNhanVien(nhanVien);
				if (ktThem) {
					map.addAttribute("kiemtradangnhap", "Tạo tài khoản thành công! ");
				} else {
					map.addAttribute("kiemtradangnhap", "Tạo tài khoản thất bại! ");
				}
			} else {
				map.addAttribute("kiemtradangnhap", "Mật khẩu không trùng khớp! ");
			}
		} else {
			map.addAttribute("kiemtradangnhap", "Vui lòng nhập đúng định dạnh email! ");
		}

		return "dangnhap";
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
}
