<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <title>update</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/update.css">
</head>

<body>
    <h2>Welcome ${sessionScope.username}</h2>
    <div class="container">
        <div class="update-box">
            <h2>Update</h2>
            <form action="${pageContext.request.contextPath}/dept/update" method="post">
                <div class="row">
                    <input type="text" id="dno" value="${requestScope.dept.deptno}" name="deptno" readonly>
                    <label for="dno">部门编号</label>
                </div>
                <div class="row">
                    <input type="text" id="dna" value="${requestScope.dept.dname}" name="dname">
                    <label for="dna">部门名称</label>
                </div>
                <div class="row">
                    <input type="text" id="lc" value="${requestScope.dept.loc}" name="loc">
                    <label for="lc">地理位置</label>
                </div>
                <div class="sb">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <input type="submit" value="修改">
                </div>
            </form>
        </div>
    </div>

</body>

</html>