$(function(){
    $("#delete").click(function(){
        var json = $("#delete").val();
        $.ajax({
            url : "/FBlog/deleteRoot",
            data : json,
            type : "POST",
            async : true,
            success : function(data){
                alert(data);
                location.reload();
            }
        })
    })
})