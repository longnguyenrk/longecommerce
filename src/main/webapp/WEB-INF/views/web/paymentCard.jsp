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
							<a href="trang-chu">Trang chủ</a> <span>Thanh toán</span>
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
				<h4>Chi tiết thanh toán thẻ</h4>
				<p style="color: red;">${msg}</p>
				<form action="paymentCard" method="post">
					<div class="row">
						<div class="col-lg-6 col-md-6">
							<div class="row">
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Tên chủ thẻ<span>*</span>
										</p>
										<input type="text" required="required" name="name" /> <input
											type="hidden" value="${order.account.id}" name="idAccount" />
										<input type="hidden" value="${order.idOrder}" name="idOrder" />

									</div>
								</div>

							</div>

							<div class="checkout__input">
								<p>
									Số thẻ <span>*</span>
								</p>
								<input type="text" required="required" name="cardNumber" />
							</div>

							<div class="row">
								<div class="col-lg-3">
									<div class="checkout__input">
										<p>
											Ngày hết hạn<span>*</span>
										</p>
										<input type="number" required="required" name="expMonth" />

									</div>
								</div>
								<div class="col-lg-3">
									<div class="checkout__input">
										<p>(MM/YY)</p>
										<span></span><input required="required" type="text"
											name="expYear" />

									</div>
								</div>
								<div class="col-lg-6">
									<div class="checkout__input">
										<p>
											Mã bảo mật<span>*</span>
										</p>
										<input type="number" required="required" name="cvcCode">
									</div>
								</div>
							</div>
						</div>

						<button type="submit" class="site-btn"
							style="position: absolute; top: 832px; right: 963px; left: 744px;">THANH
							TOÁN</button>
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