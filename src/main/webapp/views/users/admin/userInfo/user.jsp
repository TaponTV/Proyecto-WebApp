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
        <title>Dashboard - Usuarios</title>
    </head>
    <body>
        <jsp:include page="../content/sidebar.jsp"/>
        <div class="main-content">
             <jsp:include page="../content/header.jsp"/>
            <main>
                <div class="page-header">
                    <div>
                        <h1>Listado de Usuarios Registrados</h1>
                        <small> Este es un listado que muestra un resumen de los usuarios registrados</small>
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
                        } else{
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
                <% Usuario user = (Usuario) request.getSession().getAttribute("UserInfo");
                    if (user != null) {%>
                <label> Nombre </label>
                <input type="text" value="<%= user.getNombre()%>"><br>
                <label> Apellido Paterno </label>
                <input type="text" value="<%= user.getApPaterno()%>"><br>
                <label> Apellido Materno </label>
                <input type="text" value="<%= user.getApMaterno()%>"><br>
                <label> Edad </label>
                <input type="text" value="<%= user.getEdad()%>"><br>
                <label> País </label>
                <input type="text" value="<%= user.getPais()%>"><br>
                <label> Estado </label>
                <input type="text" value="<%= user.getEstado()%>"><br>
                <label> Ciudad </label>
                <input type="text" value="<%= user.getCiudad()%>"><br>
                <label> Celular </label>
                <input type="text" value="<%= user.getCelular()%>"><br>
                <label> Telefono </label>
                <input type="text" value="<%= user.getTelefono()%>"><br>
                <label> Email </label>
                <input type="text" value="<%= user.getEmail()%>"><br>
                <label> Tipo de Usuario </label>
                <input type="text" value="<%= user.getRol()%>"><br>
                <%
                    }
                    if (Integer.parseInt(request.getParameter("option")) == 1) {
                        Veterinario vet = (Veterinario) request.getSession().getAttribute("data" + user.getIdUser());
                        if (vet != null) {
                %>
                <label> Cedula </label>
                <input type="text" value="<%= vet.getCedula()%>"><br>
                <label> Especialidad </label>
                <input type="text" value="<%= vet.getEspecialidad()%>"><br>
                <label> Fecha de Titulación</label>
                <input type="text" value="<%= vet.getFechaTitulacion()%>"><br>
                <label> Universidad </label>
                <input type="text" value="<%= vet.getUniversidad()%>"><br>
                <%
                        }
                    }
                %>
                </tbody>
            </main>
        </div>

    </body>
</html>