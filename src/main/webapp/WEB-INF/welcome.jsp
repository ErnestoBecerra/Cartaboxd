<%@page import="org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration.WelcomePageConfiguration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P�gina principal</title>
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
							<a class="nav-link" href="#">Inicio</a>
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
    				<p><h1>Cartaboxd</h1></p>
  				</blockquote>
  				<figcaption class="blockquote-footer">
    				La mejor p�gina para<cite title="Source Title"> Calificar pel�culas</cite>
  				</figcaption>
			</figure>
			
			<p class="lh-1">�Vive la experiencia completa! Comienza a utilizar nuestra p�gina para crear un ambiente 
			informativo con el fin de compartir tus experiencias cinematogr�ficas con otros usuarios. 
			</p>
  			<h3 class="text-center">�No lo pienses m�s!</h3>
  			<p class="lh-1">Crea un perfil o inicia sesi�n para comenzar con esta interacci�n �nica.</p>
  			
  			<div class="col-sm-6 mb-3 mb-sm-0">
    			<div class="card">
      				<div class="card-body">
        				<h5 class="card-title">Administradores</h5>
        				<p class="card-text">Si deseas ingresar como administrador, empieza con esta opci�n, valida tus
        				credenciales y continua trabajando.
        				</p>
        				<a href="/login-admin" class="btn btn-primary">Iniciar sesi�n</a>
      				</div>
   	 			</div>
  			</div>
  			<div class="col-sm-6">
    			<div class="card">
      				<div class="card-body">
        				<h5 class="card-title">Visitante</h5>
        				<p class="card-text">Si deseas ingresar como vistante, empieza con esta opci�n, selecciona el
        					campo de tu preferencia.
						</p>
        				<a href="/login-usuario" class="btn btn-primary">Iniciar sesi�n</a>
        				<a href="/nuevo-usuario" class="btn btn-primary">Registrarse</a>
      				</div>
    			</div>
 	 		</div>

		</div>

		<table class="table table-hover">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Descripcion</th>
						<th>Calificacion</th>						
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${peliculas}" var="pelicula">
					<tr>
						<td>${pelicula.nombre}</td>
						<td>${pelicula.descripcion}</td>
						<td>${pelicula.calificacion}</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
	</div>
</body>
</html>