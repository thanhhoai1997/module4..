<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/31/2023
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="addEmployee" method="post" modelAttribute="employee">
  <table>
    <tr>
      <td><form:label path="id">Employee ID : </form:label></td>
      <td><form:input path="id"/></td>
    </tr>
    <tr>
      <td><form:label path="name">Employee Name :</form:label></td>
      <td><form:input path="name"/></td>
    </tr>
    <tr>
      <td><form:label path="contactNumber">Contact Number</form:label></td>
      <td><form:input path="contactNumber"/></td>
    </tr>
    <tr>
      <td><input:button value="Submit"/></td>
    </tr>
  </table>

</form:form>

</body>
</html>
