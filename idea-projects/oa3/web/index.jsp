<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
</head>

<body>

<h2>LOGIN</h2>
<form action="user/login" method="post">
    <label for="username">userName: </label><input type="text" name="username" id="username"><br/>
    <label for="password">passWord: </label><input type="password" name="password" id="password"><br/>
    <label for="checkbox">十天内免登录: </label><input type="checkbox" name="f" value="1" id="checkbox"><br/>
    <input type="submit" value="login"><br/>
</form>
</body>

</html>
