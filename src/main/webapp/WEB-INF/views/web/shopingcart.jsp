<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@include file="/common/taglib.jsp"%>

<title>Trang chủ</title>
<body>
	<section class="shoping-cart spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-14">
				<c:if test="${empty cartItems}">
				<p>Giỏ hàng chưa có sản phẩm</p>
				</c:if>
					<div class="shoping__cart__table">
					<c:if test="${not empty cartItems}"> <!-- check giỏ hàng có sp hay ko -->
					<p>${msg}</p>
						<table>
							<thead>
								<tr>
									<th class="shoping__product">Sản phẩm</th>
									<th>Giá</th>
									<th>Số lượng</th>
									<th>Tổng</th>
									<th style="width: 22%;"><a href="deleteAllProduct" class="primary-btn">Xóa tất cả</a>
									</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cartItems}" var="cart">
									<tr>
										<td class="shoping__cart__item"><img
											src="<c:url value='${cart.product.imgUrl}'/>"
											width="100" height="100" alt="">
											<h5>${cart.product.product}  (${cart.product.weight} ${cart.product.unit}) </h5></td>
										<td class="shoping__cart__price">
										${formatter.format(cart.product.cost)} đ </td>
									<td class="shoping__cart__quantity">
											<div class="col-xs-5">
												<form action="addProduct" method="post">

													<div class="number-input">
														<button
															onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
															class="minus"></button>
														<input class="form-control" type="number" min="1"
															name="quantity" value="${cart.quantity}">
														<button
															onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
															class="plus"></button>
													</div>

													<input type="hidden"
														value="${cart.product.idProduct}" name="idProduct" />
												</form>
										<td class="shoping__cart__total">
											<h5>
												<strong class="red" style="font-weight: bold;" value ="${cart.total}">
													${formatter.format(cart.total)} đ  </strong>
											</h5>
										</td>
										<td class="shoping__cart__item__close" href="deleteProduct?idProduct= ${cart.product.idProduct}">
										 <a href="deleteProduct?idProduct= ${cart.product.idProduct}" class="primary-btn">Xóa</a>
										 </td>
									</tr>
								</c:forEach>
							</tbody>
							
						</table>
						</c:if>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4">
				
					<div class="shoping__cart__btns">
						<a href="/vietshop/trang-chu" class="primary-btn cart-btn">Tiếp tục mua hàng</a>
					</div>

					
				</div>
				<div class="row">
				<div class="col-lg-80">
				<c:if test="${not empty cartItems}">
					<div class="shoping__checkout">
                        <ul>
                            <li>Thành tiền <span>${formatter.format(priceTotal)} đ </span></li>
                        </ul>
						<a href="checkOut?idAccount=${account.id}" class="primary-btn">Thanh toán giỏ hàng</a>
					</div>
				</c:if>
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
	</section>
	<!-- Related Product Section End -->



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