<%--
  Created by IntelliJ IDEA.
  User: 金鱼
  Date: 2021/10/29
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            +"://"
            +request.getServerName()
            +":"+request.getServerPort()
            +request.getContextPath()
            +"/";
    pageContext.setAttribute("basePath", basePath );
%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/jQuery-1/jQuery.js"></script>
