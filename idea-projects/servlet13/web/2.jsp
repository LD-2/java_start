<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        int mirror=22;
        out.print(mirror);
        String str="只可以字符串吗？ 怎么设置数字也可以输出呢";
        out.write(str);

        int a=2;
        System.out.println(a      );

    %>
    <%=200%>
    <br/>
  <%System.out.println("My First JSP...");%>
  System.out.println("My First JSP...");

    <a href="<%=request.getContextPath()   %>/1.jsp">1.jsp</a>
<%
    int a=200;
    int b=300;
    int c=a+b;
%>

<%="c="+c%>


<%

%>
</body>
</html>
