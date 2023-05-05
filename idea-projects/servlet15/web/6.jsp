<%@ page import="com.mirror.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@page contentType="text/html; charset=UTF-8" isELIgnored="true" %>
<%
  String[] strs={"lala","haha"};
  request.setAttribute("strs",strs);

  User[] users={new User(12,"ld","haha"),new User()};
  request.setAttribute("users",users);

  List<String> list=new ArrayList<>();
  list.add("first");
  list.add("second");
  request.setAttribute("list",list);

  Set<String> set=new HashSet<>();
  set.add("first");
  set.add("second");
  request.setAttribute("set",set);
%>

<%--越界不显示而已--%>
${strs} ${strs[0]} ${strs[1]} ${strs[100]}
<br/>
${users[0].userName} ${users[1].userName} 空不显示
<br/>
${list} ${list[0]} ${list[1]}
<br/>
${set}
<%--${set[0]} ${set[1]}--%>

