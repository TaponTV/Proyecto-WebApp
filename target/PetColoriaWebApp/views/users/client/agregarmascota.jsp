<%-- 
    Document   : agregarmascota
    Created on : 28 may 2023, 14:16:45
    Author     : Admin
--%>

<%@page import="models.Cliente"%>
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
            Cliente client = new Cliente();
            Usuario user = ((Usuario) request.getSession().getAttribute("CurrentUser"));
            client.setIdUser(user.getIdUser());
            client.setIdCliente();
            int idcliente = client.getIdCliente();

        %>
        <h1>Agregar Mascota</h1>
        <a href="<%=request.getContextPath()%>/views/users/client/menu.jsp"><button>Regresar</button></a>
        <form action="<%= request.getContextPath()%>/AgregarMascota" method="post">
            <p>Nombre de mascota
                <input type="text" name="idcliente" value="<%= idcliente%>" hidden>
                <input type="text" name="name" placeholder="Nombre de mascota"></p>
            <p>Edad de la mascota
                <input type="text" name="edad" placeholder="Edad"></p>
            <p>Fecha de nacimiento
                <input type="date" name="date"></p>
            <p>Raza
                <input type="text" name="raza" placeholder="raza"></p>
            <p>Especie
                <select name="especie">
                    <option><% request.getSession().setAttribute("Perro", 1); %>Perro</option>
                    <option><% request.getSession().setAttribute("Gato", 2); %>Gato</option>
                    <option><% request.getSession().setAttribute("Conejo", 3); %>Conejo</option>
                    <option><% request.getSession().setAttribute("Reptil", 4); %>Reptil</option>
                    <option><% request.getSession().setAttribute("Ave", 5); %>Ave</option>
                    <option><% request.getSession().setAttribute("Pez", 6);%>Pez</option>
                </select></p>
            <button type="submit">Registrar Mascota</button>
        </form>
    </body>
</html>
