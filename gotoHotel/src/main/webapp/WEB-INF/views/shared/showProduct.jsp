 <div class="container content">
 
  <div class="row">
  <div class="col-md-12">
  <table class="table table-responsive table-sripped">
  	<tr>
   <td><h1>${services.description }</h1>
<p><img src="${images}/${services.pid }.jpg" height="400" width="400"></p></td>
  
  <td>
<h1>Price:&#8377 ${services.price}/ Day</h1>
<h2>Location:${services.location}</h2></td>
</tr>
<form:form modelAttribute="services" action="${contextRoot}/customer/cart/${services.id}">

				
			
			<div class="row">
				<p>
					<button  style="text-size:30px" class="btn btn-danger btn-lg" ><span class="glyphicon glyphicon-shopping-cart" style="text-size:30px"></span> Book Now!!</button>
					<h3>1 Guest / 1 Room</h3>
						
				</p>
			</div>
	</form:form>

</table>

</div>
	</div>
	</div>
