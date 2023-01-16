<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <title>Home Page</title>
    <link rel="stylesheet" href="index.css">
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
                <a class="nav-link active mx-1" aria-current="page" href="login">Login</a>
              </li>
          </ul>
</nav>
    
    <div>
        <img class="position-relative opacity-50 img-fluid" src="./images/student1.jpg" alt="student">
        <h1 class="position-absolute text text-dark mx-5">Welcome To Student Enrollment System</h1>
    </div>
    <footer class="bg-primary">
        <div class="container-fluid">
            <ul class="nav justify-content-end">
                <a href="mailto:heinwinnaing0@gmail.com" class="nav-link text-dark mb-4" href="#"><i class="fa-solid fa-envelope"></i> heinwinnaing@gmail.com</a>
                <a href="tel://09789312248" class="nav-link text-dark mb-4" href="#"><i class="fa-solid fa-phone"></i> +95978931248</a>
        </ul>
    
            <p class="text-center p-3">&#169 heinwinnaing . All rights reserved.</p>
        </div>

    </footer>
    
</body>
</html>