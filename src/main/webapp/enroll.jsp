<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="./common/header.html"></c:import>
    <title>data table</title>
</head>
<body class="container-fluid container-md">

    <c:import url="./common/nav.jsp"></c:import>
    <c:if test="${fn:contains(user.role,'user') }">
    <h2 class="text-center m-5"> My Enroll List </h2>
    </c:if>
    <c:if test="${fn:contains(user.role,'admin') }">
    <h2 class="text-center m-5"> Enroll Students </h2>
    </c:if>
    <table  id="example" class="cell-border" style="width:100%">
        <thead>
            <tr>
                <th>Course Name</th>
                <th>Student Name</th>
                <th>Email</th>
                <th>Enroll Date</th>
            </tr>
        </thead>
        <tbody>
        <c:if test="${fn:contains(user.role,'admin') }">
        <c:forEach var="enroll" items="${enrollList }">
				<tr>
                <td>${enroll.courseName }</td>
                <td>${enroll.studentName }</td>
                <td>${enroll.email }</td>
                <td>${enroll.enrollDate }</td>
            </tr>
            </c:forEach>
            </c:if>
            <c:if test="${fn:contains(user.role,'user') }">
            <c:forEach var="enrollList" items="${enrollByEmail }">
				<tr>
                <td>${enrollList.courseName }</td>
                <td>${enrollList.studentName }</td>
                <td>${enrollList.email }</td>
                <td>${enrollList.enrollDate }</td>
            </tr>
            </c:forEach>
            </c:if>
        </tbody>
        <tfoot>
            <tr>
              <th>Course Name</th>
                <th>Student Name</th>
                <th>Email</th>
                <th>Enroll Date</th>
            </tr>
        </tfoot>
    </table>
    <c:import url="./common/footer.html"></c:import>
</body>
</html>