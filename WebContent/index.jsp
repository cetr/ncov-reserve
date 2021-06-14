<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <title>新冠疫苗预约</title>
    <meta charset="UTF-8">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"></script>
    <style>
        .form-div {
            float: left;
            width: 30%;
            margin-top: 50px;
            margin-left: 50px;
        }

        .map {
            float: left;
            width: 60%;
        }

        .container {
            margin-top: 100px;
        }

        .form-group {
            margin-top: 9px;
        }

        label {
            font-weight: bolder;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="map">
        <iframe id="n-map" src="https://www.lovestu.com/api/project/cnmapyinqing/obj.php" height="500" frameborder="no"
                border="0"
                width="100%">
        </iframe>
    </div>
    <div class="form-div">
        <h3>新冠疫苗预约</h3><br>
        <form action="/subscribe" method="post">
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" name="name" class="form-control" id="name" placeholder="请输入姓名">
            </div>
            <div class="form-group">
                <label for="phone">电话</label>
                <input type="text" class="form-control" name="phone" id="phone" placeholder="请输入电话">
            </div>
            <div class="form-group">
                <label for="exampleInputFile">性别</label>
                <input type="radio" name="sex" value="b" checked="checked">男
                <input type="radio" name="sex" value="g">女
            </div>
            <div class="form-group">
                <label for="id_card">身份证号码</label>
                <input type="text" class="form-control" name="id_card" id="id_card" placeholder="请输入身份证号码">
            </div>
            <div class="form-group">
                <label for="time">预约时间</label>
                <input type="datetime-local" class="form-control" name="res_time" id="time">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">立即预约</button>
                <button type="reset" class="btn btn-default">重置</button>
            </div>
            <p style="color:red;">
            ${requestScope.info}
            ${requestScope.error}
            </p>
        </form>
    </div>
</div>
</body>
<script>
</script>
</html>
