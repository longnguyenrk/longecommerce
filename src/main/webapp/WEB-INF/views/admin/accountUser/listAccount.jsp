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
<title>Danh sách tài khoản</title>


</head>
<body>
	<div class="row">
		<div class="col-lg-12 col-md-12">
		<form action="list-account" method="get" modelAttribute="account">
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
													<h3 class="panel-title">DANH SÁCH TÀI KHOẢN NGƯỜI DÙNG</h3>
													<div class="panel-heading">
													
													<div class="dropdown"  style="display: inline;align-items: left">
														<button class="btn btn-primary dropdown-toggle"
															type="button" data-toggle="dropdown">
															Sắp xếp theo<span class="caret"></span>
														</button>
														<ul class="dropdown-menu">
															<li><a
																href="<c:url value='/admin/list-account?&p=0&sort=userName'/>">Theo tài khoản</a></li>

																<li><a
																	href="<c:url value='/admin/list-account?&p=0&sort=fullName'/>">Theo tên</a></li>
																	<li><a
																href="<c:url value='/admin/list-account?p=0&sort=email'/>">Theo
																	email</a></li>
														</ul>
													</div>
													<div class="dropdown" style="display: inline;align-items: left">
														<button class="btn btn-primary dropdown-toggle"
															type="button" data-toggle="dropdown">
															Tăng dần<span class="caret"></span>
														</button>
														<ul class="dropdown-menu">
															<li><a href="<c:url value='/admin/list-account?&p=0&sort=${sorter}&updown=DESC'/>">Giảm dần</a></li>
															<li><a href="<c:url value='/admin/list-account?&p=0&sort=${sorter}&updown=ASC'/>">Tăng dần</a></li>	
														</ul>
													</div>

 												 <div class="search-container">
   														 <form>
    														  <input type="text" placeholder="Tìm kiếm..." name="keyword">
   															   <button type="submit" class="btn btn-default">Tìm kiếm</button>
   														 </form>
  													</div>
													

													</div>

												<div class="col-lg-4 col-md-4">
								<div class="filter__found">
									
										<p>Tất cả có ${size} tài khoản <c:if test="${keyword != null }"> liên quan từ khóa <b>${keyword } </b></c:if></p>
								
								</div>
							</div>
												<div class="panel-body no-padding">
													<table class="table" style="margin: auto;">
<%-- 												<c:if test="${products.totalPages-1 >= 0 }">
 --%>														<thead>
															<tr>
																
																<th>Tài khoản</th>
																<th>Họ và tên</th>
																<th>Ngày sinh</th>
																<th>Email</th>
																<th>Số điện thoại</th>
																<th>Địa chỉ</th>
																<th>Loại tài khoản</th>
																<th>Trạng thái hoạt động</th>
																<th>Cập nhật</th>
<!-- 																<th>Xóa </th>
 -->															</tr>
														</thead>
<%-- 														</c:if>
 --%>														<tbody>
															<c:forEach items="${accounts.content}" varStatus="loop"
																var="item">
																<tr>

																	<td style="vertical-align: middle;">${item.userName}</td>
																	<td style="vertical-align: middle;">${item.fullName}</td>
																	<td style="vertical-align: middle;">${item.dob}</td>
																	<td style="vertical-align: middle;">${item.email}</td>
																	<td style="vertical-align: middle;">${item.phone}</td>
																	<td style="vertical-align: middle;">${item.address}</td>
																	<td><c:if test="${item.role.idRole ==  1}">
																	<span class="label label-primary"
																			style="font-size: 15px;">Quản trị viên</span>
																	</c:if>
																	<c:if test="${item.role.idRole ==  2}">
																	<span class="label label-info"
																			style="font-size: 15px;">
																	Khách hàng</span>
																	</c:if>
																	
																	</td>
																	<td><c:if test="${item.status == 1}">
																<a href="<c:url value='/admin/deactiveAccount?idAccount=${item.id }&p=${p}'/>"><span class="label label-success" style="font-size: 15px;">Hoạt động</span></a>
															</c:if>
															<c:if test="${item.status == 0 }">
																<a href="<c:url value='/admin/activeAccount?idAccount=${item.id }&p=${p}'/>"><span class="label label-danger" style="font-size: 15px;">Tạm khóa</span></a>
															</c:if>
															</td>
																	<td style="vertical-align: middle;"><a
																		href="<c:url value = '/admin/updateAccount?id=${item.id}'/>">
																			<span class="label label-warning"
																			style="font-size: 15px;">Cập nhật</span>
																	<%-- </td>
																																		<td style="vertical-align: middle;"><a
																		href="<c:url value='/admin/deleteAccount?id=${item.id}'/>">
																			<span class="label label-warning"
																			style="font-size: 15px;">Xóa</span>
																	</a></td> --%>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
											<nav aria-label="Page navigation example">
											<ul class="pagination">
												<c:if test="${keyword == null }">
												<li class="page-item" ><a class="page-link" href="<c:url value='/admin/list-account?p=${0}&sort=${sorter}&updown=${updown}'/>">|< </a></li>
											<c:if test="${p > 0 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/admin/list-account?p=${p-1}&sort=${sorter}&updown=${updown}'/>"> << </a></li>
												</c:if>
												<li class="page-item active" ><a class="page-link" href="<c:url value='/admin/list-account?p=${p}&sort=${sorter}&updown=${updown}'/>">${p+1}</a></li>
												<c:if test="${p < accounts.totalPages -1 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/admin/list-account?p=${p+1}&sort=${sorter}&updown=${updown}'/>">${p+2}</a></li>
												<c:if test="${p < accounts.totalPages -2 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/admin/list-account?p=${p+2}&sort=${sorter}&updown=${updown}'/>">${p+3}</a></li>
												</c:if>
												</c:if>
												<c:if test="${p < accounts.totalPages -1 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/admin/list-account?p=${p+1}&sort=${sorter}&updown=${updown}'/>"> >> </a></li>
												</c:if>
												<li class="page-item"><a class="page-link" href="<c:url value='/admin/list-account?p=${accounts.totalPages-1}&sort=${sorter}&updown=${updown}'/>"> >| </a></li>
												</c:if>
																								
												<c:if test="${keyword != null }">
												<c:if test="${accounts.totalPages-1 > 0 }">
												<li class="page-item" ><a class="page-link" href="<c:url value='/admin/list-account?p=${0}&sort=${sorter}&updown=${updown}&keyword=${keyword}'/>">|< </a></li>
											<c:if test="${p > 0 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/admin/list-account?p=${p-1}&sort=${sorter}&updown=${updown}&keyword=${keyword}'/>"> << </a></li>
												</c:if>
												<li class="page-item active" ><a class="page-link" href="<c:url value='/admin/list-account?p=${p}&sort=${sorter}&updown=${updown}&keyword=${keyword}'/>">${p+1}</a></li>
												<c:if test="${p < accounts.totalPages -1 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/admin/list-account?p=${p+1}&sort=${sorter}&updown=${updown}&keyword=${keyword}'/>">${p+2}</a></li>
												<c:if test="${p < accounts.totalPages -2 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/admin/list-account?p=${p+2}&sort=${sorter}&updown=${updown}&keyword=${keyword}'/>">${p+3}</a></li>
												</c:if>
												</c:if>
												<c:if test="${p < accounts.totalPages -1 }">
												<li class="page-item"><a class="page-link" href="<c:url value='/admin/list-account?p=${p+1}&sort=${sorter}&updown=${updown}&keyword=${keyword}'/>"> >> </a></li>
												</c:if>
												<li class="page-item"><a class="page-link" href="<c:url value='/admin/list-account?p=${accounts.totalPages-1}&sort=${sorter}&updown=${updown}&keyword=${keyword}'/>"> >| </a></li>
												</c:if>
												
												</c:if>
											</ul>
										</nav>
											
										</div>
									</div>
							</div>
							<div id="headline-chart" class="ct-chart"></div>
							</form>
			</div>
					
<div class="col-lg-4 col-md-4">
					<h4 class="panel-title">TẠO TÀI KHOẢN MỚI</h4>
					<br>
		
					<form action="doregisteramdin" modelAttribute="account"
					method="post">
					<div class="form-group">
						<div class="form-label-group">
					<select class="form-select" name="idRole">
						<option value=1>Quản trị viên</option>
						<option value=2>Khách hàng</option>
					</select>
					</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<input type="fullName" id="fullName" name="fullName"
								class="form-control" placeholder="Họ và tên" required="required">
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">

							<input type="date" id="dob" name="dob" class="form-control">
						</div>
					</div>
					<p style="color: red;">${messageEmail}</p>
					<div class="form-group">
						<div class="form-label-group">
							<input type="email" id="email" name="email" class="form-control"
								placeholder="Email liên hệ" required="required">
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<input type="phone" id="phone" name="phone" class="form-control"
								placeholder="Số điện thoại liên hệ" required="required">
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<input type="text" id="address" name="address"
								class="form-control" placeholder="Địa chỉ giao hàng"
								required="required">
						</div>
					</div>
					<p style="color: red;">${messageUser}</p>

					<div class="form-group">
						<input type="text" class="form-control" id="userName"
							name="userName" placeholder="Tên đăng nhập mới">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="newpass"
							name="newpass" placeholder="Mật khẩu mới">
					</div>

					<button type="submit" class="btn btn-primary">Tạo tài khoản</button>
				</form>
	</div>			
	</div>
	
	<!-- END MAIN -->
	<div class="clearfix"></div>
	
<!-- 	<footer>
		<div class="container-fluid">
			<p class="copyright">
				&copy; 2022 <a href="https://www.themeineed.com" target="_blank">Theme
					I Need</a>. All Rights Reserved.
			</p>
		</div>
	</footer -->
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