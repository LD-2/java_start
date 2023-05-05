<%--
  Created by IntelliJ IDEA.
  User: LD
  Date: 2023/2/28
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    <script src="js/jquery_min_3.2.1.js"/>--%>
</head>
<body>
<a href="${pageContext.request.contextPath}/show01.action">请求转发页面（默认）</a><br/>
<a href="${pageContext.request.contextPath}/show02.action">请求转发action</a><br/>
<a href="${pageContext.request.contextPath}/show03.action">重定向页面</a><br/>
<a href="${pageContext.request.contextPath}/show04.action">重定向action</a><br/>
<a href="${pageContext.request.contextPath}/show05.action">随便跳</a><br/>

<a href="${pageContext.request.contextPath}/showdata.action">showdata</a><br/>

<form action="${pageContext.request.contextPath}/mydate.action">
    日期<input type="date" name="mydate"><br/>
    <input type="submit" value="提交">
</form>
<br/>
<a href="${pageContext.request.contextPath}/ll/list.action">show list</a>
</body>
</html>
