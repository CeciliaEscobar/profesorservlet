<%-- 
    Document   : create
    Created on : 8 jul. 2023, 16:58:16
    Author     : escob
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Crear registro de Profesor</title>
        <link rel="stylesheet" href="<%=request.getContextPath() %>/webjars/bootstrap/5.3.0-alpha3/dist/css/bootstrap.min.css"/>
        <script defer src="<%=request.getContextPath()%>/webjars/bootstrap/5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>


    </head>
    <body>
        <jsp:include page="../templates/header.jsp"></jsp:include>




        <h1>Pagina de Registro de Profesores</h1>
        <div class="container">

            <form action="<%= request.getContextPath() %>/ProfesorServlet?action=create" method="POST">
                <div class="mb-3">
                    <label for="nombre" class="form-label"> Nombre: </label> 
                    <input type="text" class="form-control" id="nombre" placeholder="Introduzca nombre" name="nombre">
                </div>
                <br>
                <div class="mb-3">

                    <label for="apellido" class="form-label"> Apellido: </label>
                    <input type="text" class="form-control" id="apellido" placeholder="Introduzca apellido" name="apellido">
                </div>
                <br>
                <div class="mb-3">

                    <label for="email" class="form-label"> Email </label>
                    <input type="email" class="form-control" id="email" placeholder="Introduzca email" name="email">
                </div>
                <br>
                <div class="mb-3">

                    <label for="colegio" class="form-label"> Colegio: </label>
                    <input type="text" class="form-control" id="colegio" placeholder="Introduzca nombre del colegio"  name="colegio">
                </div>
                <br>
                <button class="btn btn-primary" type="submit" name="Registrar">Registrar</button>
            </form>
        </div>
    </body>
</html>