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
});