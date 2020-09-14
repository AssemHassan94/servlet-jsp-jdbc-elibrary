<%@include file="../parts/header.jsp"%>
<%@include file="../parts/nav-bar.jsp"%>
<section class="px-5 mx-5">
	<div class="d-flex justify-content-end">
		<div>
			<a class="text-white"
				href="${pageContext.request.contextPath}/add-user"><button
					type="button" class="btn btn-primary text-white mt-5 mb-2">Add
					a new User</button></a>

		</div>
	</div>
	<table class="table table-striped ">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">User-Name</th>
				<th scope="col">Role</th>
				<th scope="col">HasBook ?</th>
				<th scope="col">Action</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<th scope="row">${user.getId()}</th>
					<td>${user.getUserName()}</td>
					<td>${user.getRole()}</td>
					<td>#</td>					
					<td><a class="text-white"
						href="${pageContext.request.contextPath}/update-user?id=${user.getId()}"><button
								type="button" class="btn btn-warning text-white">Edit</button></a> <a
						class="text-white"
						href="${pageContext.request.contextPath}/delete-user?id=${user.getId()}">
							<button type="button" class="btn btn-danger">Delete</button>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</section>
<%@include file="../parts/footer.jsp"%>