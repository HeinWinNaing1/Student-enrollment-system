<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <title>Login</title>
    <link rel="stylesheet" href="./css/style.css">
</head>
<body class="container-fluid container-md ">
    <nav class="navbar navbar-dark bg-light shadow-sm p-3 mb-5 bg-body rounded  mb-4">
        <h3 class="text-dark">
            Student Enrollment
        </h3>
        <ul class="nav" >
            <li class="nav-item">
              <a class="nav-link"  href="index.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"  href="index.jsp">About us</a>
              </li>
              <li class="nav-item">
                <a class="nav-link"  href="index.jsp">Contant us</a>
              </li>
            </ul>
        <ul class="nav nav-pills">
              <li class="nav-item ">
                <a class="nav-link active mx-1" aria-current="page" href="login.html">Login</a>
              </li>
          </ul>
</nav>
<h2 class="text-center m-5">Login</h2>

    <form class="mt-5" action="login" method="post">
    <c:if test="${loginFail }">
        <div class="mb-5">
        <span class="alert alert-danger"> Username or password is incorrect</span>
        </div>
        </c:if>
    <input type="hidden" name="mode" value="SIGNIN">
        <div class="row mb-4">
            <div class="col-sm-12">
              <input type="email" name="email" class="form-control form-control-lg" placeholder="Enter your email" id="email">
            </div>
          </div>
          <div class="row mb-4">
            <div class="col-sm-12">
              <input type="password" name="password" class=" form-control form-control-lg" placeholder="Enter your password" id="email">
            </div>
          </div>
          <div class="row mb-4 text-center">
            <div class="col ">
                <input class="btn btn-primary" type="submit" value="Login" style="width: 6rem;">
            </div>
          </div>
          <div class="row mb-4 text-center">
            <div class="col ">
                <p>Do not have a account? <a href="userRegister.jsp">signup</a></p>
            </div>
          </div>
        </form>
    
</body>
</html>