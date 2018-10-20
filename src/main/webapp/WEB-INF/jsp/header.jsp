<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>
<%
    String nickName = (String) request.getSession().getAttribute("nickName");
    String level = (String) request.getSession().getAttribute("level");
%>
<html>
<head>
    <%--jquery--%>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.3.1.min.js"></script>
    <%--bootstrap--%>
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<div class="container">
    <div class="outer">
        <p>
            <a href="${pageContext.request.contextPath}/">
                <img src="${pageContext.request.contextPath}/images/ioc.png">
            </a>

            <em>Welcome to FBLog! This is a simple blog site.</em>&nbsp;&nbsp;
            <%if (null == nickName) {%>
            <a href="${pageContext.request.contextPath}/login">登陆</a>
            <%} else {%>尊敬的<%if(level.equals("admin")){%> 管理员<%}else{%>用户<%}%>：<%=nickName%>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/logout">退出登录</a>
            <%}%>
            &nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/register" >还没有用户名？免费注册一个</a>
        </p>
    </div>
</div>
--------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
</body>
</html>
