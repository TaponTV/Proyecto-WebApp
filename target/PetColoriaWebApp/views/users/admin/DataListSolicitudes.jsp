<%@page import="models.Solicitud"%>
<%@page import="java.util.List"%>
<%@page import="models.Usuario"%>
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
        <title>Dashboard - Veterinarios</title>
    </head>
    <body>
        <jsp:include page="content/sidebar.jsp"/>
        <div class="main-content">
            <jsp:include page="content/header.jsp"/>

            <main>
                <div class="page-header">
                    <div>
                        <h1>Solicitudes en la página</h1>
                        <small> Lista de solicitudes registradas dentro de la aplicación</small>
                    </div>
                    <div class="header-actions">
                        <form action="<%= request.getContextPath()%>/GetData?action=2&option=3" method="post">
                            <button type="submit">
                                <span class="las la-spinner"></span>
                                Actualizar Métricas
                            </button>
                        </form>
                        <form action="<%= request.getContextPath()%>/logout" method="post">
                            <button type="submit" value ="Cerrar Sesion">
                                <span class="las la-sign-out-alt"></span>
                                Cerrar Sesión
                            </button>
                        </form>
                    </div>
                </div>
                <table>
                    <thead>
                        <tr>
                            <td> ID Solicitud </td>
                            <td> Cliente Solicitante </td>
                            <td> Veterinario </td>
                            <td> Fecha </td>
                            <td> Status </td>
                            <td colspan="4"> Operaciones   </td>
                        </tr>
                    </thead>
                    <tbody>
                        <% List<Solicitud> listBell = (List<Solicitud>) request.getSession().getAttribute("listBell");

                            if (listBell != null) {
                                for (Solicitud bells : listBell) {%>
                        <tr>
                            <td><%= bells.getIdSolicitud()%></td>
                            <td><%= bells.getNombre()%></td>
                            <td><%= bells.getvNombre()%></td>
                            <td><%= bells.getFecha()%></td>
                            <td><%= bells.getStatus() %></td>
                            <td>
                                <form action="<%= request.getContextPath()%>/GetData?action=7&option=1" method="post">
                                    <% request.getSession().setAttribute("data" + bells.getIdSolicitud(), bells);%>
                                    <input type="text" value="<%= bells.getIdSolicitud()%>" name="BellInfoID" hidden>
                                    <input type="submit" value="Ver más">
                                </form>
                            </td>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
            </main>


        </div>

    </body>
</html>