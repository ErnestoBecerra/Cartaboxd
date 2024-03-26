<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio Administrador</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-expand-lg">
					<div class="navbar-brand">Cartaboxd</div>
					<ul class="nav">
						<li class="nav-item">
							<a class="nav-link" href="/inicio">Inicio</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#">Acerca de</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#">Contacto</a>
						</li>
					</ul>
				</nav>
			</div>
			
			
			<figure class="text-center">
  				<blockquote class="blockquote">
    				<p><h1>Bienvenid@ a Cartaboxd</h1></p>
  				</blockquote>
			</figure>
			
			<p class="lh-1">�Comienza ahora! Agrega, borra y edita las pel�culas que los usuarios podr�n visualizar en la 
			p�gina principal. 
			</p>
			
			<div class="col-12">
    			<a href="/nueva-pelicula" class="btn btn-success">Agregar pelicula</a>
  			</div>	
			
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre Pelicula</th>
						<th>Descripcion</th>
					</tr>
				</thead>
			</table>>
		</div>
	</div>
</body>
</html>