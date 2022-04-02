<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title><dec:title default="Trang Master"/></title> <!-- Lấy title cho các trang con nếu trang con chưa định nghĩa -->
<!-- Google Font -->
<link
	href="<c:url value='https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap'/>" 
	rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />

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
	<!-- Downdrop -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="icon" type="image/png" sizes="96x96"
	href="<c:url value='/template/admin/assets/img/favicon.png'/>">
</head>

<body>

	<!-- Navigation -->
	<%@ include file="/common/web/header.jsp"%>
	<dec:body />
	<!-- Page Content -->


	<!-- Footer -->
	<%@ include file="/common/web/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
        		<script>//<![CDATA[
$('input.input-qty').each(function() {
  var $this = $(this),
    qty = $this.parent().find('.is-form'),
    min = Number($this.attr('min')),
    max = Number($this.attr('max'))
  if (min == 0) {
    var d = 0
  } else d = min
  $(qty).on('click', function() {
    if ($(this).hasClass('minus')) {
      if (d > min) d += -1
    } else if ($(this).hasClass('plus')) {
      var x = Number($this.val()) + 1
      if (x <= max) d += 1
    }
    $this.attr('value', d).val(d)
  })
})
//]]></script>
	<script src="<c:url value='template/web/js/jquery-3.3.1.min.js'/>"></script>
	<script src="<c:url value='template/web/js/bootstrap.min.js'/>"></script>

	<script
		src="<c:url value='template/web/js/jquery.nice-select.min.js'/>"></script>

	<script src="<c:url value='template/web/js/jquery-ui.min.js'/>"></script>

	<script src="<c:url value='template/web/js/jquery.slicknav.js'/>"></script>

	<script src="<c:url value='template/web/js/mixitup.min.js'/>"></script>

	<script src="<c:url value='template/web/js/owl.carousel.min.js'/>"></script>

	<script src="<c:url value='template/web/js/main.js'/>"></script>
<!-- Downdrop -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>

</html>
