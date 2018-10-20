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
        <button type="button" class="btn-primary btn-lg float-right" data-toggle="modal" data-target="#myModal" id="button">回复</button>
        <%if(("admin".equals(level)) || (post.getUser_id().equals(nickName))){%>
        <button type="submit" id="delete" class="btn-danger btn-lg float-right" value="id=<%=post.getId()%>" id="delete">删除</button><%}%>
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

        <%--<input type="hidden" id="id2" >--%>
        <button type="button" class="float-right btn-primary" data-toggle="modal" data-target="#myModal" id="submit2" value="<%=p.getId()%>" >回复</button>
        <%
                        if(("admin".equals(level)) || (p.getUser_id().equals(nickName))){%>
        <button class="float-right btn-danger" type="submit" id="submit" value="id=<%=p.getId()%>">删除</button>
                        <%} } } }%>
    </div>
</div>

<!-- 模态框1 -->
<div class="modal fade" id="myModal" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">回复帖子: <%=post.getTitle()%></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <div>
                    <input type="hidden" id="id" value="<%=post.getId()%>">
                    <input type="hidden" id="nickname" value="<%=nickName%>">
                    <label class="col-form-label">标题:</label>
                    <input type="text" id="title" class="form-control"/>
                    <label class="col-form-label">内容:</label><br>
                    <textarea id="content" rows="20" cols="60">
                    </textarea>
                </div>
            </div>
            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-secondary" id="button2">提交</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
