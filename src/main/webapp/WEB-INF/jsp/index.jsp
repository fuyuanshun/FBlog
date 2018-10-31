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
        margin : 0 auto;
    }
</style>
<body>
<div>
</div>
<div class="post-center <%--justify-content-center align-items-center row--%>">
    <div style="margin-bottom: 40px; border-bottom: 1px solid #333;border-top:1px solid #333">
        <a href="" class="btn-primary">首页</a>
        <a href="" class="btn-primary">我的帖子</a>
        <a href="" class="btn-primary">精华</a>
        <a href="" class="btn-primary">热门</a>
        <button type="button" class="btn-primary btn-sm" data-toggle="modal" data-target="#myModal" id="button">发帖子</button>
    </div>
    <div style="width:1000px;position: absolute">
        <table class="table-hover table-warning table" style="position: relative;left:100px;">
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
</div>


<!-- 模态框1 -->
<div class="modal fade" id="myModal" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">发帖</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <div>
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
