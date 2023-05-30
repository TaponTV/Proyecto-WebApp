<%-- 
    Document   : solicitudes
    Created on : 28 may 2023, 14:16:38
    Author     : Admin
--%>

<%@page import="models.Solicitud"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitudes</title>
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
                    <td>Id Solicitud</td>
                    <td>Nombre Veterinario</td>
                    <td>Fecha</td>
                    <td>Detalle</td>
                    <td> Status</td>
                </tr>
            </thead>
            <tbody>
                <% List<Solicitud> data = (List<Solicitud>) request.getSession().getAttribute("solicitudes");
                    if (data != null) {
                        for (Solicitud datac : data) {
                %>
                <tr>
                    <td><%= datac.getIdSolicitud()%></td>
                    <td><%= datac.getvNombre()%></td>
                    <td><%= datac.getFecha()%></td>
                    <td><%= datac.getDescripcion()%></td>
                    <td><%= datac.getStatus()%></td>
                    <td>
                        <%
                            if (datac.getIdEstado()==1) {
                        %>
                        <a href="<%=request.getContextPath()%>/ConfirmController?action=ripbell&BellID=<%= datac.getIdSolicitud()%>"><button>Cancelar Solicitud</button></a>
                        <%
                            }
                        %>
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
