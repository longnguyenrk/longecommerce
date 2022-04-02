<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><dec:title default="Trang Master"/></title> <!-- Lấy title cho các trang con nếu trang con chưa định nghĩa -->
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
		<%@include file="/common/admin/header.jsp" %>
		<%@include file="/common/admin/category.jsp" %>
		<div id="wrapper">
			<div th:fragment="category">
				<div id="sidebar-nav" class="sidebar">
					<div class="sidebar-scroll" style="padding-top: 20px;">
						<nav>
							<ul class="nav">
								<li><a href="trang-chu" class=""><i class="lnr lnr-home"></i>
										<span>Trang chủ</span></a></li>
								<li><a href="list-account" class=""><i
										class="lnr lnr-users"></i> <span>Tài khoản</span></a></li>
								<li><a href="list-product" class=""><i
										class="lnr lnr-gift"></i> <span>Sản phẩm</span></a></li>
								<li><a href="listOrder" class=""><i class="lnr lnr lnr-dice"></i>
										<span>Đơn hàng</span></a></li>
								<li><a href="/vietshop/trang-chu" class=""><i class="lnr lnr-store"></i> <span>Đến trang bán hàng</span></a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		
<dec:body/>


</body>
</html>