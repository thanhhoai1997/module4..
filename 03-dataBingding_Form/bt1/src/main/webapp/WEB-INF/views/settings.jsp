<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/1/2024
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="mail/update" method="post" modelAttribute="mail">
    <form:hidden path="id"/>
    <form:label path="language">Languages</form:label>
    <form:select path="language">
        <form:options items="${listLanguages}"/>
    </form:select>
    <br>
    <form:label path="pageSize">Page Size</form:label>
    <form:select path="pageSize">
        <form:options items="${listPageSize}"/>
    </form:select>
    <br>

    <form:label path="spamsFilter">Spams filter</form:label>
    <form:checkbox path="spamsFilter" value="true" disabled="disabled"/>Enable spams fillter
    <br>
    <form:label path="signature">Signature</form:label>
    <form:textarea path="signature"/>
    <br>
    <form:button>Update</form:button>
    <input type="reset" value="Cancel">
</form:form>
<h3>${message}</h3>

</body>
</html>
