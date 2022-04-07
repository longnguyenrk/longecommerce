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
<title>Danh mục loại sản phẩm</title>
</head>
<body>

	<form action="list-product-by-category" method="get" modelAttribute="product">
		<div class="main">
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-body">
							<form action="listProduct" method="get">
								<div class="row">
									<div class="col-md-10">
										<div class="panel">
											<div class="panel-heading">
												<h3 class="panel-title">DANH MỤC LOẠI SẢN PHẨM</h3>


												<div class="right">


													<a href="addCategory"><span class="label label-success"
														style="font-size: 15px;">Tạo mới loại sản phẩm</span></a>
												</div>
											</div>
											<div class="panel-body no-padding">
												<table class="table" style="margin: auto;">
													<thead>
														<tr>

															<th>ID</th>
															<th>Tên loại sản phẩm</th>
															<th>Hình ảnh</th>
															<th>Mô tả</th>
															<th>Cập nhật</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${categoryPage.content}" varStatus="loop"
															var="item">
															<tr>

																<td style="vertical-align: middle;">${item.idCategory}</td>
																<td style="vertical-align: middle;">${item.category}</td>
																<td style="vertical-align: middle;"><img style="width: 100px;height: 100px"
																	src="<c:url value='${item.imgUrl}'/>"></td>
																<td style="vertical-align: middle;">${item.descriptions}</td>
																<td style="vertical-align: middle;"><a
																	href="<c:url value = '/admin/updateCategory?idCategory=${item.idCategory}'/>">
																		<span class="label label-warning"
																		style="font-size: 15px;">Cập nhật</span>
																</a>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
										<nav aria-label="Page navigation example">
											<ul class="pagination">
											<li class="page-item" ><a class="page-link" href="<c:url value='/admin/list-category?p=${0}'/>">|< </a></li>
											<c:if test="${p > 0 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/admin/list-category?p=${p-1}'/>"> << </a></li>
												</c:if>
												<li class="page-item active" ><a class="page-link" href="<c:url value='/admin/list-category?p=${p}'/>">${p+1}</a></li>
												<c:if test="${p < category.totalPages -1 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/admin/list-category?p=${p+1}'/>">${p+2}</a></li>
												<c:if test="${p < category.totalPages -2 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/admin/list-category?p=${p+2}'/>">${p+3}</a></li>
												</c:if>
												</c:if>
												<c:if test="${p < category.totalPages -1 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/admin/list-category?p=${p+1}'/>"> >> </a></li>
												</c:if>
												<li class="page-item"><a class="page-link" href="<c:url value='/admin/list-category?p=${category.totalPages-1}'/>"> >| </a></li>
												
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
   </script>
</body>
</body>
</html>