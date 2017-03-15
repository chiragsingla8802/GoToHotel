
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
	
	<!--navigation bar  -->
	<%@ include file="shared/navigation.jsp"%>


	<!-- home content part -->
	<c:if test="${userClickHome == true}">
		<%@ include file="shared/home.jsp"%>
	</c:if>

	<!-- about us content part -->
	<c:if test="${userClickAbout == true}">
		<%@ include file="shared/aboutUs.jsp"%>
	</c:if>

	<!-- contact us content part -->
	<c:if test="${userClickContact == true}">
		<%@ include file="shared/contactUs.jsp"%>
	</c:if>

	<!-- login content part -->
	<%-- <c:if test="${userClickLogin == true}">
		<%@ include file="shared/login.jsp"%>
	</c:if> --%>
	
	<!-- product description content part -->
	<c:if test="${userClickServices == true}">
		<%@ include file="shared/productDescription.jsp"%>
	</c:if>

	<!-- register content part -->
	<c:if test="${userClickRegister == true}">
		<%@ include file="shared/register.jsp"%>
	</c:if>
	
	<!-- show product content part -->
	<c:if test="${userClickShowProduct == true}">
		<%@ include file="shared/showProduct.jsp"%>
	</c:if>
	
	<!-- payment Details content part -->
	<c:if test="${userClickPayment == true}">
		<%@ include file="shared/paymentDetails.jsp"%>
	</c:if>
	
	<!-- final invoice content part -->
	<c:if test="${userClickFinalInvoice == true}">
		<%@ include file="shared/finalInvoice.jsp"%>
	</c:if>
	
	
	<!-- cart content part -->
	<c:if test="${userClickCart == true}">
		<%@ include file="shared/cart.jsp"%>
	</c:if>

	<!-- category content part -->
	<c:if test="${userClickCategory == true}">
		<%@ include file="shared/category.jsp"%>
	</c:if>

<!-- admin content part -->
	<c:if test="${userClickAdmin == true}">
		<%@ include file="shared/adminAddProduct.jsp"%>
	</c:if>

   <c:if test="${addServicesFailed == true}">
		<%@ include file="shared/adminAddProduct.jsp"%>
	</c:if>


	<!--footer section  -->
	<%@ include file="shared/footer.jsp"%>





	<!-- self created javascript -->
	<script src="${js}/active.js"></script>



</body>

</html>
