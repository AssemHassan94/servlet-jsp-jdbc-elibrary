<%@include file="parts/header.jsp"%>

<div>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		<a class="navbar-brand" href="#"><img src="img/library.png"
			width="50" height="50" alt="logo" /> </a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Add
						Librarian</a></li>
				<li class="nav-item"><a class="nav-link" href="#">View
						Librarian</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Logout</a></li>
			</ul>
		</div>
	</nav>
</div>
<form action="./AddBook" method="GET">
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
<%@include file="parts/footer.jsp"%>

