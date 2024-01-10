<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> 
		<title>Todo Page</title>
	</head>
	<body>
		<div class = "container">
			<h1>Your todos</h1>
				<table class= "table">
					<thead>
						<tr>
							<th>Id</th>
							<th>Description</th>
							<th>Target Date</th>
							<th>Done</th>
						</tr>
					</thead>
					<tbody>
							<c:forEach items = "${todos}" var="todo">
							<tr>
							<td>${todo.id}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.isDone}</td>
							<td><button>Update</button></td>
							<td><button>Delete</button></td>
							</tr>
							</c:forEach>
					</tbody>			
				</table>
				<a href = "todo" class = "btn btn-success">Add Todo</a>
			</div>
		 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
			<script src=https://code.jquery.com/jquery-3.6.0.js></script>
	</body>
</html>