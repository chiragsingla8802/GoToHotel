<!-- Add Modal -->
<form:form method="POST" modelAttribute="service"
	class="form-horizontal" action="/admin/save/services">

	<div class="modal fade" id="updatemodal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Update Services Details</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="CategoryID">Category Id:</label>
						<form:input type="text" path="category_id" value="${s }" class="form-control" id="CategoryID" />
						<div class="has-error">
							<form:errors path="category_id" class="help-inline" />
						</div>
					</div>
					<div class="form-group">
						<label for="ProductID">Product Id:</label>
						<form:input type="text" path="product_id" class="form-control" id="ProductID" />
						<div class="has-error">
							<form:errors path="product_id" class="help-inline" />
						</div>
					</div>
					<div class="form-group">
						<label for="ServicePrice">Price:</label>
						<form:input type="text" path="price" class="form-control"
							id="ServicePrice" />
						<div class="has-error">
							<form:errors path="price" class="help-inline" />
						</div>
					</div>
					<div class="form-group">
						<label for="ServiceLocation">Location:</label>
						<form:input type="text" path="location" class="form-control"
							id="ServiceLocation" />
						<div class="has-error">
							<form:errors path="location" class="help-inline" />
						</div>
					</div>
					<div class="checkbox">
						<label><input type="checkbox" value="">Active</label>
					</div>
				</div>
				<div class="modal-footer">
					<input type="submit" class="btn btn-default" role="button"
						value="UpdateProduct" />
				</div>
			</div>

		</div>
	</div>
</form:form>
<!--  End of Add Modal -->