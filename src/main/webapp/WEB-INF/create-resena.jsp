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
		<h1>Crear Reseña</h1>
		<c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    	</c:if>
		<form:form action="/registrar-resena" method="POST" modelAttribute="resenia" class="row g-3">
            <form:hidden path="peliculaId" value="${pelicula.id}" />
			<%-- Esto imprimirá el valor de ${pelicula.id} --%>
<c:out value="${pelicula.id}" />

			<div class="col-12">
				<form:label path="resena" class="form-label">Reseña</form:label>
				<form:input path="resena" class="form-control" placeholder="Escribe una reseña"/>
				<form:errors path="resena" class="text-danger"/>
			</div>
			<div class="col-12">
				<form:label path="calificacion" class="form-label">Calificacion</form:label>
				<form:input path="calificacion" class="form-control" placeholder="Ingrese un numero del 1-5"/>
				<form:errors path="calificacion" class="text-danger"/>
			</div>

			<div class="col-12">
    			<input type="submit" value="Agregar reseña" class="btn btn-success mt-3">
  			</div>
		</form:form>
	</div>
</body>
</html>