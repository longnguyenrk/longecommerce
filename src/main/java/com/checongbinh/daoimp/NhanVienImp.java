package com.checongbinh.daoimp;

import com.checongbinh.entity.NhanVien;

public interface NhanVienImp {

	

	boolean KiemTraDangNhap(String email, String matkhau);
	boolean ThemNhanVien(NhanVien nhanVien);
}
