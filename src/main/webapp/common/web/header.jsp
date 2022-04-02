<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.vietshop.util.SecurityUtils"%>

<header class="header">

	<div class="header__top">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="header__top__left">
						<ul>
							<li><i class="fa fa-envelope"></i> vShop@gmail.com</li>
							<li>Miễn phí giao hàng Đà Nẵng</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="header__top__right">
						<div class="header__top__right__social">
							<a href="https://www.facebook.com/fviet295"><i
								class="fa fa-facebook"></i></a> <a
								href="https://www.facebook.com/fviet295"><i
								class="fa fa-twitter"></i></a> <a
								href="https://www.facebook.com/fviet295"><i
								class="fa fa-linkedin"></i></a> <a
								href="https://www.facebook.com/fviet295"><i
								class="fa fa-pinterest-p"></i></a>
						</div>
						<div class="header__top__right__auth">
							<!-- Hiển thị khi chưa login -->
							<security:authorize access="isAnonymous()">
								<a href="<c:url value='/authen'/>"><i class="fa fa-user"></i>
									Đăng nhập</a>
							</security:authorize>
							<!-- Hiển thị khi đã login -->
							<security:authorize access="isAuthenticated()">
								<a href="profile"><i class="fa fa-user"></i> Xin chào <%=SecurityUtils.getPrincipal().getFullName()%></a>
								<a href="<c:url value='/thoat'/>"><i class="fa fa-us"></i>Thoát</a>
							</security:authorize>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="header__logo">
					<a href="trang-chu"><img
						src="<c:url value='/template/admin/assets/img/logoV.png'/>" alt=""></a>
				</div>
			</div>
			<div class="col-lg-6">
				<nav class="header__menu" style="font-family: Cairo, sans-serif;">
					<ul>
						<li class="active"><a href="<c:url value='/trang-chu'/>">Trang
								chủ</a></li>
						<li><a href="shop-grid">Cửa hàng</a></li>
						<li><a href="#">Pages</a>
							<ul class="header__menu__dropdown">
								<li><a href="./shop-details.html">Shop sDetails</a></li>
								<li><a href="./shoping-cart.html">Shoping Cart</a></li>
								<li><a href="./checkout.html">Check Out</a></li>
								<li><a href="./blog-details.html">Blog Details</a></li>
							</ul></li>
						<li><a href="./blog.html">Bài viết</a></li>
						<li><a href="./contact.html">Liên hệ</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-lg-3">
				<security:authorize access="isAuthenticated()">
					<div class="header__cart">

						<ul>
							<li><a href="shopingcart"><i class="fa fa-shopping-bag"></i>
									<span>${sessionScope.quantity}</span></a></li>
						</ul>
						<div class="header__cart__price">
							Giỏ hàng: <span> ${sessionScope.total} đ </span>
						</div>
					</div>
				</security:authorize>
			</div>

		</div>
		<div class="humberger__open">
			<i class="fa fa-bars"></i>
		</div>
	</div>
	<section class="hero hero-normal">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories"
						style="font-family: Cairo, sans-serif;">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>Danh mục</span>
						</div>
						<ul>
							<li><a href="<c:url value='/shop-grid?p=0'/>"> Tất cả</a></li>
							<c:forEach items="${category}" var="item">

								<li><a
									href="<c:url value='/shopGridByCategory?idCategory=${item.idCategory}&p=0'/>">${item.category}</a></li>
							</c:forEach>

						</ul>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="shop-grid">

								<input type="text" placeholder="Nhập sản phẩm cần tìm ? "
									name="keyword">
								<button type="submit" class="site-btn">Tìm kiếm</button>
							</form>
						</div>
						<div class="hero__search__phone">
							<div class="hero__search__phone__icon">
								<i class="fa fa-phone"></i>
							</div>
							<div class="hero__search__phone__text">
								<h5 style="font-family: Cairo, sans-serif; font-size: 18px;">0937088941</h5>
								<span>Hỗ trợ 24/7</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</header>