<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>
<html>
<head>
    <title>用户登陆</title>
    <%--jquery--%>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery.validate.js"></script>
    <%--bootstrap--%>
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css" rel="stylesheet"/>
    <%-- 本页面js --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/project/login.js"></script>
</head>
<style>
    .login-center{
        height : 100vh;
    }
</style>
<body>
    <div class="container">
        <div>
            <a href="${pageContext.request.contextPath}/">
                <img src="${pageContext.request.contextPath}/images/ioc.png" height="80px" width="80px">
            </a>
        </div>
        <div class="login-center row align-items-center justify-content-center">
            <form action="" method="POST" id="loginForm">
                <h4 class="text-center text-danger">用户登录</h4>
                <input type="text" id="username" name="username" placeholder="用户名" class="form-control" required>
                <label for="username" class="text-danger"></label><br>
                <input type="text" id="password" name="password" placeholder="密码" class="form-control" required>
                <label for="password" class="text-danger"></label><br>
                <input type="checkbox">记住用户名 &nbsp;
                <input type="checkbox">记住密码<br><br>
                <button type="submit" id="login" class="btn-block btn-success">登陆</button>
            </form>
        </div>
    </div>
</body>
</html>
