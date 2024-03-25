<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro Lista</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Crear Lista</h1>
		<form:form action="/registrar-lista" method="POST" modelAttribute="lista" class="row g-3">
			<div class="col-md-6">
				<form:label path="nombreLista" class="form-label">Nombre</form:label>
				<form:input path="nombreLista" class="form-control" placeholder="Escriba el nombre de su lista"/>
				<form:errors path="nombreLista" class="text-danger"/>
			</div>
			
			<div class="col-12">
    			<input type="submit" value="Agregar Lista" class="btn btn-success mt-3">
  			</div>			
		</form:form>
	</div>
</body>
</html>