<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Registrar Usuario</h1>
		<form:form action="/registrar-usuario" method="POST" modelAttribute="usuario" class="row g-3">
			<div class="col-12">
				<form:label path="nombre" class="form-label">Nombre</form:label>
				<form:input path="nombre" class="form-control" placeholder="Ingrese su nombres(s)"/>
				<form:errors path="nombre" class="text-danger"/>
			</div>
			
			<div class="col-12">
				<form:label path="apellido" class="form-label">Apellido</form:label>
				<form:input path="apellido" class="form-control" placeholder="Ingrese su apellido"/>
				<form:errors path="apellido" class="text-danger"/>
			</div>
			
			<div class="col-md-6">
				<form:label path="email" class="form-label">E-mail</form:label>
				<form:input path="email" class="form-control" placeholder="Ingrese su correo electrónico"/>
				<form:errors path="email" class="text-danger"/>
			</div>
			
			<div class="col-md-6">
				<form:label path="contrasena" class="form-label">Contraseña</form:label>
				<form:input path="contrasena" class="form-control" placeholder="Ingrese una contraseña"/>
				<form:errors path="contrasena" class="text-danger"/>
			</div>
			
			<div class="col-12">
    			<input type="submit" value="Agregar usuario" class="btn btn-success mt-3">
  			</div>
		</form:form>
	</div>
</body>
</html>