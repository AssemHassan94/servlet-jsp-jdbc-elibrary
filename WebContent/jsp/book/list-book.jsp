<%@include file="../parts/header.jsp"%>
<%@include file="../parts/nav-bar.jsp"%>
<section class="px-5 mx-5">
	<div class="d-flex justify-content-end">
		<div>
			<a class="text-white"
				href="${pageContext.request.contextPath}/add-book"><button
					type="button" class="btn btn-primary text-white mt-5 mb-2">Add
					a new book</button></a>

		</div>
	</div>
	<table class="table table-striped ">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Title</th>
				<th scope="col">Author</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">

				<tr>
					<th scope="row">${book.getId()}</th>
					<td>${book.getTitle()}</td>
					<td>${book.getAuthor()}</td>
					<td><a class="text-white"
						href="${pageContext.request.contextPath}/update-book?id=${book.getId()}"><button
								type="button" class="btn btn-warning text-white">Edit</button></a> <a
						class="text-white"
						href="${pageContext.request.contextPath}/delete-book?id=${book.getId()}">
							<button type="button" class="btn btn-danger">Delete</button>
					</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</section>
<%@include file="../parts/footer.jsp"%>