<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> 
		<title>Todo Page</title>
	</head>
	<body>
	
		<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
			<a class="navbar-brand m-1" href="https://courses.in28minutes.com">Spring boot project</a>
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="/todos">Todos</a></li>
				</ul>
			</div>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/login">Logout</a></li>
			</ul>	
		</nav>
		<div class = "container">
			<h1>Your todos</h1>
				<table class= "table">
					<thead>
						<tr>
							<th>Description</th>
							<th>Target Date</th>
							<th>Done</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
							<c:forEach items = "${todos}" var="todo">
							<tr> 
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.isDone}</td>
							<td><a href = "update-todo?id=${todo.id}" class="btn btn-info">Update</a></td>
							<td><a href = "delete-todo?id=${todo.id} " class = "btn btn-warning">DELETE</a></td>
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