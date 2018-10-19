<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%
    String username = (String) request.getSession().getAttribute("username");
%>
<html>
<head>
    <title>首页</title>
    <%--jquery--%>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.3.1.min.js"></script>
    <%--bootstrap--%>
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/js/project/index.js"></script>
</head>
<body>
<div class="container">
    <p>
        <a href="${pageContext.request.contextPath}/">
            <img src="${pageContext.request.contextPath}/images/ioc.png">
        </a>

        <em>Welcome to FBLog! This is a simple blog site.</em>&nbsp;&nbsp;
        <%if (null == username) {%>
        <a href="${pageContext.request.contextPath}/login">登陆</a>
        <%} else {%>尊敬的用户：<%=username%>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/logout">退出登录</a>
        <%}%>
        <a href="${pageContext.request.contextPath}/register" class="float-right">还没有用户名？免费注册一个</a>
    </p>
</div>
</body>
</html>
