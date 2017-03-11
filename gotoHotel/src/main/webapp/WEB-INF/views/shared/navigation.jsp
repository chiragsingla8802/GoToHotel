<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!-- Navigation -->

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">

		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextRoot}/home">gotoHotel</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav ">
				<li id="aboutUs"><a href="${contextRoot}/aboutUs">About</a></li>
				<li id="productDescription"><a
					href="${contextRoot}/productDescription">Services</a></li>
				<li id="category"><a href="${contextRoot}/category">Category</a>
				</li>
				<li id="contactUs"><a href="${contextRoot}/contactUs">Contact</a>
				</li>
				<li id="register"><a href="${contextRoot}/register">Register</a>
				</li>
				<security:authorize access="isAnonymous()">
				<li id="login"><a href="${contextRoot}/login">Login</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
				<li id="logout"><a href="${contextRoot}/logout">Logout</a></li>
				</security:authorize>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>

