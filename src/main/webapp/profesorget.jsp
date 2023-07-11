<%-- 
    Document   : profesorget
    Created on : 8 jul. 2023, 16:55:42
    Author     : escob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina de Registro de Profesores</h1>
        <form action="<%= request.getContextPath()%>/ProfesorServlet" method="GET">
            <label>Nombre:</label>
            <input type="text" name="nombre">
            <br> 
            <label>Email:</label>
            <input type="email" name="emailId">
            <br>
            <label>Telefono:</label>
            <input type="text" name="telefono">
            <br>
            <label>Colegio:</label>
            <input type="text" name="colegio">
            <br>
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>

