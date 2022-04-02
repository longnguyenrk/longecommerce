<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<title>Trang quản trị</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

</head>
<body>

	<!-- WRAPPER -->
	

		<!-- MAIN -->
		<!-- MAIN CONTENT -->
		<div class="main">
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3">
									<a class="metric-link" href="listOrder" style="color: #676A6D;">
										<div class="metric" style="box-shadow: 0 0 3px;">
											<span class="icon"><i class="fa fa-shopping-cart"></i></span>
											<p>
												<span class="number">${amountOrders}</span> <span class="title">Đơn đặt hàng</span>
											</p>
										</div>
									</a>
								</div>
								<div class="col-md-3">
									<a class="metric-link" href="<c:url value='/admin/list-product'/>"
										style="color: #676A6D;">
										<div class="metric" style="box-shadow: 0 0 3px;">
											<span class="icon"><i class="fab fa-product-hunt"
												style="font-size: 26px; margin-top: 12px;"></i></span>
											<p>
												<span class="number">${amountProducts }</span> <span class="title">Sản phẩm</span>
											</p>
										</div>
									</a>
								</div>
								<div class="col-md-3">
									<a class="metric-link" href="<c:url value='/admin/list-account'/>" style="color: #676A6D;">
										<div class="metric" style="box-shadow: 0 0 3px;">
											<span class="icon"><i
												style='font-size: 24px; margin-top: 2px;' class='fas'>&#xf0c0;</i></span>
											<p>
												<span class="number">${amountAccount }</span><span class="title">Khách hàng</span>
											</p>
										</div>
									</a>
								</div>
								<div class="col-md-3">
									<!-- <div class="metric" style="box-shadow: 0 0 3px;">
										<span class="icon"><i class="fa fa-bar-chart"></i></span>
										<p>
											<span class="number">35%</span> <span class="title">Restore</span>
										</p>
									</div> -->
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="panel">
										<div class="panel-heading">
											<h3 class="panel-title">Đơn hàng gần đây</h3>
											<div class="right">
												<button type="button" class="btn-toggle-collapse">
													<i class="lnr lnr-chevron-up"></i>
												</button>
												<button type="button" class="btn-remove">
													<i class="lnr lnr-cross"></i>
												</button>
											</div>
										</div>
										<div class="panel-body no-padding">
											<table class="table table-striped">
												<thead>
													<tr>
														<th>Mã đơn hàng</th>
														<th>Tên khách hàng</th>
														<th>Tổng thanh toán</th>
														<th>Ngày đặt hàng</th>
														<th>Tình trạng đơn hàng</th>
														<th>Chi tiết</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${pageOrders.content}" var="order">
														<tr>
															<td><a href="#">No. ${order.idOrder}</a></td>
															<td>${order.account.fullName}</td>
															<td>${formatter.format(order.subTotal)} đ </td>
															<td>${order.dateOrder}</td>
															<c:if test="${order.status eq 'Thanh toán khi nhận hàng'}">
																<td><a href="<c:url value='/admin/successStatusHome?idOrder=${order.idOrder }'/>"><span class="label label-warning" >Thanh toán khi nhận hàng</span></a></td>
															</c:if>
															<c:if test="${order.status eq 'Đã thanh toán'}">
																<td><a href="<c:url value='/admin/pendingStatusHome?idOrder=${order.idOrder }'/>"><span class="label label-success">Đã thanh toán</span></a></td>
															</c:if>
															<td><a  href="<c:url value='/admin/detailsOrder?idOrder=${order.idOrder }'/>" style="text-decoration: underline;">Chi tiết</a></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
										<div class="panel-footer">
											<div class="row">
												<div class="col-md-6">
													
												</div>
												<div class="col-md-6 text-right">
													<a href="listOrder" class="btn btn-primary">Xem tất cả đơn hàng</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div id="headline-chart" class="ct-chart"></div>
								<!-- <div class="col-md-3">
									<div class="weekly-summary text-right">
										<span class="number">2,315</span> <span class="percentage"><i
											class="fa fa-caret-up text-success"></i> 12%</span> <span
											class="info-label">Total Sales</span>
									</div>
									<div class="weekly-summary text-right">
										<span class="number">$5,758</span> <span class="percentage"><i
											class="fa fa-caret-up text-success"></i> 23%</span> <span
											class="info-label">Monthly Income</span>
									</div>
									<div class="weekly-summary text-right">
										<span class="number">$65,938</span> <span class="percentage"><i
											class="fa fa-caret-down text-danger"></i> 8%</span> <span
											class="info-label">Total Income</span>
									</div>
								</div> -->
							</div>
						</div>
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
</body>
</html>