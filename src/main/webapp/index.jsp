<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="style.css">
    <title>Course Time Left Calculator</title>
</head>

<body>
<h1>Course Time Left Calculator</h1>
<br>
<p style="Font-family:'Arial',sans-serif; Font-size:18px; color:black;">
    IMPORTANT: Please take the time to consider that all students tend to work at different speeds.
    <br><br>
    Note: This calculator only serves to give you a basis upon which to estimate your time left
    in the course. If you find that you are consistently taking more time than what is
    estimated, then make adjustments to these estimates.</p>
<p></p>

    <br>

    <form action="${pageContext.request.contextPath}/calculate" method="post">
        <p style="Font-family:'Arial Black',sans-serif; Font-size:18px; color:black;">
    Step 1: Select your course
            <br>
            <label>
                <select name = "courseName">
                    <option>APCSA1</option>
                    <option>APCSA2</option>
                    <option>DIT1</option>
                    <option>DIT2</option>
                    <option>FOP1</option>
                    <option>FOP2</option>

                </select>
            </label>
            <br>
        <br>
    <p style="Font-family:'Arial Black',sans-serif; Font-size:18px; color:black;">
    Step 2: Please enter the last section that you completed (Ex: 02.10)
    <br>
    New students should enter: 00.00</p>
        <label>
            <input type="text" name="lastSect" placeholder="Enter Last Section Submitted" minlength="5" maxlength="5"
                   pattern="^[0,1]\d.\d\d"  required  data-error="You must enter a valid assignment number usually starting with 0.">
        </label>
        <input type="submit" value="Calculate Time" name = "submit">



</form>
</body>

</html>