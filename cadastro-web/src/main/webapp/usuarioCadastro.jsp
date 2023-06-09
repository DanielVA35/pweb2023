<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Cadastro de Usu�rio</title>
  </head><body>
    <%
    	String nome = request.getParameter("nome");
    	if(nome == null){
    		nome = "";
    	}
    
    	String email = request.getParameter("email");
    	if(email == null){
    		email = "";
    	}
    %>
  	<div>
 		<form method = "post" action="cadastroUsuario">
	    	<h1>Cadastro de Usu�rio</h1>
	    	
	    	<label for="nome">Nome:</label>
	        <input type="text" name="nome" id="nome" value="${param.nome}"><br>
	        
	        <label for="email">E-mail:</label>
	        <input type="text" name="email" id="email" value="<%=email%>"><br>
	        
	        <label for="senha1">Senha:</label>
	        <input type="password" name="senha1" id="senha1"><br>
	        
	        <label for="senha2">confirmar senha:</label>
	        <input type="password" name="senha2" id="senha2"><br>
	        
	        <input type="submit" value="Salvar">
	        
	        <a class="btn btn-primary" href="cadastroUsuario" role="button">Listar Usu�rios</a>
	        
	        <a class="btn btn-primary" href="index.html" role="button">Voltar</a>
    	</form>
    	<c:if test="${not empty param.nome }">
    		<div class="alert alert-danger" role="alert">
	    		 ${param.nome}<span>, as senhas informadas n�o s�o iguais.</span> 
	    	</div>
    	</c:if>
    	
	</div>
	
</body>
</html>