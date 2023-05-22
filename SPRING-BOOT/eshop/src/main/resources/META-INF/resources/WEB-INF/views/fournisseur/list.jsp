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
		<h1>liste des fournisseurs</h1>
		<c:if test="${param['delete']!=null}">
			<div class="alert alert-warning">suppression du 
				fourniseur ${param['delete']} </div>
		</c:if>
		<c:if test="${param['create']!=null}">
			<div class="alert alert-success">
				creation du fournisseur ${param['create']}
			</div>
		</c:if>
		<c:if test="${param['update']!=null}">
			<div class="alert alert-success">
				mise à jour du fournisseur ${param['update']}
			</div>
		</c:if>
		<table class="table">
			<tr>
				<th>id:</th>
				<th>nom:</th>
				<th>contact:</th>
				<th>adresse:</th>
				<th>code postal:</th>
				<th>ville:</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="f" items="${fournisseurs}">
				<tr>
					<td>${f.id}</td>
					<td>${f.nom}</td>
					<td>${f.contact }</td>
					<td>${f.adresse.numero}&nbsp;${f.adresse.rue }</td>
					<td>${f.adresse.codePostal}</td>
					<td>${f.adresse.ville}</td>
					<td><a href="fournisseur/edit?id=${f.id}"
						class="btn btn-primary">editer</a></td>
					<td><a href="fournisseur/delete?id=${f.id}"
						class="btn btn-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="fournisseur/add" class="btn btn-link">nouveau
			fournisseur</a>
	</div>
</body>
</html>