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
<title>Cập nhật sản phẩm</title>
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
			<div class="main-content"style="padding: 185px;">
				<div class="container-fluid"
					style="position: relative; top: -146px; margin-right: -180px; margin-left: -186px; line-height: 46px;">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading"
							style="display: flex; justify-content: space-between;">
							<h3 class="panel-title">Cập nhật sản phẩm</h3>
							<a class="btn btn-warning" href="list-product"
								style="background-color: #D9534F; padding: 2px 10px; text-decoration: none; border: none; margin-right: 10px; height: 25px;">Quay lại</a>
						</div>
						<form:form action="doUpdateProduct" method="post"
							enctype="multipart/form-data" modelAttribute="product">
							<div class="row"
								style="display: flex; justify-content: space-between;">
								<table style="margin: auto; margin-left: 60px;" class="col-md-6">
									
									<%-- <tr>
										<th>ID :</th>
										<td>${product.idProduct}
											<form:hidden path="idProduct"/>
											</td>
									</tr> --%>
									<tr>
											<th>Danh mục:</th>
											<td><select name=idCategory>
												<c:forEach items="${category}" var="category">
													<option
														<c:if test="${product.category.idCategory == category.idCategory}">
															selected="selected"
														</c:if>
														value="${category.idCategory}">${category.category}</option>
												</c:forEach>
										</select></td>
										</tr>
									<tr>
										<th>Tên sản phẩm :</th>
										<td><input type="text" class="form-control"
											required="required" style="height: 30px;"
											placeholder="Nhập tên sản phẩm..." name="Product"
											value="${product.product}" />
											<input type="hidden" name="idProduct" value="${product.idProduct}">
											</td>
									</tr>
									<tr>
											<th>Mô tả ngắn :</th>
											<td><input type="text" class="form-control"
											required="required" style="height: 30px;"
											placeholder="Nhập mô tả ngắn sản phẩm..." name="shortdescription"
											value="${product.shortdescription}" /></td>
										</tr>
									<tr>
										<th>Mô tả chi tiết:</th>
										<td><textarea required="required" class="form-control"
												placeholder="Nhập mô tả chi tiết sản phẩm..." rows="4"
												name="descriptions">${product.descriptions}</textarea></td>
									</tr>
									<tr>
										<th>Giá:</th>
										<td><input type="text" class="form-control" 
											style="height: 30px; width: 230px;"
											placeholder="${product.cost} VND" name="Cost" value="${product.cost}"/>
											</td>
									</tr>
								</table>
								<table
									style="margin: auto; margin-left: 50px; margin-right: -40px;"
									class="col-md-6">
									
									<tr>
										<th>Số lượng kho: </th>
										<td>${product.quantity}</td>
									</tr>
									<tr>
										<th>Thêm số lượng:</th>
										<td><input type="number" class="form-control" 
											style="height: 30px; width: 230px;"
											placeholder="Nhập số lượng muốn thêm..." name="addQuantity" min = 0 value="0"/>
											</td>
									</tr>
									<tr>
											<th>Khối lượng chuẩn :</th>
											<td><input type="number" class="form-control"
												required="required" style="height: 30px; width: 230px;"
												placeholder="${product.weight}" name="weight" min = 0 value="${product.weight}"/></td>
												
												
										</tr>
										<tr>
											<th>Đơn vị :</th>
										<td><input type="text" class="form-control"
											required="required" style="height: 30px;width: 230px;"
											placeholder="Nhập tên sản phẩm..." name="unit"
											value="${product.unit}" />
											</td>
											</tr>
									<tr>
										<th>Hình ảnh:</th>
											<td> <form id="form1" runat="server">
      											  <input type='file' name="imageFile" id="imgInp" value="${product.imgUrl}"/>
     											  <img id="blah" value='${product.imgUrl}' name="imageFile"  style="width: 20%; margin-top: 20px;" />
  											  </form></td>
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