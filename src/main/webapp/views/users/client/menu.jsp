<%-- 
    Document   : menu
    Created on : 9 may 2023, 20:09:24
    Author     : eduar
--%>

<%@page import="models.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            String name = "";
            if (response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else if (request.getSession(false) == null || request.getSession().getAttribute("CurrentUser") == null) {
                request.getRequestDispatcher("/CheckController").forward(request, response);
            } else {
                Usuario currentUser = (Usuario) request.getSession().getAttribute("CurrentUser");
                if (currentUser != null && currentUser.getIdRol() == 3) {
                    name = currentUser.getNombre() + " " + currentUser.getApPaterno() + currentUser.getApMaterno();
                } else {
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                    return;
                }
            }
        %>
        <h1> PetColoria - Version beta 1.0 </h1>
        <h3>Cliente: <%= name%></h3>
        <h3> MENU CLIENTE </h3>
        <form action="<%= request.getContextPath()%>/BusquedaServlet" method="post">
            <input type="submit" value ="Buscar Veterinario">
        </form>
        <form action="<%= request.getContextPath()%>/ConsultaCliente" method="post">
            <input type="submit" value ="Consultas">
        </form>
        <form action="<%= request.getContextPath()%>/SolicitudCliente" method="post">
            <input type="submit" value ="Solicitudes pendientes">
        </form>
        <form action="<%= request.getContextPath()%>/views/users/client/agregarmascota.jsp" method="post">
            <input type="submit" value ="Agregar Mascota">
        </form>
        <form action="<%= request.getContextPath()%>/ShowPetController" method="post">
            <input type="submit" value ="Mostrar mascotas">
        </form>
        <form action="<%= request.getContextPath()%>/logout" method="post">
            <input type="submit" value ="Cerrar Sesion">
        </form>

    </body>
</html>
