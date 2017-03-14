<div class="container content">
 
  
  	<div class="col-md-12" style="height:5%: border-bottom:1px solid black">
  		<h2>My Bookings</h2>
  	</div> 	
  
 <br>
  <div class="row">
  <div class="col-md-12">
  <table class="table table-responsive table-sripped">
  	<tr>
  		<td colspan="2" style="color:darkgrey">Hotel</td>
  		<td style="color:darkgrey">No. of Room</td>
  		<td style="color:darkgrey">Price</td>
  		<td style="color:darkgrey">Sub Total</td>
  		
  	</tr>
  	<c:forEach items="${cartItem}" var="ci">
  	<tr>
  	<td>${ci.servicesDto.description}</td>
  	<td>${ci.quantity}</td>
  	<td>${ci.servicesDto.price}</td>
  	<td>${ci.totalPrice}</td>
  	<td><a href="${contextRoot}/customer/cart/delete/${ci.servicesDto.id}" class="btn btn-danger btn-lg">cancel booking</a></td> 
  	
  	<td><a href="${contextRoot}/customer/cart/update/${ci.servicesDto.id}" class="btn btn-danger btn-lg">add more room</a></td>
  	
  	</tr>
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
  <td><a href="billing" class="btn btn-danger btn-lg">Pay Now!</button></td>
  </tr>
  </table> 
  </div>
  </div>
  </div>
  </div>