package com.checongbinh.entity;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;



@Entity(name="NHANVIEN")
public class NhanVien {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int manhanvien;
	String hoten;
	String diachi;
	String cmnd;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="machucvu")
	ChucVu chucvu;
	
	String email;
	String tendangnhap;
	String matkhau;
	@Column(name = "enabled", nullable = false, columnDefinition = "TINYINT(1)")
	Boolean enabled;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "nhanVien")
	private Set<UsersRoles> usersRoleses = new HashSet<UsersRoles>(0);
	
	
	
	public NhanVien() {
		
	}
	public NhanVien(String tendangnhap, String matkhau, Boolean enabled, Set<UsersRoles> usersRoleses) {
		
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.enabled = enabled;
		this.usersRoleses = usersRoleses;
	}
	public int getManhanvien() {
		return manhanvien;
	}
	public void setManhanvien(int manhanvien) {
		this.manhanvien = manhanvien;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public ChucVu getChucvu() {
		return chucvu;
	}
	public void setChucvu(ChucVu chucvu) {
		this.chucvu = chucvu;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	
	
	
	public Boolean getEnabled() {
		return this.enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public Set<UsersRoles> getUsersRoleses() {
		return this.usersRoleses;
	}
	public void setUsersRoleses(Set<UsersRoles> usersRoleses) {
		this.usersRoleses = usersRoleses;
	}
	
	
	@Transient
	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (UsersRoles usersRoles: this.usersRoleses) {
			authorities.add(new SimpleGrantedAuthority(usersRoles.getRole().getName()));
		}
		return authorities;
	}
	
	
}
