package com.checongbinh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checongbinh.dao.NhanVienDAO;
import com.checongbinh.daoimp.NhanVienImp;
import com.checongbinh.entity.NhanVien;


@Service
public class NhanVienService implements NhanVienImp  {
	@Autowired
	NhanVienDAO nhanVienDAO;
	/*@Override
	public boolean KiemTraDangNhap(String email, String matkhau) {
		boolean kiemtra =  nhanVienDAO.KiemTraDangNhap(email, matkhau);
		return kiemtra;
	}*/
	@Override
	public boolean KiemTraDangNhap(String email, String matkhau) {
		boolean kiemtra =  nhanVienDAO.KiemTraDangNhap(email, matkhau);
		return kiemtra;
	}
	@Override
	public boolean ThemNhanVien(NhanVien nhanVien) {
		boolean ktThem = nhanVienDAO.ThemNhanVien(nhanVien);
		return ktThem;
	}
	
	
	
	
	
}
