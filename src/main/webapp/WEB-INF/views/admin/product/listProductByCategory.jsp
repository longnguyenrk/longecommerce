<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Danh sách sản phẩm</title>
</head>
<body>

	<!-- WRAPPER -->
	<div id="wrapper">



		<!-- MAIN -->
		<!-- MAIN CONTENT -->

		<form action="list-product-by-category" method="get"
			modelAttribute="product">
			<div class="main">
				<div class="main-content">
					<div class="container-fluid">
						<!-- OVERVIEW -->
						<div class="panel panel-headline">
							<div class="panel-body">
								<form action="listProduct" method="get">
									<div class="row">
										<div class="col-md-12">
											<div class="panel">
												<h3 class="panel-title">DANH SÁCH SẢN PHẨM</h3>
												<div class="panel-heading">
													<div class="dropdown"
														style="display: inline; align-items: left">
														<button class="btn btn-primary dropdown-toggle"
															type="button" data-toggle="dropdown">
															Chọn danh mục
															<selected>
															<span class="caret"></span>
														</button>
														<ul class="dropdown-menu">
															<li><a
																href="<c:url value='/admin/list-product?&p=0'/>">Tất
																	cả danh mục</a></li>
															<c:forEach items="${category}" var="category">
																<li><a
																	href="<c:url value='/admin/list-product-by-category?idCategory=${category.idCategory}&p=0'/>">${category.category}</a></li>
															</c:forEach>
														</ul>
													</div>
													<div class="dropdown"
														style="display: inline; align-items: left">
														<button class="btn btn-primary dropdown-toggle"
															type="button" data-toggle="dropdown">
															Sắp xếp theo<span class="caret"></span>
														</button>
														<ul class="dropdown-menu">
															<li><a
																href="<c:url value='/admin/list-product?&p=0&sort=idProduct'/>">Theo
																	ID</a></li>

															<li><a
																href="<c:url value='/admin/list-product?&p=0&sort=Product'/>">Theo
																	tên</a></li>
															<li><a
																href="<c:url value='/admin/list-product?p=0&sort=Cost'/>">Theo
																	giá</a></li>
																	<li><a
																href="<c:url value='/admin/list-product?p=0&sort=soldQuantity'/>">Bán chạy</a></li>
																<li><a
																href="<c:url value='/admin/list-product?p=0&sort=status'/>">Tình trạng hiển thị</a></li>
														</ul>
													</div>
													<div class="dropdown"
														style="display: inline; align-items: left">
														<button class="btn btn-primary dropdown-toggle"
															type="button" data-toggle="dropdown">
															Tăng dần<span class="caret"></span>
														</button>
														<ul class="dropdown-menu">
															<li><a
																href="<c:url value='/admin/list-product?&p=0&sort=${sorter}&updown=DESC'/>">Giảm
																	dần</a></li>
															<li><a
																href="<c:url value='/admin/list-product?&p=0&sort=${sorter}&updown=ASC'/>">Tăng
																	dần</a></li>
														</ul>
													</div>

													<div class="right">
														<a href="list-category"><span
															class="label label-danger" style="font-size: 15px;">Danh
																mục sản phẩm</span></a> <a href="addProduct"><span
															class="label label-success" style="font-size: 15px;">Thêm
																sản phẩm mới</span></a>
													</div>
												</div>

												<div class="panel-body no-padding">
													<table class="table" style="margin: auto;">
														<thead>
															<tr>
																<th>ID</th>
																<th>Sản phẩm</th>
																<th>Giá</th>
																<th>Số lượng kho</th>
																<th>Số lượng đã bán</th>
																<th>Khối lượng chuẩn</th>
																<th style="width: 10%;">Hình ảnh</th>
																<th style="width: 22%;">Mô tả</th>
																<th style="width: 10%;">Cập nhật</th>
																<th>Ẩn sản phầm</th>
															</tr>
														</thead>
														<tbody>
															<c:if test="${size == 0}">
																<td style="vertical-align: middle;">Danh mục không
																	có sản phẩm</td>
															</c:if>
															<c:if test="${size > 0}">
																<p>
																	<span class="label label-success"
																		style="font-size: 15px;">${cateName.category}</span>
																	có ${size} sản phẩm
																</p>
															</c:if>
															<c:forEach items="${products.content}" varStatus="loop"
																var="item">
																<tr>

																	<td style="vertical-align: middle;">${item.idProduct}</td>
																	<td style="vertical-align: middle;">${item.product}</td>
																	<td style="vertical-align: middle;">${formatter.format(item.cost)} đ
																		</td>
																<td style="vertical-align: middle;">${item.quantity}</td>
																<td style="vertical-align: middle;">${item.soldQuantity}</td>
																	<td style="vertical-align: middle;">${item.weight}
																		${item.unit}</td>
																	<td style="vertical-align: middle;"><img
																		style="width: 70%;"
																		src="<c:url value='${item.imgUrl}'/>"></td>
																	<td style="vertical-align: middle;">${item.descriptions}</td>
																	<td style="vertical-align: middle;"><a
																		href="<c:url value = '/admin/updateProduct?idProduct=${item.idProduct}'/>">
																			<span class="label label-warning"
																			style="font-size: 15px;">Cập nhật</span>
																	</a>
																	<c:if test="${item.status eq  'display'}">
																<td style="vertical-align: middle;"><a
																	href="<c:url value='/admin/doHideProductByCate?idProduct=${item.idProduct}&idCategory=${item.category.idCategory }&p=${p }'/>">
																		<span class="label label-info" style="font-size: 15px;">Hiển thị</span>
																</a>
																</td>
																</c:if>
																
																<c:if test="${item.status eq  'hide'}">
																<td style="vertical-align: middle;"><a
																	href="<c:url value='/admin/doDisplayProductByCate?idProduct=${item.idProduct}&idCategory=${item.category.idCategory }&p=${p }'/>">
																		<span class="label label-default" style="font-size: 15px;">Ẩn</span>
																</a>
																</td>
																</c:if>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
											<nav aria-label="Page navigation example">
												<ul class="pagination">
													<li class="page-item"><a class="page-link"
														href="<c:url value='/admin/list-product-by-category?idCategory=${idCategory}&p=${0}&sort=${sorter}&updown=${updown}'/>">|<
													</a></li>
													<c:if test="${p > 0 }">
														<li class="page-item"><a class="page-link"
															href="<c:url value='/admin/list-product-by-category?idCategory=${idCategory}&p=${p-1}&sort=${sorter}&updown=${updown}'/>">
																<< </a></li>
													</c:if>
													<li class="page-item active"><a class="page-link"
														href="<c:url value='/admin/list-product-by-category?idCategory=${idCategory}&p=${p}&sort=${sorter}&updown=${updown}'/>">${p+1}</a></li>
													<c:if test="${p < products.totalPages -1 }">
														<li class="page-item"><a class="page-link"
															href="<c:url value='/admin/list-product-by-category?idCategory=${idCategory}&p=${p+1}&sort=${sorter}&updown=${updown}'/>">${p+2}</a></li>
														<c:if test="${p < products.totalPages -2 }">
															<li class="page-item"><a class="page-link"
																href="<c:url value='/admin/list-product-by-category?idCategory=${idCategory}&p=${p+2}&sort=${sorter}&updown=${updown}'/>">${p+3}</a></li>
														</c:if>
													</c:if>
													<c:if test="${p < products.totalPages -1 }">
														<li class="page-item"><a class="page-link"
															href="<c:url value='/admin/list-product-by-category?idCategory=${idCategory}&p=${p+1}&sort=${sorter}&updown=${updown}'/>">
																>> </a></li>
													</c:if>
													<li class="page-item"><a class="page-link"
														href="<c:url value='/admin/list-product-by-category?idCategory=${idCategory}&p=${products.totalPages-1}&sort=${sorter}&updown=${updown}'/>">
															>| </a></li>
												</ul>
											</nav>



										</div>
									</div>
							</div>
							<div id="headline-chart" class="ct-chart"></div>
		</form>
	</div>
	</div>
	</div>
	</div>
	</div>
	</form>
	<!-- END MAIN -->
	<div class="clearfix"></div>
	<footer>
		<div class="container-fluid">
			<p class="copyright">
				&copy; 2017 <a href="https://www.themeineed.com" target="_blank">Theme
					I Need</a>. All Rights Reserved.
			</p>
		</div>
	</footer>
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script>
            let userSelection = document.getElementsByClassName('checkbox');
            let checkAll = document.getElementById('checkAll')


            checkAll.addEventListener('click', () => {
                if (checkAll.checked == true) {
                    for (let i = 1; i <= userSelection.length; i++) {
                        document.getElementById(i).checked = true
                    }
                } else {
                    for (let i = 1; i <= userSelection.length; i++) {
                        document.getElementById(i).checked = false
                    }
                }

            })
            
            $(document).ready(function(){

   $("#countryList").change(function(){

       var selectedCountry = $(this).children("option:selected").val();

       console.log("You have selected the country - " + selectedCountry);

   });

});

            $(function(){

                $(".dropdown-menu").on('click', 'li a', function(){
                  $(".btn:first-child").text($(this).text());
                  $(".btn:first-child").val($(this).text());
               });

            });

            $(function(){

                $(".dropdown-menu li a").click(function(){

                  $(".btn:first-child").text($(this).text());
                  $(".btn:first-child").val($(this).text());

               });

            });

            $(".dropdown-menu li a").click(function(){
            	  $(this).parents(".dropdown").find('.btn').html($(this).text() + ' <span class="caret"></span>');
            	  $(this).parents(".dropdown").find('.btn').val($(this).data('value'));
            	});

            $(".dropdown-menu li a").click(function(){
            	  $(this).parents(".dropdown").find('.btn').html($(this).text() + ' <span class="caret"></span>');
            	  $(this).parents(".dropdown").find('.btn').val($(this).data('value'));
            	});

            $(".dropdown-menu").on('click', 'li a', function(){
                $(this).parent().parent().siblings(".btn:first-child").html($(this).text()+' <span class="caret"></span>');
                $(this).parent().parent().siblings(".btn:first-child").val($(this).text());
            });
   </script>
</body>
</body>
</html>