package com.checongbinh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checongbinh.dao.HoaDonDAO;
import com.checongbinh.daoimp.HoaDonImp;
import com.checongbinh.entity.HoaDon;

@Service
public class HoaDonService implements HoaDonImp {
	
	@Autowired
	HoaDonDAO hoaDonDAO;

	@Override
	public int ThemHoaDon(HoaDon hoaDon) {
		return hoaDonDAO.ThemHoaDon(hoaDon);
	}
	
	
}
