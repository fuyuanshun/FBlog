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
})