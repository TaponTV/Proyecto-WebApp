<%@page import="models.Receta"%>
<%@page import="models.Consulta"%>
<%@page import="java.util.List"%>
<%
    Consulta data = (Consulta) request.getSession().getAttribute("CurrentMeet");
    if (data != null) {
%>
<h1>Datos de consulta</h1>
<p>ID Consulta: <%= data.getIdConsulta()%></p>
<p>Cliente: <%= data.getNombreC()%></p>
<p>Mascota: <%= data.getNombre()%></p>
<form method="post" action="<%=request.getContextPath()%>/ConfirmController?action=updateMeetVet">
    <input type="text" name="BellID" value="<%=data.getIdSolicitud()%>" hidden>
    <p>Fecha Consulta</p>
    <input type="text" name="dateMeet" value="<%=data.getFechaConsulta()%>">
    <p>Detalle</p>
    <input type="text" name="detailMeet" value="<%=data.getDetalle()%>"><br>
    <input value="<%= data.getIdConsulta()%>" name="MeetID" hidden>
    <button type="submit">Actualizar Consulta</button>
</form>
<form method="post" action="<%=request.getContextPath()%>/views/users/vet/menu.jsp?section=5">
    <input value="<%= data.getIdConsulta()%>" name="idMeet" hidden>
    <button type="submit">Agregar Medicamento</button>
</form>
<form method="post" action="<%=request.getContextPath()%>/ConfirmController?action=ripmeet">
    <input value="<%= data.getIdConsulta()%>" name="MeetID" hidden>
    <button type="submit">Cancelar Consulta</button>
</form>
<%
    }
    List<Receta> list = (List<Receta>) request.getSession().getAttribute("listRecipes");
    if (list != null) {
        if (!list.isEmpty()) {
%>
<table>
    <thead>
        <tr>
            <td> Medicamento</td>
            <td> Administración</td>
            <td> Horario</td>
            <td> Instrucciones </td>
        </tr>
    </thead>
    <tbody>
        <%
            for (Receta recipe : list) {
        %>
        <tr>
            <td><%= recipe.getMedicamento()%></td>
            <td><%= recipe.getTipoAdministracion()%></td>
            <td><%= recipe.getHorario()%></td>
            <td><%= recipe.getDetalles()%></td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
<%
} else {
%>
<p>No se encontro ninguna receta para esta consulta</p>
<%
        }

    }
%>