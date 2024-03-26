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
    <h1>Editar Película</h1>
    
    <%-- Mostrar mensaje de error si existe --%>
    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:if>
    
    <form:form action="/peliculas/${pelicula.id}" method="POST" modelAttribute="pelicula" class="row g-3">
        <form:hidden path="id" />
        
        <div class="col-12">
            <form:label path="nombre" class="form-label">Nombre</form:label>
            <form:input path="nombre" class="form-control" placeholder="Ingrese nombre" value="${pelicula.nombre}"/>
            <form:errors path="nombre" class="text-danger"/>
        </div>
        
        <div class="col-12">
            <form:label path="descripcion" class="form-label">Descripcion</form:label>
            <form:input path="descripcion" class="form-control" placeholder="Ingrese una breve descripcion" value="${pelicula.descripcion}"/>
            <form:errors path="descripcion" class="text-danger"/>
        </div>
        
        <div class="col-12">
            <form:label path="calificacion" class="form-label">Calificacion</form:label>
            <form:input path="calificacion" class="form-control" placeholder="Ingrese un numero del 1 al 5" value="${pelicula.calificacion}"/>
            <form:errors path="calificacion" class="text-danger"/>
        </div>
        
        <div class="col-12">
            <input type="hidden" name="_method" value="PUT" />
            <input type="submit" value="Guardar Cambios" class="btn btn-primary mt-3">
        </div>
    </form:form>
</div>


</body>
</html>