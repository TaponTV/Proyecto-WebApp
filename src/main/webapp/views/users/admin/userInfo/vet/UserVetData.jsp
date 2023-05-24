<%@page import="models.Veterinario"%>
<%@page import="models.Usuario"%>
<main>
    <div class="page-header">
        <div>
            <h1>Listado de Usuarios Registrados</h1>
            <small> Este es un listado que muestra un resumen de los usuarios registrados</small>
        </div>
        <jsp:include page="headeractionsVet.jsp"/>
    </div>
    <%
        Usuario user = (Usuario) request.getSession().getAttribute("UserInfo");
        Veterinario vet = (Veterinario) request.getSession().getAttribute("data" + user.getIdUser());
        if (user != null && vet != null) {%>
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
    <input type="text" value="<%= user.getRol()%>" readonly><br>
    <label> Cedula </label>
    <input type="text" value="<%= vet.getCedula()%>" readonly><br>
    <label> Especialidad </label>
    <input type="text" value="<%= vet.getEspecialidad()%>" readonly><br>
    <label> Fecha de Titulación</label>
    <input type="text" value="<%= vet.getFechaTitulacion()%>" readonly><br>
    <label> Universidad </label>
    <input type="text" value="<%= vet.getUniversidad()%>" readonly><br>
    <form method="post" action="/RipDataUser">
        <input type="text" value="<%= user.getIdUser()%>" name="UID" hidden>
        <button type="submit">Eliminar Usuario</button>
    </form>
    <form method="post" action="/ModifyDataUser">
        <input type="text" value="<%= user.getIdUser()%>" name="UID" hidden>
        <button type="submit">Aplicar Cambios</button>
    </form>
    <form action="<%= request.getContextPath()%>/ConnectionListController?typeuser=1" method="post">
        <input type="text" value="<%= user.getIdUser()%>" name="UserInfoID" hidden>
        <input type="submit" value="Mostrar Conexiones">
    </form>
    <form action="<%= request.getContextPath()%>/ShowMeetController?typeUser=1" method="post">
        <input type="text" value="<%= vet.getCedula()%>" name="UserInfoID" hidden>
        <input type="submit" value="Mostrar Citas">
    </form>
    <form action="<%= request.getContextPath()%>/BellsVetAdmin" method="post">
        <input type="text" value="<%= vet.getCedula()%>" name="UserInfoID" hidden>
        <input type="submit" value="Mostrar Solicitudes">
    </form>
    <%
        }
    %>

</main>