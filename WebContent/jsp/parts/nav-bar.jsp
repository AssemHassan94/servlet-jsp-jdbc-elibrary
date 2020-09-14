<nav class="navbar navbar-expand-md navbar-dark bg-dark ">
	<a class="navbar-brand" href="${pageContext.request.contextPath}"><img
		src="./img/library.png" width="50" height="50" alt="logo" /> </a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}">Home</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/users">Users</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/books">Books</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/lending">Lending</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/logout">Logout</a></li>
		</ul>
	</div>
</nav>