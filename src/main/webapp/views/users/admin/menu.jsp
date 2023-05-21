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
        <jsp:include page="content/sidebar.jsp"/>
        <div class="main-content">
            <jsp:include page="content/header.jsp"/>
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
