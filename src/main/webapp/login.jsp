<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/login.css" rel="stylesheet">
<link rel="stylesheet" href="static/css/base.css">
<body>
<div class="header">
    <h1>图书管理系统</h1>
</div>
<div class="container">


    <div class="form-login">
        <form class="form-horizontal" action="${pageContext.request.contextPath}/LoginServlet" method="post">
            <div class="form-group">
                <label for="inputUsername" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputUsername" placeholder="请输入用户名" name="username">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword" placeholder="请输入密码" name="password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-1">
                    <button type="submit" class="btn btn-default">登陆</button>
                </div>
            </div>
        </form>
        <div style="color: red">${requestScope.msg}</div>
    </div>
</div>
</body>
</html>
