<script type="text/javascript">
	$(function() {
		$('#productTable')
				.DataTable(
						{
							ajax : {
								url : '/gotoHotel/admin/all/product',
								dataSrc : ''
							},

							columns : [
									{
										data : 'id'
									},
									{
										data : 'pid'
									},
									{
										data : 'price'
									},
									{
										data : 'location'
									},
									{
										data : 'description'
									},
									{
										data : 'image_url',
										'mRender' : function(data, type, row) {
											return '<img src=/gotoHotel/resources/images/'+row.pid+'.jpg height="50" width="50">';
										}
									},

									{
										data : 'edit',
										'mRender' : function(data, type, row) {
											return '<a class="btn btn-info btn-sm" href="/gotoHotel/admin/edit/' +row.id + '/services">Edit</a>';
										}
									},

									{
										data : null,
										'mRender' : function(data, type, row) {
											return '<a class="btn btn-info btn-sm" href=/gotoHotel/admin/delete/' +row.id + '/services>Delete</a>';
										}
									}

							]
						});

	});
</script>


<script type="text/javascript">
	$(function() {

		var path = window.location.href;
		if (path.indexOf('edit') > -1) {
			$('#updatemodal').modal('show');
		} else if (path.indexOf('add') > -1) {
			$('#addmodal').modal('show');
		}

	});
</script>



<script type="text/javascript">
<c:if test="${addServicesFailed == true}">
<script>
	$(function() {
		$('#updatemodal').modal('show');
	});
</script>
</c:if>
</script>






<div class="row">
	<div class="container">
		<ul>
			<a href="/gotoHotel/admin/add/services"
				class="btn btn-primary active pull-right" role="button">Add
				Services</a>
		</ul>
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
			<th>Image</th>
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
<a href="#" class="list-group-item">${service.pId}</a>
<a href="#" class="list-group-item">${service.price}</a>
<a href="#" class="list-group-item">${service.location}</a>
<a href="#" class="list-group-item">${service.description}</a>
</c:forEach> --%>

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

<%@include file="addServices.jsp"%>

<%@include file="updatemodal.jsp"%>