<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Mensageiro Web</title>
</head>
<body>
	<div>
		<div>
			<h1>Serviço de Mensageira</h1>
			<hr>
		</div>
		<form action="mensageiro" method="post">
			
			<label for="emails">E-mail: </label> 
			<select name="emails" id="emails">
				<c:forEach items="${lstDeEmails}" var="email">
					<option value="${email}">${email}</option>
				</c:forEach>
			</select> <br> 
			
			<input type="radio" id="formal" name="cumprimento" value="formal">
			<label for="formal">Cumprimento formal</label> 
			
			<input type="radio" id="horario" name="cumprimento" value="horario">
			<label for="horario">Cumprimento conforme horário</label> <br>
				
			<input type="checkbox" name="aviso" id="aviso" value="automatico">
			<label>Incluir aviso de "E-mail automático"</label> <br>
			
			<label>Título: </label>
			<input type="text" name="titulo" id="titulo"> <br>
			
			<label>Texto:</label> <br>
			<input type="text" name="texto" id="texto">
			
			<input type="submit" value="Enviar">
		</form>
			<c:if test="${funcionou}">
				<div class="alert alert-success" role="alert">
	  				A simple success alert—check it out!
				</div>
				
			</c:if>

			
	</div>
</body>
</html>