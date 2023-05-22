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
		<h1>edition produit</h1>
		<form:form action="produit/save" method="post"
			modelAttribute="produit">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" cssClass="form-control"
					placeholder="numero auto" readonly="true" />
			</div>
			<div class="form-group">
				<form:label path="nom">nom:</form:label>
				<form:input path="nom" class="form-control" />
				<form:errors path="nom">
					<div class="h-25 alert alert-danger small">*nom obligatoire</div>
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="description">description</form:label>
				<form:textarea path="description" rows="10" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="prix">prix:</form:label>
				<form:input type="number" step="0.01" path="prix"
					class="form-control" />
				<form:errors path="prix" element="div" class="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="fournisseur.id">fournisseur:</form:label>
				<%-- 				<form:select path="fournisseur.id" items="${fournisseurs}" --%>
				<%-- 					itemValue="id" itemLabel="infos" class="form-control"></form:select> --%>
				<form:select path="fournisseur.id" class="form-control" >
					<form:option value="">pas de fournisseur</form:option>
					<form:options items="${fournisseurs}" itemLabel="infos" itemValue="id"/>
				</form:select>
			</div>
			<div>
				<button type="submit" class="btn btn-primary">enregistrer</button>
				<a href="produit" class="btn btn-link">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>