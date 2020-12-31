<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>用户登录</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/floating-labels/">

    <!-- Bootstrap core CSS -->
    <link href="/static/bootstrap-4.5.3-examples/assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="/static/bootstrap-4.5.3-examples/floating-labels/floating-labels.css" rel="stylesheet">

    <SCRIPT type="text/javascript">

        function checkForm() {
            var username = $("#username").val();
            var password = $("#password").val();
            if (username == null || username == "") {
                $("#error").html("用户名不能为空！");
                return false;
            }
            if (password == null || password == "") {
                $("#error").html("密码不能为空！");
                return false;
            }
            return true;
        }
    </SCRIPT>
</head>
<body>
<%--<form action="${pageContext.request.contextPath}/loginUser" method="post" onsubmit="return checkForm()">--%>
<form class="form-signin" action="${pageContext.request.contextPath}/loginUser" method="post"
      onsubmit="return checkForm()">
    <div class="text-center mb-4">
        <img class="mb-4" src="/static/bootstrap-4.5.3-examples/assets/brand/bootstrap-solid.svg" alt="" width="72"
             height="72">
        <h1 class="h3 mb-3 font-weight-normal">用户登录</h1>
        <p></a></p>
    </div>
<%--这里使用了input type="email"进行判别是否是邮箱的格式--%>
<%--  <label for=""> 中for的作用是和哪个表单元素绑定 --%>
<%--    <label for="inputEmail">则是与<input type="text" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>来进行绑定--%>
    <div class="form-label-group">
        <input type="text" id="username" name="username" class="form-control" placeholder="Email address" required autofocus>
        <label for="username">请输入用户名</label>
    </div>

    <div class="form-label-group">
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        <label for="password">请输入密码</label>
    </div>

    <div>
        <h6><a href="/index">首页</a></h6>
        <span><font color="red" id="error">${errorInfo }</font></span>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    <p class="mt-5 mb-3 text-muted text-center">&copy; 2017-2020</p>
</form>
</body>
</html>
