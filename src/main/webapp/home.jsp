<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="./common/header.html"></c:import>
    <title>Home Page</title>
</head>
<body class="container-fluid container-md">
	 <c:import url="./common/nav.jsp"></c:import>
    
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
    <c:import url="./common/footer.html"></c:import>
    
</body>
</html>