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
    <input type="submit" name="+" value="Addition(+)" >
    <input type="submit" name="-" value="Subtraction(-)" >
    <input type="submit" name="*" value="Multiplication(X)" >
    <input type="submit" name="/" value="Division(/)" >

</form>



</body>
</html>