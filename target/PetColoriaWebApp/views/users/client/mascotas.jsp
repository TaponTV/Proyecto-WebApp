<%-- 
    Document   : mascotas
    Created on : 28 may 2023, 14:16:23
    Author     : Admin
--%>

<%@page import="models.Mascota"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mascotas Registradas</h1>
        <a href="<%=request.getContextPath()%>/views/users/client/menu.jsp"><button>Regresar</button></a>
        <table>
            <thead>
                <tr>
                    <td> Nombre </td>
                    <td> Edad </td>
                    <td> Raza </td>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Mascota> list = (List<Mascota>) request.getSession().getAttribute("DataPet");
                    if (list != null) {
                        for (Mascota var : list) {
                %>
                <tr>
                    <td><%= var.getNombre()%></td>
                    <td><%= var.getEdad()%></td>
                    <td><%= var.getRaza()%></td>
                    <td><%= var.getNombre()%></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
