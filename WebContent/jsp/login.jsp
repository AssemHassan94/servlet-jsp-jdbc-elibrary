
<%@include file="parts/header.jsp"%>

<div class="container-fluid container-background text-center">
	<div class="row">
		<div class="col-4 mx-auto" style="margin-top: 15rem">
			<form class="form-signin"
				action="${pageContext.request.contextPath}/LoginServlet" method="POST">
				<img class="mb-4" src="img/library.png" alt="" width="100"
					height="100" />
				<h1 class="h3 mb-2 font-weight-normal" style="color: #090e47">
					Please sign in</h1>
				<label for="inputEmail" class="sr-only">Email address</label> <input
					type="text" id="inputEmail" class="form-control"
					placeholder="Email address" name="email" required autofocus /> <label
					for="inputPassword" class="sr-only">Password</label> <input
					type="password" id="inputPassword" class="form-control"
					placeholder="Password" name="password" required /> <span
					style="color: red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
				<div class="checkbox mb-3">
					<label> <input type="checkbox" value="remember-me" />
						Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">
					Sign in</button>
				<p class="mt-5 mb-3 text-muted">&copy; 2020</p>
			</form>
		</div>
	</div>
</div>

<%@include file="parts/footer.jsp"%>
