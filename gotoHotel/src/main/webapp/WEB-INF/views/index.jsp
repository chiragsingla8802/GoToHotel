
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>Hotel World</title>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/style.css" rel="stylesheet">



</head>

<body>
	<!--navigation bar  -->
	<%@ include file="navigation.jsp"%>

	<!-- slider section -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
			<li data-target="#myCarousel" data-slide-to="4"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="${images}/16.jpg" alt="hotel taj" width="1150" height="250">
			</div>

			<div class="item">
				<img src="${images}/17.jpg" alt="hotel savai mansingh" width="1150"
					height="250">
			</div>

			<div class="item">
				<img src="${images}/18.jpg" alt="the lalit" width="1150" height="250">
			</div>

			<div class="item">
				<img src="${images}/16.jpg" alt="saffron square" width="1150"
					height="250">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	</div>

	<!-- end of slider section -->

	<!-- Full Width Image Header -->
	<!-- <header class="header-image">
	<div class="headline">
		<div class="container">
			<h1>One Page Wonder</h1>
			<h2>Will Knock Your Socks Off</h2>
		</div>
	</div>
	</header> -->

	<!-- Page Content -->
	<div class="container">

		<hr class="featurette-divider">

		First Featurette
		<div class="featurette" id="about">
			<img class="featurette-image img-circle img-responsive pull-right"
				src="${images}/13.jpg">
			<h2 class="featurette-heading">
				This First Heading <span class="text-muted">Will Catch Your
					Eye</span>
			</h2>
			<p class="lead">Donec ullamcorper nulla non metus auctor
				fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
				commodo cursus magna, vel scelerisque nisl consectetur. Fusce
				dapibus, tellus ac cursus commodo.</p>
		</div>

		<hr class="featurette-divider">


		<!-- Second Featurette -->
		<div class="featurette" id="services">
			<img class="featurette-image img-circle img-responsive pull-left"
				src="${images}/14.jpg">
			<h2 class="featurette-heading">
				The Second Heading <span class="text-muted">Is Pretty Cool
					Too.</span>
			</h2>
			<p class="lead">Donec ullamcorper nulla non metus auctor
				fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
				commodo cursus magna, vel scelerisque nisl consectetur. Fusce
				dapibus, tellus ac cursus commodo.</p>
		</div>

		<hr class="featurette-divider">

		<!-- Third Featurette -->
		<div class="featurette" id="contact">
			<img class="featurette-image img-circle img-responsive pull-right"
				src="${images}/15.jpg">
			<h2 class="featurette-heading">
				The Third Heading <span class="text-muted">Will Seal the
					Deal.</span>
			</h2>
			<p class="lead">Donec ullamcorper nulla non metus auctor
				fringilla. Vestibulum id ligula porta felis euismod semper. Praesent
				commodo cursus magna, vel scelerisque nisl consectetur. Fusce
				dapibus, tellus ac cursus commodo.</p>
		</div>

		<hr class="featurette-divider">

		<!--footer section  -->
	<%@ include file="footer.jsp"%>
		

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="${js}/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>


</body>

</html>
