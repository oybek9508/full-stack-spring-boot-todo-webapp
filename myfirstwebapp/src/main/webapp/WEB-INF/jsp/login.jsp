<html>
	<head>
		<title>Login Page</title>
	</head>
	<body>
		<div class = "container">
			<h1>Login</h1>
			
			<form method='post'>
				Name: <input type = 'text' name = 'name'/>
				Password: <input type = 'password' name = 'password'/>
				<input type = 'submit'/>
				<pre>${errorMessage}</pre>
			</form>
		</div>
	</body>
</html>