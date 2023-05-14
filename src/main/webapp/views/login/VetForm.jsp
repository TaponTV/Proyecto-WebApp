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
            if (request.getAttribute("notFoundUser") != null) {
                int param = Integer.parseInt(request.getAttribute("notFoundUser").toString());
                if (param == 1) {
        %>
        <script>
            alert("Credenciales incorrectas");
            location.replace('./views/login/login.jsp');
        </script>
        <%
                }
            }
            if (request.getSession().getAttribute("CurrentUser") != null) {
                switch (((Usuario) request.getSession().getAttribute("CurrentUser")).getIdRol()) {
                    case 1:
        %>
        <script>
            location.replace("../users/admin/menu.jsp");
        </script>          
        <%
                break;
            case 2:
        %>
        <script>
            location.replace("../users/vet/menu.jsp");
        </script>          
        <%
                break;
            case 3:
        %>
        <script>
            location.replace("../users/client/menu.jsp");
        </script>          
        <%
                        break;
                }
            }

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
            <form method="post" action="<%= request.getContextPath()%>/login" class="login">
                <label for="hidden-btn">Iniciar Sesión</label>
                <input type="text" placeholder="Email" name="userEmail">
                <input type="password" placeholder="Contraseña" name="userPswrd">
                <button type="submit">Iniciar Sesión</button>
            </form>

        </div>
    </body>


</html>

