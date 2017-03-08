<script type="text/javascript">
		$(function(){
    $('#productTable').DataTable( {
        ajax: {
			url : '/gotoHotel/admin/all/product',
			dataSrc : ''
          } ,
   
		columns : [ 
		            {data : 'category_id'}, 
		            {data : 'product_id'}, 
		            {data : 'price'}, 
		            {data : 'location'}, 
		            {data : 'description'}, 
		            { data: null ,
                        'mRender': function (data, type, row) {
                            return '<img src=/gotoHotel/resources/images/'+row.category_id+'.jpg height="50" width="50">';}
		            },  
                         
            
		            { data: 'category_id' ,
		            	'mRender': function (data, type, row) {
		            	    return '<a class="btn btn-info btn-sm" href="/gotoHotel/admin/edit/' +row.category_id + '/services">Edit</a>';}
		            } , 
		            	  
		            
		               { data: null ,
		            	'mRender': function (data, type, row) {
		            	    return '<a class="btn btn-info btn-sm" href=/gotoHotel/admin/edit/' +row.category_id + '/services>Delete</a>';}
		            }      
		            	  
		            /* {data: null,
			        	mRender: function ( data, type, row ) {
			                return '<img src="../webapp/assets/images/'+ row.category_id +'.jpg" height="50" width="50">';
			            }
			        } */
			       /*  {data: null,
			        	mRender: function ( data, type, row ) {
			                return '<a class="btn btn-primary" href="'+data+'">View Item</a> &nbsp;<a class="btn btn-primary" href="'+data+'">Add To Cart</a> ';
			            }	
			        } */
		            	]
                                   });
    /* $('[data-toggle="tooltip"]').tooltip();
	 */
	
		});
</script>


<script type="text/javascript">	
	
	
	$(function(){
		
		
		var path = window.location.href;
		if(path.indexOf('edit') > -1) {		
			$('#updatemodal').modal('show');
		}	
			
	});
	
	
</script>



<%-- <div class="container">
	<div class="dropdown">
		<h2>Add/Update Items</h2>
		<p>Use the following options to Add/Delete/Update Products</p>
		<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
			Select Operation <span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<c:forEach items="${servicesadmin}" var="option">
				<li><a href="" data-target="#${option}" data-toggle="">${option}</a></li>
			</c:forEach>

		</ul>
	</div>
	<!--  end of dropdown -->
<p class="lead"></p>
<div class="list-group"> --%>
		 <div class="row">
            		<div class="form-actions floatRight">
                		<input type="submit" name="action" value="Add" class="btn btn-primary btn-sm">
            		</div>
        		</div>
<table id="productTable" class="table table-hover">
			<thead>
				<tr class="active">
					<th>Category ID</th>
					<th>Product ID</th>
					<th>Price</th>
					<th>Location</th>
					<th>Description</th>
					<th>Image </th>
					<th>edit</th>
				 <th>delete</th>
				</tr>
			</thead>
			<tfoot>
			<tr class="active">
					<th>Category ID</th>
					<th>Product ID</th>					
					<th>Price</th>
					<th>Location</th>
					<th>Description</th>
					<th>Image</th>
					<th>edit</th>
				<th>delete</th> 
				</tr>
			</tfoot>
		</table>
	</div>
<%-- <c:forEach items="${services}" var="service">
<a href="#" class="list-group-item">${service.category_id}</a>
<a href="#" class="list-group-item">${service.product_id}</a>
<a href="#" class="list-group-item">${service.price}</a>
<a href="#" class="list-group-item">${service.location}</a>
<a href="#" class="list-group-item">${service.description}</a>
</c:forEach> --%>
 <%@include file="updatemodal.jsp"%>