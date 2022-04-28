package com.checongbinh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.checongbinh.daoimp.SizeSanPhamImp;
import com.checongbinh.entity.SanPham;
import com.checongbinh.entity.SizeSanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SizeSanPhamDAO implements SizeSanPhamImp {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<SizeSanPham> LayDanhSachSize() {
		Session session = sessionFactory.getCurrentSession();
		String query = "from SIZESANPHAM";
		List<SizeSanPham> listSizeSanPham =session.createQuery(query).getResultList();
		
		return listSizeSanPham;
	}
	
	
}
