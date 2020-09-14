<%@include file="../parts/header.jsp"%>
<%@include file="../parts/nav-bar.jsp"%>
<form action="${pageContext.request.contextPath}/add-user" method="POST">
	<div class="container form-add">
		<h1 class="h3 mb-2 font-weight-normal" style="color: #090e47">
			Add User</h1>
		<div class="form-group">
			<label for="exampleFormControlInput1">User Name</label> <input
				type="text" class="form-control" id="exampleFormControlInput1"
				name="username" />
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Password</label> <input
				type="password" class="form-control" id="exampleFormControlInput1"
				name="password" />
		</div>
		<div class="form-group">
			<label for="inputRole">Role</label> 
			<select id="inputRole" class="form-control" name="role">
				<option selected>Choose...</option>
				<option value="admin">Admin</option>
				<option value="user">User</option>
			</select>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">
			Submit</button>
	</div>
</form>
<%@include file="../parts/footer.jsp"%>

