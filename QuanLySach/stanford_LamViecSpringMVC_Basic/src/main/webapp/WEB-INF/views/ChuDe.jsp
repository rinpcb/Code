<%--
  Created by IntelliJ IDEA.
  User: Rin-PC
  Date: 25/01/2022
  Time: 12:13 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Chủ Đề</title>
</head>
<body>
<c:url value="/chude-add" var="urlAdd"/>
<c:url value="/chude-edit" var="urlEdit"/>
<c:url value="/chude-delete" var="urlDelete"/>
<div style="width: 100%; text-align: center;">
    <h2>Danh sách chủ đề</h2>
</div>
<div style="width: 100%; text-align: center">
    <a href="${urlAdd}">Thêm mới</a>
</div>
<table style="width: 100%; border-collapse: collapse" border="1">
    <tr>
        <th>Mã chủ đề</th>
        <th>Tên chủ đề</th>
        <th></th>
    </tr>
    <tr>
        <tbody>
        <c:if test="${not empty lstChuDe}">
            <c:forEach items="${lstChuDe}" var="s">
                <tr>
                    <td>${s.maChuDe}</td>
                    <td>${s.tenChuDe}</td>
                    <td>
                        <a href="${urlEdit}/${s.maChuDe}">Sửa</a>
                        &nbsp;
                        <a href="${urlDelete}/${s.maChuDe}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </tr>
</table>
</body>
</html>
