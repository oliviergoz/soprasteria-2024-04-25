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
		<form action="commande/save" method="post">
			selection du client:<select name="id" class="form-select"
				required="required">
				<c:forEach items="${clients}" var="client">
					<option value="${client.id}">${client.prenom}&nbsp;
						${client.nom}</option>
				</c:forEach>
			</select>
			<button type="submit" class="btn btn-primary">enregistrer</button>
		</form>

	</div>

</body>
</html>