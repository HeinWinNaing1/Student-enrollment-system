<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="./common/header.html"></c:import>
    <title>Category</title>
</head>
<body class="container-fluid container-md">
    
    <c:import url="./common/nav.jsp"></c:import>
    
    <h2 class="text-center m-5">Category List</h2>
    <table  id="example" class="cell-border" style="width:100%;">
        <thead>
            <tr>
                <th>Category Name</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categoryList }">
        	<c:url var="updateLink" value="category">
        		<c:param name="mode" value="LOAD"></c:param>
        		<c:param name="id" value="${category.id }"></c:param>
        	
        	</c:url>
        	
        	<c:url var="deleteLink" value="category">
        		<c:param name="mode" value="DELETE"></c:param>
        		<c:param name="id" value="${category.id }"></c:param>
        	
        	</c:url>
            <tr>
                <td>${category.categoryType }</td>
                <td>${category.description }</td>
                <td>
                    <a href="${updateLink }" class="btn btn-primary ms-5">Update</a>
                    <a href="${deleteLink }" onclick="return confirm('Are you sure to delete');" class="btn btn-danger ms-2">Delete</a>
                </td>
            </tr>
            </c:forEach>
            
        </tbody>
        <tfoot>
            <tr>
                <th>Category Name</th>
                <th>Descrition</th>
                <th>Action</th>
            </tr>
        </tfoot>
    </table>
    <c:import url="./common/footer.html"></c:import>
</body>
</html>