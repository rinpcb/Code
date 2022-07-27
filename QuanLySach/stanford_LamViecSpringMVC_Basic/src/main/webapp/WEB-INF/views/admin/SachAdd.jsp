<%--
  Created by IntelliJ IDEA.
  User: Rin-PC
  Date: 21/01/2022
  Time: 03:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Thêm mới thông tin sách</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">

    <style type="text/css">
        .error {
            color: red;
        }

        .errorBlock {
            color: black;
            border: 1px solid #e69d91;
            background-color: #f7b8ad;
            font-size: 16px;
            display: inline-block;
            margin: 3px;
        }

        .row {
            margin-bottom: 4px;
            margin-top: 4px;
        }
    </style>
</head>
<body>
<div class="app-title">
    <div>
        <h1><i class="fa fa-th-list"></i> Thêm, sửa thông tin sách</h1>
        <p>Quản lý các thông tin về sách trong hệ thống</p>
    </div>
    <ul class="app-breadcrumb breadcrumb side">
        <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
        <li class="breadcrumb-item">BookStore</li>
        <li class="breadcrumb-item active"><a href="quanly-sach">Quản lý sách</a></li>
    </ul>
</div>
<div class="row">
    <div class="col-md-12">
        <div class="tile">
            <div class="tile-body">
                <c:url value="/admin/themMoiSach" var="urlThemSach"/>
                <c:url value="/admin/quanly-sach" var="urlDanhSach"/>
                <s:form action="${urlThemSach}" method="post" enctype="multipart/form-data" modelAttribute="sach">
                    <fieldset>
                        <legend>Nhập thông tin sách</legend>
                        <div class="container-fluid">
                            <div class="row">
                                <label class="col-md-2">
                                    Mã sách:
                                </label>
                                <div class="col-md-4">
                                    <s:input cssClass="form-control" path="maSach"/>
                                    <s:errors path="maSach" cssClass="error"/>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-md-2">
                                    Tên sách:
                                </label>
                                <div class="col-md-10">
                                    <s:input cssClass="form-control" path="tenSach"/>
                                    <s:errors path="tenSach" cssClass="error"/>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-md-2">
                                    Mô tả:
                                </label>
                                <div class="col-md-10">
                                    <s:textarea cssClass="form-control" path="moTa" rows="5"/>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-md-2">
                                    Ảnh sách:
                                </label>
                                <div class="col-md-4">
                                    <input type="file" name="fUpload"/>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-md-2">
                                    Giá sách:
                                </label>
                                <div class="col-md-4">
                                    <s:input cssClass="form-control" path="giaSach"/>
                                    <s:errors path="giaSach" cssClass="error"/>
                                </div>
                                <label class="col-md-2">
                                    Tác giả:
                                </label>
                                <div class="col-md-4">
                                    <s:input cssClass="form-control" path="tacGia"/>
                                    <s:errors path="tacGia" cssClass="error"/>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-md-2">
                                    Chủ đề:
                                </label>
                                <div class="col-md-4">
                                    <s:select path="maChuDe" cssClass="form-control">
                                        <s:option value="">---Chọn Chủ đề---</s:option>
                                        <s:options items="${lstChuDe}"/>
                                    </s:select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2"></div>
                                <div class="col-md-4">
                                    <input type="submit" class="btn btn-primary" value="Thêm mới"/>
                                    &nbsp;
                                    <a class="btn btn-danger" href="${urlDanhSach}">Trở về</a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2"></div>
                                <div class="col-md-10">
                                    <span class="text-warning">${message}</span><br>
                                    <s:errors path="*" cssClass="alert-danger" element="div"/>
                                </div>
                            </div>
                        </div>

                    </fieldset>
                </s:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

