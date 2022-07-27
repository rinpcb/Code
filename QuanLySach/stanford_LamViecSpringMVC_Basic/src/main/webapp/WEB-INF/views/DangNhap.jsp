<%--
  Created by IntelliJ IDEA.
  User: Rin-PC
  Date: 21/01/2022
  Time: 02:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri ="http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>BookStore - admin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.4.1.min.js"/>">
    </script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>">
    </script>
    <style type="text/css">
        .row {
            margin-bottom: 4px;
            margin-top: 4px;
        }
    </style>
</head>
<body>
<div class="container">
<form:form method="post" modelAttribute="user" action="thucHienDangNhap">
<div style="width: 100%; text-align: center;">
    <h2>Admin - Login</h2>
</div>
<fieldset style="text-align: center;">
    <div style="text-align: center;padding:  100px; margin-left: 72px">
        <div class="row">
            <label class="col-md-4">
                Tên Đăng Nhập:
            </label>
            <div class="col-md-6">
                <form:input path="tenDangNhap"/>
            </div>
        </div>
        <div class="row">
            <label class="col-md-4">
                Mật Khẩu:
            </label>
            <div class="col-md-6">
                <form:password path="matKhau"/>
            </div>
        </div>
        <div class="row">
            <label class="col-md-4"></label>
            <div class="col-md-6">
                <input class="btn btn-primary" type="submit" value="Đăng Nhập" name="btnDangNhap"/>
                <a href="#" class="btn btn-danger">Hủy bỏ</a>
            </div>
        </div>
        <div class="row">
            <label class="col-md-2"></label>
            <div class="col-md-4">
                <span class="alert-primary">${thongbao}</span>
            </div>
        </div>
    </div>
</fieldset>
</form:form>
</div>
</body>
</html>
