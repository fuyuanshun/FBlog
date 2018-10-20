<%@ page import="java.util.List" %>
<%@ page import="com.fys.blog.pojo.Post_" %>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%@ include file="header.jsp" %>
<%
    List<Post_> posts = (List<Post_>) request.getAttribute("posts");
%>
<html>
<head>
    <title>首页</title>
    <script src="${pageContext.request.contextPath}/js/project/index.js"></script>
</head>
<style>
    .post-center {
        height: 100vh;
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
<div class="post-center justify-content-center align-items-center row">
    <table class="table-hover table-warning table">
        <tr>
            <td class="active">标题</td>
            <td>内容</td>
            <td>作者</td>
            <td>发帖时间</td>
            <%if ("admin".equals(level)) {%>
            <td>操作</td>
            <%}%>
        </tr>
        <%
            if (null != posts) {
                for (Post_ post : posts) {
                    if (post.getRoot_id().equals("0")) {
        %>

        <tr>
            <td><a href="${pageContext.request.contextPath}/post?id=<%=post.getId()%>"><%=post.getTitle()%>
            </a></td>
            <td><%=post.getContent()%>
            </td>
            <td><a href="#"><%=post.getUser_id()%>
            </a></td>
            <td><%=post.getPost_time()%>
            </td>
            <%if (("admin".equals(level)) || (post.getUser_id().equals(nickName))) {%>
            <td>
                <button type="submit" class="btn-danger btn-sm" value="id=<%=post.getId()%>" id="delete">删除
                </button>&nbsp;
                <button class="btn-sm btn-danger">置顶</button>
            </td>
            <%}%>
        </tr>
        <%
                    }
                }
            }
        %>
    </table>
</div>

</body>
</html>
