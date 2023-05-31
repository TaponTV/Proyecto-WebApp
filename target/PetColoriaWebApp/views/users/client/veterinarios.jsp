<%-- 
    Document   : veterinarios
    Created on : 28 may 2023, 14:16:15
    Author     : Admin
--%>

<%@page import="models.Veterinario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String msg = "";
            if (request.getSession().getAttribute("msg") != null) {
                msg = request.getSession().getAttribute("msg").toString();
                out.print(msg);
                request.getSession().setAttribute("msg", null);
            }

        %>
        <h1>Veterinarios registrados</h1>
        <a href="<%=request.getContextPath()%>/views/users/client/menu.jsp"><button>Regresar</button></a>
        <table>
            <thead>
                <tr>
                    <td>Cedula</td>
                    <td>Nombre</td>
                    <td>Especialidad</td>
                    <td>Universidad</td>
                    <td>telefono</td>
                    <td> Detalles </td>
                </tr>
            </thead>
            <tbody>
                <% List<Veterinario> data = (List<Veterinario>) request.getSession().getAttribute("veterinarios");
                    if (data != null) {
                        for (Veterinario datac : data) {
                %>
                <tr>
                    <td><%= datac.getCedula()%></td>
                    <td><%= datac.getNombre() + datac.getApPaterno() + datac.getApMaterno()%></td>
                    <td><%= datac.getEspecialidad()%></td>
                    <td><%= datac.getUniversidad()%></td>
                    <td><%= datac.getTelefono()%></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/views/users/client/registrarsolicitud.jsp?id=<%= datac.getCedula()%>"><button>Registrar Solicitud</button></a>
                        <a href="<%=request.getContextPath()%>/Comentarios?id=<%= datac.getCedula()%>"><button>Ver Comentarios</button></a>
                    </td>
                </tr>
                <%
                        }
                    }

                %>
            </tbody>
        </table>
    </body>
</html>
