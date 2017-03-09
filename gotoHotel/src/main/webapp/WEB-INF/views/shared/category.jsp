<p class="lead"></p>
<div class="list-group">


<script type="text/javascript">
		$(function(){
    $('#productTable').DataTable( {
        ajax: {
			url : '/gotoHotel/pro/all/product1',
			dataSrc : ''
          } ,
   
		columns : [ 
		            {data : 'id'}, 
		            {data : 'name'},   
		                /*  { data: null ,
                        mRender: function (data, type, row) {
                            return '<img src=/gotoHotel/resources/images/'+row.id+'.jpg height="50" width="50">';}
		            }, */  
                         
            
		           { data: 'pid' ,
		            	'mRender': function (data, type, row) {
		            	    return '<a class="btn btn-info btn-sm" href=/gotoHotel/product/' +row.id + '> view</a>';}
		            } ,
		            	  
		                 
		            	  
		            /* {data: null,
			        	mRender: function ( data, type, row ) {
			                return '<img src="../webapp/assets/images/'+ row.id +'.jpg" height="50" width="50">';
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
					<th>Name</th>
					<th></th>
				</tr>
			</thead>
			<tfoot>
			<tr class="active">
					<th>Category ID</th>
					<th>Name</th>
					<th></th>
				</tr>
			</tfoot>
		</table>

<%-- <c:forEach items="${categories}" var="category">
<a href="#" class="list-group-item">${category.category_id}</a>
<a href="#" class="list-group-item">${category.name}</a>
</c:forEach> --%>

</div>