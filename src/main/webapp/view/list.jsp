<%-- 
    Document   : list
    Created on : 8 jul. 2023, 16:58:39
    Author     : escob
--%>

<%@page language= "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/webjars/bootstrap/5.3.0-alpha3/dist/css/bootstrap.min.css"/>
        <script defer src="<%=request.getContextPath()%>/webjars/bootstrap/5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>

        <title>Lista de Profesores</title>

    </head>
    <body>

       <jsp:include page="../templates/header.jsp"></jsp:include>
        
        <div class="container">
            <table class="table">
                <tr>
                    <td>ID</td>
                    <td>NOMBRE</td>
                    <td>APELLIDO</td>
                    <td>EMAIL</td>
                    <td>COLEGIO</td>
                    <td colspan="2" align="center">ACCIONES</td>
                    
                </tr>
                <c:forEach var="datosBD" items="${lista}"> <%--Lista dentro de ProfesorServlet metodo List --%>
                <tr>
                    <td><c:out value="${datosBD.id}"/></td><%--Debe coincidir con el model los datosBD.xxxx --%>
                    <td><c:out value="${datosBD.nombre}"/></td>
                    <td><c:out value="${datosBD.apellido}"/></td>
                    <td><c:out value="${datosBD.email}"/></td>
                    <td><c:out value="${datosBD.colegio}"/></td>
                    <td>
                        <button type="button" class="btn btn-warning">
                            <a href="<%= request.getContextPath()%>/ProfesorServlet?action=read&id=<c:out value="${datosBD.id}"/>">
                               Actualizar
                            </a>
                        </button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-danger">
                           <a href="<%= request.getContextPath()%>/ProfesorServlet?action=delete&id=<c:out value="${datosBD.id}"/>">
                           Eliminar
                           </a>
                        </button>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>