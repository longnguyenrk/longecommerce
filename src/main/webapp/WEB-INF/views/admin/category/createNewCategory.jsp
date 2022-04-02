<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm danh mục mới</title>
</head>
<body>
	<div id="wrapper" style="max-width: 1250px; margin: auto;">
		<!-- WRAPPER -->

		<!-- MAIN -->
		<!-- MAIN CONTENT -->
		<div class="main">
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading"
							style="display: flex; justify-content: space-between;">
							<h3 class="panel-title">THÊM DANH MỤC LOẠI SẢN PHẨM</h3>
							<a class="btn btn-warning" href="list-category"
								style="background-color: #D9534F; padding: 2px 10px; text-decoration: none; border: none; margin-right: 10px; height: 25px;">Quay
								lại</a>
						</div>
						<form action="doAddCategory" method="post"
							modelAttribute="category" enctype="multipart/form-data">
							<div class="row"
								style="display: flex; justify-content: space-between;">
								<table
									style="border-collapse: separate; border-spacing: 15px 10px; margin: auto; margin-left: 60px;"
									class="col-md-6">

									<tr style="font-weight: bold;" style="line-height: 1.6;">
										<th>Tên loại sản phẩm:</th>
										<td><input type="text" class="form-control"
											required="required" style="height: 30px;"
											placeholder="Nhập tên danh mục..." name="Category" /></td>
									</tr>
									<tr>
										<th>Mô tả:</th>
										<td><textarea required="required" class="form-control"
												placeholder="Nhập mô tả danh mục..." rows="4"
												name="descriptions"></textarea></td>
									</tr>
									<tr>
										<th>Hình ảnh:</th>
										<td><form id="form1" runat="server">
												<input type='file' name="imageFile" id="imgInp" /> <img
													id="blah" name="imageFile"
													style="width: 20%; margin-top: 20px;" />
											</form></td>
									</tr>
									<td>
										<button type="submit" class="btn btn-primary"
											style="position: absolute; bottom: 3px; left: 158px;">
											Xác nhận</button>
									</td>

								</table>

							</div>
						</form>
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