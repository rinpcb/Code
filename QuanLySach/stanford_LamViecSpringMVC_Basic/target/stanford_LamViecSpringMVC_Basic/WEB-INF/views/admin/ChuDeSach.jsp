<%--
  Created by IntelliJ IDEA.
  User: Rin-PC
  Date: 21/02/2022
  Time: 01:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="/sach-add" var="urlAdd" />
<c:url value="/sach-edit" var="urlEdit" />
<c:url value="/sach-delete" var="urlDelete" />
<div class="app-title">
    <div>
        <h1><i class="fa fa-th-list"></i> Quản lý thông tin sách</h1>
        <p>Quản lý các thông tin về sách trong hệ thống</p>
    </div>
    <ul class="app-breadcrumb breadcrumb side">
        <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
        <li class="breadcrumb-item">BookStore</li>
        <li class="breadcrumb-item active"><a href="#">Quản lý sách</a></li>
    </ul>
</div>
<div class="row">
    <div class="col-md-12">
        <div style="width:100%; text-align:right;margin-bottom:5px;">
            <a class="btn btn-primary" href="${urlAdd}">Thêm mới</a>
        </div>
        <div class="tile">

            <div class="tile-body">

                <table class="table table-hover table-bordered" id="sampleTable">
                    <thead>
                    <tr>
                        <th>Mã chủ đề</th>
                        <th>Tên chủ đề</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty lstChuDe}">
                        <c:forEach items="${lstChuDe}" var="s">
                            <tr>
                                <td>${s.maChuDe}</td>
                                <td>${s.tenChuDe}</td>
                                <td><a class="btn btn-xs btn-info" href="${urlEdit}/${s.maChuDe}"><i class="ace-icon fa fa-pencil bigger-120"></i></a>
                                    &nbsp;
                                    <a class="btn btn-xs btn-danger" href="${urlDelete}/${s.maChuDe}"><i class="ace-icon fa fa-trash-o bigger-120"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
