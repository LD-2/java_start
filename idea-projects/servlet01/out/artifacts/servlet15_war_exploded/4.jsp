<%@ page import="com.mirror.bean.User" %>
<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%
    User user = new User();
    user.setUserName("mirror");
    request.setAttribute("user",user);

    request.setAttribute("com.mirror","mirror");
%>


<%--两种取得属性值的方法--%>
${user.userName}
<br/>
${user["userName"]}
<br/>
${com.mirror}
<br/>
${requestScope["com.mirror"]}
<br/>