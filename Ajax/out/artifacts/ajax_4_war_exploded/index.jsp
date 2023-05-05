<%--
  Created by IntelliJ IDEA.
  User: LD
  Date: 2023/1/6
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <script type="text/javascript">
      let address={
        "city":"成都",
        "street":"太古里",
        "zipcode":"610016"
      }

      let user={
        "name":"mirror",
        "code":22,
        "sex":true,
        "age":20,
        "hpbbies":["code","ae","keep"],
        "address":{
          "city":"成都",
          "street":"太古里",
          "zipcode":"610016"
        }
      }

      console.log(user.address.city)
      console.log(user.name)
      console.log(user.sex?"男":"女")
    </script>
  </body>
</html>
