<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%
  request.setAttribute("data","request");
  pageContext.setAttribute("data","pageContext");
  session.setAttribute("data","session");
  application.setAttribute("data","application");
%>
${data}
<br>
<%--在EL表达式中可以通过隐含的隐式范围对象 指定范围取数据--%>
${pageScope.data}
<br/>
${requestScope.data}
<br/>
${sessionScope.data}
<br>
${applicationScope.data}
<br>
