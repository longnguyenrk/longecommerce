<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@include file="/common/taglib.jsp"%>

<title>Đơn hàng của tôi</title>
<body>
	<section class="breadcrumb-section set-bg"
		data-setbg="<c:url value='/template/web/img/breadcrumb.jpg'/>">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>
							V-SHOP
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

	<section style="padding-top: 4px; padding-bottom: 160px;"
		class="shoping-cart spad">
		<div class="container" style="align-content: center;">

			<br>
			<br>
			<div id="wrapper">
				<c:if test="${elements == 0}">
					<p>Bạn chưa có đơn hàng nào</p>

				</c:if>
				<c:if test="${pageOrders.totalPages-1 >= 0}">
					<div class="main">
						<div class="main-content">
							<div class="container-fluid">

								<!-- OVERVIEW -->
								<div class="panel panel-headline">
									<div class="panel-heading">
										<h3 class="panel-title">DANH SÁCH ĐƠN HÀNG CỦA TÔI</h3>

									</div>
									<div class="panel-body no-padding">
										<table class="table table-striped">
											<thead>
												<tr>
													<th>Mã đơn hàng</th>
													<th>Tổng thanh toán</th>
													<th>Ngày đặt hàng</th>
													<th>Địa chỉ nhận hàng</th>
													<th>Tình trạng đơn hàng</th>
													<th>Chi tiết</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${pageOrders.content}" var="order">
													<tr>
														<td><a href="#">No. 000${order.idOrder}</a></td>
														<td>${formatter.format(order.subTotal)}đ</td>
														<td>${order.dateOrder}</td>
														<td>${order.shippingInfo.address}</td>
														<c:if test="${order.status eq 'Thanh toán khi nhận hàng'}">
															<td><a
																href="<c:url value='/admin/successStatus?idOrder=${order.idOrder }&p=${p }'/>"><span
																	class="label label-warning">Thanh toán khi nhận
																		hàng</span></a></td>
														</c:if>
														<c:if test="${order.status eq 'Đã thanh toán'}">
															<td><a><span
																	class="label label-success">Đã thanh toán</span></a></td>
														</c:if>
														<td><a
															href="<c:url value='/myorderdetail?idOrder=${order.idOrder }'/>"
															style="text-decoration: underline;">Chi tiết</a></td>
													</tr>
												</c:forEach>
											</tbody>

										</table>
									</div>
									<div id="headline-chart" class="ct-chart"></div>
								</div>
							</div>
							<!-- END OVERVIEW -->
						</div>
						<!-- END MAIN CONTENT -->
					</div>
				</c:if>
				<!-- END MAIN -->
				<div class="clearfix"></div>
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<c:if test="${pageOrders.totalPages-1 >= 0 }">
							<li class="page-item"><a class="page-link"
								href="<c:url value='/mylistorder?p=${0}'/>">|< </a></li>
							<c:if test="${p > 0 }">
								<li class="page-item"><a class="page-link"
									href="<c:url value='/mylistorder?p=${p-1}'/>"> << </a></li>
							</c:if>
							<li class="page-item active"><a class="page-link"
								href="<c:url value='/mylistorder?p=${p}'/>">${p+1}</a></li>
							<c:if test="${p < pageOrders.totalPages -1 }">
								<li class="page-item"><a class="page-link"
									href="<c:url value='/mylistorder?p=${p+1}'/>">${p+2}</a></li>
								<c:if test="${p < pageOrders.totalPages -2 }">
									<li class="page-item"><a class="page-link"
										href="<c:url value='/mylistorder?p=${p+2}'/>">${p+3}</a></li>
								</c:if>
							</c:if>
							<c:if test="${p < pageOrders.totalPages -1 }">
								<li class="page-item"><a class="page-link"
									href="<c:url value='/mylistorder?p=${p+1}'/>"> >> </a></li>
							</c:if>
							<li class="page-item"><a class="page-link"
								href="<c:url value='/mylistorder?p=${pageOrders.totalPages-1}'/>">
									>| </a></li>
						</c:if>
					</ul>
				</nav>

			</div>
			<div class="row">
				<div class="col-lg-4">

					<div class="shoping__cart__btns">
						<a href="/vietshop/trang-chu" class="primary-btn cart-btn">Tiếp
							tục mua hàng</a>
					</div>


				</div>
				<div class="row">
					<div class="col-lg-80"></div>
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