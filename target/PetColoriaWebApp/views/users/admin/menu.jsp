<%@page import="models.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Dashboard</title>
    </head>
    <body>
        <%
            String name = "", email = "";
            if (request.getSession(false) == null || request.getSession().getAttribute("CurrentUser") == null) {
                request.getRequestDispatcher("/CheckController").forward(request, response);
            } else {
                Usuario currentUser = (Usuario) request.getSession().getAttribute("CurrentUser");
                if (currentUser != null && currentUser.getIdRol()==1) {
                    name = ((Usuario) request.getSession().getAttribute("CurrentUser")).getNombre() + " "
                            + ((Usuario) request.getSession().getAttribute("CurrentUser")).getApPaterno()
                            + ((Usuario) request.getSession().getAttribute("CurrentUser")).getApMaterno();
                    email = ((Usuario) request.getSession().getAttribute("CurrentUser")).getEmail();
                } else {
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
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
                <div class="sidebar-menu">
                    <div class="menu-head">
                        <span><b>DashBoard</b></span>
                    </div>
                    <ul>
                        <li>
                            <a href="profile.jsp" class="slide">
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
                            <a href="4" class="slide">
                                <span class="las la-users"></span>
                                Clientes
                            </a>
                        </li>
                        <li>
                            <a href="5" class="slide">
                                <span class="las la-file-alt"></span>
                                Informe de Solicitudes
                            </a>
                        </li>
                        <li>
                            <a href="6" class="slide">
                                <span class="las la-comments"></span>
                                Comentarios
                            </a>
                        </li>
                        <li>
                            <a href="7" class="slide">
                                <span class="las la-envelope-open"></span>
                                Peticiones
                            </a>
                        </li>
                        <li>
                            <a href="8" class="slide">
                                <span class="las la-question"></span>
                                Ayuda
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
        <div class="main-content">
            <header>
                <div class="menu-toggle">
                    <label>
                        <span class="las la-bars"></span>
                    </label>
                </div>
                <span class="bars"></span>
                <div class="header-icons">
                    <span class="las la-search"></span>
                    <span class="las la-bookmark"></span>
                    <span class="las la-sms"></span>
                </div>
            </header>
            <main>
                <div class="page-header">
                    <div>
                        <h1>Estadisticas de Datos</h1>
                        <small> Monitoreo General de las estadisticas de la página</small>
                    </div>
                    <div class="header-actions">
                        <form action="<%= request.getContextPath()%>/GetData?option=0" method="post">
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
                <div class="cards">   
                                
                    <a href="<%= request.getContextPath()%>/GetData?action=2" class="card-single">
                        <div class="card-flex">
                            <div class="card-info">
                                <div class="card-head">
                                    <span>Usuarios</span>
                                    <small>Numero de registros</small>
                                </div>
                                <h2><%= request.getSession().getAttribute("DataUser")%></h2>
                            </div>
                            <div class="card-chart c1">
                                <span class="las la-chart-line"></span>
                            </div>
                        </div>
                    </a>
                            
                    <a href="<%= request.getContextPath()%>/GetData?action=3" class="card-single">
                        <div class="card-flex">
                            <div class="card-info">
                                <div class="card-head">
                                    <span>Veterinarios</span>
                                    <small>Numero de registros</small>
                                </div>
                                <h2><%= request.getSession().getAttribute("DataVet")%></h2>
                            </div>
                            <div class="card-chart c2">
                                <span class="las la-chart-line"></span>
                            </div>
                        </div>
                    </a>
                    <a href="#" class="card-single">
                        <div class="card-flex">
                            <div class="card-info">
                                <div class="card-head">
                                    <span>Clientes</span>
                                    <small>Numero de registros</small>
                                </div>
                                <h2><%= request.getSession().getAttribute("DataClient")%></h2>
                            </div>
                            <div class="card-chart c3">
                                <span class="las la-chart-line"></span>
                            </div>
                        </div>
                    </a>
                    <a href="#" class="card-single">
                        <div class="card-flex">
                            <div class="card-info">
                                <div class="card-head">
                                    <span>Conexiones</span>
                                    <small>Numero de registros</small>
                                </div>
                                <h2><%= request.getSession().getAttribute("DataConnection")%></h2>
                            </div>
                            <div class="card-chart c4">
                                <span class="las la-chart-line"></span>
                            </div>
                        </div>
                    </a>
                    <a href="#" class="card-single">
                        <div class="card-flex">
                            <div class="card-info">
                                <div class="card-head">
                                    <span>Mascotas</span>
                                    <small>Numero de registros</small>
                                </div>
                                <h2><%= request.getSession().getAttribute("DataPet")%></h2>
                            </div>
                            <div class="card-chart c5">
                                <span class="las la-chart-line"></span>
                            </div>
                        </div>
                    </a>
                    <a href="#" class="card-single">
                        <div class="card-flex">
                            <div class="card-info">
                                <div class="card-head">
                                    <span>Solicitudes</span>
                                    <small>Numero de registros</small>
                                </div>
                                <h2><%= request.getSession().getAttribute("DataBell")%></h2>
                            </div>
                            <div class="card-chart c6">
                                <span class="las la-chart-line"></span>
                            </div>
                        </div>
                    </a>
                </div>
            </main>
        </div>

    </body>
</html>
<!-- Design Code by Code Resource -->
