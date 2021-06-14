<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>新冠疫苗预约系统 - 管理端</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
    <style>
        .con {
            width: 1200px;
            height: 380px;
            margin: 200px auto;
        }

        .form-div {
            float: left;
            width: 500px;
            margin-left: 50px;
        }

        .form-group {
            margin-top: 9px;
        }

        .img {
            float: left;
        }

        label {
            font-weight: bolder;
        }
    </style>
</head>
<body>
<div class="con">
    <div class="img"><img
            src="https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2021%2F0612%2F026e2611p00qulguj001yd200u000gvg00it00ak.png&thumbnail=650x2147483647&quality=80&type=jpg">
    </div>
    <div class="form-div">
        <h3>新冠疫苗预约系统 - 注冊</h3><br>
        <form action="/register" method="post">
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="text" name="username" id="username" class="form-control"/><br>
            </div>
            <div class="form-group">
                <label for="username">电话</label>
                <input type="text" name="phone" id="phone" class="form-control"/><br>
            </div>
            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" name="password" class="form-control" id="password">
            </div>
            <div class="form-group" style="margin-top: 20px">
                <button type="submit" class="btn btn-primary">注册</button>
                <a href="register.jsp">
                    <button type="button" class="btn btn-default">已有账号? 去登录</button>
                </a>
            </div>
            <p style="color:red;">
                ${requestScope.info}
                ${requestScope.error}
            </p>
        </form>
    </div>
</div>
</body>
</html>