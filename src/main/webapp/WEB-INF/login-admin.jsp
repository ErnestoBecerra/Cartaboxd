<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sesión Administrador</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Iniciar sesión administrador</h1>
		<form:form action="/iniciar-admin" method="POST" class="row g-3">
			<div class="col-md-6">
				<label class="form-label">Correo</label>
				<input type="email" name="email" class="form-control" placeholder="Ingrese su correo"/>
			</div>
			
			<div class="col-md-6">
				<label  class="form-label">Contraseña</label>
				<input  type="password" name="password" class="form-control" placeholder="Ingrese su contraseña"/>
			</div>
			
			<div class="col-12">
    			<input type="submit" value="Validar datos" class="btn btn-success mt-3">
  			</div>
		</form:form>
	</div>
</body>
</html>