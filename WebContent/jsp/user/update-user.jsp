<%@include file="../parts/header.jsp"%>
<%@include file="../parts/nav-bar.jsp"%>
<form action="${pageContext.request.contextPath}/update-user"
	method="POST">
	<div class="container form-add">
		<h1 class="h3 mb-2 font-weight-normal" style="color: #090e47">
			Update User</h1>
		<div class="form-group">
			<label for="exampleFormControlInput1">User Name</label> <input
				type="text" class="form-control" id="exampleFormControlInput1"
				name="username" value="${user.getUserName()}" />
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Password</label> <input
				type="password" class="form-control" id="exampleFormControlInput1"
				name="password" value="${user.getPassword()}" />
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Password</label> <input
				type="text" class="form-control" id="exampleFormControlInput1"
				name="Role" value="${user.getRole()}" disabled />
		</div>

		<input name="id" type="hidden" value="${user.getId()}">

		<button class="btn btn-lg btn-primary btn-block" type="submit">
			Submit</button>
	</div>
</form>
<%@include file="../parts/footer.jsp"%>

