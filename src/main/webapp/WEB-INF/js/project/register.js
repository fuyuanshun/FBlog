$(function () {
    $.validator.addMethod("validateName", function (value, element, param) {
        if (/^[0-9a-z_\*\+\@\!\#]{8,15}$/.test(value)) {
            return true;
        } else {
            return false;
        }
    }, "请输入最少八位字母(可包含_*+@!#)");

    //验证成功提交时的回调函数
    $.validator.setDefaults({
        submitHandler: function () {
            var json = $("#registerForm").serialize();
            console.info(json);
            $.ajax({
                url: "/FBlog/registerDeal",
                async: true,
                type: "POST",
                data: json,
                success: function (data) {
                    alert("success");
                }
            })
        }
    })

    $("#registerForm").validate({
        rules: {
            username: {
                required: true,
                validateName: true
            },
            password: {
                required: true
            },
            confirmPassword: {
                required: true,
                equalTo: "#password"
            },
            nickname: {
                required: true
            }
        },
        messages: {
            username: {
                required: "请输入用户名"
            },
            password: {
                required: "请输入密码",
            },
            confirmPassword: {
                required: "请再次输入您的密码",
                equalTo: "两次密码输入不一致"
            },
            nickname: {
                required: "请输入您的社区昵称"
            }
        }
    })
})