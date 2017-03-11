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
<!--navigation bar  -->
	<%@ include file="shared/navigation.jsp"%>
	
	<div class="container">
		
		<h1 class="welcome text-center">Welcome to pic_click.com</h1>
		<div class="card card-container">
			<h2 class='login_title text-center'>Login</h2>
			<hr>

			<form class="form-signin" action="${contextRoot}/login" method="post" >
				<span id="reauth-email" class="reauth-email"></span>
				<p class="input_title">Email</p>
				<input type="text" id="inputEmail" class="login_box" name="username"
					placeholder="user01@gmail.com" required autofocus>
				<p class="input_title">Password</p>
				<input type="password" id="inputPassword" class="login_box" name="password"
					placeholder="******" required>
				<div id="remember" class="checkbox">
					<label> </label>
				</div>
				<input class="btn btn-lg btn-primary" type="submit" value="Login"/>
			</form>
			<!-- /form -->
		</div>
		<!-- /card-container -->
	</div>
	<!-- /container -->
	
	<!--footer section  -->
	<%@ include file="shared/footer.jsp"%>
	
	
	
	<!-- self created javascript -->
	<script src="${js}/active.js"></script>
</body>
</html>