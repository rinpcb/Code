<%--
  Created by IntelliJ IDEA.
  User: Rin-PC
  Date: 18/02/2022
  Time: 02:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="/admin/sach-add" var="urlAdd" />
<c:url value="/admin/sach-edit" var="urlEdit" />
<c:url value="/admin/sach-delete" var="urlDelete" />
<c:url value="/admin/tim-kiem-sach" var="urlTimKiem"/>
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
        <s:form action="${urlTimKiem}" method="post" modelAttribute="sachSearch">
            <fieldset>
                <legend >Nhập thông tin tìm kiếm</legend>
                <div class="row form-group">
                    <label class="col-md-2">Từ khóa</label>
                    <div class="col-md-3">
                        <s:input path="tuKhoa"/>
                    </div>
                    <label class="col-md-2">
                        Chủ đề:
                    </label>
                    <div class="col-md-3">
                        <s:select path="maChuDe" cssClass="form-control">
                            <s:option value="">---Chọn Chủ Đề---</s:option>
                            <s:options items="${lstChuDe}"/>
                        </s:select>
                    </div>
                    <div class="col-md-2">
                        <input type="submit" value="Tìm kiếm" class="btn btn-success">
                    </div>
                </div>
            </fieldset>
        </s:form>
    </div>
    <div class="col-md-12">
        <div style="width:100%; text-align:right;margin-bottom:5px;">
            <a  style="margin-right: 88px" class="btn btn-primary" href="${urlAdd}">Thêm mới</a>
        </div>
        <div class="tile">
            <div class="tile-body">
                <table class="table table-hover table-bordered" id="sampleTable">
                    <thead>
                    <tr>
                        <th>Ảnh sách</th>
                        <th>Mã sách</th>
                        <th>Tên sách</th>
                        <th>Mô tả</th>
                        <th>Giá sách</th>
                        <th>Ngày tạo</th>
                        <th>Tác giả</th>
                        <th>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty lstSach}">
                        <c:forEach items="${lstSach}" var="s">
                            <tr>
                                <td><img src="images/${s.anhSach}" width="80" height="80"/> </td>
                                <td>${s.maSach}</td>
                                <td>${s.tenSach}</td>
                                <td>${s.moTa}</td>
                                <td>${s.giaSach}</td>
                                <td>${s.ngayTao}</td>
                                <td>${s.tacGia}</td>
                                <td>
                                    <a class="btn btn-xs btn-info" href="${urlEdit}/${s.maSach}"><i class="ace-icon fa fa-pencil bigger-120"></i></a>
                                    &nbsp;
                                    <a class="btn btn-xs btn-danger" href="${urlDelete}/${s.maSach}"><i class="ace-icon fa fa-trash-o bigger-120"></i></a>
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
