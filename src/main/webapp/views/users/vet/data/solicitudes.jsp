<%@page import="models.Solicitud"%>
<%@page import="java.util.List"%>
<%
    List<Solicitud> datalist = (List<Solicitud>) request.getSession().getAttribute("dataList");
    if (datalist != null) {
        if (!datalist.isEmpty()) {
%>
<table>
    <thead>
        <tr>
            <td>ID Solicitud</td>
            <td>Cliente</td>
            <td>Fecha solicitada</td>
            <td>Contacto</td>
            <td>Estado</td>
            <td>Detalles</td>
            <td>Opciones</td>
        </tr>
    </thead>
    <tbody>
        <%
            for (Solicitud data : datalist) {
        %>
        <tr>
            <td><%= data.getIdSolicitud()%></td>
            <td><%= data.getNombre()%></td>
            <td><%= data.getFecha()%></td>
            <td><%= data.getCelular()%></td>
            <td><%= data.getStatus()%></td>
            <td><%= data.getDescripcion()%></td>
            <td>
                <%
                    if (data.getIdEstado() == 1) {
                %>
                <form method="post" action="<%=request.getContextPath()%>/Respuesta?option=1">
                    <% request.getSession().setAttribute("data" + data.getIdSolicitud(), data);%>
                    <input value="<%= data.getIdSolicitud()%>" name="id" hidden>
                    <button type="submit">Aceptar</button>
                </form>
                <form method="post" action="<%=request.getContextPath()%>/Respuesta?option=2">
                    <% request.getSession().setAttribute("data" + data.getIdSolicitud(), data);%>
                    <input value="<%= data.getIdSolicitud()%>" name="id" hidden>
                    <button type="submit">Declinar</button>
                </form>
            </td>
        </tr>
        <%
        } else {
        %>
    <p>Solicitud concluida</p>
    <%
            }
        }
    } else {
    %>
    <p> No tiene solicitudes registradas actualmente :c </p>
    <%
            }
        }
    %>
    <tr>

    </tr>
</tbody>
</table>