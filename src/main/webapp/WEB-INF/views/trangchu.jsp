<%@page import="java.util.List"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div id="header" class="container-fluid">
		<nav class="navbar navbar-default none_nav">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="/minishop/"><img src='<c:url value="/resources/Image/icon_yame_shop.png"/>'></a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav navbar-center">
		        <li class="active"><a href="/minishop/">TRANG CHỦ</a></li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Sản phẩm <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		          	<c:forEach var="value" items="${danhmuc }"> 
						<li><a href='<c:url value="/sanpham/${value.getMadanhmuc()}/${value.getTendanhmuc() }"/>'>${value.getTendanhmuc() }</a></li>
						<li role="separator" class="divider"></li>
					</c:forEach>
		            
		          </ul>
		        </li>
		        <li><a href="#">DỊCH VỤ</a></li>
		        <li><a href="#">LIÊN HỆ ${chucaidau }</a></li>
		        
		      </ul>
		      
		      <ul class="nav navbar-nav navbar-right">
		      	<c:choose>
		      		<c:when test="${chucaidau != null }">
		      			 <li><a class="circle-avartar" href="dangnhap/"><span>${chucaidau }</span></a></li>
		      		</c:when>
		      		
		      		<c:otherwise>
		      			 <li><a href="dangnhap/">ĐĂNG NHẬP</a></li>
		      		</c:otherwise>
		      	</c:choose>
		       
		        <li id="giohang"><a href="/minishop/giohang/" ><img src='<c:url value="/resources/Image/ic_shopping_cart_white_24dp_1x.png"/>'></a></li>
		        
		       
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
		
		<div class="event_header container wow rubberBand">
			<span>Ngay 17/10 - 23/10/2017</span><br/>
			<span style="font-size: 50px">Mua 1 tang 1</span><br/>
			<button>XEM NGAY</button>
		</div>
	</div>
	
	<div id="info" class="container">
		<div class="row">
			<div class="col-12 col-sm-4 col-md-4 wow fadeInLeft" data-wow-duration="1s">
				<img class="icon" src='<c:url value="/resources/Image/icon_chatluong.png"/>'/><br/>
				<span style="font-size: 32px; font-weight: 500;">CHẤT LƯỢNG</span><br/>
				<span>Chúng tôi cam kết sẽ mang đến cho các bạn chất lượng sản phẩm tốt nhất</span>
			</div>
			
			<div class="col-12 col-sm-4 col-md-4 wow fadeInDown" data-wow-duration="1s" data-wow-delay="1s">
				<img class="icon" src='<c:url value="/resources/Image/icon_conheo.png"/>'/><br/>
				<span style="font-size: 32px; font-weight: 500;">TIẾT KIỆM CHI PHÍ</span><br/>
				<span>Cam kết giá rẻ nhất Việt Nam giúp các bạn tiết kiệm hơn 20%cho từng sản phẩm</span>
			</div>
			
			<div class="col-12 col-sm-4 col-md-4 wow fadeInUp" data-wow-duration="1s" data-wow-delay="2s">
				<img class="icon" src='<c:url value="/resources/Image/icon_giaohang.png"/>'/><br/>
				<span style="font-size: 32px; font-weight: 500;">GIAO HÀNG</span><br/>
				<span>Cam kết giao hàng tận nơi trong ngày. Để mang sản phẩm đếncho khách hàng nhanh nhất</span>
			</div>
		</div>
		
	</div>
	
	<div id="title-sanpham" class="container">
		<span>SẢN PHẨM HOT</span>
		<div class="row" style="margin-top:42px">
		
			<c:forEach var="sanpham" items="${listSanPham}">
				<div class="col-md-3 col-sm-6">
					 <a href="chitiet/${sanpham.getMasanpham()}">
						<div class="sanpham wow zoomIn">
							<img alt="hinh" src='<c:url value="/resources/Image/sanpham/${sanpham.getHinhsanpham() }"/>' /><br/>
							<span>${sanpham.getTensanpham()} </span><br/>
							<span class="gia">${sanpham.getGiatien() } VNĐ</span>
						</div>
					</a> 
					
				</div>
			</c:forEach> 
			
			
			
			<%-- 
			<div class="col-md-3 col-sm-6">
					
						<div class="sanpham wow zoomIn">
							<img alt="hinh" src='<c:url value="/resources/Image/sanpham.png"/>' /><br/>
							<span>ao so mi</span><br/>
							<span class="gia">1.500.000 VNĐ</span>
						</div>
					
					
				</div>
				<div class="col-md-3 col-sm-6">
					
						<div class="sanpham wow zoomIn">
							<img alt="hinh" src='<c:url value="/resources/Image/sanpham.png"/>' /><br/>
							<span>ao so mi</span><br/>
							<span class="gia">1.500.000 VNĐ</span>
						</div>
					
					
				</div>
				<div class="col-md-3 col-sm-6">
					
						<div class="sanpham wow zoomIn">
							<img alt="hinh" src='<c:url value="/resources/Image/sanpham.png"/>' /><br/>
							<span>ao so mi</span><br/>
							<span class="gia">1.500.000 VNĐ</span>
						</div>
					
					
				</div>
				<div class="col-md-3 col-sm-6">
					
						<div class="sanpham wow zoomIn">
							<img alt="hinh" src='<c:url value="/resources/Image/sanpham.png"/>' /><br/>
							<span>ao so mi</span><br/>
							<span class="gia">1.500.000 VNĐ</span>
						</div>
					
					
				</div>
				<div class="col-md-3 col-sm-6">
					
						<div class="sanpham wow zoomIn">
							<img alt="hinh" src='<c:url value="/resources/Image/sanpham.png"/>' /><br/>
							<span>ao so mi</span><br/>
							<span class="gia">1.500.000 VNĐ</span>
						</div>
					
					
				</div>
				<div class="col-md-3 col-sm-6">
					
						<div class="sanpham wow zoomIn">
							<img alt="hinh" src='<c:url value="/resources/Image/sanpham.png"/>' /><br/>
							<span>ao so mi</span><br/>
							<span class="gia">1.500.000 VNĐ</span>
						</div>
					
					
				</div>
				<div class="col-md-3 col-sm-6">
					
						<div class="sanpham wow zoomIn">
							<img alt="hinh" src='<c:url value="/resources/Image/sanpham.png"/>' /><br/>
							<span>ao so mi</span><br/>
							<span class="gia">1.500.000 VNĐ</span>
						</div>
					
					
				</div>
				<div class="col-md-3 col-sm-6">
					
						<div class="sanpham wow zoomIn">
							<img alt="hinh" src='<c:url value="/resources/Image/sanpham.png"/>' /><br/>
							<span>ao so mi</span><br/>
							<span class="gia">1.500.000 VNĐ</span>
						</div>
					
					
				</div>
				<div class="col-md-3 col-sm-6">
					
						<div class="sanpham wow zoomIn">
							<img alt="hinh" src='<c:url value="/resources/Image/sanpham.png"/>' /><br/>
							<span>ao so mi</span><br/>
							<span class="gia">1.500.000 VNĐ</span>
						</div>
					
					
				</div>
				<div class="col-md-3 col-sm-6">
					
						<div class="sanpham wow zoomIn">
							<img alt="hinh" src='<c:url value="/resources/Image/sanpham.png"/>' /><br/>
							<span>ao so mi</span><br/>
							<span class="gia">1.500.000 VNĐ</span>
						</div>
					
					
				</div>
				<div class="col-md-3 col-sm-6">
					
						<div class="sanpham wow zoomIn">
							<img alt="hinh" src='<c:url value="/resources/Image/sanpham.png"/>' /><br/>
							<span>ao so mi</span><br/>
							<span class="gia">1.500.000 VNĐ</span>
						</div>
					
					
				</div>
				<div class="col-md-3 col-sm-6">
					
						<div class="sanpham wow zoomIn">
							<img alt="hinh" src='<c:url value="/resources/Image/sanpham.png"/>' /><br/>
							<span>ao so mi</span><br/>
							<span class="gia">1.500.000 VNĐ</span>
						</div>
					
					
				</div>
				 --%>
			
			
			<!-- end san pham --> 
		</div>
		
	</div>
	
	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4 wow tada">
				<p><span class="title-footer">THÔNG TIN SHOP</span></p>
				<span>Yame là một thương hiệu thời trang đầy uy tín, luôn đảm bảo chất lượng sản phẩm tốt nhất cho khách hàng.</span>
			</div>
			
			<div class="col-sm-4 col-md-4 wow tada">
				<p><span class="title-footer">LIÊN HỆ</span></p>
				<span>43 Nguyễn trãi , phường 12, quận 5  TP. Hồ Chí Minh</span>
				<span>checongbinh@gmail.com</span>
				<span>0909489834</span>
			</div>
			
			<div class="col-sm-4 col-md-4 wow tada">
				<p><span class="title-footer">GÓP Ý</span></p>
				<form action="" method="post">
					<input name="tenNhanVien" class="material-textinput" style="margin-bottom: 8px" type="text" placeholder="Email"/>
					<textarea name="tuoi" style="margin-bottom: 8px" rows="4" cols="50" placeholder="Nội dung"></textarea>
					<button class="material-primary-button">ĐỒNG Ý</button>
				</form>
				
			</div>
		</div>
		
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>


</html>