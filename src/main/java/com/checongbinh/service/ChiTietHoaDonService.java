package com.checongbinh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checongbinh.dao.ChiTietHoaDonDAO;
import com.checongbinh.daoimp.ChiTietHoaDonImp;
import com.checongbinh.entity.ChiTietHoaDon;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImp {
	
	@Autowired
	ChiTietHoaDonDAO chiTietHoaDonDAO;

	@Override
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		
		return chiTietHoaDonDAO.ThemChiTietHoaDon(chiTietHoaDon);
	}

}
