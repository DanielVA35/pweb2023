<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de Usuaros</title>
</head>
<body>

	<h1>Lista de Usuarios</h1>
	<table>
		<c:forEach var="usuario" items="${usuarios}" varStatus="id">
			<tr>
				<td>${usuario.id }</td>
				<td>${usuario.nome }</td>
				<td>${usuario.email }</td>
			</tr>
			
		</c:forEach>
		<tr></tr>
	</table>
</body>
</html>