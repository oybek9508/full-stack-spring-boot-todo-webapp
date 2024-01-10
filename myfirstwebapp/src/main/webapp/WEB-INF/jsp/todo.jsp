<html>
	<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<title>Add Todo Page</title>
	</head>
	<body>
		<div class = "container">
			<h1>Welcome ${name}</h1>
		 	<form method = "post">
		 	Description: <input type = "text" name = "description" placeholder = "description"/>
		 	<p>${emptyDescriptionFieldMessage}</p>
		 	<!-- <input type = "date" name = "targetDate" placeholder = "targetDate"/>
		 	<input type = "boolean" name = "isDone"/> -->
		 	<input type = "submit" class = "btn btn-success"/>
		 	</form>
		</div>
		 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
	</body>
</html>