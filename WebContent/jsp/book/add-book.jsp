<%@include file="../parts/header.jsp"%>
<%@include file="../parts/nav-bar.jsp"%>

<form action="${pageContext.request.contextPath}/add-book" method="POST">
	<div class="container form-add">
		<h1 class="h3 mb-2 font-weight-normal" style="color: #090e47">
			Add Book</h1>
		<div class="form-group">
			<label for="exampleFormControlInput1">Book Title</label> <input
				type="text" class="form-control" id="exampleFormControlInput1"
				placeholder="Book title" name="bookTitle" />
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Author</label> <input
				type="text" class="form-control" id="exampleFormControlInput1"
				placeholder="author name" name="authorName" />
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">
			Submit</button>
	</div>
</form>
<%@include file="../parts/footer.jsp"%>

