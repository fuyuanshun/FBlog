$(function () {
    $("button#submit").click(function(){
        if(confirm('删除后无法恢复，确定吗？')){
        var json = $(this).val();
        $.ajax({
            url: "/FBlog/deleteAll",
            type : "POST",
            data : json,
            async : true,
            success : function(data){
                alert(data);
                location.reload();
            }
        })
    }})


    $("#delete").click(function(){
        if(confirm('删除后无法恢复，确定吗？')){
            var json = $(this).val();
            $.ajax({
                url: "/FBlog/deleteAll",
                type : "POST",
                data : json,
                async : true,
                success : function(data){
                    alert(data);
                   $(window).attr("location", "/FBlog/");
                }
            })
        }})


    $("#button2").click(function(){
        var title = $("#title").val();
        var content = $("#content").val();
        var id = $("#id").val();
        var nickname = $("#nickname").val();
        if (null == title || title === "" || null == content || content === "") {
            alert("不能为空!");
            return;
        }
        var json = "id=" + id + "&title=" + title + "&content="+content+"&nickname="+nickname;
        $.ajax({
            url: "/FBlog/addPost",
            async : true,
            data : json,
            type : "POST",
            success : function(data){
                if (data === "success") {
                    alert("回复成功!");
                    location.reload();
                } else {
                    alert(data);
                }
            }
        });
    })
});