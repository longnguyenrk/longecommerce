<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@include file="/common/taglib.jsp"%>

<title>Trang chủ</title>
<body>
	<section class="breadcrumb-section set-bg"
		data-setbg="<c:url value='/template/web/img/breadcrumb.jpg'/>" />
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="breadcrumb__text">
					<h2>${product.product}</h2>
					<div class="breadcrumb__option">
						<a href="shop-grid?p=0">Trang chủ</a> <a
							href="shopGridByCategory?idCategory=${product.category.idCategory}&p=0">${product.category.category}</a>
						<span>${product.product}</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Product Details Section Begin -->
	<section class="product-details spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="product__details__pic">
						<div class="product__details__pic__item">
							<img class="product__details__pic__item"
								src="<c:url value='${product.imgUrl}'/>" width="100"
								height="500" alt="">
						</div>
						<!-- <div class="product__details__pic__slider owl-carousel">
                            <img data-imgbigurl="img/product/details/product-details-2.jpg"
                                src="img/product/details/thumb-1.jpg" alt="">
                            <img data-imgbigurl="img/product/details/product-details-3.jpg"
                                src="img/product/details/thumb-2.jpg" alt="">
                            <img data-imgbigurl="img/product/details/product-details-5.jpg"
                                src="img/product/details/thumb-3.jpg" alt="">
                            <img data-imgbigurl="img/product/details/product-details-4.jpg"
                                src="img/product/details/thumb-4.jpg" alt="">
                        </div> -->
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="product__details__text">
						<h3>${product.product} (${product.weight} ${product.unit}) </h3>
						
						<!-- <div class="product__details__rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star-half-o"></i>
                            <span>(18 reviews)</span>
                        </div> -->
						<c:if test="${product.quantity > 0}">
							<div class="product__details__price">${formatter.format(product.cost)} đ </div>
						</c:if>
						<c:if test="${product.quantity <= 0}">
							<h3>Hết hàng</h3>
						</c:if>
						<p>${product.shortdescription}.</p>
						<p>Còn ${product.quantity} sản phẩm.</p>

						<c:if test="${product.quantity > 0}">
							<a href="addProduct?idProduct= ${product.idProduct}&quantity=1"
								class="primary-btn">Thêm vào giỏ hàng</a>
						</c:if>
						<c:if test="${product.quantity <= 0}">
							<a href="<c:url value='/shop-grid?p=0'/>" class="primary-btn">Chọn
								sản phẩm khác</a>
						</c:if>
						<ul>
							<!--                             <li><b>Availability</b> <span>In Stock</span></li> -->
							<!--                             <li><b>Shipping</b> <span>01 day shipping. <samp>Free pickup today</samp></span></li> -->
							<!--                             <li><b>Weight</b> <span>0.5 kg</span></li> -->
							<!-- <li><b>Chia sẻ</b>
								<div class="share">
									<a href="#"><i class="fa fa-facebook"></i></a>
								</div>
							</li> -->
						</ul>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="product__details__tab">
						<ul class="nav nav-tabs" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">Mô
									tả</a></li>

						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="tabs-1" role="tabpanel">
								<div class="product__details__tab__desc">
									<p>${product.descriptions}.</p>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Product Details Section End -->

	<!-- Related Product Section Begin -->
	<section class="related-product">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title related__product__title">
						<h2>Sản phẩm tương tự</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<c:if test="${size > 0}">
					<c:forEach items="${productByCate.content}" var="item">

						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="<c:url value='${item.imgUrl}'/>" />
								<ul class="product__item__pic__hover">
									<c:if test = "${item.quantity > 0}">
									<li><a href="addProductDetail?idProduct= ${item.idProduct}&quantity=1"><i class="fa fa-shopping-cart"></i></a></li>
									</c:if>
								</ul>
							</div>
							<div class="product__item__text">
								<h6>
									<a
										href="<c:url value='product-detail?idProduct=${item.idProduct}&idCategory=${item.category.idCategory}'/>">${item.product}</a>
								</h6>
								<h5>${formatter.format(item.cost)} đ</h5>
							</div>
						</div>
			</div>
			</c:forEach>
			</c:if>
			<c:if test="${size == 0}">
				<p>Không có sản phẩm tương tự
				<p>
			</c:if>
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