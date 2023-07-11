<%-- 
    Document   : index
    Created on : 8 jul. 2023, 16:51:53
    Author     : escob
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Gestion de Profesores</title>
        <link rel="stylesheet" href="<%=request.getContextPath() %>/webjars/bootstrap/5.3.0-alpha3/dist/css/bootstrap.min.css"/>
        <script defer src="<%= request.getContextPath() %>/webjars/bootstrap/5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        
    <body class="d-flex flex-column min-vh-100">

        <jsp:include page="/templates/header.jsp"></jsp:include>

            <div class="container text-center">

                <h1 class="text-primary">Gestion de Profesores</h1>

                <div class="row">
                    <div class="col-sm-6 d-flex justify-content-center">
                        <div class="card" style="width: 18rem;">
                            <img src="assets/img/profesor.svg" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Registrar Profesor</h5>
                                <p class="card-text">Formulario para añadir un nuevo profesor</p>
                                <a href="<%= request.getContextPath() %>/ProfesorServlet?action=showRegister" class="btn btn-primary">Registrar</a>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 d-flex justify-content-center">
                    <div class="card" style="width: 18rem;">
                        <img src="assets/img/profesores.svg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Lista de Profesores</h5>
                            <p class="card-text">Muestra la lista de profesores registrados</p>
                            <a href="<%= request.getContextPath() %>/ProfesorServlet?action=list" class="btn btn-primary">Listar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="/templates/footer.jsp"></jsp:include>

    </body>
</html>
