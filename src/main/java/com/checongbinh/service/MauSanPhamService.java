package com.checongbinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checongbinh.dao.MauSanPhamDAO;
import com.checongbinh.daoimp.MauSanPhamImp;
import com.checongbinh.entity.MauSanPham;

@Service
public class MauSanPhamService implements MauSanPhamImp{
	
	@Autowired
	MauSanPhamDAO mauSanPhamDAO;
	
	@Override
	public List<MauSanPham> LayDanhSachMau() {
		// TODO Auto-generated method stub
		return mauSanPhamDAO.LayDanhSachMau();
	}

}
