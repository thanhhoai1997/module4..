<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/24/2023
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet" >
    <script src="webjars/bootstrap/5.3.2/js/bootstrap.bundle.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<div align="center">
    <a href="/new" class="btn btn-primary">Create</a>
    <table class="table table-striped">
        <tr>
            <th>Code</th>
            <th>Name</th>
            <th>Price</th>
            <th>Delete</th>

        </tr>
        <c:forEach var="p" items="${products}">
            <tr>
                <td>${p.code}</td>

                <td><a href="/view?id=${p.id}">${p.name}</a> </td>
                <td>${p.price}</td>
                <td><a class="btn bg-danger" href="/delete?id=${p.id}">Delete</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
