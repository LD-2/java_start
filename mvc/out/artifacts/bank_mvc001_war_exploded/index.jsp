<%@page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <meta charset="UTF-8" />
        <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    </head>

    <body>
        <form action="transfer" method="post">
            转入账户名: <input name="toact" type="text"><br>
            转出账户名: <input name="fromact" type="text"><br>
            转账金额: <input name="account" type="text"><br>
            <input type="submit" value="转账"><br>
        </form>
    </body>
</html>