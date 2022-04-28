<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="header.jsp"/>
</head>
<body id="body-login">
	<div>
		<form id="ajax" action=${pageContext.request.contextPath}></form>
	</div>
	
	<div id="body-flex-login">
		<div id="container-login">
			<div id="container-login-left">
				<div id="header-top-left" class="header-login">
					<span id="text-logo">Welcome</span><br/>
					<span id="hint-text-logo">Hãy tạo nên phong cách của bạn cùng Minishop ! </span>
				</div>
				
				<div id="header-bottom-left">
					<p><img alt="icon_oval" src='<c:url value="/resources/Image/icon_oval.png" />' /><span>Luôn cập nhật xu hướng thời trang mới nhất </span></p>
					<p><img alt="icon_oval" src='<c:url value="/resources/Image/icon_oval.png" />' /><span>Giảm hơn 50% tất cả các mặt hàng giành cho khách VIP </span></p>
					<p><img alt="icon_oval" src='<c:url value="/resources/Image/icon_oval.png" />' /><span>Tận tình tư vấn để tạo nên phong cách của bạn</span></p>
				</div>
			</div>
			
			<div id="container-login-right">
				<div id="header-top-right" class="header-login">
					<span class="actived" id="dangnhap">Đăng nhập</span> / <span id="dangky">Đăng ký</span>
				</div>
				
				<div id="container-center-login-right">
						<div class="container-login-form"  id="container-center-login-right">
							
							<input id="email" name="email" class="material-textinput input-icon-email" placeholder="Email" type="text" /><br/>
							<input id="matkhau" name="matkhau" class="material-textinput input-icon-password" placeholder="Mật khẩu " type="text" /><br/>
							<input id="btnDangNhap1" class="material-primary-button" type="submit"  value="ĐĂNG NHẬP" / ><br/>
							
							
							</form>
						</div>
						
					<div class="container-signup-form" id="container-center-login-right">
							<form action="" method="post">
								<input id="email" name="email" class="material-textinput input-icon-email" placeholder="Email" type="text" /><br/><p></p>
								<input id="matkhau" name="matkhau" class="material-textinput input-icon-password" placeholder="Mật khẩu " type="password" /><br/><p></p>
								<input id="nhaplaimatkhau" name="nhaplaimatkhau" class="material-textinput input-icon-password" placeholder="Nhập lại mật khẩu " type="password" /><br/>
								<input id="btnDangNhap" class="material-primary-button" type="submit" value="ĐĂNG KÝ" /><br/>
							</form>
							
						</div>
						
						
						<span id="ketqua" ></span>
						<span>${kiemtradangnhap}</span>
				</div>
				
				<div id="container-social-login">
					<img alt="icon_oval" src='<c:url value="/resources/Image/icon_facebook.png" />' />
					<img alt="icon_oval" src='<c:url value="/resources/Image/icon_google.png" />' />
				</div>
				
		
				
			</div>
			
		</div>
	</div>
	
	
</body>

<jsp:include page="footer.jsp"/>
</html>