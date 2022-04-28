package com.checongbinh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.checongbinh.daoimp.DanhMucImp;
import com.checongbinh.entity.DanhMucSanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDAO implements DanhMucImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<DanhMucSanPham> LayDanhMuc() {
		Session session = sessionFactory.getCurrentSession();
		String query = "from DANHMUCSANPHAM";
		List<DanhMucSanPham> danhMucSanPhams =  session.createQuery(query).getResultList();
		System.out.println(danhMucSanPhams.size());
		return danhMucSanPhams;
	}

}
