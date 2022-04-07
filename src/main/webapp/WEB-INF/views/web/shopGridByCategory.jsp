<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<title>Trang chủ</title>
<body>

	<!-- Hero Section End -->
		<section class="breadcrumb-section set-bg"
		data-setbg="<c:url value='/template/web/img/breadcrumb.jpg'/>" />
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="breadcrumb__text"
					style="font-size: 46px; color: #ffffff; font-weight: 700;font-family: Cairo, sans-serif;">
					<h2>V-SHOP</h2>
					<div class="breadcrumb__option" style="text-align: center;">
						<a href="shop-grid?p=0">Trang chủ</a>
						<span href="<c:url value='/shopGridByCategory?idCategory=${item.idCategory}&p=0'/>" >${cateName.category}</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	<!-- Breadcrumb Section Begin -->

	<!-- Product Section Begin -->
	<section class="product spad">
		<div class="container">
			<div class="row">
			<div class="col-lg-3 col-md-5">
					<div class="sidebar">
						<div class="sidebar__item">
							<h4>Danh mục</h4>
							<ul>
						<li><a href="<c:url value='/shop-grid?p=0'/>"> Tất cả</a></li>
							<c:forEach items="${category}" var="item">

								<li><a href="<c:url value='/shopGridByCategory?idCategory=${item.idCategory}&p=0'/>">${item.category}</a></li>
							</c:forEach>

						</ul>
						</div>
						
						<div class="sidebar__item">
							<div class="latest-product__text">
								<h4>Sản phẩm mới</h4>
								<div class="latest-product__slider owl-carousel">
									<div class="latest-prdouct__slider__item">
										<c:forEach items = "${lastProduct1.content }" var = "item">
										<a href="<c:url value='product-detail?idProduct=${item.idProduct}&idCategory=${item.category.idCategory}'/>" class="latest-product__item">
											<div class="latest-product__item__pic">
												<img src="<c:url value='${item.imgUrl}'/>" alt="">
											</div>
											<div class="latest-product__item__text">
												<h6>${item.product}</h6>
												<span>${formatter.format(item.cost)}đ</span>
											</div>
										</a> 
										</c:forEach>
									</div>
									<div class="latest-prdouct__slider__item">
										<c:forEach items = "${lastProduct2.content }" var = "item">
										<a href="<c:url value='product-detail?idProduct=${item.idProduct}&idCategory=${item.category.idCategory}'/>" class="latest-product__item">
											<div class="latest-product__item__pic">
												<img src="<c:url value='${item.imgUrl}'/>" alt="">
											</div>
											<div class="latest-product__item__text">
												<h6>${item.product}</h6>
												<span>${formatter.format(item.cost)}đ</span>
											</div>
										</a> 
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-9 col-md-7">
<div class="filter__item">
						<div class="row">
							<div class="col-lg-4 col-md-5">

								<c:if test="${product.totalPages-1 >= 0 }">

									<div class="col-lg-4 col-md-5">

										<div class="filter__sort">

											<div class="dropdown">
												<button class="btn btn-primary dropdown-toggle"
													type="button" data-toggle="dropdown">
													Sắp xếp theo<span class="caret"></span>
												</button>
												<ul class="dropdown-menu">
													<li><a href="<c:url value='/shopGridByCategory?idCategory=${idCategory}&p=0&sort=idProduct'/>">Mới nhất</a></li>
													<li><a href="<c:url value='/shopGridByCategory?idCategory=${idCategory}&p=0&sort=Product'/>">Tên sản phẩm</a></li>
													<li><a href="<c:url value='/shopGridByCategory?idCategory=${idCategory}&p=0&sort=Cost'/>">Giá</a></li>
													<li><a href="<c:url value='/shopGridByCategory?idCategory=${idCategory}&p=0&sort=soldQuantity'/>">Bán chạy</a></li>
												</ul>
											</div>
										</div>

										<div class="dropdown">
											<button class="btn btn-primary dropdown-toggle" type="button"
												data-toggle="dropdown">
												Tăng dần<span class="caret"></span>
											</button>
											<ul class="dropdown-menu">
												<li><a
													href="<c:url value='/shopGridByCategory?idCategory=${idCategory}&p=0&sort=${sorter}&updown=DESC'/>">Giảm
														dần</a></li>
												<li><a
													href="<c:url value='/shopGridByCategory?idCategory=${idCategory}&p=0&sort=${sorter}&updown=ASC'/>">Tăng
														dần</a></li>


											</ul>

										</div>
									</div>
								</c:if>
							</div>
							<div class="col-lg-4 col-md-4">
								<div class="filter__found">
									<h6>
										<p style="text-align: center">${cateName.category} có ${size} sản phẩm <c:if test="${keyword != null }"> liên quan từ khóa <b>${keyword } </b></c:if></p>
									</h6>
								</div>
							</div>
							<div class="col-lg-4 col-md-3"></div>
						</div>
					</div>
					<div class="row">
						<c:forEach items="${product.content}" var="item">

							<div class="col-lg-4 col-md-10 col-sm-6">
								<div class="product__item">
									<div class="product__item__pic set-bg"
										data-setbg="<c:url value='${item.imgUrl}'/>">
										<ul class="product__item__pic__hover">
									<c:if test = "${item.quantity > 0}">
									<li><a href="addProduct?idProduct= ${item.idProduct}&quantity=1"><i class="fa fa-shopping-cart"></i></a></li>
									</c:if>

										</ul>
									</div>
									<div class="product__item__text">
										<h6>
											<a
												href="<c:url value='product-detail?idProduct=${item.idProduct}&idCategory=${item.category.idCategory}'/>"><p>${item.product}</p> (${item.weight} ${item.unit}) </a>
										</h6>
										<c:if test = "${item.quantity > 0}">
										<h5>${formatter.format(item.cost)} đ</h5>
									</c:if>
									<c:if test = "${item.quantity <= 0}">
									<h5>Hết hàng</h5>
									</c:if>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>
					<nav aria-label="Page navigation example">
											<ul class="pagination">
												<li class="page-item" ><a class="page-link" href="<c:url value='/shop-grid?p=${0}&sort=${sorter}&updown=${updown}'/>">|< </a></li>
											<c:if test="${p > 0 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/shop-grid?p=${p-1}&sort=${sorter}&updown=${updown}'/>"> << </a></li>
												</c:if>
												<li class="page-item active" ><a class="page-link" href="<c:url value='/shop-grid?p=${p}&sort=${sorter}&updown=${updown}'/>">${p+1}</a></li>
												<c:if test="${p < product.totalPages -1 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/shop-grid?p=${p+1}&sort=${sorter}&updown=${updown}'/>">${p+2}</a></li>
												<c:if test="${p < product.totalPages -2 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/shop-grid?p=${p+2}&sort=${sorter}&updown=${updown}'/>">${p+3}</a></li>
												</c:if>
												</c:if>
												<c:if test="${p < product.totalPages -1 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/shop-grid?p=${p+1}&sort=${sorter}&updown=${updown}'/>"> >> </a></li>
												</c:if>
												<li class="page-item"><a class="page-link" href="<c:url value='/shop-grid?p=${product.totalPages-1}&sort=${sorter}&updown=${updown}'/>"> >| </a></li>
											</ul>
										</nav>


				</div>
			</div>
		</div>
	</section>
	<!-- Product Section End -->

	<!-- Footer Section Begin -->


	</footer>
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