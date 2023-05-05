<%@page contentType="text/html; charset=UTF-8" %>

<%--
  JSP中EL表达式的隐含对象
    1、pageContext
    2、param
    3、paramValues
    4、initParam
    5、其他的
--%>
<%--从请求域中取数据--%>
<%--获取应用的根路径--%>
应用根路径: ${pageContext.request.contextPath}<br/>


<%--从请求域中去数据--%>
<%--request是JSP的九大内置对象之一--%>
<%--request.getParameter("username") 获取请求的参数--%>
<%--用户在浏览器上提交数据 http://localhost:8080/servlet15/8.jsp?username=mirror --%>
用户名: <%=request.getParameter("username")%><br/>
用户名: ${param.username}<br/>

http://localhost:8080/servlet15/8.jsp?username=mirror&aihao=ae&aihao=keep&aihao=java
<%--param 获取的是请求参数一维数组当中的第一个元素--%>
爱好: ${param.aihao}<br/>
爱好: <%=request.getParameter("aihao")%><br/>

一维数组 爱好: <%=request.getParameterValues("aihao")%><br/>
一维数组 爱好: ${paramValues.aihao}<br/>

爱好: ${paramValues.aihao[0]} ${paramValues.aihao[1]} ${paramValues.aihao[2]}<br/>

<%--EL表达式中的隐含对象 initParam--%>
<%--ServletContext是Servlet上下文对象 对应的是JSP九大内置对象之一: application--%>
pageSize: <%=application.getInitParameter("pageSize")%><br/>
pageNumber: <%=application.getInitParameter("pageNumber")%><br/>

<%--从应用域中取数据--%>
pageSize: ${initParam.pageSize}<br/>
pageNumber: ${initParam.pageNumber}<br/>


