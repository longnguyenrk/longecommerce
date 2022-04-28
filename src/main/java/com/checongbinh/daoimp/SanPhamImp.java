package com.checongbinh.daoimp;

import java.util.List;

import com.checongbinh.entity.SanPham;

public interface SanPhamImp {
	List<SanPham> LayDanhSachSanPhamLimit(int spbatdau);
	SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham);
	List<SanPham> LayDanhSachSanPhamTheoMaDanhMuc(int madanhmuc);
	boolean XoaSanPhamTheoMaSanPham(int masanpham);
	boolean ThemSanPham(SanPham sanPham);
	boolean CatNhatSanPham(SanPham sanPham);
}
