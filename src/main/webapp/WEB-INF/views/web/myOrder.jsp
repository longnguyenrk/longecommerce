<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@include file="/common/taglib.jsp"%>

<title>Chi tiết đơn hàng</title>
<body>
	<section class="breadcrumb-section set-bg"
		data-setbg="<c:url value='/template/web/img/breadcrumb.jpg'/>">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>V-SHOP
						<div class="breadcrumb__option">
							<a href="./index.html">Trang chủ</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Checkout Section Begin -->
	<section class="shoping-cart spad">
		<div class="container" style="align-content: center;">

			<br><br>
			<div id="wrapper">

		<div class="main">
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading">
							<h3 class="panel-title">CHI TIẾT ĐƠN HÀNG <br> No.000${order.idOrder}</h3>

						</div>
						<div class="panel-body no-padding">
							<table class="table table-striped" >
								<thead>
									<tr>
										<th>Hình ảnh</th>
										<th>Chi tiết sản phẩm</th>
										<th>Đơn giá</th>
										<th>Số lượng</th>
										<th>Thành tiền</th>
									</tr>
								</thead>
								<tbody>
								<ol>
									<c:forEach items="${items}" var="item">
										<tr>
											<td><a><img style="width: 20%;"
													src="<c:url value='${item.product.imgUrl}'/>" alt=""></a></td>
											<td>
												<div class="shop-details">
													<div class="productname"><strong class="pcode">${item.product.product}</strong></div>
													Khối lượng chuẩn: ${item.product.weight} ${item.product.unit} 
													
													<p>
														Mã sản phẩm : <strong class="pcode">0000${item.product.idProduct}</strong>
													</p>
												</div>
											</td>
											<td>
												<h5 style="color: #41B314; font-weight: bold;">${formatter.format(item.product.cost)} đ</h5>
											</td>
											<td>${item.quantity}</td>
											<td>
												<h5>
													<strong class="red" style="color: red;">${formatter.format(item.total)} đ  </strong> 
												</h5>
											</td>

										</tr>
									</c:forEach>
								</tbody>
								<tfoot>
									 <tr>
										<td colspan="6"><span class="pull-right"> <span style="color: red;"></span></span><br /> <span
											class="pull-right"> <span style="color: red;"></span></span><br /> <span  
											class="pull-right" style="font-size: 22px;">Tổng đơn hàng:  <span style="color: red;">${formatter.format(order.subTotal)} đ </span>
										</span>

											</td>
									</tr>
									<c:if test="${order.status eq 'Thanh toán khi nhận hàng'}">
								<a ><span class="label label-warning" style="font-size: 15px; margin-right: 15px;">${order.status}</span></a>
								</c:if>
								<c:if test="${order.status eq 'Đã thanh toán'}">
								<span class="label label-success" style="font-size: 15px; margin-right: 15px;">${order.status}</span>
								</c:if>
								</tfoot>
							</table>
						</div>
						<div id="headline-chart" class="ct-chart"></div>
					</div>
				</div>
				<!-- END OVERVIEW -->
			</div>
			<!-- END MAIN CONTENT -->
		</div>
		<!-- END MAIN -->
		<div class="clearfix"></div>
		
	</div>
			<div class="row">
				<div class="col-lg-4">
				
					<div class="shoping__cart__btns">
						<a href="/vietshop/trang-chu" class="primary-btn cart-btn">Tiếp tục mua hàng</a>
					</div>

					
				</div>
				<div class="row">
				<div class="col-lg-80">
				
					

				</div>
				<!-- <div class="col-lg-6">
					<div class="shoping__continue">
						<div class="shoping__discount">
							<h5>Discount Codes</h5>
							<form action="#">
								<input type="text" placeholder="Enter your coupon code">
								<button type="submit" class="site-btn">APPLY COUPON</button>
							</form>
						</div>
					</div>
				</div> -->
				
			</div>
		</div>
		</div>
	</section>
	<!-- Checkout Section End -->


	<!-- Footer Section End -->

	<!-- Js Plugins -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>



</body>
</html>