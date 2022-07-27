<%--
  Created by IntelliJ IDEA.
  User: DangQuang
  Date: 2/21/22
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>
    <tiles:insertAttribute name="title"/>
</title>
<meta name="keywords" content="Book Store Template, Stanford - Day lap trinh" />
<meta name="description" content="Book Store Template, Stanford - Day lap trinh" />
<link href="<c:url value="/resources/css/templatemo_style.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>

<!-- Templates from www.stanford.com.vn -->
<div id="templatemo_container">
    <!-- Menu -->
   <tiles:insertAttribute name="menu"/>
    <!-- End menu -->

    <div id="templatemo_header">
        <tiles:insertAttribute name="header"/>
    </div> <!-- end of header -->

    <div id="templatemo_content">

        <div id="templatemo_content_left">
            <tiles:insertAttribute name="nav"/>
        </div> <!-- end of content left -->

        <div id="templatemo_content_right">
            <tiles:insertAttribute name="body"/>
            <a href="subpage.html"><img src="<c:url value="/images/templatemo_ads.jpg"/>" alt="ads" /></a>
        </div> <!-- end of content right -->

        <div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->

    <!-- Footer -->
    <tiles:insertAttribute name="footer"/>
    <!-- end of footer -->
</div> <!-- end of container -->
<div align=center>This template  downloaded form <a href='http://www.stanford.com.vn'>Stanford.com.vn</a></div>
</body>
</html>
