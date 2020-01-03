<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>首页</title>
    <style type="text/css">

    </style>
</head>
<body class="myElement" data="/SSM-WEB">
    <div>
        <input id="userName" name="userName" type="text" placeholder="请输入用户名"/>
        <input id="passWord" name="password" type="password" placeholder="请输入密码"/>
        <button onclick="doLogin()">提交</button>
    </div>

<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script>
    function doLogin(){
        let userName = $("#userName").val();
        let passWord = $("#passWord").val();
        if (!userName || !passWord) {
            alert("用户名或者密码不能为空");
            return ;
        }
        let userData = {
            userName : userName,
            passWord : passWord
        }

        $.ajax({
            type:'post',
            url:'doLogin',
            data: userData,
            success: function(data) {
                if (data.code == '200') {
                    //可跳转页面
                    alert('登录成功');
                } else {
                    alert(data.msg)
                }
            }
        })

    }

</script>
</body>
</html>