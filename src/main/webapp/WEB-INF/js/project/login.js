$(function () {
    $.validator.setDefaults({
        submitHandler : function () {
            var json = $("#loginForm").serialize();
            $.ajax({
                url: "/FBlog/loginDeal",
                async : true,
                type : "POST",
                data : json,
                success : function (data) {
                    if (data === "success") {
                        $(window).attr("location", "/FBlog/");
                    } else {
                        alert(data);
                    }
                },
                error : function () {
                    alert("服务器出了点小问题哦~请稍后重试");
                }
            })
        }
    })

    $("#loginForm").validate({
        errorPlacement: function (error, element) {
            $(element)
                .closest("form")
                .find("label[for='" + element.attr("id") + "']")
                .append(error);
        },
        errorElement: "span",
        rules: {
            username: {
                required: true,
                maxlength : 8
            },
            password: {
                required: true,
                maxlength : 8
            }
        },
        messages: {
            username: {
                required: "请输入用户名",
                maxlength : "请输入至少八位用户名"
            },
            password: {
                required: "请输入密码",
                maxlength : "密码至少为八位字符"
            }
        }
    })
});