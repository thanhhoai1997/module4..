<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/29/2023
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Validation</title>
</head>
<body>
<h3 style="color: red">${message}</h3>

<form action="validate" method="post">
  <input type="text" name="email">
  <input type="submit" value="validate">
</form>

</body>
</html>
