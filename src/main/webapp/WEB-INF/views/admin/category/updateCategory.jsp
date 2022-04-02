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
<title>Cập nhật thông tin danh mục</title>
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
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading"
							style="display: flex; justify-content: space-between;">
							<h3 class="panel-title">CẬP NHẬT THÔNG TIN DANH MỤC</h3>
							<a class="btn btn-warning" href="list-category"
								style="background-color: #D9534F; padding: 2px 10px; text-decoration: none; border: none; margin-right: 10px; height: 25px;">Quay lại</a>
						</div>
						<form:form action="doUpdateCategory" method="post"
							enctype="multipart/form-data" modelAttribute="category">
							<div class="row"
								style="display: flex; justify-content: space-between;">
								<table style="border-collapse: separate; border-spacing: 15px 10px; margin: auto; margin-left: 60px;" class="col-md-6">

									<tr>
										<td><form:hidden path="idCategory" />
										</td>
									</tr>

									<th>Tên danh mục:</th>
									<td><input type="text" class="form-control"
										required="required" style="height: 30px;"
										placeholder="Nhập tên danh mục..." name="Category"
										value="${category.category}" /></td>
									</tr>
									<tr>
										<th>Mô tả:</th>
										<td><textarea required="required" class="form-control"
												placeholder="Nhập mô tả danh mục..." rows="4"
												name="descriptions" >${category.descriptions} </textarea></td>
									</tr>
									<tr>
										<th>Hình ảnh:</th>
										<td><form id="form1" runat="server">
												<input type='file' name="imageFile" id="imgInp" value="${category.imgUrl}" />
												 <img id="blah" value='${category.imgUrl}' name="imageFile"  style="width: 20%; margin-top: 20px;" />
												
											</form></td>
									</tr>

									<tr>
										<th></th>
										<td>
											<button type="submit" class="btn btn-primary capnhap"
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
</body>

</html>
</html>