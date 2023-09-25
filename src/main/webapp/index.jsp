<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
<h1>Calculator</h1>
<form action="hello-servlet" method="post">
    <label for="num1">Enter 1st number:</label>
    <input type="text" id="num1" name="num1">
    <br>
    <label for="num2">Enter 2nd number:</label>
    <input type="text" id="num2" name="num2" >
    <br>
    <label for="operation">Enter operation: Example(+, -, *, /)</label>
    <input type="text" id="operation" name="operation">
    <br>
    <input type="submit" value="Calculate">
</form>
</div>
</body>
</html>