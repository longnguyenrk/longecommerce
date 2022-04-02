<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Chi tiết đơn hàng</title>

</head>
<body>
	<!-- WRAPPER -->
<div id="wrapper">

		<div class="main">
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading">
							<h3 class="panel-title">CHI TIẾT ĐƠN HÀNG</h3>
							<div class="right">
								<button type="submit">
									<a href="listOrder"><span class="label label-danger"
										style="font-size: 15px; margin-right: 15px;">Quay lại</span></a>
								</button>
								
							</div>
						</div>
						<div class="panel-body no-padding">
							<table class="table table-striped" >
								<thead>
									<tr>
										<th>Hình ảnh</th>
										<th>Chi tiết sản phẩm</th>
										<th>Đơn giá</th>
										<th>Số lượng</th>
										<th>Thành tiền</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${items}" var="item">
										<tr>
											<td><a><img style="width: 20%;"
													src="<c:url value='${item.product.imgUrl}'/>" alt=""></a></td>
											<td>
												<div class="shop-details">
													<div class="productname"><strong class="pcode">${item.product.product}</strong></div>
													Khối lượng chuẩn: ${item.product.weight} ${item.product.unit} 
													
													<p>
														Mã sản phẩm : <strong class="pcode">0000${item.product.idProduct}</strong>
													</p>
												</div>
											</td>
											<td>
												<h5 style="color: #41B314; font-weight: bold;">${formatter.format(item.product.cost)} đ</h5>
											</td>
											<td>${item.quantity}</td>
											<td>
												<h5>
													<strong class="red" style="color: red;">${formatter.format(item.total)} đ  </strong> 
												</h5>
											</td>

										</tr>
									</c:forEach>
								</tbody>
								<tfoot>
									 <tr>
										<td colspan="6"><span class="pull-left"> <span style="color: red;"></span></span><br /> <span
											class="pull-left"> <span style="color: red;"></span></span><br /> <span  
											class="pull-left" style="font-size: 22px;">Tổng đơn hàng:  <span style="color: red;">${formatter.format(order.subTotal)} đ <c:if test="${order.status eq 'Thanh toán khi nhận hàng'}">
								<a href="order-update?orderId=${order.idOrder}"><span class="label label-warning" style="font-size: 15px; margin-right: 15px;">${order.status}</span></a>
								</c:if>
								<c:if test="${order.status eq 'Đã thanh toán'}">
								<span class="label label-success" style="font-size: 15px; margin-right: 15px;">${order.status}</span>
								</c:if></span>
										</span>
											<p class="pull-right" style="display: flex; border: none;">
												<i class="material-icons"
													style="margin-top: -35px; color: #00ACC1; margin-right: 1px;">&#xe0c8;</i>
												<i class="title"
													style="font-size: 17px; color: #00ACC1; font-weight: bold; margin-top: -30px;">
													${order.shippingInfo.customer} * ${order.shippingInfo.address} *     
													${order.shippingInfo.phone}</i><br/>
											</p>
											</td>
									</tr>
								</tfoot>
							</table>
						</div>
						<div id="headline-chart" class="ct-chart"></div>
					</div>
				</div>
				<!-- END OVERVIEW -->
			</div>
			<!-- END MAIN CONTENT -->
		</div>
		<!-- END MAIN -->
		<div class="clearfix"></div>
		
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script>
            let userSelection = document.getElementsByClassName('checkbox');
            let checkAll = document.getElementById('checkAll')


            checkAll.addEventListener('click', () => {
                if (checkAll.checked == true) {
                    for (let i = 1; i <= userSelection.length; i++) {
                        document.getElementById(i).checked = true
                    }
                } else {
                    for (let i = 1; i <= userSelection.length; i++) {
                        document.getElementById(i).checked = false
                    }
                }

            })
   </script>
</body>
</body>
</html>