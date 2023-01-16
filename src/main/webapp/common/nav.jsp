<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<nav class="navbar navbar-dark bg-light shadow-sm p-3 mb-5 bg-body rounded  mb-4">
<c:url var="loadToAdd" value="category">
	<c:param name="mode" value="ADD"></c:param>

</c:url>
<c:url var="showRegisterStudent" value="user">
	<c:param name="mode" value="SHOW"></c:param>

</c:url>
            <h3 class="text-dark">
                Student Enrollment
            </h3>
            <ul class="nav" >
                <li class="nav-item">
                  <a class="nav-link"  href="home.jsp">Home</a>
                </li>
                 <c:if test="${fn:contains(user.role,'admin') }">
                <li class="nav-item">
                  <a class="nav-link" href="${showRegisterStudent }">Register Students</a>
                </li>
                </c:if>
                 <c:if test="${fn:contains(user.role,'admin') }">
                <li class="nav-item">
                    <a class="nav-link" href="enroll">Enroll Students</a>
                  </li>
                  </c:if>
                   <c:if test="${fn:contains(user.role,'user') }">
                  <li class="nav-item">
                    <a class="nav-link" href="course">Course</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="enroll">My Enroll Lists</a>
                  </li>
                  </c:if>
                   <c:if test="${fn:contains(user.role,'admin') }">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Course Category</a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="addCategory.jsp">Add Category</a></li>
                      <li><a class="dropdown-item" href="category">Category</a></li>
                    </ul>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Course</a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="${loadToAdd }">Add Course</a></li>
                      <li><a class="dropdown-item" href="course">Course</a></li>
                    </ul>
                  </li>
                  </c:if>
              </ul>
            <ul class="nav nav-pills">
                  <li class="nav-item ">
                    <a class="nav-link active mx-1" aria-current="page" href="course?mode=LOGOUT">Logout</a>
                  </li>
                  <c:if test="${fn:contains(user.role,'admin') }">
                <li class="nav-item">
                  <span class="fs-5 m-3 text-primary">(Admin)</span>
                </li>
                </c:if>
                <c:if test="${fn:contains(user.role,'user') }">
                <li class="nav-item">
                  <span class="fs-5 m-3 text-primary">Hi. ${user.username}</span>
                </li>
                </c:if>
              </ul>
    </nav>