<%@page import="java.util.List"%>
<%@page import="models.Veterinario"%>
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
                        <h1>Listado de Veterinarios Registrados</h1>
                        <small> Este es un listado que muestra un resumen de los veterinarios registrados</small>
                    </div>
                    <div class="header-actions">
                        <form action="<%= request.getContextPath()%>/GetData?action=2&option=1" method="post">
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
                            <td> ID Usuario </td>
                            <td> Nombre </td>
                            <td> Apellidos </td>
                            <td> Pais Origen </td>
                            <td> Residencia </td>
                            <td> Correo </td>
                            <td> Universidad </td>
                            <td colspan="4"> Operaciones   </td>
                        </tr>
                    </thead>
                    <tbody>
                        <% List<Veterinario> listUsers = (List<Veterinario>) request.getSession().getAttribute("listUsers");

                            if (listUsers != null) {
                                for (Veterinario user : listUsers) {%>
                        <tr>
                            <td><%= user.getIdUser()%></td>
                            <td><%= user.getNombre()%></td>
                            <td><%= user.getApPaterno()%> <%= user.getApMaterno()%></td>
                            <td><%= user.getCedula()%></td>
                            <td><%= user.getEspecialidad()%></td>
                            <td><%= user.getFechaTitulacion()%></td>
                            <td><%= user.getUniversidad()%></td>
                            <td>
                                <form action="<%= request.getContextPath()%>/ConnectionListController?typeuser=1" method="post">
                                    <input type="text" value="<%= user.getIdUser()%>" name="UserInfoID" hidden>
                                    <input type="submit" value="Mostrar Conexiones">
                                </form>
                            </td>
                            <td>
                                <form action="<%= request.getContextPath()%>/MeetsVetAdmin" method="post">
                                    <input type="text" value="<%= user.getCedula()%>" name="UserInfoID" hidden>
                                    <input type="submit" value="Mostrar Citas">
                                </form>
                            </td>
                            <td>
                                <form action="<%= request.getContextPath()%>/BellsVetAdmin" method="post">
                                    <input type="text" value="<%= user.getCedula()%>" name="UserInfoID" hidden>
                                    <input type="submit" value="Mostrar Solicitudes">
                                </form>
                            </td>
                            <td>
                                <form action="<%= request.getContextPath()%>/ShowData?typeUser=1" method="post">
                                    <% request.getSession().setAttribute("data" + user.getIdUser(), user);%>
                                    <input type="text" value="<%= user.getIdUser()%>" name="UserInfoID" hidden>
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