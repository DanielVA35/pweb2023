<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
<body>
<div class="container-fluid">
<div class="position-absolute top-45 start-50 translate-middle">
	<h1>Calculadora de Areas</h1>
<%
	String base = request.getParameter("base");
	String altura = request.getParameter("altura");
	
	if(base.isEmpty() || altura.isEmpty()){
%>
		<div class="alert alert-danger" role="alert">
  			<p>Para que o cálculo seja realizado são necessários valores validos</p>
		</div>
<%} else{
	Float basef = Float.parseFloat(base);
	Float alturaf = Float.parseFloat(altura);
	
	Float area = (basef * alturaf) / 2;
%>
		<p>A área do triângulo de base <%=basef %> e altura <%=alturaf %> é <%=area %> centímetros quadrados</p>
<%} %>
	<a href="index.jsp" class="btn btn-primary">Voltar</a>
 
</div>
</div>
</body>
</html>