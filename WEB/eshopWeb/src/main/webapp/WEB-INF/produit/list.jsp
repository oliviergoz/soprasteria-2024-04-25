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
		<h1>liste des produits</h1>
		<c:if test="${delete!=null}">
			<div class="alert alert-warning">suppression du produit
				${delete}</div>
		</c:if>
		<c:if test="${create!=null}">
			<div class="alert alert-success">
				creation du produit ${create}
			</div>
		</c:if>
		<c:if test="${update!=null}">
			<div class="alert alert-success">
				mise à jour du produit ${update}
			</div>
		</c:if>
		<table class="table">
			<tr>
				<th>id:</th>
				<th>nom:</th>
				<th>description:</th>
				<th>prix:</th>
				<th>fournisseur</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="p" items="${produits}">
				<tr>
					<td>${p.id}</td>
					<td>${p.nom}</td>
					<td>${p.description }</td>
					<td>${p.prix}</td>
					<td>${p.fournisseur}</td>
					<td><a href="produit?q=update&id=${p.id}"
						class="btn btn-primary">editer</a></td>
					<td><a href="produit?q=delete&id=${p.id}"
						class="btn btn-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="produit?q=add" class="btn btn-link">nouveau produit</a>
	</div>
</body>
</html>