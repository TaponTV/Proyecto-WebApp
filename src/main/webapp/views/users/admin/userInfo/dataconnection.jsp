<%@page import="models.Conexion"%>
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
        <title>Dashboard - Conexiones</title>
    </head>
    <body>
        <jsp:include page="../content/sidebar.jsp"/>
        <div class="main-content">
             <jsp:include page="../content/header.jsp"/>
            <main>
                <div class="page-header">
                    <div>
                        <h1>Registro de conexiones</h1>
                        <small> Conexiones Usuario ID: <%= request.getParameter("id") %></small>
                    </div>
                    <div class="header-actions">
                        <%
                            if (Integer.parseInt(request.getParameter("option")) == 1) {
                        %>
                        <form action="<%= request.getContextPath()%>/GetData?action=2&option=1" method="post">
                            <button type="submit">
                                <span class="las la-spinner"></span>
                                Regresar
                            </button>
                        </form>
                        <%
                        } else {
                        %>
                        <form action="<%= request.getContextPath()%>/GetData?action=2&option=2" method="post">
                            <button type="submit">
                                <span class="las la-spinner"></span>
                                Regresar
                            </button>
                        </form>
                        <%
                            }
                        %>
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
                            <td> Fecha Conexion </td>
                            <td> Desconexion </td>
                        </tr>
                    </thead>
                    <tbody>
                        <% List<Conexion> data = (List<Conexion>) request.getSession().getAttribute("UserDataConnection");
                            if (data != null) {
                                for (Conexion datac : data) {
                        %>
                        <tr>
                            <td><%= datac.getFechaConexion()%></td>
                            <td><%= datac.getFechaDesconexion()%></td>
                        </tr>
                        <%
                                }
                                //data = null;
                            }

                        %>
                    </tbody>
                </table>
            </main>
        </div>

    </body>
</html>