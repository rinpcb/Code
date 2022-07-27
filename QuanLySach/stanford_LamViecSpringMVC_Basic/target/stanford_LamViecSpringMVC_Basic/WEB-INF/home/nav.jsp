<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--Khai báo package cần sử dụng --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/trang-chu" var="urlTrangChu" />
<div class="templatemo_content_left_section">
	<h1>Danh mục sách</h1>
	<ul>
<c:if test="${not empty lstChuDe}">
	<c:forEach items="${lstChuDe}" var="cd">
	<li><a href="${urlTrangChu}/${cd.maChuDe}">${cd.tenChuDe}</a>
	</li>
	</c:forEach>
</c:if>
	</ul>
</div>
<div class="templatemo_content_left_section">
	<h1>Sách bán chạy</h1>
	<ul>
		<li><a href="#">Vestibulum ullamcorper</a></li>
		<li><a href="#">Maece nas metus</a></li>
		<li><a href="#">In sed risus ac feli</a></li>
		<li><a href="#">Praesent mattis varius</a></li>
		<li><a href="#">Maece nas metus</a></li>
		<li><a href="#">In sed risus ac feli</a></li>
	</ul>
</div>

<div class="templatemo_content_left_section">
	<a href="http://validator.w3.org/check?uri=referer"><img
		style="border: 0; width: 88px; height: 31px"
		src="http://www.w3.org/Icons/valid-xhtml10"
		alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8"
		border="0" /></a> <a
		href="http://jigsaw.w3.org/css-validator/check/referer"><img
		style="border: 0; width: 88px; height: 31px"
		src="http://jigsaw.w3.org/css-validator/images/vcss-blue"
		alt="Valid CSS!" vspace="8" border="0" /></a>
</div>