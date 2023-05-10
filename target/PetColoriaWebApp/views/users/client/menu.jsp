<%-- 
    Document   : menu
    Created on : 9 may 2023, 20:09:24
    Author     : eduar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="<%= request.getContextPath()%>/logout" method="post">
            <input type="submit" value ="Cerrar Sesion">
        </form>
        <h1>Este es el menu para clientes</h1>
    </body>
</html>
