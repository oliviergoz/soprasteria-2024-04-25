<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formation</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<%
		if (request.getAttribute("erreur") != null) {
		%>
		<div class="alert alert-danger">
			<%=request.getAttribute("erreur")%>
		</div>
		<%
		}
		%>
		<form action="age" method="post">
			<label>saisir un age:<input type="number" name="age"
				class="form-control"></label>
			<button type="submit" class="btn btn-primary">envoyer</button>
		</form>
	</div>
</body>
</html>