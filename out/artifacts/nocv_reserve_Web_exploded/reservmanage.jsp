<%--
  Created by IntelliJ IDEA.
  User: cetr
  Date: 13/06/21
  Time: 下午3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>数据管理</title>
</head>
<body>
${sessionScope.session_info}
<a href="/loginout">退出登录</a>
<table border="1" cellpadding="10" cellspacing="0">
    <tr align="center">
        <td colspan="8">按身份证号查询：
            <form action="/findReservByIdcardTable" method="post">
                <input name="id_card" type="text"/>
                <button type="submit">查询</button>
            </form>
        </td>
    </tr>
    <tr align="center">
        <td>编号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>电话</td>
        <td>时间</td>
        <td>身份证号</td>
        <td>是否接种</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.reserveList}" var="reserve">
        <tr align="center">
            <td>${reserve.id}</td>
            <td>${reserve.name}</td>
            <td>${reserve.sex == 'g'?'女':'男'}</td>
            <td>${reserve.phone}</td>
            <td>${reserve.reserveTime}</td>
            <td>${reserve.idCard}</td>
            <td>${reserve.isEnd == '0'?'未接种':'已接种'}</td>
            <td><a href="/vaccinate?id=${reserve.id}">接种</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>