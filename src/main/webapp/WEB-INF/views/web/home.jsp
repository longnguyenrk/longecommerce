<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<title>Trang chủ</title>
<body>
	<section class="hero">
		<div class="container">

			<div class="hero__search">

				<div class="hero__search__phone"></div>
			</div>
			<div class="hero__item set-bg"
				data-setbg="<c:url value='/template/web/img/hero/banner.jpg'/>">
				<div class="hero__text">
					<span>Trái cây tươi</span>
					<h2 style="font-family: Cairo, sans-serif;">
						Rau sạch <br />100% Organic
					</h2>
					<p style="font-family: Cairo, sans-serif;">Miễn phí giao hàng</p>
					<a href="shop-grid" class="primary-btn"
						style="font-family: Cairo, sans-serif;">Đến Cửa Hàng</a>
				</div>
			</div>

		</div>
	</section>

	<!-- Categories Section Begin -->

	<section class="categories">
		<div class="container">
			<div class="row">
				<div class="categories__slider owl-carousel">
					<c:forEach items="${category}" var="item">
						<div class="col-lg-3">
							<div class="categories__item set-bg"
								data-setbg="<c:url value='${item.imgUrl}'/> ">
								<h5>
									<a
										href="<c:url value='/shopGridByCategory?idCategory=${item.idCategory}&p=0'/>">${item.category}</a>
								</h5>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>
	<!-- Categories Section End -->

	<!-- Featured Section Begin -->
	<section class="featured spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title">
						<h2>Sản phẩm nổi bật</h2>
					</div>

				</div>
			</div>
			<div class="row featured__filter">
				<c:forEach items="${topProduct.content}" var="item">
					<div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
						<div class="featured__item">
							<div class="featured__item__pic set-bg" 
								data-setbg="<c:url value='${item.imgUrl}'/> ">

								<ul class="featured__item__pic__hover">
									<c:if test="${item.quantity > 0}">
										<li><a 
											href="addProductHome?idProduct= ${item.idProduct}&quantity=1" ><i
												class="fa fa-shopping-car"></i></a></li>
									</c:if>
<!-- 									<li><a href="#"><i class="fa fa-retweet"></i></a></li>
 -->								</ul>
							</div>
							<div class="featured__item__text">
								<h6>
									<a
										href="<c:url value='product-detail?idProduct=${item.idProduct}&idCategory=${item.category.idCategory}'/>"><p>${item.product}</p>
										(${item.weight} ${item.unit}) </a>
								</h6>
								<h5>${formatter.format(item.cost)}đ</h5>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
	</section>
	<!-- Featured Section End -->

	<!-- Banner Begin -->
	<div class="banner">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="banner__pic">
						<img src="<c:url value='/template/web/img/banner/banner-1.jpg'/>"
							alt="">

					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="banner__pic">
						<img src="<c:url value='/template/web/img/banner/banner-2.jpg'/>"
							alt="">

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Banner End -->
	<section class="featured spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title">
						<h2>Sản phẩm mới</h2>
					</div>

				</div>
			</div>
			<div class="row featured__filter">
				<c:forEach items="${lastProduct.content}" var="item">
					<div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
						<div class="featured__item">
							<div class="featured__item__pic set-bg"
								data-setbg="<c:url value='${item.imgUrl}'/>">

								<ul class="featured__item__pic__hover">
									<c:if test="${item.quantity > 0}">
										<li><a 
											href="addProductHome?idProduct= ${item.idProduct}&quantity=1" ><i
												class="fa fa-shopping-car"></i></a></li>
									</c:if>
								</ul>
							</div>
							<div class="featured__item__text">
								<h6>
									<a
										href="<c:url value='product-detail?idProduct=${item.idProduct}&idCategory=${item.category.idCategory}'/>"><p>${item.product}</p>
										(${item.weight} ${item.unit}) </a>
								</h6>
								<h5>${formatter.format(item.cost)}đ</h5>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
	</section>
	

	<!-- Latest Product Section Begin -->
	<%-- <section class="latest-product spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="latest-product__text">
						<h4>Latest Products</h4>
						<div class="latest-product__slider owl-carousel">
							<div class="latest-prdouct__slider__item">
								<a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-1.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a> <a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-2.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a> <a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-3.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<span>$30.00</span>
									</div>
								</a>
							</div>
							<div class="latest-prdouct__slider__item">
								<a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-1.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a> <a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-2.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a> <a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-3.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="latest-product__text">
						<h4>Top Rated Products</h4>
						<div class="latest-product__slider owl-carousel">
							<div class="latest-prdouct__slider__item">
								<a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-1.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a> <a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-2.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a> <a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-3.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a>
							</div>
							<div class="latest-prdouct__slider__item">
								<a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-1.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a> <a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-2.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a> <a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-3.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="latest-product__text">
						<h4>Review Products</h4>
						<div class="latest-product__slider owl-carousel">
							<div class="latest-prdouct__slider__item">
								<a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-1.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a> <a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-2.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a> <a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-3.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a>
							</div>
							<div class="latest-prdouct__slider__item">
								<a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-1.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a> <a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-2.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a> <a href="#" class="latest-product__item">
									<div class="latest-product__item__pic">
										<img
											src="<c:url value='/template/web/img/latest-product/lp-3.jpg'/>"
											alt="">

									</div>
									<div class="latest-product__item__text">
										<h6>Crab Pool Security</h6>
										<span>$30.00</span>
									</div>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section> --%>
	<!-- Latest Product Section End -->

	<!-- Blog Section Begin -->
	<section class="from-blog spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title from-blog__title">
						<h2>From The Blog</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-6">
					<div class="blog__item">
						<div class="blog__item__pic">
							<img src="<c:url value='/template/web/img/blog/blog-1.jpg'/>"
								alt="">

						</div>
						<div class="blog__item__text">
							<ul>
								<li><i class="fa fa-calendar-o"></i> May 4,2019</li>
								<li><i class="fa fa-comment-o"></i> 5</li>
							</ul>
							<h5>
								<a href="#">Cooking tips make cooking simple</a>
							</h5>
							<p>Sed quia non numquam modi tempora indunt ut labore et
								dolore magnam aliquam quaerat</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-6">
					<div class="blog__item">
						<div class="blog__item__pic">
							<img src="<c:url value='/template/web/img/blog/blog-2.jpg'/>"
								alt="">

						</div>
						<div class="blog__item__text">
							<ul>
								<li><i class="fa fa-calendar-o"></i> May 4,2019</li>
								<li><i class="fa fa-comment-o"></i> 5</li>
							</ul>
							<h5>
								<a href="#">6 ways to prepare breakfast for 30</a>
							</h5>
							<p>Sed quia non numquam modi tempora indunt ut labore et
								dolore magnam aliquam quaerat</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-6">
					<div class="blog__item">
						<div class="blog__item__pic">
							<img src="<c:url value='/template/web/img/blog/blog-3.jpg'/>"
								alt="">

						</div>
						<div class="blog__item__text">
							<ul>
								<li><i class="fa fa-calendar-o"></i> May 4,2019</li>
								<li><i class="fa fa-comment-o"></i> 5</li>
							</ul>
							<h5>
								<a href="#">Visit the clean farm in the US</a>
							</h5>
							<p>Sed quia non numquam modi tempora indunt ut labore et
								dolore magnam aliquam quaerat</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
