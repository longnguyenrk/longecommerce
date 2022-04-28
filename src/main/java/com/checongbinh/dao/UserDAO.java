package com.checongbinh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.checongbinh.entity.NhanVien;



@Repository(value = "userDAO")
@Transactional(rollbackFor = Exception.class)
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public NhanVien loadUserByUsername(final String username) {
		List<NhanVien> users = new ArrayList<NhanVien>();
		Session session = this.sessionFactory.getCurrentSession();
		users = session.createQuery("from NHANVIEN where username=?", NhanVien.class).setParameter(0, username).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
}
