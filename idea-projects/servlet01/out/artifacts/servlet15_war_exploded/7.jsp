<%@page contentType="text/html; charset=UTF-8" %>


<%=pageContext.getRequest()%>
<%=request%>
<hr>

<%--
    在el表达式中没有request这个隐式对象
    requestScope 这个只代表请求范围 不等同于request对象
    有pageContext这个隐式对象
    因此可以通过调用pageContext.getRequest()方法 再去调用request的方法
    el表达式中隐式对象pageContext和JSP九大内置对象中的是一个
--%>


<%--强转一下 因为servletRequest的没有获取根路径的方法--%>
<%=((HttpServletRequest)pageContext.getRequest()).getContextPath()%>
<br/>
${pageContext.request.contextPath}