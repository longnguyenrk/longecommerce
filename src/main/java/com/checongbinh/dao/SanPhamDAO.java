package com.checongbinh.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.checongbinh.daoimp.SanPhamImp;
import com.checongbinh.entity.ChiTietHoaDon;
import com.checongbinh.entity.ChiTietHoaDonId;
import com.checongbinh.entity.ChiTietSanPham;
import com.checongbinh.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<SanPham> LayDanhSachSanPhamLimit(int spbatdau) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> listSanPhams = new ArrayList<>();
		if(spbatdau < 0){
			String query = "from SANPHAM";
			listSanPhams = (List<SanPham>)  session.createQuery(query).getResultList();
		}else{
			listSanPhams = (List<SanPham>) session.createQuery("from SANPHAM").setFirstResult(spbatdau).setMaxResults(50).getResultList();
		}
		
		return listSanPhams;
	}
	
	@Override
	@Transactional
	public SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham){
		
		Session session = sessionFactory.getCurrentSession();
		String query = "from SANPHAM sp where sp.masanpham="+masanpham;
		SanPham sanPhams = (SanPham) session.createQuery(query).getSingleResult();

		return sanPhams;
	}
	
	@Override
	@Transactional
	public List<SanPham> LayDanhSachSanPhamTheoMaDanhMuc(int madanhmuc) {
		Session session = sessionFactory.getCurrentSession();
		String query = "from SANPHAM sp where sp.danhmucsanpham.madanhmuc="+madanhmuc;
		List<SanPham> listSanPhams = (List<SanPham>)  session.createQuery(query).getResultList();
		return listSanPhams;
	}
	
	@Override
	@Transactional
	public boolean XoaSanPhamTheoMaSanPham(int masanpham) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sanPham = session.get(SanPham.class, masanpham);
		
		Set<ChiTietSanPham> chiTietSanPhams = sanPham.getChitietsanpham();
		for (ChiTietSanPham chiTietSanPham : chiTietSanPhams) {
			
			session.createQuery("delete CHITIETHOADON WHERE machitietsanpham="+chiTietSanPham.getMachitietsanpham()).executeUpdate();
			
			
		}
		session.createQuery("delete CHITIETKHUYENMAI WHERE masanpham="+masanpham).executeUpdate();
		session.createQuery("delete CHITIETSANPHAM WHERE masanpham="+masanpham).executeUpdate();
		session.createQuery("delete SANPHAM WHERE masanpham="+masanpham).executeUpdate();
		
		return false;
	}

	@Override
	@Transactional
	public boolean ThemSanPham(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		int id =(int) session.save(sanPham);
		
		return false;
	}

	@Override
	@Transactional
	public boolean CatNhatSanPham(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		session.update(sanPham);
		
		return false;
	}

}
