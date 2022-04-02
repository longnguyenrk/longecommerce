<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><dec:title default="Đăng nhập" /></title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="<c:url value='/template/login/style.css' />" rel="stylesheet" type="text/css" media="all"/>
	
	<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet"
	href="<c:url value='/template/web/css/bootstrap.min.css'/>"
	type="text/css">

<link rel="stylesheet"
	href="<c:url value='/template/web/css/font-awesome.min.css'/>"
	type="text/css">

<link rel="stylesheet"
	href="<c:url value='/template/web/css/elegant-icons.css'/>"
	type="text/css">

<link rel="stylesheet"
	href="<c:url value='/template/web/css/nice-select.css'/>"
	type="text/css">

<link rel="stylesheet"
	href="<c:url value='/template/web/css/jquery-ui.min.css'/>"
	type="text/css">

<link rel="stylesheet"
	href="<c:url value='/template/web/css/owl.carousel.min.css'/>"
	type="text/css">

<link rel="stylesheet"
	href="<c:url value='/template/web/css/slicknav.min.css'/>"
	type="text/css">

<link rel="stylesheet"
	href="<c:url value='/template/web/css/style.css'/>" type="text/css">
	
</head>
<body id="LoginForm">
    <dec:body/>
    <%@ include file="/common/web/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->

	<script src="<c:url value='template/web/js/jquery-3.3.1.min.js'/>"></script>
	<script src="<c:url value='template/web/js/bootstrap.min.js'/>"></script>

	<script src="<c:url value='template/web/js/jquery.nice-select.min.js'/>"></script>

	<script src="<c:url value='template/web/js/jquery-ui.min.js'/>"></script>

	<script src="<c:url value='template/web/js/jquery.slicknav.js'/>"></script>

	<script src="<c:url value='template/web/js/mixitup.min.js'/>"></script>

	<script src="<c:url value='template/web/js/owl.carousel.min.js'/>"></script>

	<script src="<c:url value='template/web/js/main.js'/>"></script>
</body>
</html>