<%@page import="models.Solicitud"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@page import = "java.io.*"%>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=devide-width" initial-scale="1" maximum-scale="1">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/admin.css">
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">
        <title>Dashboard - Conexiones</title>
    </head>
    <% Solicitud data = (Solicitud) request.getSession().getAttribute("Bell"); %>
    <body>
        <jsp:include page="../content/sidebar.jsp"/>
        <div class="main-content">
            <jsp:include page="../content/header.jsp"/>
            <main>
                <div class="page-header">
                    <div>
                        <h1>Detalles</h1>
                    </div>
                </div>
                <%
                    if (data != null) {
                %>
                <form method="post" action="<%= request.getContextPath()%>/ConfirmController?action=modifybell">
                    SolicitudID: <input type="text" value="<%= data.getIdSolicitud()%>" name="BellID"><br>
                    ClienteID: <input type="text" value="<%= data.getIdCliente()%>" name="ClientID"><br>
                    VeterinarioID: <input type="text" value="<%= data.getIdVeterinario()%>" name="VetID"><br>
                    MascotaID: <input type="text" value="<%= data.getIdMascota()%>" name="PetID"><br>
                    PrioridadID: <input type="text" value="<%= data.getIdPrioridad()%>" name="PriorityID"><br>
                    StatusID: <input type="text" value="<%= data.getIdEstado()%>" name="StatusID"><br>
                    Fecha: <input type="text" value="<%= data.getFecha()%>" name="Date"><br>
                    Descripcion: <input type="text" value="<%= data.getDescripcion()%>" name="Details"><br>
                    <button type="submit">Modificar Solicitud</button><br>
                </form>
                <form method="post" action="<%= request.getContextPath()%>/ConfirmController?action=ripbell">
                    <% request.getSession().setAttribute("Bell", data);%>
                    <input type="text" value="<%= data.getIdSolicitud()%>" name="BellID" hidden>
                    <button type="submit">Eliminar Solicitud</button>
                </form>
                <%
                    }
                %>
            </main>
        </div>

    </body>
</html>