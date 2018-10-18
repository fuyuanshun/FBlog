<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<html>
<head>
    <title>注册</title>
    <%--jquery--%>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery.validate.js"></script>
    <%--bootstrap--%>
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css" rel="stylesheet"/>
    <%-- js --%>
    <script src="${pageContext.request.contextPath}/js/project/birthdayByJS.js"></script>
    <script src="${pageContext.request.contextPath}/js/project/register.js"></script>
</head>
<style>
    .login-center {
        height: 100vh;
    }
</style>
<body>
    <div class="container">
        <div class="row align-items-center justify-content-center login-center">
            <form action="" method="POST" id="registerForm">
                <h4 class="text-center">用户注册</h4>
                <input type="text" id="username" name="username" class="form-control" placeholder="用户名" required/><br>
                <input type="text" id="password" name="password" class="form-control" placeholder="密码" required/><br>
                <input type="text" id="confirmPassword" name="confirmPassword" class="form-control" placeholder="确认密码" required/><br>
                <input type="text" id="nickname" name="nickname" class="form-control" placeholder="您的社区昵称" required/><br>

                <span>出生日期:</span>
                <select onchange="setDays()" id="year" name="year" required>
                </select>
                <span>年</span>
                <select onchange="setDays()" id="month" name="month" required>
                </select>
                <span>月</span>
                <select id="day" name="day" required>
                </select>
                <span>日</span><br>
                <button class="btn-block btn-success " type="submit" id="register">注册</button>
            </form>
        </div>
    </div>
</body>
</html>
