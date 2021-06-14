<%--
  Created by IntelliJ IDEA.
  User: cetr
  Date: 13/06/21
  Time: 下午12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理端</title>
</head>
<body>
<form action="/login" method="post">
    用户名: <input type="text" name="usernameOrPhone" id="username"/><br>
    密码: <input type="password" name="password" id="password"><br>
    <button type="submit">登录</button>
    <a href="register.jsp">
        <button type="button">去注册</button>
    </a>
    <br>
    ${requestScope.info}
    ${requestScope.error}
</form>
</body>
</html>
