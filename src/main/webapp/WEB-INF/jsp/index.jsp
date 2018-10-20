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


<!-- 模态框 -->
<div class="modal fade" id="myModal" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">确认信息</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <div>
                    <label class="text-muted">名称:</label>
                    <input type="text" id="name" class="form-control" readonly>
                    <label class="col-form-label">宿舍楼:</label>
                    <input type="text" id="floor" class="form-control" readonly>
                    <label class="col-form-label">寝室号:</label>
                    <input type="text" id="room" class="form-control" readonly>
                    <label class="col-form-label">联系电话:</label>
                    <input type="text" id="phone" class="form-control" readonly>
                    <label class="col-form-label">故障信息:</label>
                    <input <%--cols="30" rows="10"--%> type="text" id="info" class="form-control" readonly />
                    <span class="text-danger">注: 如想修改信息，请返回上个页面修改</span>
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
