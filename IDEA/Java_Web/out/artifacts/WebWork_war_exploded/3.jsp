<%--
  Created by IntelliJ IDEA.
  User: 金鱼
  Date: 2021/10/15
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>获取提交信息</title>
</head>
<body>
<% String Name = request.getParameter("RdName"); %>
欢迎，<%=Name%>成功登录！
</body>
</html>