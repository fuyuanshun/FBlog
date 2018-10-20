<%@ page import="com.fys.blog.pojo.Post_" %>
<%@ page import="java.util.List" %>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>
<%@include file="header.jsp" %>
<%
    Post_ post = (Post_) request.getAttribute("post");
%>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/project/post_detail.js"></script>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <h3><%=post.getTitle()%>
        </h3><br>
        发帖人:<%=post.getUser_id()%>
        &nbsp;&nbsp;日期：<%=post.getPost_time()%>
    </div>
    <div>
        <textarea rows="15" cols="150" readonly>
            <%=post.getContent()%>
        </textarea>
        <button class="btn-primary btn-lg float-right">回复</button>
        <button type="submit" id="delete" class="btn-danger btn-lg float-right" value="id=<%=post.getId()%>" id="delete">删除主题</button>
    </div>
    <div>
        <%
            List<Post_> posts = (List<Post_>) request.getAttribute("posts");
            if (posts != null) {
                for (Post_ p : posts) {
                    if (p.getRoot_id().equals(post.getId())) {%>
        <textarea rows="10" cols="150" readonly>
            标题：<%=p.getTitle()%>
            回帖人：<%=p.getUser_id()%>
            回帖时间：<%=p.getPost_time()%>
            内容：<%=p.getContent()%>
        </textarea>
        <%
                        if(("admin".equals(level)) || (p.getUser_id().equals(nickName))){%>
        <button class="float-right btn-danger" type="submit" id="submit" value="id=<%=p.getId()%>">删除</button>
                        <%}
                    }
                }
            }
        %>
    </div>
</div>
</body>
</html>
