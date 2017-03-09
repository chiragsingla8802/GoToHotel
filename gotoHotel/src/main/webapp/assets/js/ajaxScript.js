
		$(function(){
    $('#productTable').DataTable( {
        ajax: {
			url : '/gotoHotel/pro/all/product1',
			dataSrc : ''
          } ,
   
		columns : [ 
		            {data : 'category_id'}, 
		            {data : 'pId'}, 
		            {data : 'location'}, 
		            {data : 'description'}, 
		            {data : 'price'}, 
		            {data : 'image_url'},   
		                 { data: null ,
                        mRender: function (data, type, row) {
                            return '<img src=/pic_click/resources/images/'+row.category_id+'.jpg height="50" width="50">';}
		            },  
                         
            
		           { data: 'category_id' ,
		            	'mRender': function (data, type, row) {
		            	    return '<a class="btn btn-info btn-sm" href=/pic_click/product/' +row.category_id + '> view</a>';}
		            } ,
		            	  
		            
		              { data: null ,
		            	'mRender': function (data, type, row) {
		            	    return '<a class="btn btn-info btn-sm" href=/pic_click/product' + row[0] + '>' + 'add to cart' + '</a>';}
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

