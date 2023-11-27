<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.ddd.bean.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 金鱼
  Date: 2021/10/27
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <% List studentList = new LinkedList();
       for (int i = 0; i < 10; i++) {
           studentList.add(new Student(i,"chen"+i,"1223"+i,17+i,"32323232"+i));
       }
   %>
   <%request.setAttribute("stus",studentList);%>
       <table>
       <tr>
           <th>编号</th>
           <th>用户名</th>
           <th>密码</th>
           <th>年龄</th>
           <th>电话</th>
           <th>操作</th>
       </tr>
       <%--
       items 表示遍历的集合
       var 表示遍历到的数据
       begin 表示遍历的开始索引值
       end 表示结束的索引值
       step 属性表示遍历的步长值
       varStatus 属性表示当前遍历到的数据的状态
       for（int i = 1; i < 10; i+=2）
       --%>
       <c:forEach begin="2" end="7" step="2" varStatus="status"  items="${requestScope.stus}" var="stu">
           <tr>
               <td>${stu.id}</td>
               <td>${stu.username}</td>
               <td>${stu.password}</td>
               <td>${stu.age}</td>
               <td>${stu.phone}</td>
               <td>${status.step}</td>
           </tr>
       </c:forEach>
   </table>
</body>
</html>
