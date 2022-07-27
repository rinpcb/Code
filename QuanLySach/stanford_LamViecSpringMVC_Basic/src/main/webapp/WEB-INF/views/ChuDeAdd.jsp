<%--
  Created by IntelliJ IDEA.
  User: Rin-PC
  Date: 25/01/2022
  Time: 12:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Thêm mới</title>
</head>
<body>
<c:url value="/themMoiChuDe" var="urlThemChuDe"/>
<c:url value="/chude" var="urlDanhSach"/>
<s:form action="${urlThemChuDe}" method="post" modelAttribute="chude">
    <fieldset>
        <legend>Nhập thông tin chủ đề</legend>
        <table>
            <tr>
                <td>Mã chủ đề</td>
                <td>
                    <s:input path="maChuDe"/>
                </td>
            </tr>
            <tr>
                <td>Tên chủ đề</td>
                <td>
                    <s:input path="tenChuDe"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Thêm mới"/>
                    &nbsp;
                    <a href="${urlDanhSach}">Trở lại</a>
                </td>
            </tr>
        </table>
    </fieldset>
</s:form>
</body>
</html>
