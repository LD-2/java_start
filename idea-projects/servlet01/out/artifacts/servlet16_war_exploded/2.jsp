<%@ page import="com.mirror.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--for循环--%>
<%--begin开始--%>
<%--end结束--%>
<%--step步长--%>
<%--var变量--%>
<%--所以说底层是存到了某个域中 pageContext域中--%>
<c:forEach var="i" begin="1" end="10" step="2">
  ${i}
</c:forEach>
<hr/>


<%
  List<Student> list = new ArrayList<Student>();
  list.add(new Student(12,"ld"));
  list.add(new Student(20,"mirror"));

  request.setAttribute("list",list);
%>
<%--利用jstl标签库代替Java 遍历  其实底层还是Java语言  但是这里翻译后 有点乱没看懂--%>

<%--var这里代表集合中的每个Student对象 --%>
<%--varStatus表示var状态对象 是一个java对象 这个java对象代表了var的状态--%>
<%--varStatus中有count属性 可以直接使用 类似javaforEach 加强循环遍历中 外定义了一个 idx--%>
<c:forEach items="${list}" var="student" varStatus="suibian">
  ${suibian.count}
  age: ${student.age}
  name: ${student.name}
  <br/>
</c:forEach>
<hr/>