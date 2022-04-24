<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="style.css">
    <title>APCSA Estimated Time Left Calculator</title>
</head>

<body>
<h1>APCSA Estimated Time Left Calculator</h1>
<br>
<p style="Font-family:'Arial',sans-serif; Font-size:18px; color:black;">
    IMPORTANT: Please take the time to consider that all students tend to work at different paces.
    <br><br>
    Note: This calculator only serves to give you a basis upon which to estimate your time left
    in the course. If you find that you are consistently taking more time than what is
    estimated, then make adjustments to these estimates.</p>
<p></p>
<p style="Font-family:'Arial Black',sans-serif; Font-size:18px; color:black;">
    DIRECTIONS: Please enter the last section that you completed (Ex: 02.10)
    <br>
    New students should enter: 00.00</p>
<form action="${pageContext.request.contextPath}/calculate" method="post">
    <input type="text" name="lastSect" placeholder="Enter Last Section Submitted">
    <input type="submit" value="Calculate Time">

</form>
</body>

</html>