<%--
  Created by IntelliJ IDEA.
  User: LD
  Date: 2023/2/28
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入jstl核心库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--导入jstl格式化标签库--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
show....
<br/>
${requestScope.date}
<br/>
<table width="800px" border="1">
    <tr>
        <th>性名</th>
        <th>生日</th>
    </tr>
    <c:forEach items="${list}" var="stu">
        <tr>
            <td>${stu.name}</td>
            <td>${stu.birth}----<fmt:formatDate value="${stu.birth}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
