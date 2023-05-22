<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h1>edition client</h1>
		<form:form action="client/save" method="post" modelAttribute="client">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" class="form-control" readonly="true"
					placeholder="numero automatique" />
			</div>
			<div class="form-group">
				<form:label path="prenom">prenom:</form:label>
				<form:input path="prenom" class="form-control" />
				<form:errors path="prenom" element="div" class="alert alert-danger">
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="nom">nom:</form:label>
				<form:input path="nom" class="form-control" />
				<form:errors path="nom" element="div" class="alert alert-danger">
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="adresse.numero">numero:</form:label>
				<form:input path="adresse.numero" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="adresse.rue">rue:</form:label>
				<form:input path="adresse.rue" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="adresse.codePostal">code postal:</form:label>
				<form:input path="adresse.codePostal" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="adresse.ville">ville:</form:label>
				<form:input path="adresse.ville" class="form-control" />
				<form:errors path="adresse.ville"></form:errors>
			</div>
			<div>
				<button type="submit" class="btn btn-primary">enregistrer</button>
				<a href="client" class="btn btn-link">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>