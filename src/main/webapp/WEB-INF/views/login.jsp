<div class="container">
<h3 style="text-align: center">Cette page nécessite une authentification </h3>
<div class=" d-flex justify-content-center " style="max-height: 300px">
	
		<form action="${pageContext.request.contextPath}/login.html" method="post">
		<div>
		<label>login:</label>
		<input type="text" name="username"/>
		</div>
		<div>
		<label>Password</label>
		<input type="password" name="password"/>
		</div>
		<div>
		<input type="submit" value="login"/>
		</div>
	
		</form>
		</div>
		</div>