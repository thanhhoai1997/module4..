<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/11/2023
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Phuc Vu Cuong</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.3.2/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
</head>
<body>
<div align="center">
    <caption><h2>TIỀN QUỸ <h1>PHỤC VỤ CƯỜNG 2023</h1> </h2></caption>
    <table>
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Tháng 1</th>
            <th>Tháng 2</th>
            <th>Tháng 3</th>
            <th>Tháng 4</th>
            <th>Tháng 5</th>
            <th>Tháng 6</th>
            <th>Tháng 7</th>
            <th>Tháng 8</th>
            <th>Tháng 9</th>
            <th>Tháng 10</th>
            <th>Tháng 11</th>
            <th>Tháng 12</th>

        </tr>
        <c:forEach items="${tienquy}" var="t">
            <td>${t.id}</td>
            <td>${t.name}</td>
            <c:if test="${t.thang1 != 0}">
                <td>Đã Nộp</td>
            </c:if>
            <c:if test="${t.thang2 != 0}">
                <td>Đã Nộp</td>
            </c:if>
            <c:if test="${t.thang3 != 0}">
                <td>Đã Nộp</td>
            </c:if>
            <c:if test="${t.thang4 != 0}">
                <td>Đã Nộp</td>
            </c:if>
            <c:if test="${t.thang5 != 0}">
                <td>Đã Nộp</td>
            </c:if>
            <c:if test="${t.thang6 != 0}">
                <td>Đã Nộp</td>
            </c:if>
            <c:if test="${t.thang7 != 0}">
                <td>Đã Nộp</td>
            </c:if>
            <c:if test="${t.thang8 != 0}">
                <td>Đã Nộp</td>
            </c:if>
            <c:if test="${t.thang9 != 0}">
                <td>Đã Nộp</td>
            </c:if>
            <c:if test="${t.thang10 != 0}">
                <td>Đã Nộp</td>
            </c:if>
            <c:if test="${t.thang11 != 0}">
                <td>Đã Nộp</td>
            </c:if>
            <c:if test="${t.thang12 != 0}">
                <td>Đã Nộp</td>
            </c:if>


        </c:forEach>
    </table>
</div>

</body>
</html>
