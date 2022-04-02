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
<title>Danh sách đặt hàng</title>


</head>
<body>
<div class="main">
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-body">
							<form>
								<div class="row">
								<div class="col-md-12">
											<h3 class="panel-title">QUẢN LÝ ĐƠN HÀNG</h3>
									<div class="dropdown"
													style="display: inline; align-items: left">
													<button class="btn btn-primary dropdown-toggle"
														type="button" data-toggle="dropdown">
														Sắp xếp theo<span class="caret"></span>
													</button>
													<ul class="dropdown-menu">
														<li><a
															href="<c:url value='/admin/listOrder?&p=0&sort=idOrder'/>">Mã đơn hàng</a></li>

														<li><a
															href="<c:url value='/admin/listOrder?&p=0&sort=account.fullName'/>">Khách hàng</a></li>
														<li><a
															href="<c:url value='/admin/listOrder?p=0&sort=subTotal'/>">Tổng giá</a></li>
														<li><a
															href="<c:url value='/admin/listOrder?p=0&sort=dateOrder'/>">Thời gian đặt hàng</a></li>
														<li><a
															href="<c:url value='/admin/listOrder?p=0&sort=status'/>">Trạng thái đơn hàng</a></li>
													</ul>
												</div>
												<div class="dropdown"
													style="display: inline; align-items: left">
													<button class="btn btn-primary dropdown-toggle"
														type="button" data-toggle="dropdown">
														Tăng dần<span class="caret"></span>
													</button>
													<ul class="dropdown-menu">
														<li><a
															href="<c:url value='/admin/listOrder?&p=0&sort=${sorter}&updown=DESC'/>">Giảm
																</a></li>
														<li><a
															href="<c:url value='/admin/listOrder?&p=0&sort=${sorter}&updown=ASC'/>">Tăng
																</a></li>
													</ul>
												</div>

												<div class="search-container">
													<form>
														<input type="text" placeholder="Tìm kiếm đơn hàng theo tên khách hàng"
															name="keyword">
														<button type="submit" class="btn btn-default">Tìm
															kiếm</button>
													</form>
												</div>
										<div class="panel-body no-padding">
											<table class="table table-striped">
												<thead>
													<tr>
														<th>Mã đơn hàng</th>
														<th>Tên khách hàng</th>
														<th>Tổng thanh toán</th>
														<th>Ngày đặt hàng</th>
														<th>Địa chỉ nhận hàng</th>
														<th>Tình trạng đơn hàng</th>
														<th>Chi tiết</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${orders.content}" var="order">
														<tr>
															<td><a href="#">No. 000${order.idOrder}</a></td>
															<td>${order.account.fullName}</td>
															<td>${formatter.format(order.subTotal)} đ </td>
															<td>${order.dateOrder}</td>
															<td>${order.shippingInfo.address}</td>
															<c:if test="${order.status eq 'Thanh toán khi nhận hàng'}">
																<td><a href="<c:url value='/admin/successStatus?idOrder=${order.idOrder }&p=${p }'/>"><span class="label label-warning">Thanh toán khi nhận hàng</span></a></td>
															</c:if>
															<c:if test="${order.status eq 'Đã thanh toán'}">
																<td><a href="<c:url value='/admin/pendingStatus?idOrder=${order.idOrder }&p=${p }'/>"><span class="label label-success">Đã thanh toán</span></a></td>
															</c:if>
															<td><a href="<c:url value='/admin/detailsOrder?idOrder=${order.idOrder }'/>" style="text-decoration: underline;">Chi tiết</a></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
										<nav aria-label="Page navigation example">
											<ul class="pagination">
												<c:if test="${keyword == null }">
													<li class="page-item"><a class="page-link"
														href="<c:url value='/admin/listOrder?p=${0}&sort=${sorter}&updown=${updown}'/>">|<
													</a></li>
													<c:if test="${p > 0 }">
														<li class="page-item"><a class="page-link"
															href="<c:url value='/admin/listOrder?p=${p-1}&sort=${sorter}&updown=${updown}'/>">
																<< </a></li>
													</c:if>
													<li class="page-item active"><a class="page-link"
														href="<c:url value='/admin/listOrder?p=${p}&sort=${sorter}&updown=${updown}'/>">${p+1}</a></li>
													<c:if test="${p < orders.totalPages -1 }">
														<li class="page-item"><a class="page-link"
															href="<c:url value='/admin/listOrder?p=${p+1}&sort=${sorter}&updown=${updown}'/>">${p+2}</a></li>
														<c:if test="${p < orders.totalPages -2 }">
															<li class="page-item"><a class="page-link"
																href="<c:url value='/admin/listOrder?p=${p+2}&sort=${sorter}&updown=${updown}'/>">${p+3}</a></li>
														</c:if>
													</c:if>
													<c:if test="${p < orders.totalPages -1 }">
														<li class="page-item"><a class="page-link"
															href="<c:url value='/admin/listOrder?p=${p+1}&sort=${sorter}&updown=${updown}'/>">
																>> </a></li>
													</c:if>
													<li class="page-item"><a class="page-link"
														href="<c:url value='/admin/listOrder?p=${orders.totalPages-1}&sort=${sorter}&updown=${updown}'/>">
															>| </a></li>
												</c:if>

												<c:if test="${keyword != null }">
													<c:if test="${orders.totalPages-1 > 0 }">
														<li class="page-item"><a class="page-link"
															href="<c:url value='/admin/listOrder?p=${0}&sort=${sorter}&updown=${updown}&keyword=${keyword}'/>">|<
														</a></li>
														<c:if test="${p > 0 }">
															<li class="page-item"><a class="page-link"
																href="<c:url value='/admin/listOrder?p=${p-1}&sort=${sorter}&updown=${updown}&keyword=${keyword}'/>">
																	<< </a></li>
														</c:if>
														<li class="page-item active"><a class="page-link"
															href="<c:url value='/admin/listOrder?p=${p}&sort=${sorter}&updown=${updown}&keyword=${keyword}'/>">${p+1}</a></li>
														<c:if test="${p < orders.totalPages -1 }">
															<li class="page-item"><a class="page-link"
																href="<c:url value='/admin/listOrder?p=${p+1}&sort=${sorter}&updown=${updown}&keyword=${keyword}'/>">${p+2}</a></li>
															<c:if test="${p < orders.totalPages -2 }">
																<li class="page-item"><a class="page-link"
																	href="<c:url value='/admin/listOrder?p=${p+2}&sort=${sorter}&updown=${updown}&keyword=${keyword}'/>">${p+3}</a></li>
															</c:if>
														</c:if>
														<c:if test="${p < orders.totalPages -1 }">
															<li class="page-item"><a class="page-link"
																href="<c:url value='/admin/listOrder?p=${p+1}&sort=${sorter}&updown=${updown}&keyword=${keyword}'/>">
																	>> </a></li>
														</c:if>
														<li class="page-item"><a class="page-link"
															href="<c:url value='/admin/listOrder?p=${orders.totalPages-1}&sort=${sorter}&updown=${updown}&keyword=${keyword}'/>">
																>| </a></li>
													</c:if>

												</c:if>
											</ul>
										</nav>

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
							</form>
						</div>
					</div>
				</div>
				<!-- END OVERVIEW -->
			</div>
			<!-- END MAIN CONTENT -->
		</div>
</body>
</body>
</html>