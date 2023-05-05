<%@ page import="com.mirror.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html; charset=UTF-8" %>

<%--引入JSTL标签库--%>

<%--引入JSTL标签库 这里引入的是JSTL的核心标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--格式化标签库，专门负责格式化操作--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%--sql标签库--%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%
    List<Student> list = new ArrayList<Student>();
    list.add(new Student(12,"ld"));
    list.add(new Student(20,"mirror"));

    request.setAttribute("list",list);
%>

<%--将list集合中的元素遍历 输出道浏览器--%>
<%--java语言遍历--%>
<%
    List<Student> l = (List<Student>)request.getAttribute("list");
    for (Student student : l) {
%>
        age: <%=student.getAge()%>
        name: <%=student.getName()%>
        <br/>
<%
    }
%>
<hr/>
<%--利用jstl标签库代替Java 遍历  其实底层还是Java语言  但是这里翻译后 有点乱没看懂--%>
<c:forEach items="${list}" var="student">
    age: ${student.age}
    name: ${student.name}
    <br/>
</c:forEach>
