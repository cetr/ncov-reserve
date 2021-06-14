<%--
  Created by IntelliJ IDEA.
  User: cetr
  Date: 13/06/21
  Time: 下午1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预约</title>
</head>
<body>
<form action="/subscribe" method="post">
    姓名: <input type="text" name="name" id="name"/><br>
    电话: <input type="text" name="phone" id="phone"><br>
    性别: <input type="radio" name="sex" value="b" checked="checked">男
    <input type="radio" name="sex" value="g">女<br>
    身份证: <input type="text" name="id_card" id="id_card"><br>
    <button type="submit">提交</button>
    <button type="reset">重置</button>
    <br>
    ${requestScope.info}
    ${requestScope.error}
</form>
</body>
</html>
