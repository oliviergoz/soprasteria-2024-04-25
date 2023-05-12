<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${erreur!=null}">
		<div>infos manquantes</div>
	</c:if>
	<form method="post">
		prenom:<input name="prenom" value="${personne.prenom }"> <br>
		nom:<input name="nom" value="${personne.nom }"><br> rue:<input
			name="adresse.rue" value="${personne.adresse.rue }"><br>
		ville:<input name="adresse.ville" value="${personne.adresse.ville }"><br>
		<button type="submit">envoyer</button>
	</form>
</body>
</html>