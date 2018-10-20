<%@ page import="com.fys.blog.pojo.Blog" %>
<%@ page import="java.util.List" %>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%@ include file="header.jsp"%>
<%
    List<Blog> blogs = (List<Blog>) request.getAttribute("blogs");
%>
<html>
<head>
    <title>首页</title>
</head>
<style>
    .post-center{
        height:100vh;
    }
</style>
<body>
<div>
    <a href="" class="btn-primary">首页</a>
    <a href="" class="btn-primary">我的帖子</a>
    <a href="" class="btn-primary">精华</a>
    <a href="" class="btn-primary">热门</a>
    <button class="btn-primary">发帖子</button>
</div>
<div>
    <table class="table-hover table-warning" border="1">
        <tr>
            <td >标题</td>
            <td >内容</td>
            <td >作者</td>
            <td >发帖时间</td>
            <%if(level.equals("admin")){%>
            <td>操作</td>
            <%}%>
        </tr>
        <%
            if (null != blogs) {
                for (Blog blog : blogs) {%>
        <tr>
            <td><a href="${pageContext.request.contextPath}/post?id=<%=blog.getId()%>"><%=blog.getTitle()%></a></td>
            <td><%=blog.getContent()%></td>
            <td><a href="#"><%=blog.getUser_id()%></a></td>
            <td><%=blog.getPost_time()%></td>
            <%if(level.equals("admin")){%>
            <td><a href="#">删除</a>&nbsp;<a href="#">置顶</a></td>
            <%}%>
        </tr>
        <%} }%>
    </table>
</div>

</body>
</html>
