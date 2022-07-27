<%--
  Created by IntelliJ IDEA.
  User: Rin-PC
  Date: 21/01/2022
  Time: 03:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Quản lý sách</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.4.1.min.js"/>">
    </script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>">
    </script>
</head>
<body>
<c:url value="/sach-add" var="urlAdd"/>
<c:url value="/sach-edit" var="urlEdit"/>
<c:url value="/sach-delete" var="urlXoa"/>
    <div style="width: 100%; text-align: center;">
        <h2>Quản lý thông tin sách</h2>
<div class="container-fluid"></div>
    </div>
<div style="width: 100%; text-align: right">
    <a class="btn btn-primary" href="${urlAdd}">Thêm mới</a>
</div>

<table class="table table-bordered table-striped" style="width: 100%; border-collapse: collapse" border="1">
    <tr>
        <th>Ảnh sách</th>
        <th>Mã sách</th>
        <th>Tên sách</th>
        <th>Mô tả</th>
        <th>Giá sách</th>
        <th>Ngày tạo</th>
        <th>Tác giả</th>
        <th></th>
    </tr>
    <tr>
    <tbody>
    <c:if test="${not empty lstSach}">
        <c:forEach items="${lstSach}" var="s">
            <tr>
                <td>
                    <img class="img-thumbnail" src="images/${s.anhSach}" width="80" height="80">
                </td>
                <td>${s.maSach}</td>
                <td>${s.tenSach}</td>
                <td>${s.moTa}</td>
                <td>${s.giaSach}</td>
                <td>${s.ngayTao}</td>
                <td>${s.tacGia}</td>
                <td>
                    <a href="${urlEdit}/${s.maSach}">Sửa</a>
                    &nbsp;
                    <a href="${urlXoa}/${s.maSach}">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
    </tr>
</table>
</body>
</html>
