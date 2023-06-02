<%-- 
    Document   : historial
    Created on : 2 jun 2023, 14:59:54
    Author     : Admin
--%>

<%@page import="models.Receta"%>
<%@page import="java.util.Map"%>
<%@page import="models.Consulta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Historial Clinico</h1>
        <a href="<%= request.getContextPath()%>/views/users/client/mascotas.jsp"><button>Regresar</button></a>
        <%
            List<Consulta> list = (List<Consulta>) request.getSession().getAttribute("meets");
            Map<Integer, List<Receta>> hashMeet = (Map<Integer, List<Receta>>) request.getSession().getAttribute("hashMeet");
            if (list != null) {
                if (!list.isEmpty()) {
        %>
        <table>
            <thead>
                <tr>
                    <td>Consulta</td>
                    <td>Fecha Consulta</td>
                    <td>Detalle</td>
                    <td>Veterinario</td>
                    <td>Receta</td>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Consulta var : list) {
                %>
                <tr>
                    <td><%= var.getIdConsulta()%></td>
                    <td><%= var.getFechaConsulta()%></td>
                    <td><%= var.getDetalle()%></td>
                    <td><%= var.getAux().getvNombre()%></td>
                    <td>
                        <%
                            List<Receta> recipes = hashMeet.get(var.getIdConsulta());
                            if (recipes != null) {
                                if (!recipes.isEmpty()) {
                                    for (Receta tmp : recipes) {
                        %>
                        <p>Medicamento: <%= tmp.getMedicamento()%></p>
                        <p>Administración: <%= tmp.getTipoAdministracion()%></p>
                        <p>Horario: <%= tmp.getHorario()%></p>
                        <p>Indicaciones: <%= tmp.getDetalles()%></p>
                        <%
                            }
                        } else {
                        %>
                        <p>No se encontro ninguna receta asignada a esta consulta, pongase en contacto con su Médico Veterinario</p>
                        <%
                                }
                            }
                        %>
                    </td>
                </tr>
                <%
                        }      
                } else {
                %>
            <p>No se ha programado ninguna cita aun</p>
            <%
                    }
                }
            %>
        </tbody>
    </table>
</body>
</html>
