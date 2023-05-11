<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eshop</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<base href="${pageContext.request.contextPath }/">	
</head>
<body>
	<div class="container">
		<h1>edition fournisseur</h1>
		<form action="fournisseur" method="post">
			<input type="hidden" name="action" value="${action}">
			<div class="form-group">
				<label for="id">id:</label> <input class="form-control" name="id"
					id="id" readonly="readonly" placeholder="génération automatique"
					value="${fournisseur.id}">
			</div>
			<div class="form-group">
				<label for="nom">nom:</label> <input class="form-control" name="nom"
					id="nom" value="${fournisseur.nom }">
			</div>
			<div class="form-group">
				<label for="contact">contact:</label> <input class="form-control"
					name="contact" id="contact" value="${fournisseur.contact }">
			</div>
			<div class="form-group">
				<label for="adresse.numero">numero:</label> <input
					class="form-control" name="adresse.numero" id="adresse.numero"
					value="${fournisseur.adresse.numero }">
			</div>
			<div class="form-group">
				<label for="adresse.rue">rue:</label> <input class="form-control"
					name="adresse.rue" id="adresse.rue"
					value="${fournisseur.adresse.rue }">
			</div>
			<div class="form-group">
				<label for="adresse.codePostal">code postal:</label> <input
					class="form-control" name="adresse.codePostal"
					id="adresse.codePostal" value="${fournisseur.adresse.codePostal }">
			</div>
			<div class="form-group">
				<label for="adresse.ville">ville:</label> <input
					class="form-control" name="adresse.ville" id="adresse.ville"
					value="${fournisseur.adresse.ville }">
			</div>
			<div>
				<button type="submit" class="btn btn-primary">enregistrer</button>
				<a href="fournisseur" class="btn btn-link">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>