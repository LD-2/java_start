<%--
  Created by IntelliJ IDEA.
  User: LD
  Date: 2023/2/28
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<a href="${pageContext.request.contextPath}/req.ld"--%>
<h2>测试不同的请求提交方式</h2>
<form action="${pageContext.request.contextPath}/req.ld" method="get">
    <input type="submit" value="submit-get">
</form>
<form action="${pageContext.request.contextPath}/req.ld" method="post">
    <input type="submit" value="submit-post">
</form>
<br>
</form>
<br/>
<h3>单个数据提交</h3>
<form action="${pageContext.request.contextPath}/req01.ld" method="post">
    <input type="text" name = "name">name
    <br/>
    <input type="text" name = "age">age
    <br/>
    <input type="submit" value="submit01">
</form>
<br/>
<h3>对象封装数据提交</h3>
<form action="${pageContext.request.contextPath}/req02.ld" method="post">
    <input type="text" name = "name">name
    <br/>
    <input type="text" name = "age">age
    <br/>
    <input type="submit" value="submit01">
</form>
<br/>
<h3>动态占位符</h3>
<a href="${pageContext.request.contextPath}/req03/mirror/20.ld" >动态占位符提交</a>
<br/>
<form action="${pageContext.request.contextPath}/req04.ld" method="post">
    <input type="text" name = "name">name
    <br/>
    <input type="text" name = "age">age
    <br/>
    <input type="submit" value="submit04">
</form>
<br/>
<form action="${pageContext.request.contextPath}/req05.ld" method="post">
    <input type="text" name = "name">name
    <br/>
    <input type="text" name = "age">age
    <br/>
    <input type="submit" value="submit05">
</form>
</body>
</body>
</html>
