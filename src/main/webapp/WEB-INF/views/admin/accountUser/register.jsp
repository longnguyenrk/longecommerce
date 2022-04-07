<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tạo tài khoản</title>
</head>
<body>

	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
									
		
		<div class="login-form" style="position: absolute; top: 166px; left: 379px;">
			<div class="main-div">
			<h4 class="panel-title">Tạo tài khoản</h4>

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

					<button type="submit" class="btn btn-primary">Đăng ký</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

