<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 金鱼
  Date: 2021/10/27
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% request.setAttribute("height",168);%>

    <c:choose>
        <c:when test="${requestScope.height > 190}">
            <h2>小巨人</h2>
        </c:when>
        <c:when test="${requestScope.height >180}">
            <h2>很高</h2>
        </c:when>
        <c:when test="${requestScope.height >170}">
            <h2>还可以</h2>
        </c:when>
        <c:otherwise>
            <h2>剩下小于170</h2>
        </c:otherwise>
    </c:choose>
</body>
</html>
