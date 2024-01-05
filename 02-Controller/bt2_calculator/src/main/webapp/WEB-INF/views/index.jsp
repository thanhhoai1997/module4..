<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculator" method="post">
    <input type="text" name="num1">
    <input type="text" name="num2">
    <br>
    <input type="submit" name="calculation" value="Addition(+)" >
    <input type="submit" name="calculation" value="Subtraction(-)" >
    <input type="submit" name="calculation" value="Multiplication(X)" >
    <input type="submit" name="calculation" value="Division(/)" >

</form>
<h3>Result Division : ${result}</h3>



</body>
</html>