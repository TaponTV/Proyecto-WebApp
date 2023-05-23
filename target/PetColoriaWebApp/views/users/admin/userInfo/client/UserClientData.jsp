<%@page import="models.Usuario"%>
<main>
    <div class="page-header">
        <div>
            <h1>Listado de Usuarios Registrados</h1>
            <small> Este es un listado que muestra un resumen de los usuarios registrados</small>
        </div>
        <div class="header-actions">
            <form action="<%= request.getContextPath()%>/GetData?action=2&option=2" method="post">
                <button type="submit">
                    <span class="las la-spinner"></span>
                    Regresar
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
    <%
        Usuario user = (Usuario) request.getSession().getAttribute("UserInfo");
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
    %>
    </tbody>
</main>