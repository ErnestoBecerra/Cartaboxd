<%@page import="org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration.WelcomePageConfiguration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página principal</title>
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
    				La mejor página para<cite title="Source Title"> Calificar películas</cite>
  				</figcaption>
			</figure>
			
			<p class="lh-1">¡Vive la experiencia completa! Comienza a utilizar nuestra página para crear un ambiente 
			informativo con el fin de compartir tus experiencias cinematográficas con otros usuarios. 
			</p>
  			<h3 class="text-center">¡No lo pienses más!</h3>
  			<p class="lh-1">Crea un perfil o inicia sesión para comenzar con esta interacción única.</p>
  			
  			<div class="col-sm-6 mb-3 mb-sm-0">
    			<div class="card">
      				<div class="card-body">
        				<h5 class="card-title">Administradores</h5>
        				<p class="card-text">Si deseas ingresar como administrador, empieza con esta opción, valida tus
        				credenciales y continua trabajando.
        				</p>
        				<a href="#" class="btn btn-primary">Iniciar sesión</a>
      				</div>
   	 			</div>
  			</div>
  			<div class="col-sm-6">
    			<div class="card">
      				<div class="card-body">
        				<h5 class="card-title">Visitante</h5>
        				<p class="card-text">Si deseas ingresar como vistante, empieza con esta opción, selecciona el
        					campo de tu preferencia.
						</p>
        				<a href="/iniciar-sesion" class="btn btn-primary">Iniciar sesión</a>
        				<a href="/nuevo-usuario" class="btn btn-primary">Registrarse</a>
      				</div>
    			</div>
 	 		</div>

		</div>
	</div>
</body>
</html>