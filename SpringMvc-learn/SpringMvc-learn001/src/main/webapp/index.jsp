<%--
  Created by IntelliJ IDEA.
  User: LD
  Date: 2023/2/26
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
"${pageContext.request.contextPath}/demo.action"
<a href="${pageContext.request.contextPath}/demo.action">访问服务器</a>
<a href="${pageContext.request.contextPath}/mirror01/demo.action">访问mirror01服务器</a>
<a href="${pageContext.request.contextPath}/mirror02/demo.action">访问mirror02服务器</a>
</body>
</html>
