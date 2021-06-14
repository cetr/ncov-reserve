<%--
  Created by IntelliJ IDEA.
  User: cetr
  Date: 13/06/21
  Time: 下午12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="/register" method="post">
    电话: <input type="text" name="phone" id="phone"/><br>
    用户名: <input type="text" name="username" id="username"/><br>
    密码: <input type="password" name="password" id="password"><br>
    <button type="submit">注册</button>
    <a href="admin.jsp">
        <button type="button">去登录</button>
    </a>
    <br>
    ${requestScope.info}
    ${requestScope.error}
</form>
</body>
</html>
