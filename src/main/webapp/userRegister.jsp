<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <title>User Register</title>
    <link rel="stylesheet" href="./css/style.css">
</head>
<body class="container-fluid container-md">
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
                <a class="nav-link active mx-1" aria-current="page" href="#">Login</a>
              </li>
          </ul>
</nav>
<h5 id="message" class="text-success ms-5">${message }</h5>
    <h2 class="text-center m-5">User Registration</h2>
    <form  action="user" method="post" class="mt-5">
    	<input type="hidden" value="SIGNUP">
        <div class="row mb-3">
          <div class="col-sm-12">
            <input type="text" name="username"  id="username" class="form-control form-control-lg" placeholder="Enter your name" onfocus="allclear()">
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-sm-12">
            <input type="text" name="phNo" class="form-control form-control-lg" placeholder="Enter your phone number" id="phNo">
          </div>
        </div>
        <div class="row mb-4">
            <div class="col-sm-12">
              <input type="email" name="email" class="form-control form-control-lg" placeholder="Enter your email" id="email">
            </div>
          </div>
          <div class="row mb-4">
            <div class="col-sm-12">
              <input type="password" name="password" class=" form-control form-control-lg position-relative" placeholder="Enter your password" id="password">
            </div>
          </div>
          <div class="row mb-4 text-center">
            <div class="col ">
                <input class="btn btn-danger" type="reset" value="reset" style="width: 6rem;">
            </div>
            <div class="col">
                <input class="btn btn-primary" type="submit" value="create" style="width: 6rem;">
            </div>
          </div>
          <div class="row mb-4 text-center">
            <div class="col ">
                <p>Already have a account? <a href="login.jsp">back to login</a></p>
            </div>
          </div>
        </form>
        <script src="./js/course.js"></script>
</body>
</html>