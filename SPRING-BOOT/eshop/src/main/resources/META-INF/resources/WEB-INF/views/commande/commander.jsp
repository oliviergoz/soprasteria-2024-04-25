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
		<h1>nos produits</h1>
		<table class="table">
			<c:forEach items="${produits}" var="produit">
				<tr>
					<td>${produit.nom}</td>
					<td>${produit.description}</td>
					<td>${produit.prix}</td>
					<td><a href="commande/panier/add?id=${produit.id}"
						class="btn btn-link"> ajouter au panier </a></td>
					<td>${panier[produit]}</td>
					<td><c:if test="${panier[produit]!=null}">
							<a href="commande/panier/remove?id=${produit.id}"
								class="btn btn-link">retirer </a>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${!panier.isEmpty() }"> <a href="commande/save" class="btn btn-link">valider commande</a></c:if>
	</div>

</body>
</html>