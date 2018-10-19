$(function () {
    $.validator.addMethod("checkUsername", function (value, element, param) {
        if (/^[0-9a-zA-Z_\*\+\@\!\#]{8,15}$/.test(value.trim())) {
            return true;
        } else {
            return false;
        }
    }, "请输入最少八位字母(可包含_*+@!#)");

    $.validator.addMethod("checkNickname", function (value, element, param) {
        if (/(^[a-zA-Z]{4,10}$)|(^\S{2,4}$)/.test(value.trim())) {
            return true;
        } else {
            return false;
        }
    }, "请输入您的社区昵称(2-4个中文字符或4-10个字母)");

    //验证成功提交时的回调函数
    $.validator.setDefaults({
        submitHandler: function () {
            var json = $("#registerForm").serialize();
            $.ajax({
                url: "/FBlog/registerDeal",
                async: true,
                type: "POST",
                data: json,
                success: function (data) {
                    if (data === "success") {
                        alert("注册成功！");
                        $(window).attr("location", "/FBlog/");
                    } else {
                        alert(data);
                    }
                }
            })
        }
    })

    $("#registerForm").validate({
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
                checkUsername: true
            },
            password: {
                required: true,
                checkUsername: true
            },
            confirmPassword: {
                required: true,
                equalTo: "#password"
            },
            nickname: {
                required: true,
                checkNickname: true
            }
        },
        messages: {
            username: {
                required: "请输入用户名"
            },
            password: {
                required: "请输入密码",
                checkUsername: "请输入最少八位的密码"
            },
            confirmPassword: {
                required: "请再次输入您的密码",
                equalTo: "两次密码输入不一致"
            },
            nickname: {
                required: "请输入您的社区昵称",
            }
        }
    })
})


/**
 * 检查用户名是否已经被使用
 */
function checkUsername() {
    var username = $("#username").val();
    if (!(/^[0-9a-zA-Z_\*\+\@\!\#]{8,15}$/.test(username.trim()))) {
        return;
    }
    $.ajax({
        url: "/FBlog/checkUserIsExist",
        async: true,
        type: "POST",
        data: "username=" + username,
        success: function (data) {
            if (data === "用户名可以使用") {
                $("#usernameLabel").attr("class", "text-success");
                $("#usernameLabel").text(data);
            } else {
                $("#usernameLabel").attr("class", "text-danger");
                $("#usernameLabel").text(data);
            }
        }
    })
}

/**
 * 检查社区昵称是否已经被使用
 */
function checkNickname() {
    var nickname = $("#nickname").val();
    if (!(/(^[a-zA-Z]{4,10}$)|(^\S{2,4}$)/.test(nickname.trim()))) {
        return;
    }
    $.ajax({
        url: "/FBlog/checkNickname",
        async: true,
        type: "POST",
        data: "nickname=" + nickname,
        success: function (data) {
            if (data === "该社区昵称可以使用") {
                $("#nicknameLabel").attr("class", "text-success");
                $("#nicknameLabel").text(data);
            } else {
                $("#nicknameLabel").attr("class", "text-danger");
                $("#nicknameLabel").text(data);
            }
        }
    })
}