<%--
  Created by IntelliJ IDEA.
  User: 金鱼
  Date: 2021/10/15
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>

<!-- ch03_2_Javalet.jsp   -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>自动刷新</title>
</head>
<body>
当前时间是：<%=new Date().toLocaleString()%><br>
<hr>
<%response.setHeader("refresh","1");%>
</body>

</html>
