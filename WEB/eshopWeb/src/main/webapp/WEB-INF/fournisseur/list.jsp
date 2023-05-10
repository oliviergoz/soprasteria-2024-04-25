<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="eshop.entities.Fournisseur"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Fournisseur> fournisseurs = (List<Fournisseur>) request.getAttribute("fournisseurs");
	
	for (Fournisseur f : fournisseurs) {
	%>
	<div>fournisseur: <%=f.getId() %> <%=f.getNom() %></div>
	<%
	}
	%>
</body>
</html>