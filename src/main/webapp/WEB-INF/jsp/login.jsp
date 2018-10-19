<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>
<%@include file="header.jsp"%>
<%
    String username = "";
    String password = "";
    String value = "";
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("cookie-user")) {
            value = cookie.getValue();
            if (null != value && !"".equals(value)) {
                username = value;
            }
        }
        if (cookie.getName().equals("cookie-password")) {
            value = cookie.getValue();
            if (null != value && !"".equals(value)) {
                password = value;
            }
        }
    }
%>
<html>
<head>
    <title>用户登陆</title>
    <%-- jquery验证插件 --%>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery.validate.js"></script>
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
        <div class="login-center row align-items-center justify-content-center">
            <form action="" method="POST" id="loginForm">
                <h4 class="text-center text-danger">用户登录</h4>
                <input type="text" id="username" <%if(!username.equals("")){%>value="<%=username%>"<%}%> name="username" placeholder="用户名/社区昵称" class="form-control" required>
                <label for="username" class="text-danger"></label><br>
                <input type="password" <%if(!password.equals("")){%>value="<%=password%>"<%}%>  id="password" name="password" placeholder="密码" class="form-control" required>
                <label for="password" class="text-danger"></label><br>
                <input type="checkbox" id="remUsername" <%if(!username.equals("")){%> checked <%}%>name="remUsername">记住用户名 &nbsp;
                <input type="checkbox" <%if(!password.equals("")){%> checked <%}%> id="remPassword" name="remPassword">记住密码<br><br>
                <button type="submit" id="login" class="btn-block btn-success">登陆</button>
            </form>
        </div>
    </div>
</body>
</html>
