<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
				<c:if test="${param.incorrectAccount != null}"> <!-- incorrectAccount từ security.xml -->
					<div class="alert alert-danger">	
							Tài khoản hoặc mật khẩu không đúng.
					</div>
				</c:if>
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">	
							Sử dụng tài khoản Quản trị viên để truy cập.
					</div>
				</c:if>
				<c:if test="${message != null}">
					<div class="alert alert-danger">	
							<h6>${message}</h6>
					</div>
				</c:if>
				<div >
				
				<form action="j_spring_security_check" id="formLogin" method="post" >
					<div class="form-group" >
						<input type="text" class="form-control" id="userName" name="j_username" placeholder="Tên đăng nhập">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="password" name="j_password" placeholder="Mật khẩu">
					</div>
					
					<button type="submit" class="btn btn-primary" >Đăng nhập</button>
					
				</form>
			</div>
				<div class="text-center">
          <a class="d-block medium mt-4" href="/vietshop/authen/register">Đăng ký</a>
          <a class="d-block medium" href="forgot-password.html">Forgot Password?</a>
        </div>
        
			</div>
		</div>
		
	</div>
</body>
</html>