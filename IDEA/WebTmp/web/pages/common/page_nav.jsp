<%--
  Created by IntelliJ IDEA.
  User: 金鱼
  Date: 2021/11/7
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--分页代码--%>
<div id="page_nav">
    <%--大于首页才显示上一页--%>
    <c:if test="${requestScope.page.pageNumber>1}">
        <a href="${ requestScope.page.url }&pageNumber=1">首页</a>
        <a href="${ requestScope.page.url }&pageNumber=${requestScope.page.pageNumber-1}">上一页</a>
    </c:if>
    <%--页码输出的开始--%>
    <c:choose>
        <c:when test="${requestScope.page.pageTotal} <= 5">
            <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                <c:if test="${i == requestScope.page.pageNumber}">
                    【${i}】
                </c:if>
                <c:if test="${i != requestScope.page.pageNumber}">
                    <a href="${ requestScope.page.url }&pageNumber=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>
    </c:choose>


    <%--页码输出的结束--%>
    <%--到末页不显示下一页--%>
    <c:if test="${requestScope.page.pageNumber<requestScope.page.pageTotal}">
        <a href="${ requestScope.page.url }&pageNumber=${requestScope.page.pageNumber+1}">下一页</a>
        <a href="${ requestScope.page.url }&pageNumber=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${param.pageNumber}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">

    <script type="text/javascript">
        $(function () {
            $("#searchPageBtn").click(
                function () {
                    var pageNumber = $("#pn_input").val();
                    location.href = "${pageScope.basePath}${ requestScope.page.url }&pageNumber=" + pageNumber;
                });
        });
    </script>

</div>