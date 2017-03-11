<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="fonts" value="/resources/fonts" />
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>


<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>${title}_HotelWorld</title>
<script>
	window.menu = '${title}';
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/style.css" rel="stylesheet">
<link href="${css}/registerStyle.css" rel="stylesheet">
<link href="${css}/round-about.css" rel="stylesheet">
<link href="${css}/loginStyle.css" rel="stylesheet">
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<link href="${css}/custom.css" rel="stylesheet">
</head>

<body>

	<!-- jQuery -->
	<script src="${js}/jquery.js"></script>

	<!--DataTable javaScript  -->
	<script src="${js}/jquery.dataTables.js"></script>
	<script src="${js}/dataTables.bootstrap.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>
	
	
	<div class="card card-container">
		<h1>Congratulation!</h1>
		<br>
		<h2>You are registered successfully with gotoHotel.com</h2>
		<br>
		<h2>Enjoy best Services with us.</h2>
		<br>
		<h3>your userId:<br>${userDto.email}</h3>
	</div>
	
</body>
</html>