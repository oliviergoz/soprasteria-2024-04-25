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
		<h1>edition produit</h1>
		<form action="produit" method="post">
			<input type="hidden" name="action" value="${action}">
			<div class="form-group">
				<label for="id">id:</label> <input class="form-control" name="id"
					id="id" readonly="readonly" placeholder="génération automatique"
					value="${produit.id}">
			</div>
			<div class="form-group">
				<label for="nom">nom:</label> <input class="form-control" name="nom"
					id="nom" value="${produit.nom }">
			</div>
			<div class="form-group">
				<label for="description">description:</label>
				<textarea name="description" rows="10" class="form-control">${produit.description }</textarea>
			</div>
			<div class="form-group">
				<label for="prix">prix:</label> <input type="number" step="0.01"
					class="form-control" name="prix" id="prix" value="${produit.prix }">
			</div>
			<div class="form-group">
				<label for="fournisseur.id">fournisseur:</label> <select
					name="fournisseur.id" id="fourisseur.id" class="form-control">
					<c:forEach var="f" items="${fournisseurs}">
						<c:choose>
							<c:when test="${produit.fournisseur.id==f.id }">
								<option value="${f.id}" selected="selected">nom:${f.nom},
									contact:${f.contact}</option>
							</c:when>
							<c:otherwise>
								<option value="${f.id}">nom:${f.nom},
									contact:${f.contact}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div>
				<button type="submit" class="btn btn-primary">enregistrer</button>
				<a href="produit" class="btn btn-link">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>