<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <c:import url="./common/header.html"></c:import>
    <title>Add Course</title>
</head>
<body class="container-fluid container-md">
   
   <c:import url="./common/nav.jsp"></c:import>
   
<h5 id="message" class="text-success ms-5">${message }</h5>
<h3 class="text-center mb-5">Add Course</h3>
<form action="course" method="Post">
<input type="hidden" name="mode" value="CREATE">
  <div class="row g-3 mb-3">
    <div class="col-md-6">
      <input type="text" name="courseName" id="courseName" class="form-control form-control-lg" placeholder="Enter course name" onfocus="allclear()" required>
    </div>
    <div class="col-md-6">
      <input type="text" name="instructorName" id="instructorName" class="form-control form-control-lg" placeholder="Enter Instructor name" required>
    </div>
  </div>
  <div class="row g-3 mb-3">
    <div class="col-md-6">
      <input type="number" name="price" id="price" class="form-control form-control-lg" placeholder="Enter price" required>
    </div>
    <div class="col-md-6">
      <select id="category" class="form-select form-select-lg" name="category" required>
       <c:forEach  var="category" items="${categoryList }">
        <option value="${category.categoryType }">${category.categoryType }</option>
        </c:forEach>
      </select>
    </div>
  </div>
  <div class="row g-3 mb-3">
    <div class="col-md-6">
      <input type="date" name="startDate" id="startDate" class="form-control form-control-lg" placeholder="Enter startDate" required>
    </div>
    <div class="col-md-6">
      <input type="text" name="period" id="period" class="form-control form-control-lg" placeholder="Enter period" required>
    </div>
  </div>
  <div class="row g-3 mb-3">
      <textarea name="description" id="description" cols="30" rows="5" class="form-control form-control-lg" placeholder="Enter Descrition" required></textarea>
  </div>
  <div class="row mb-3 d-grid col-sm-12 col-md-6 mx-auto">
    <button type="submit" onclick="add()" class="btn btn-primary" style="width:20rem">Add Course</button>
</div>
</form>
<c:import url="./common/footer.html"></c:import>

</body>
</html>