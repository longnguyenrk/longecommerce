<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@include file="/common/taglib.jsp"%>

<title>Trang chủ</title>
<body>
	<section class="breadcrumb-section set-bg"
		data-setbg="<c:url value='/template/web/img/breadcrumb.jpg'/>">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Thanh toán</h2>
						<div class="breadcrumb__option">
							<a href="./index.html">Trang chủ</a> <span>Thanh toán</span>
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
				<h4>Chi tiết đặt hàng</h4>
				<form action="checkOut" method="post" modelAttribute="Account">
					<div class="row">
						<div class="col-lg-6 col-md-6">
							<div class="row">
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Họ và tên<span></span>
										</p>
										<input type="text" placeholder="${order.account.fullName }"
											value="${order.account.fullName }" name="fullName"/>
											 <input
											type="hidden" value="${order.account.id}" name="idAccount" />
											 <input
											type="hidden" value="${order.dateOrder}" name="dateorder" />
									</div>
								</div>

							</div>

							<div class="checkout__input">
								<p>
									Địa chỉ<span>*</span>
								</p>
								<input type="text" placeholder="${order.account.address }"
									value="${order.account.address }" name="address"/>
							</div>

							<div class="row">
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Số điện thoại<span>*</span>
										</p>
										<input type="text" placeholder="${order.account.phone }"
											value="${order.account.phone }" name="phone"/>
									</div>
								</div>
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Email<span>*</span>
										</p>
										<input type="text" placeholder="${order.account.email }"
											value="${order.account.email }" name="email">
									</div>
								</div>
							</div>


						</div>
						<div class="col-lg-6 col-md-6">
							<div class="checkout__order">
								<h4>Đơn hàng của bạn</h4>
								<div class="checkout__order__products">
									Sản phẩm <span>Thành tiền</span>
								</div>
								<c:forEach items="${cartItems}" varStatus="loop" var="item">
									<ul>
										<li>${item.product.product}(${item.product.weight}
											${item.product.unit}) SL: ${item.quantity}<span>${formatter.format(item.total)} đ 
												</span>
										</li>

									</ul>
								</c:forEach>
								<div class="checkout__order__total">
									Tổng cộng <span>${formatter.format(order.priceTotal)} đ </span>
								</div>

								<div class="checkout__order__products">
									Chọn hình thức thanh toán
								</div>
								<select class="form-select form-select-sm"
									aria-label=".form-select-sm example" name="methodPayment">
									<option value="card">Thanh toán qua thẻ ngân hàng</option>
									<option value="cod">Thanh toán tiền mặt khi nhận hàng (Miễn phí thu hộ)</option>
								</select>

								<button type="submit" class="site-btn">ĐẶT HÀNG</button>
							</div>
						</div>
					</div>
				</form>
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