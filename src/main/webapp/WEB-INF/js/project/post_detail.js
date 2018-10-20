$(function () {
    $("#submit").click(function(){
        var json = $("#submit").val();
        $.ajax({
            url: "/FBlog/delete",
            type : "POST",
            data : json,
            async : true,
            success : function(data){
                alert(data);
                location.reload();
            }
        })
    })
});