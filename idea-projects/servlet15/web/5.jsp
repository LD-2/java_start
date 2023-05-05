<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.mirror.bean.User" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%
  Map<String,String> map=new HashMap<String,String>();
  map.put("name","mirror");
  map.put("password","123456");
  request.setAttribute("map",map);

  Map<String, User> map2=new HashMap<String, User>();
  User user = new User();
  user.setUserName("mirror");
  map2.put("user",user);
  request.setAttribute("map2",map2);
%>

${map.name} ${map.password}
<br/>
${map2.user.userName}
