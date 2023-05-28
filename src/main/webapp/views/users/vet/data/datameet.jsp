<%@page import="models.Consulta"%>
<%@page import="java.util.List"%>
<%
    Consulta data = (Consulta) request.getSession().getAttribute("CurrentMeet");
    if (data != null) {
%>
<p>ID Consulta: <%= data.getIdConsulta()%></p>
<p>Cliente: <%= data.getNombreC()%></p>
<p>Mascota: <%= data.getNombre()%></p>
<form method="post" action="<%=request.getContextPath()%>/ConfirmController?action=updateMeetVet">
    <input type="text" name="BellID" value="<%=data.getIdSolicitud()%>" hidden>
    <p>Fecha Consulta</p>
    <input type="text" name="dateMeet" value="<%=data.getFechaConsulta()%>">
    <p>Detalle</p>
    <input type="text" name="detailMeet" value="<%=data.getDetalle()%>">
    <input value="<%= data.getIdConsulta()%>" name="MeetID" hidden>
    <button type="submit">Actualizar Consulta</button>
</form>
<form method="post" action="<%=request.getContextPath()%>/RecetaryController">
    <input value="<%= data.getIdConsulta()%>" name="idMeet" hidden>
    <button type="submit">Agregar receta</button>
</form>
<form method="post" action="<%=request.getContextPath()%>/ConfirmController?action=ripmeet">
    <input value="<%= data.getIdConsulta()%>" name="MeetID" hidden>
    <button type="submit">Cancelar Consulta</button>
</form>


<%
    }
%>