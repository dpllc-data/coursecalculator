<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="style.css">
    <title>Time Remaining</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.8.0/html2pdf.bundle.min.js"></script>

</head>
<%
    String course = request.getParameter("courseName");
%>
<body>
<jsp:useBean id="results" scope="request" type="java.util.List"/>
<h1><%= course %> Time Left in Course Estimator</h1>

<div class="adjust-line-height">
    <h4>We all work at different speeds, so use this as a relative tool, not an absolute statement of time left
        in the course.</h4>
    <h4>Make adjustments to these numbers if you see yourself working faster or slower than what is estimated.
        This calculator leaves out any collaboration assessments as they are optional.</h4>

    <br>


    <%-- <c:forEach var = "x" items = "${results}"> --%>
    <h3> <c:out value = "${line1}" /> </h3> <%--@elvariable id="line1" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line2}" /> </h3> <%--@elvariable id="line2" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line17}" /> </h3> <%--@elvariable id="line17" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line3}" /> </h3> <%--@elvariable id="line3" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line4}" /> </h3> <%--@elvariable id="line4" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line17}" /> </h3>
    <h3> <c:out value = "${line5}" /> </h3> <%--@elvariable id="line5" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line6}" /> </h3> <%--@elvariable id="line6" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line7}" /> </h3> <%--@elvariable id="line7" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line17}" /> </h3>
    <h3> <c:out value = "${line8}" /> </h3> <%--@elvariable id="line8" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line9}" /> </h3> <%--@elvariable id="line9" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line10}" /> </h3> <%--@elvariable id="line10" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line17}" /> </h3>
    <h3> <c:out value = "${line11}" /> </h3> <%--@elvariable id="line11" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line12}" /> </h3> <%--@elvariable id="line12" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line13}" /> </h3> <%--@elvariable id="line13" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line17}" /> </h3>
    <h3> <c:out value = "${line14}" /> </h3> <%--@elvariable id="line14" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line15}" /> </h3> <%--@elvariable id="line15" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line16}" /> </h3> <%--@elvariable id="line16" type="com.eliteteachlearn.request"--%>
    <h3> <c:out value = "${line17}" /> </h3>
    <%-- </c:forEach> --%>
    <br>
    <a href="index.jsp">Go Back</a>


</div>
</body>
</html>
