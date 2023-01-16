<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="./common/header.html"></c:import>
    <title>Student List</title>
</head>
<body class="container-fluid container-md">
    <c:import url="./common/nav.jsp"></c:import>
    <h2 class="text-center m-5">Register Student List</h2>
    <table  id="example" class="cell-border" style="width:100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Created Date</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${userList }">
            <tr>
                <td>${student.username } </td>
                <td>${student.email }</td>
                <td>${student.createDate }</td>
                
            </tr>
            </c:forEach>
            
        </tbody>
        <tfoot>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Created Date</th>
            </tr>
        </tfoot>
    </table>
    <c:import url="./common/footer.html"></c:import>
</body>
</html>