<%--
  Created by IntelliJ IDEA.
  User: 金鱼
  Date: 2021/10/27
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="upload" enctype="multipart/form-data" method="post">
        用户名：<input type="text" name="username" /> <br>
        头像：<input type="file" name="photo"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
