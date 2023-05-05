<%@ page import="com.mirror.bean.User" %>
<%@ page import="com.mirror.bean.Address" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%--
    向作用域request中存数据
--%>
<%
    request.setAttribute("name","mirror");
    request.setAttribute("obj",new Object());
    User user = new User(20,"mirror","23333");
    user.setAddress(new Address("WuGang","yakou","462500"));
    request.setAttribute("userOne",user);
%>
<%--
    将request中数据取出来 并且输出到浏览器
--%>
<%=request.getAttribute("name")%>
<br>
${name}
<br/>
<%=request.getAttribute("obj")%>
<br/>
${obj}
<br/>
${userOne}
<br/>
${userOne.age}
<%--${userOne.Age}--%>
<br/>
${userOne.email}
<%--和属性无关 和get方法有关--%>
<br/>
${"userOne"}
<%--和直接输出字符串一样--%>
<br/>

${userOne.address}
<br/>
${userOne.address.zipcode}
<br/>
