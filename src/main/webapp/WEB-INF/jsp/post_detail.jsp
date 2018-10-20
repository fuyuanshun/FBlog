<%@ page import="com.fys.blog.pojo.Blog" %>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>
<%@include file="header.jsp"%>
<%
    Blog blog = (Blog) request.getAttribute("blog");
%>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .detail-center{
        height : 100vh;
    }
</style>
<body>
<div class="container">
    <div class=".detail-center row justify-content-center align-items-center">
            楼主:<%=blog.getUser_id()%>&nbsp;&nbsp;发帖时间:<%=blog.getPost_time()%><br>
            标题:<%=blog.getTitle()%><br>
            内容:<br><%=blog.getContent()%><br>
    </div>
</div>
</body>
</html>
