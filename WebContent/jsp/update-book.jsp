<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />

<title>Edit Book</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/navbar-static/" />

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" />

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="css/add-book.css" rel="stylesheet" />
</head>
<body>
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

	<form action="./UpdateBook" method="POST">
		<div class="container form-add">
			<h1 class="h3 mb-2 font-weight-normal" style="color: #090e47">
				Edit Book</h1>
			<div class="form-group">
				<label for="exampleFormControlInput1">Book Title</label> <input
					type="text" class="form-control" id="exampleFormControlInput1"
					value="${book.getTitle()}" name="bookTitle" />
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">Author</label> <input
					type="text" class="form-control" id="exampleFormControlInput1"
					value="${book.getAuthor()}" name="authorName" />
			</div>

			<input name="id" type="hidden" value="${book.getId()}">
			<button class="btn btn-lg btn-primary btn-block" type="submit">
				Submit</button>
		</div>
	</form>
</body>
</html>
