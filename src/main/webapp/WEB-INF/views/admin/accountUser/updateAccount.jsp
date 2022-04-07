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
<title>Cập nhật tài khoản</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- VENDOR CSS -->

</head>
<body>
	<div id="wrapper" style="max-width: 1250px; margin: auto;">
		<!-- MAIN -->
				
		<!-- MAIN CONTENT -->
		<div class="main">
			<div class="main-content">
				<div class="container-fluid" style="line-height: 46px;">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading"
							style="display: flex; justify-content: space-between;">
							<h3 class="panel-title">Thông tin tài khoản</h3>
							<a class="btn btn-warning" href="list-product"
								style="background-color: #D9534F; padding: 2px 10px; text-decoration: none; border: none; margin-right: 10px; height: 25px;">Quay lại</a>
						</div>
						<form:form action="doUpdateAccount" method="post"
							enctype="multipart/form-data" modelAttribute="account">
							<div class="row"
								style="display: flex; justify-content: space-between;">
								<table style="margin: auto; margin-left: 60px;" class="col-md-6">
									
									<tr>
										<th>ID :</th>
										<td>${account.id}
											<form:hidden path="id"/>
											</td>
									</tr>
									<tr>
											<!-- <th>Kích hoạt:</th>
											<td><select name="status">
    											<option value=1>Hoạt động</option>
    											<option value=0>Tạm khóa</option>
												</select></td> -->
										</tr>
									<tr>
										<th>Tên tài khoản :</th>
										<td><input type="text" class="form-control"
											required="required" style="height: 30px;"
											placeholder="Nhập tên sản phẩm..." name="userName"
											value="${account.userName}" />
											<input type="hidden" class="form-control"
											name="status" 
											value="${account.status}" />
											</td>
									</tr>
									<tr>
											<th>Họ và tên:</th>
											<td><input type="text" class="form-control"
											required="required" style="height: 30px;"
											placeholder="Nhập mô tả ngắn sản phẩm..." name="fullName"
											value="${account.fullName}" /></td>
										</tr>
									<tr>
										<th>Email liên hệ</th>
										<td><input type="email" class="form-control"
											required="required" style="height: 30px;"
											placeholder="Nhập mô tả ngắn sản phẩm..." name="email"
											value="${account.email}" value="${account.email}"/></td>
									</tr>
									
								</table>
								<table
									style="margin: auto; margin-left: 50px; margin-right: -40px;"
									class="col-md-6">
									<tr>
										<th>Số điện thoại:</th>
										<td><input type="text" class="form-control" 
											style="height: 30px; width: 230px;"
											placeholder="${account.phone}" name="phone" value="${account.phone}"/>
											</td>
									</tr>
									<tr>
										<th>Địa chỉ:</th>
										<td><input type="text" class="form-control" 
											style="height: 50px; width: 230px;"
											placeholder="${account.address}" name="address" value="${account.address}" />
											</td>
									</tr>

									<tr>
										<th></th>
										<td>
											<button type="submit" class="btn btn-primary"
												style="font-weight: bold;">Cập nhật</button>
										</td>
									</tr>
									<tr>
										<th></th>
										<td></td>
									</tr>
								</table>
							</div>
						</form:form>
					</div>

				</div>
				<div id="headline-chart" class="ct-chart"></div>
			</div>

			<!-- END OVERVIEW -->
		</div>
		<!-- END MAIN CONTENT -->
	</div>
	<script>
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        
        reader.onload = function (e) {
            $('#blah').attr('src', e.target.result);
        }
        
        reader.readAsDataURL(input.files[0]);
    }
}

$("#imgInp").change(function(){
    readURL(this);
});
</script>
</body>

</html>
</html>