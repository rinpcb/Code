<%--
  Created by IntelliJ IDEA.
  User: Rin-PC
  Date: 18/02/2022
  Time: 02:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="app-sidebar">
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="/images/member_icon.png">
        <div>
            <p class="app-sidebar__user-name">Rin NV</p>
            <p class="app-sidebar__user-designation">FullStack Dev</p>
        </div>
    </div>
    <ul class="app-menu">
        <li><a class="app-menu__item" href="/trang-chu"><i class="app-menu__icon fa fa-dashboard"></i><span class="app-menu__label">Trang chủ</span></a></li>

        <li><a class="app-menu__item" href="admin/quanly-sach"><i class="app-menu__icon fa fa-book"></i><span class="app-menu__label">Quản lý</span></a></li>
        <li><a class="app-menu__item" href="admin/sach-add"><i class="app-menu__icon fa fa-address-book-o"></i><span class="app-menu__label">Thêm mới sách</span></a></li>

        <li class="treeview"><a class="app-menu__item" href="sach-add" data-toggle="treeview"><i class="app-menu__icon fa fa-edit"></i><span class="app-menu__label">Quản lý sách</span><i class="treeview-indicator fa fa-angle-right"></i></a>
            <ul class="treeview-menu">
                <li><a class="treeview-item" href="chude"><i class="icon fa fa-circle-o"></i> Chủ Đề</a></li>
                <li><a class="treeview-item" href="chude"><i class="icon fa fa-circle-o"></i> Chủ đề sách</a></li>
                <li><a class="treeview-item" href="form-samples.html"><i class="icon fa fa-circle-o"></i> Chức vụ</a></li>
                <li><a class="treeview-item" href="form-notifications.html"><i class="icon fa fa-circle-o"></i> Hệ số lương</a></li>
            </ul>
        </li>
<%--        <li class="treeview is-expanded"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-th-list"></i><span class="app-menu__label">Danh sách</span><i class="treeview-indicator fa fa-angle-right"></i></a>--%>
<%--            <ul class="treeview-menu">--%>
<%--                <li><a class="treeview-item" href="table-basic.html"><i class="icon fa fa-circle-o"></i> Danh sách</a></li>--%>
<%--                <li><a class="treeview-item active" href="table-data-table.html"><i class="icon fa fa-circle-o"></i> Data Tables</a></li>--%>
<%--            </ul>--%>
<%--        </li>--%>
        <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-file-text"></i><span class="app-menu__label">Trang</span><i class="treeview-indicator fa fa-angle-right"></i></a>
            <ul class="treeview-menu">
                <li><a class="treeview-item" href="blank-page.html"><i class="icon fa fa-circle-o"></i> Blank Page</a></li>
                <li><a class="treeview-item" href="page-login.html"><i class="icon fa fa-circle-o"></i> Login Page</a></li>
                <li><a class="treeview-item" href="page-lockscreen.html"><i class="icon fa fa-circle-o"></i> Lockscreen Page</a></li>
                <li><a class="treeview-item" href="page-user.html"><i class="icon fa fa-circle-o"></i> User Page</a></li>
                <li><a class="treeview-item" href="page-invoice.html"><i class="icon fa fa-circle-o"></i> Invoice Page</a></li>
                <li><a class="treeview-item" href="page-calendar.html"><i class="icon fa fa-circle-o"></i> Calendar Page</a></li>
                <li><a class="treeview-item" href="page-mailbox.html"><i class="icon fa fa-circle-o"></i> Mailbox</a></li>
                <li><a class="treeview-item" href="page-error.html"><i class="icon fa fa-circle-o"></i> Error Page</a></li>
            </ul>
        </li>
    </ul>
</aside>