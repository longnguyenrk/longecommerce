<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@include file="/common/taglib.jsp"%>

<title>Thông tin tài khoản</title>
<head>
<!-- VENDOR CSS -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/vendor/bootstrap/css/bootstrap.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/vendor/font-awesome/css/font-awesome.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/vendor/linearicons/style.css'/>">
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/vendor/chartist/css/chartist-custom.css'/>">
<!-- MAIN CSS -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/main.css'/>">
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/demo.css'/>">
<!-- GOOGLE FONTS -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700"
	rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- ICONS -->
<link rel="apple-touch-icon" sizes="76x76"
	href="<c:url value='/template/admin/assets/img/apple-icon.png'/>">
<link rel="icon" type="image/png" sizes="96x96"
	href="<c:url value='/template/admin/assets/img/favicon.png'/>">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">




</head>
<body>
	<section class="breadcrumb-section set-bg"
		data-setbg="<c:url value='/template/web/img/breadcrumb.jpg'/>">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>V-SHOP
						<div class="breadcrumb__option">
							<a href="./index.html">Thông tin tài khoản</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Checkout Section Begin -->
	<section class="checkout spad">
		<div class="container">

			<div class="checkout__form">
									<a href="mylistorder"><div class="primary-btn">ĐƠN HÀNG CỦA TÔI</div></a>
						
									
				<h4 >Thông tin tài khoản</h4>
				
					<div class="row">
				
						<div class="col-lg-6 col-md-6">
						<form action="updateProfile" method="post" modelAttribute="account">
							<div class="row">
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Họ và tên<span></span>
										</p>
										<input type="text" 
											value="${account.fullName }" name="fullName"/>
											<input
											type="hidden" value="${account.id}" name="id" />
									</div>
								</div>

							</div>

							<div class="checkout__input">
								<p>
									Địa chỉ<span>*</span>
								</p>
								<input type="text" 
									value="${account.address}" name="address"/>
							</div>

							<div class="row">
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Số điện thoại<span>*</span>
										</p>
										<input type="text" 
											value="${account.phone }" name="phone"/>
									</div>
								</div>
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Email<span>*</span>
										</p>
										<input type="text" 
											value="${account.email }" name="email">
									</div>
								</div>
								<button type="submit" class="site-btn">Cập nhật thông tin</button>
								
							</div>
							</form>

						</div>
						
						<div class="col-lg-4 col-md-4">
						<p style="color: red;">${mess}</p>
				<form action="changePassword" method="post" modelAttribute="account">
				
							<div class="checkout__input">
							
								 <p>
									Mật khẩu mới<span>*</span>
								</p>
								<input type="password" required = "required" name="oldpass"/>
							</div>
							<input type="hidden" value="${account.id}" name="id" />
							<div class="checkout__input">
								<p>
									Nhập lại mật khẩu mới<span>*</span>
								</p>
								<input type="password" required = "required" name="newpass"/>
							</div>
						<button type="submit" class="site-btn">Đổi mật khẩu</button>
							
							</form>
						</div>
					</div>
					
			</div>
		</div>
	</section>
		<div class="clearfix"></div>
	</div>
	<script src="<c:url value='/template/admin/js/jquery-3.3.1.min.js'/>"></script>
	<script src="<c:url value='/template/admin/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/template/admin/js/jquery.nice-select.min.js'/>"></script>
	<script src="<c:url value='/template/admin/js/jquery-ui.min.js'/>"></script>
	<script src="<c:url value='/template/admin/js/jquery.slicknav.js'/>"></script>
	<script src="<c:url value='/template/admin/js/mixitup.min.js'/>"></script>
	<script src="<c:url value='/template/admin/js/owl.carousel.min.js'/>"></script>
	<script src="<c:url value='/template/admin/js/main.js'/>"></script>
	
	<script type="text/javascript"
		src="<c:url value='/template/admin/js/jquery-1.10.2.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='../template/admin/js/jquery.easing.1.3.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='../template/admin/js/bootstrap.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='../template/admin/js/jquery.sequence-min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='../template/admin/js/jquery.carouFredSel-6.2.1-packed.js'/>"></script>
	<script defer src="<c:url value='../template/admin/js/jquery.flexslider.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='../template/admin/js/script.min.js'/>"></script>



</body>
</html>