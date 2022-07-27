<%--
  Created by IntelliJ IDEA.
  User: Rin-PC
  Date: 21/02/2022
  Time: 02:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Trang Chủ</title>
</head>
<body>
<%
    int i = 0; %>
<c:if test="${not empty lstSach}">
    <c:forEach items="${lstSach}" var="s">
        <div class="templatemo_product_box">
            <h1>${s.tenSach}<span>(by ${s.tacGia})</span></h1>
            <img src="<c:url value="/images/${s.anhSach}"/>" alt="image" width="100" height="150" />
            <div class="product_info">
                <p>${s.moTa}</p>
                <h3>${s.giaSach}</h3>
                <div class="buy_now_button"><a href="#">Mua ngay</a></div>
                <div class="detail_button"><a href="#">Chi tiết</a></div>
            </div>
            <div class="cleaner">&nbsp;</div>
        </div>
        <%if(i%2==0){ %>
        <div class="cleaner_with_width">&nbsp;</div>
        <%}else{ %>
        <div class="cleaner_with_height">&nbsp;</div>
        <%}
            i++;
        %>
    </c:forEach>
</c:if>
</body>
</html>
