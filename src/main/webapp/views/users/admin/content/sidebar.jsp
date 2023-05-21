
<%@page import="java.io.IOException"%>
<%@page import="models.Usuario"%>
<%
    String name = "", email = "";
    if (response.isCommitted()) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }else if (request.getSession(false) == null || request.getSession().getAttribute("CurrentUser") == null) {
        request.getRequestDispatcher("/CheckController").forward(request, response);
    } else {
        Usuario currentUser = (Usuario) request.getSession().getAttribute("CurrentUser");
        if (currentUser != null && currentUser.getIdRol() == 1) {
            name = currentUser.getNombre() + " " + currentUser.getApPaterno() + currentUser.getApMaterno();
            email = currentUser.getEmail();
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
    }


%>
<div class="sidebar">
    <div class="sidebar-brand">
        <div class="brand-flex">
            <img src="<%= request.getContextPath()%>/assets/img/logo.png" width="40px" alt="">
        </div>
    </div>
    <div class="sidebar-main">
        <div class="sidebar-user">
            <img src="<%= request.getContextPath()%>/assets/img/logo1.jpg" width="40px" alt="">
            <div>
                <h3><%= name%></h3>
                <span><%= email%></span>
            </div>
        </div>

    </div>

    <div class="sidebar-menu">
        <div class="menu-head">
            <span><b>DashBoard</b></span>
        </div>
        <ul>
            <li>
                <a href="#" class="slide">
                    <span class="las la-user-circle"></span>
                    Perfil
                </a>
            </li>
            <li>
                <a href="<%= request.getContextPath()%>/GetData?action=1" class="slide">
                    <span class="las la-chart-pie"></span>
                    Estadísticas 
                </a>
            </li>
        </ul>
        <div class="menu-head">
            <span><b>Operaciones</b></span>
        </div>
        <ul>
            <li>
                <a href="<%= request.getContextPath()%>/GetData?action=3" class="slide">
                    <span class="las la-stethoscope"></span>
                    Veterinarios
                </a>
            </li>
            <li>
                <a href="<%= request.getContextPath()%>/GetData?action=4" class="slide">
                    <span class="las la-users"></span>
                    Clientes
                </a>
            </li>
            <li>
                <a href="<%= request.getContextPath()%>/GetData?action=5" class="slide">
                    <span class="las la-file-alt"></span>
                    Informe de Solicitudes
                </a>
            </li>
            <li>
                <a href="#" class="slide">
                    <span class="las la-comments"></span>
                    Comentarios
                </a>
            </li>
            <li>
                <a href="#" class="slide">
                    <span class="las la-envelope-open"></span>
                    Peticiones
                </a>
            </li>
            <li>
                <a href="#" class="slide">
                    <span class="las la-question"></span>
                    Ayuda
                </a>
            </li>
        </ul>
    </div>
</div>