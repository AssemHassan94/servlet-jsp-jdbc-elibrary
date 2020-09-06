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
<form action="librarian/add" method="get">
	<div class="container form-add">
		<h1 class="h3 mb-2 font-weight-normal" style="color: #090e47">
			Add Librarian</h1>
		<div class="form-group">
			<label for="exampleFormControlInput1">First Name</label> <input
				type="text" class="form-control" id="exampleFormControlInput1"
				placeholder="joe" name="firstname" />
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Last Name</label> <input
				type="text" class="form-control" id="exampleFormControlInput1"
				placeholder="doe" name="lastname" />
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Email</label> <input
				type="email" class="form-control" id="exampleFormControlInput1"
				placeholder="name@example.com" name="email" />
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Password</label> <input
				type="password" class="form-control" id="exampleInputPassword1"
				placeholder="Password" name="password" />
		</div>

		<button class="btn btn-lg btn-primary btn-block" type="submit">
			submit</button>
	</div>
</form>
<%@include file="parts/footer.jsp"%>

