<%--
  Created by IntelliJ IDEA.
  User: 金鱼
  Date: 2021/10/15
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>获取提交信息</title>
</head>
<body>
<%String Name = request.getParameter("RdName");
    String Passwd = request.getParameter("RdPasswd");
    if (Name.equals("abcdef") && Passwd.equals("123456")){ %>
<jsp:forward page="3.jsp"/>
<%}else{
    response.sendRedirect("http://sohu.com");
}%>
</body>
</html>
