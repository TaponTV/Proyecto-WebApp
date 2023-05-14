<%@page import="models.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>PetColoria - SignUp</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../../assets/css/style.css">
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    </head>
    <body>
        <%
            //if CurrentUser exists, then check the rol
            if (request.getSession().getAttribute("CurrentUser") != null) {
                if (request.getSession().getAttribute("vetID") != null) {
                    request.getRequestDispatcher("/CheckController").forward(request, response);
                }
            }else{
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        %>   
        <div class="container">
            <input type="checkbox" id="hidden-btn" />
            <form method="post" action="<%= request.getContextPath()%>/VetSignupController">
                <label for="hidden-btn">Completa tu registro</label>
                <p>Es importante que completes tu registro para poder comenzar a aparecer dentro de los filtros de búsqueda!</p>
                <input type="text" placeholder="Cedula Profesional" name="cedula" required>
                <input type="text" placeholder="Especialidad" name="specialty" value="">
                <input type="text" placeholder="Universidad de Estudio" name="university" required>
                <p>Fecha de titulación</p>
                <input type="date" placeholder="Fecha Titulación" name="dateTitle" required>
                <button type="submit">Completar Registro</button>
            </form>

        </div>
    </body>


</html>

