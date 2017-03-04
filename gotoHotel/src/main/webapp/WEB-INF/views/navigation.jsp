<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <spring:url var="css" value="/resources/css" />
    <spring:url var="js" value="/resources/js" />
    <spring:url var="images" value="/resources/images" />
    <spring:url var="fonts" value="/resources/fonts" />
    <c:set var="contextRoot" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

 <!-- Bootstrap Core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <link href="${css}/bootstrap-theme.css" rel="stylesheet">

 <!-- Custom CSS -->
    <link href="${css}/style.css" rel="stylesheet">

</head>
 
 <body>
<!-- Navigation -->
    
    <nav class="navbar navbar-inverse navbar-fixed-top" >
        <div class="container">
    
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand"  href="/gotoHotel/index">gotoHotel</a>
            </div>
    
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="/gotoHotel/aboutUs">About</a>
                    </li>
                    <li>
                        <a href="/gotoHotel/productDescription">Services</a>
                    </li>
                    <li>
                        <a href="/gotoHotel/contactUs">Contact</a>
                    </li>
                    <li>
                        <a href="/gotoHotel/register">Register</a>
                    </li>
                    <li>
                        <a href="/gotoHotel/login">Login</a>
                    </li>
                    <li>
                        <a href="/gotoHotel/index">Logout</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
    <!-- jQuery -->
    <script src="${js}/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${js}/bootstrap.min.js"></script>
    
</body>


</html>