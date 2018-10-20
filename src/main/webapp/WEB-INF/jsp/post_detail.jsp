<%@ page import="com.fys.blog.pojo.Post_" %>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>
<%@include file="header.jsp"%>
<%
    Post_ post = (Post_) request.getAttribute("post");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <h3><%=post.getTitle()%></h3><br>
        发帖人:<%=post.getUser_id()%>
        &nbsp;&nbsp;日期：<%=post.getPost_time()%>
    </div>
    <div>
        <textarea rows="15" cols="150"  readonly>
            <%=post.getContent()%>
        </textarea>
        <button class="btn-primary btn-lg float-right">回复</button>
    </div>
</div>
</body>
</html>
