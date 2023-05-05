<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>

<head lang="zh-CN">
    <meta charset="UTF-8">
    <title>details</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
</head>

<body>
    <h2>Welcome ${sessionScope.username}</h2>
    <h3>详情</h3>
    depno ${requestScope.dept.deptno}<br>
    dname ${requestScope.dept.dname}<br>
    loc ${requestScope.dept.loc}<br>
    <input type="button" value="后退" onclick="window.history.back()">
</body>

</html>