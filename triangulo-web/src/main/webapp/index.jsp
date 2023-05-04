<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>

</head>
<body>
	<div class="container-fluid">
		<div class="position-absolute top-50 start-50 translate-middle">
			<form action="mostraArea.jsp">
				<h1>Calcular area</h1>
				<label for="base">Valor da base:</label>
				<input type="text" name="base" id="base"> <br>
				<label for="altura">Valor da altura:</label>
				<input type="text" name="altura" id="altura"> <br>
				<input type="submit" value="Calcular" class="btn btn-primary">
			</form>
		
		</div>
	 	
	</div>
</body>
</html>