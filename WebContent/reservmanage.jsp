<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新冠疫苗预约系统</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
</head>
<body>
<a href="/loginout">退出登录</a>
<div class="container" align="">
    <div style="width: 1000px">
        <form action="/findReservByIdcardTable" method="get">
            <label for="idCard">身份证号：</label><input id="idCard" style="width: 200px" name="id_card" type="text"/>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input style="margin-top: 9px" class="form-check-input" name="isEnd" type="checkbox" id="flexCheckDefault">
            <label class="form-check-label" for="flexCheckDefault">
                包含已接种
            </label>
            &nbsp;&nbsp;&nbsp;
            <button class="btn btn-outline-primary btn-sm" type="submit">查询</button>
        </form>
    </div>
</div>
<div class="container">
    <table border="1" cellpadding="10" cellspacing="0" class="table table-hover">
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
                <td><a href="/vaccinate?id=${reserve.id}">${reserve.isEnd == '1'?'':'接种'}</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>