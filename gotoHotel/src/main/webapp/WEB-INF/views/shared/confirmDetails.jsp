
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

	<!-- <div class="col-md-3">

		 No need to load the sidebar for admin page - leaving space just in case

	</div> -->



	<!-- 
		<div class="col-md-9">
		<div class="row">
			<div class="col-lg-12">

				 Adding breadcrumb component
				<ol class="breadcrumb">
					<li><a href="{contextRoot}/home">Home</a></li>
					<li class="active">Admin</li>
				</ol>
			</div>
			 end col-lg-12 -->




	<div class="card card-container">
		<h2 class='register_title text-center'>Confirm your details</h2>
		<hr>
		<div class="row main">

			<div class="main-login main-center">
				<table align="center" cellpadding="5" cellspacing="5">
					<form:form commandName="userDto">

						<tr>
							<td>Name</td>
							<td><form:input path="name" placeholder="Enter your Name "
									class="form-control" /><font color="red"> <form:errors
										path="name" /></font>
						</tr>


						 <tr>
							<td>Password</td>
							<td><form:password path="password"
									placeholder="Enter your password." class="form-control" /><font
								color="red"> <form:errors path="password" /></font>
						</tr>
 
						<tr>
							<td>Email Id</td>
							<td><form:input path="email"
									placeholder="Enter your Email Address" class="form-control" />
								<font color="red"><form:errors path="email" /></font>
						</tr>

						<tr>
							<td>Address</td>
							<td><form:textarea path="address"
									placeholder="Enter your Address" class="form-control" /><font
								color="red"> <form:errors path="address" /></font>
						</tr>
						<tr>
							<td>City</td>
							<td><form:select path="city" placeholder="Enter your city"
									class="form-control">
									<form:option value="" label="Please Select" />
									<form:option value="Faridabad" label="Faridabad" />
									<form:option value="Delhi" label="Delhi" />
									<form:option value="Mumbai" label="Mumbai" />
									<form:option value="Banglore" label="Banglore" />
									<form:option value="Haridwar" label="Haridwar" />
									<form:option value="Goa" label="Goa" />
								</form:select> <br /> <font color="red"> <form:errors path="city" />
							</font></td>
						</tr>

						<tr>
							<td>State</td>
							<td><form:select path="state" placeholder="Enter your state"
									class="form-control">
									<form:option value="" label="Please Select" />
									<form:option value="Haryana" label="Haryana" />
									<form:option value="Delhi" label="Delhi" />
									<form:option value="Maharashtra" label="Maharashtra" />
									<form:option value="punjab" label="punjab" />
									<form:option value="Uttrakhand" label="Uttrakhand" />
									<form:option value="Goa" label="Goa" />

								</form:select><font color="red"> <form:errors path="state" /></font></td>
						</tr>

						<tr>
							<td>role</td>
							<td><form:select path="role" placeholder="Enter your role"
									class="form-control">
									<form:option value="" label="Please Select" />
									<form:option value="ADMIN" label="ADMIN" />
									<form:option value="CUSTOMER" label="CUSTOMER" />
									<form:option value="SUPPLIER" label="SUPPLIER" />

								</form:select><font color="red"> <form:errors path="role" /></font></td>
						</tr>

						<tr>
							<td>PhoneNo</td>
							<td><form:input path="phoneNo"
									placeholder="Enter Contact no.." class="form-control" /><font
								color="red"> <form:errors path="phoneNo" /></font>
						</tr>
						<tr>
							<td><input type="submit" name="_eventId_submit1"
								value="Submit" /></td>
							<td><input type="submit" name="_eventId_edit" value="Edit" /></td>
						</tr>
					</form:form>
				</table>

			</div>
		</div>
	</div>
</body>
</html>

