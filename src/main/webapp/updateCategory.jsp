<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <<c:import url="./common/header.html"></c:import>
    <title>Add Course</title>
</head>
<body class="container-fluid container-md">
    
    <c:import url="./common/nav.jsp"></c:import>
  
<h3 class="text-center mb-5">Update Category</h3>
<form action="category" method="post">
<input type="hidden" name="mode" value="UPDATE">
<input type="hidden" name="id" value="${category.id }">

  <div class="row g-3 mb-3">
    <div class="col-sm-12">
      <input type="text" name="categoryType" id="categoryType" class="form-control form-control-lg" value="${category.categoryType }">
    </div>
    <div class="row g-3 mb-3">
        <textarea  id="description" name="description" cols="30" rows="5" class="form-control form-control-lg ms-1">${category.description }</textarea>
    </div>
  </div>
  <div class="row mb-3">
    <button type="submit" class="btn btn-primary">Update Category</button>
</div>
</form>
<c:import url="./common/footer.html"></c:import>
</body>
</html>