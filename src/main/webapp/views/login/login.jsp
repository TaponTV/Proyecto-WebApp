<%@page import="models.Usuario"%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>PetColoria - Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../../assets/css/style.css">
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    </head>
    <body>
        <!--        <header>
                    <div>
                        <a href="../../index.jsp"><img src="../../assets/img/img_logo_petcoloria.png" class="logo"/></a>
                    </div>
                    <ul class="navigation-list">
                        <li><a href="../../index.jsp">Inicio</a></li>
                        <li><a href="../comments.jsp">Comentarios</a></li>
                        <li><a href="#">Nosotros</a></li>
                        <li><a href="../contact.html">Contacto</a></li>
                        <li><a href="login.jsp">Sign In / Login</a></li>
                    </ul>
                    <div class="bx bx-menu" id="menu-icon"></div>
                </header>-->
        <%
            //if CurrentUser exists, then check the rol
            if (request.getSession().getAttribute("CurrentUser") != null) 
                request.getRequestDispatcher("/CheckController").forward(request, response);
        %>    
        <div class="container">
            <input type="checkbox" id="hidden-btn" />
            <form action="<%= request.getContextPath()%>/SignupController" method="post" class="signup">
                <label for="hidden-btn">Registrarse</label>
                <input type="text" placeholder="Nombre" name="Nombre">
                <input type="text" placeholder="Apellido Paterno" name="apPaterno">
                <input type="text" placeholder="Apellido Materno" name="apMaterno">
                <select name="genero" id="genero">
                    <option> Masculino </option>
                    <option> Femenino </option>
                </select>
                <input type="text" placeholder="Edad" name="edad">
                <input type="text" placeholder="País" name="pais">
                <input type="text" placeholder="Estado" name="estado">
                <input type="text" placeholder="Ciudad" name="ciudad">
                <input type="text" placeholder="Calle" name="calle">
                <input type="text" placeholder="Celular" name="celular">
                <input type="text" placeholder="Telefono" name="telefono">
                <input type="text" placeholder="Email" name="email">
                <input type="password" placeholder="Contraseña" name="pswrd">
                <select name="typeUser" id="typeUser">
                    <option> Veterinario </option>
                    <option> Cliente </option>
                </select>
                <button type="submit">Registrarse</button>
            </form>
            <form action="<%= request.getContextPath()%>/login" method="post" class="login">
                <label for="hidden-btn">Iniciar Sesión</label>
                <input type="text" placeholder="Email" name="userEmail">
                <input type="password" placeholder="Contraseña" name="userPswrd">
                <button type="submit">Iniciar Sesión</button>
            </form>

        </div>
    </body>


</html>
