<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<div style="margin-left: 20%" class="col-md-6" >
    <a href="/products">Back To My List Products</a>
    <form:form cssClass="form-control" method="post" action="/update?id=${product.id}" modelAttribute="product">

        <form:label path="code">Code</form:label>
        <form:input cssClass="form-control" path="code"/>
        <br>
        <form:label path="name">Name</form:label>
        <form:input cssClass="form-control" path="name"/>
        <br>
        <form:label path="price">Price</form:label>
        <form:input cssClass="form-control" path="price"/>
        <br>
        <form:button>Update</form:button>



    </form:form>
    <h2>${message}</h2>

</div>

</body>
</html>
