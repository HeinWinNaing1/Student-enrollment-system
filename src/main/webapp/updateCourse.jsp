<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <c:import url="./common/header.html"></c:import>
    <title>Update Course</title>
</head>
<body class="container-fluid container-md">
    <c:import url="./common/nav.jsp"></c:import>
<h4 id="message"></h4>
<h3 class="text-center mb-5">Update Course</h3>

<form action="course" method="Post">
<input type="hidden" name="mode" value="UPDATE">
<input type="hidden" name="id" value="${course.id }">
  <div class="row g-3 mb-3">
    <div class="col-md-6">
      <input type="text" name="courseName" id="courseName" class="form-control form-control-lg" value="${course.courseName }">
    </div>
    <div class="col-md-6">
      <input type="text" name="instructorName" id="instructorName" class="form-control form-control-lg" value="${course.instructorName }">
    </div>
  </div>
  <div class="row g-3 mb-3">
    <div class="col-md-6">
      <input type="number" name="price" id="price" class="form-control form-control-lg" value="${course.price }">
    </div>
    <div class="col-md-6">
      <select id="category" class="form-select form-select-lg" name="category">
       <c:forEach  var="category" items="${categoryList }">
        <option value="${category.categoryType }">${category.categoryType }</option>
        </c:forEach>
      </select>
    </div>
  </div>
  <div class="row g-3 mb-3">
    <div class="col-md-6">
      <input type="date" name="startDate" id="startDate" class="form-control form-control-lg" value="${ course.startDate}">
    </div>
    <div class="col-md-6">
      <input type="text" name="period" id="period" class="form-control form-control-lg" value="${course.period }">
    </div>
  </div>
  <div class="row g-3 mb-3">
      <textarea name="description" id="description" cols="30" rows="5" class="form-control form-control-lg">${course.description}</textarea>
  </div>
  <div class="row mb-3 d-grid col-sm-12 col-md-6 mx-auto">
    <button type="submit"  class="btn btn-primary" style="width:20rem">Update Course</button>
</div>
</form>
<c:import url="./common/footer.html"></c:import>
</body>
</html>