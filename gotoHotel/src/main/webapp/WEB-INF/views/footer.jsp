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
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Product View_Hotel World</title>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/style.css" rel="stylesheet"></head>
<body>

<footer> <!--footer-->
<section class="footer">
    <div class="container">
    	<div class="row">
        	<div class="col-lg-4  col-md-4 col-sm-4">
            	<div class="footer_dv">
                	<h4>Useful Links</h4>
                	<ul>
                    	<li class="line_rv"><a href="/gotoHotel/aboutUs">About us</a></li>
                        <li><a href="/gotoHotel/contactUs">Contact Us</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4  col-md-4 col-sm-4">
            	<div class="footer_dv">
                	<h4>Products</h4>
                	<ul>
                    	<li><a href="#">latest events</a></li>
                        <li><a href="#">testimonials</a></li>
                        <li><a href="#">Indian photoshoot</a></li>
                        <li><a href="#">Casual Photoshoot</a></li>
                        <li><a href="#">Mobile Photography</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4  col-md-4 col-sm-4">
            	<div class="footer_dv">
                	<h4>Toll Free</h4>
                	<p>To know more about latest Photoshoots</p>
      			<p>IND (TOLL FREE) +91 8802746226<br>

				
                </p></div>
            </div>
        </div>
    </div>
</section>


		<div class="row">
			<div class="col-lg-12">
				<p>Copyright &copy; developed and created by CHIRAG SINGLA</p>
			</div>
		</div>
	
</footer><!--  end footer -->
</body>
</html>
