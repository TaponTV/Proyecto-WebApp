<%@page contentType="text/html" pageEncoding="UTF-8"%>


<section id="sidebar" class="hide">
    <a href="#" class="brand"><i></i><img src="../../../assets/img/logo.png" class="icon" width="45px"> PetColoria </a>
    <ul class="side-menu">
        <li><a href="menu.jsp?section=1"><i class='bx bxs-dashboard icon' ></i> Dashboard</a></li>
        <li class="divider" data-text="main">Menu</li>
        <li>
            <a href="#"><i class='bx bxs-inbox icon' ></i> Operaciones <i class='bx bx-chevron-right icon-right' ></i></a>
            <ul class="side-dropdown">
                <li><a href="<%=request.getContextPath()%>/DiaryController">Agenda</a></li>
                <li><a href="<%=request.getContextPath()%>/solicitudes">Solicitudes</a></li>
            </ul>
        </li>

    </ul>

    <!--Futuro -->
    <div class="ads">
        <div class="wrapper">
            <a href="#" class="btn-upgrade">Proximamente</a>
            <p>¿Qué sorpresas podemos encontrar?</p>
        </div>
    </div>
</section>


