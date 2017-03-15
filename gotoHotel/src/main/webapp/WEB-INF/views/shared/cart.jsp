<div class="container content">
 
  
  	<div class="col-md-12" style="height:5%: border-bottom:1px solid black">
  		<h2>My Bookings</h2>
  	</div> 	
  
 <br>
  <div class="row">
  <div class="col-md-12">
  <table class="table table-responsive table-sripped">
  <div>	<tr>
  		<td colspan="2">Hotel</td>
  		<td>No. of Room</td>
  		<td>Price</td>
  		<td>Sub Total</td>
  		<!-- <td>Add</td> -->
  		
  	</tr></div>
  	<div><c:forEach items="${cartItem}" var="ci">
  	<tr>
  	<td colspan="2">${ci.servicesDto.description}</td>
  	<td>${ci.quantity}</td>
  	<td>${ci.servicesDto.price}</td>
  	<td>${ci.totalPrice}</td>
   	<%--  <td><a href="${contextRoot}/customer/cart/delete/cartItem/${ci.servicesDto.id}" class="btn btn-danger btn-lg">cancel booking</a></td> 
  	  
  	  <td><a href="${contextRoot}/customer/cart/update/${ci.servicesDto.id}" class="btn btn-danger btn-lg">add more room</a></td>
  	 --%>
  	</tr></div>
  	</c:forEach>
  </table>
  </div>
  </div>   
   
   <div class="row">
  <div class="col-md-12">
   <table class="table table-responsive">
  <tr>
  <td>Grand Total</td>
  <td>${cart.grandTotal}</td>
  </tr>
  <tr>
  <td>total bookings</td>
  <td>${cart.cartItemsCount}</td>
  </tr>
  <tr>
  <td><a href="${contextRoot}/productDescription" class="btn btn-danger btn-lg">Book More</a> </td>
  <td><a href="${contextRoot}/customer/cart/payment" class="btn btn-danger btn-lg">Pay Now!</button></td>
  </tr>
  </table> 
  </div>
  </div>
  </div>
  </div>