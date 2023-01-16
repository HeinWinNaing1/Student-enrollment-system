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
    
    <h2 class="text-center m-5"> Course List </h2>
    <table  id="example" class="cell-border" style="width:100%">
        <thead>
            <tr>
                <th>Course Name</th>
                <th>Instructor</th>
                <th>Price</th>
                <th>Category</th>
                <th>Start date</th>
                <th>Period</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="course" items="${courseList }">

				<c:url var="updateLink" value="course">
					<c:param name="mode" value="LOAD"></c:param>
					<c:param name="id" value="${course.id }"></c:param>
				</c:url>
				<c:url var="deleteLink" value="course">
					<c:param name="mode" value="DELETE"></c:param>
					<c:param name="id" value="${course.id }"></c:param>
				
				</c:url>
				<c:url var="enrollLink" value="enroll">
					<c:param name="mode" value="CREATE"></c:param>
					<c:param name="id" value="${course.id }"></c:param>
				
				</c:url>
				<tr>
                <td>${course.courseName }</td>
                <td>${course.instructorName }</td>
                <td>${course.price } MMK</td>
                <td>${course.category }</td>
                <td>${course.startDate }</td>
                <td>${course.period }</td>
                <td>${course.description }</td>
                <c:if test="${fn:contains(user.role,'admin') }">
                <td>
                    <a href="${updateLink }" class="btn btn-primary my-1"><i class="fa-solid fa-pen-to-square"></i></a>
                    <a href="${deleteLink }" class="btn btn-danger " onclick="return confirm('Are you sure to delete this result?');"><i class="fa-solid fa-trash"></i></a>
                </td>
                </c:if>
                <c:if test="${fn:contains(user.role,'user') }">
                <td>
                    <a href="${enrollLink }" class="btn btn-primary">Enroll</a>        
                </td>
                </c:if>
            </tr>
            </c:forEach>
            
        </tbody>
        <tfoot>
            <tr>
              <th>Course Name</th>
              <th>Instructor</th>
              <th>Price</th>
              <th>Category</th>
              <th>Start date</th>
              <th>Period</th>
              <th>Descrition</th>
              <th>Action</th>
            </tr>
        </tfoot>
    </table>
    <c:import url="./common/footer.html"></c:import>
</body>
</html>