<%@   page   contentType="text/html;charset=utf-8"%>
<%@ page   pageEncoding="utf-8"%>
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
            <em>Welcome to FBLog! This is a simple blog site.</em>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/register" class="">注册</a>
        </p>
    </div>
  </body>
</html>
