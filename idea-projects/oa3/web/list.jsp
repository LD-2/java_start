<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<heade>
    <meta charset="UTF-8">
    <title>list</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/list.css">
    <script type="text/javascript">
        function del(dno){
            if(window.confirm("确认删除!")){
                document.location.href="${pageContext.request.contextPath}/dept/delete?deptno="+dno;
            }else{
                document.location.href="${pageContext.request.contextPath}/dept/list";
            }
        }
    </script>
</heade>

<body>
<h2>Welcome ${sessionScope.username} <a href="user/exit">退出登入</a></h2>
<h4>OnLine: ${applicationScope.loginCount}</h4>
    <div id="tb">
        <table>
            <caption>部门列表</caption>
            <thead>
                <td><button class="add"><a href="add.jsp">增添部门</a></button></td>
                <tr>
                    <th>编号</th>
                    <th>部门编号</th>
                    <th>部门名称</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <%--jstl中for循环和if 中的对象都是存到域中的--%>
                <c:forEach items="${requestScope.list}" varStatus="deptListStatus" var="dept">
                    <tr>
                        <td>${deptListStatus.count}</td>
                        <td>${dept.deptno}</td>
                        <td>${dept.dname}</td>
                        <td>
                            <a href="dept/show?flag=update&deptno=${dept.deptno}" title="update">修改</a>
                            <a href="javascript:void(0)" onclick="del(${dept.deptno})" title="delete">删除</a>
                            <a href="dept/show?flag=details&deptno=${dept.deptno}" title="details">部门详情</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>

</html>