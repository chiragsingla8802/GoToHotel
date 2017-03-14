<p class="lead"></p>
<div class="list-group">
		
		<script type="text/javascript">
		$(function(){
    $('#productTable').DataTable( {
        ajax: {
			url : '/gotoHotel/pro/all/product2',
			dataSrc : ''
          } ,
   
		columns : [ 
		            {data : 'id'}, 
		            {data : 'pid'}, 
		            {data : 'price'}, 
		            {data : 'location'}, 
		            {data : 'serviceQuantity'},
		            {data : 'description'}, 
		            { data: null ,
                        'mRender': function (data, type, row) {
                            return '<img src=/gotoHotel/resources/images/'+row.pid+'.jpg height="50" width="50">';}
		            },  
                         
            
		           { data: 'category_id' ,
		            	'mRender': function (data, type, row) {
		            	    return '<a class="btn btn-info btn-sm" href=/gotoHotel/showProduct/' +row.id + '> view</a>';}
		            } ,
		            	  
		            
		              /* { data: null ,
		            	'mRender': function (data, type, row) {
		            	    return '<a class="btn btn-info btn-sm" href=/gotoHotel/product' + row[0] + '>' + 'add to cart' + '</a>';}
		            }  */     
		            	  
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

<table id="productTable" class="table table-hover">
			<thead>
				<tr class="active">
					<th>Category ID</th>
					<th>Product ID</th>
					<th>Price</th>
					<th>Location</th>
					<th>Rooms Available</th>
					<th>Description</th>
					<th>Image </th>
					<!-- <th></th> -->
					<th></th>
				</tr>
			</thead>
			<tfoot>
			<tr class="active">
					<th>Category ID</th>
					<th>Product ID</th>					
					<th>Price</th>
					<th>Location</th>
					<th>Rooms Available</th>
					<th>Description</th>
					<th>Image</th>
					<!-- <th></th> -->
					<th></th>
				</tr>
			</tfoot>
		</table>
	</div>
<%-- <c:forEach items="${services}" var="service">
<a href="#" class="list-group-item">${service.category_id}</a>
<a href="#" class="list-group-item">${service.pId}</a>
<a href="#" class="list-group-item">${service.price}</a>
<a href="#" class="list-group-item">${service.location}</a>
<a href="#" class="list-group-item">${service.description}</a>
</c:forEach> --%>