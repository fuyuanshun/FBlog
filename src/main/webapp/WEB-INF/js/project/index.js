$(function(){
    $("button#delete").click(function(){
        if(confirm('删除后无法恢复，确定吗？')){
        var json = $(this).val();
        $.ajax({
            url : "/FBlog/deleteAll",
            data : json,
            type : "POST",
            async : true,
            success : function(data){
                alert(data);
                location.reload();
            }
        })
    }})

    $("#button2").click(function(){
        var nickname = $("#nickname").val();
        var title = $("#title").val();
        var content = $("#content").val();
        if (null == title || title === "" || null == content || content === "") {
            alert("不能为空!");
            return;
        }
        var json = "nickname="+nickname+"&title="+title+"&content="+content;
        $.ajax({
            url : "/FBlog/newPost",
            data : json,
            type : "POST",
            async : true,
            success : function(data){
                if (data === "success") {
                    alert("发帖成功！");
                    location.reload();
                } else {
                    alert(data);
                    location.reload();
                }
            }
           })
        })

})