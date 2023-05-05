<%@page contentType="text/html; charset=UTF-8" %>
<%--
  关于EL表达式中的运算符
    1、算术运算符
        + - * / %
    2、关系运算符
        == != > >= < <= eq
    3、逻辑运算符
        ! && || not and or
    4、条件运算符
        ? :
    5、取值运算符
        [] .
    6、empty 运算符

--%>

<%--EL表达式中的+只会进行求和运算 不会字符串拼接  否则会报错--%>
${10+20}<br>
${10+"20"}<br>
\${"abc"+"def"}<br>
\${"10"+"abc"}<br>

${"abc"=="abc"}<br> <%--true--%>
<%
    Object obj=new Object();
    request.setAttribute("obj1",obj);
    request.setAttribute("obj2",obj);
%>
${obj1==obj2}<br> <%--true--%>

<%
    String str1=new String("666");
    String str2=new String("999");
    request.setAttribute("str1",str1);
    request.setAttribute("str2",str2);
%>
${str1==str2}  <%--true--%> <%--本质调用的equals()方法--%>
<%
    Object obj1=new Object();
    Object obj2=new Object();
    request.setAttribute("o1",obj1);
    request.setAttribute("o2",obj2);
%>
${obj1==obj2} <%--false--%>

