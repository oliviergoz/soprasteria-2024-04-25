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
<body class="container">
	<h1>hello world</h1>
	<div>
		<h2>votre age:<%=request.getParameter("age") %></h2>
		<%
		//scriptlet
		Integer age = Integer.parseInt(request.getParameter("age"));
		if (age < 18) {
		%>
		<h2>mineur</h2>
		<%
		} else {
		%>
		<h2>majeur</h2>
		<%
		}
		%>
		<table class="table">
			<tr>
				<td>dlsjsdl</td>
				<td>sldkjsdmlfjsd</td>
			</tr>
			<tr>
				<td>dlsjsdl</td>
				<td>sldkjsdmlfjsd</td>
			</tr>

		</table>
	</div>
</body>
</html>