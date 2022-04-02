<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.vietshop.util.SecurityUtils" %>


<body>
	<div th:fragment="header">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand" style="background-color: #f8f8f8;">
				<img  src="<c:url value='/template/admin/assets/img/logoV.png'/>" alt="Klorofil Logo"
					class="img-responsive logo">
			</div>
			<div class="container-fluid">
				<div id="navbar-menu">
<!-- 					<form class="navbar-form navbar-left">
						<div class="input-group">
							<input type="text" value="" class="form-control"
								placeholder="Search dashboard..."> <span
								class="input-group-btn"><button type="button"
									class="btn btn-primary">Go</button></span>
						</div>
					</form> -->
					<ul class="nav navbar-nav navbar-right">
						<li><a href="trang-chu"> <i class="fa fa-home"
								style="font-size: 18px;"></i><span> Trang chủ</span>
						</a></li>
						<li><a href="#">  <span>Xin chào <%=SecurityUtils.getPrincipal().getFullName()%></span>
						</a></li>
						<li><a href="<c:url value='/thoat'/>"> <i class="material-icons"
								style="color: red;">&#xe8ac;</i><span>Đăng xuất</span>
						</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<!-- END NAVBAR -->
</body>
