<%@page import="models.Consulta"%>
<%@page import="java.util.List"%>
<table>
    <thead>
        <tr>
            <td>ID Consulta</td>
            <td>Cliente</td>
            <td>Nombre Mascota</td>
            <td>Especie</td>
            <td>Fecha Consulta</td>
            <td>operaciones</td>
        </tr>
    </thead>
    <tbody>
        <%
            List<Consulta> datalist = (List<Consulta>) request.getSession().getAttribute("datalist");
            if (datalist != null) {
                for (Consulta data : datalist) {
        %>
        <tr>
            <td><%= data.getIdConsulta() %></td>
            <td><%= data.getNombreC() %></td>
            <td><%= data.getNombre()%></td>
            <td><%= data.getEspecie() %></td>
            <td><%= data.getFechaConsulta() %></td>
            <td>
                <form method="post" action="<%=request.getContextPath()%>/MeetVetController">
                    <% request.getSession().setAttribute("data"+data.getIdConsulta(),data); %>
                    <input value="<%= data.getIdConsulta()%>" name="idMeet">
                    <button type="submit">Ver detalles</button>
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
        <tr>

        </tr>
    </tbody>
</table>