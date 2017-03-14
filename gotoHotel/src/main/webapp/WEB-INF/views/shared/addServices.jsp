<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
<form:form method="POST" modelAttribute="servicesDto" enctype="multipart/form-data" class="form-horizontal" action="${contextRoot}/admin/save/services">

	<div class="modal fade" id="addmodal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add Services</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="id">Category Id:</label>
						<form:input type="text" path="id"  class="form-control" id="id" />				
						<div class="has-error">
							<form:errors path="id" class="help-inline" />
						</div>
					</div>
					<div class="form-group">
						<label for="pId">Product Id:</label>
						<form:input type="text" path="pid" class="form-control" id="pId" />
						<div class="has-error">
							<form:errors path="pid" class="help-inline" />
						</div>
					</div>
					<div class="form-group">
						<label for="price">Price:</label>
						<form:input  path="price" class="form-control"
							id="price" />
						<div class="has-error">
							<form:errors path="price" class="help-inline" />
						</div>
					</div>
					<div class="form-group">
						<label for="location">Location:</label>
						<form:input type="text" path="location" class="form-control"
							id="location" />
						<div class="has-error">
							<form:errors path="location" class="help-inline" />
						</div></div>
						
						<div class="form-group">
						<label for="serviceQuantity">Rooms Available:</label>
						<form:input  type="text" path="serviceQuantity" class="form-control"
							id="serviceQuantity" />
						<div class="has-error">
							<form:errors path="serviceQuantity" class="help-inline" />
						</div>
					</div>
						
						<div class="form-group">
						<label for="description">Description:</label>
						<form:input type="text" path="description" class="form-control"
							id="description" />
						<div class="has-error">
							<form:errors path="description" class="help-inline" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="imageurl">Image:</label>
						<form:input type="text" path="image_url" class="form-control"
							id="imageurl" />
						<div class="has-error">
							<form:errors path="image_url" class="help-inline" />
						</div>
					</div>
					<div class="checkbox">
						<label><input type="checkbox" >Active</label>
					</div>
					
					<div class="form-group">
						<label for="Image">Image:</label>
						<form:input type="file" path="file" class="form-control"
							id="Image" />
						<div class="has-error">
							<form:errors path="file" class="help-inline" />
						</div>
					</div>
					
				<div class="modal-footer">
					<input type="submit" class="btn btn-default" role="button" />
				</div>
				</div>
				
				
				
				
			</div>

		</div>
	</div>

	
	
</form:form>
</div>