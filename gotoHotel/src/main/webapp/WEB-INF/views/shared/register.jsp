<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<div class="card card-container">
			<h2 class='register_title text-center'>Register here</h2>
			<hr>
			<div class="row main">

				<div class="main-login main-center">
					      <table align="center" cellpadding="5" cellspacing="5">
                                 <form:form commandName="field" method="POST" action="process-form">

                                           <tr>
<td>Name</td>
<td><form:input path="name" />
</tr>

<tr>
<td>UserId</td>
<td><form:input path="Userid" />
</tr>

<tr>
<td>Password</td>
<td><form:password path="password" />
</tr>

<tr>
<td>Email Id</td>
<td><form:input path="email" />
</tr>

<tr>
<td>Address</td>
<td><form:textarea path="address" />
</tr>
<tr>
<td>City</td>
<td><form:select path="city">
<form:option value="" label="Please Select" />
<form:options items="${city}" itemValue="name" itemLabel="name" />
</form:select><br />
<font color="red"><form:errors path="city" /></font></td>
</tr>

<tr>
<td>State</td>
<td><form:select path="state" items="${state}" /><br />
<font color="red"><form:errors path="state" /></font></td>
</tr>
<tr>
<td>PhoneNo</td>
<td><form:input path="phoneNo" />
</tr>
<tr>
<td><input type="submit" name="save" /></td>
</tr>
</form:form>
</table>
</html>
				</div>
			</div>
		</div>	
