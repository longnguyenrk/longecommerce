package com.checongbinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checongbinh.dao.SizeSanPhamDAO;
import com.checongbinh.daoimp.SizeSanPhamImp;
import com.checongbinh.entity.SizeSanPham;

@Service
public class SizeSanPhamService implements SizeSanPhamImp{
	
	@Autowired
	SizeSanPhamDAO sizeSanPhamDAO;
	
	@Override
	public List<SizeSanPham> LayDanhSachSize() {
		// TODO Auto-generated method stub
		return sizeSanPhamDAO.LayDanhSachSize();
	}

}
