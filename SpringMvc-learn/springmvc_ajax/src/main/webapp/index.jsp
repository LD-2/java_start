<%--
  Created by IntelliJ IDEA.
  User: LD
  Date: 2023/2/28
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery_min_3.2.1.js"/>
</head>
<body>
<a href="javascript:showStu()">访问服务器返回学生集合</a><br/>
<div id="mydiv">等待服务器返回数据</div>
<script type="text/javascript">
    function showStu(){
        $.ajax({
            url:"${pageContext.request.contextPath}/list.action",
            type:"get",
            dataType:"json",
            success:function(stuList){
                var s="";
                $.each(stuList,function (i,stu){
                    s+=stu.name+"-----"+stu.age+"<br/>";
                });
                $("#mydiv").html(s);
            }
        });
    }
</script>
</body>
</html>
