<%@include file="../parts/header.jsp"%>
<%@include file="../parts/nav-bar.jsp"%>
<section class="px-5 mx-5">

	<table class="table table-striped ">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">User Name</th>
				<th scope="col">Book Title</th>
				<th scope="col">lend Date</th>	
				<th scope="col">return Date</th>
				<th scope="col">Status</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lends}" var="lend">
				<tr>
					<th scope="row">${lend.getId()}</th>
					<td>${lend.getBorrowerId()}</td>
					<td>${lend.getBookId()}</td>
					<td>#</td>
					<td>#</td>
					<td>${lend.isStatus()}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</section>
<%@include file="../parts/footer.jsp"%>