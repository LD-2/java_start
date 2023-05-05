<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>add</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/add.css">
</head>

<body>
    <h2>Welcome ${sessionScope.username}</h2>
    <div class="container">
        <div class="add-box">
            <div class="left"></div>
            <div class="right">
                <h2>新增部门</h2>
                <form action="dept/add" method="post">
                    <p>部门编号<input type="text" class="field" placeholder="depno" name="deptno"></p>
                    <p>部门名称<input type="text" class="field" placeholder="dname" name="dname"></p>
                    <p>地理位置<input type="text" class="field" placeholder="loc" name="loc"></p>
                    <input type="submit" value="提交" class="sb">
                </form>
            </div>
        </div>
    </div>

</body>

</html>