<%@page import="formation.model.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>vos informations</h1>
		<h2><%=((Utilisateur) request.getAttribute("utilisateur")).getPrenom()%> 
			<%=((Utilisateur) request.getAttribute("utilisateur")).getNom()%>
			<%=((Utilisateur) request.getAttribute("utilisateur")).getLogin()%></h2>
		<h2>${utilisateur.getPrenom()}${utilisateur.nom }
			${utilisateur.login }</h2>
		<h2>${utilisateur.infos }</h2>
	</div>
</body>
</html>