<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 金鱼
  Date: 2021/10/27
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%request.setAttribute("object",new String[]{"323232323","#323233","323344343"});%>

    <c:forEach items="${requestScope.object}" var="q">
        ${q}<br>
    </c:forEach>

    <%
        Map<String, Object> map= new HashMap<String, Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        request.setAttribute("map",map);
    %>
    <c:forEach items="${requestScope.map}" var="ss">
        ${ss}<br>
    </c:forEach>
</body>
</html>
