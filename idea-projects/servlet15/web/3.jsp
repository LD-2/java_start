<%@ page import="com.mirror.bean.User" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%
    User user = new User();
    user.setUserName("mirror");
    request.setAttribute("user",user);
%>

<%=request.getAttribute("user")%>
<br>
<%=request.getAttribute("uuser")%>
<br>
${user}
<br>
<%--EL表达式主要任务是做页面展示 要求最终页面展示上是友好的--%>
<%--所以EL表达式对null进行了处理 如果是null 则在浏览器上显示空白--%>
${uuser}  这个el表达式等同于 <%=request.getAttribute("uuser")==null?"":request.getAttribute("uuser")%>
