<%-- 
    Document   : login
    Created on : 7 may 2023, 23:00:35
    Author     : eduar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <header>
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
    </header>
    <div class="container">
        <input type="checkbox" id="hidden-btn" />
        <form action="LoginController" method="POST" class="signup">
            <label for="hidden-btn">Registrarse</label>
            <input type="text" placeholder="Nombre">
            <input type="text" placeholder="Apellido Paterno">
            <input type="text" placeholder="Apellido Materno">
            <input type="text" placeholder="Genero">
            <input type="text" placeholder="Edad">
            <input type="text" placeholder="Celular">
            <input type="text" placeholder="Telefono">
            <input type="text" placeholder="Email">
            <input type="password" placeholder="Contraseña">
            <select name="typeUser" id="typeUser">
                <option> Veterinario </option>
                <option> Cliente </option>
            </select>
            <button type="submit">Registrarse</button>
        </form>
        <form action="LoginController" method="POST" class="login">
            <label for="hidden-btn">Iniciar Sesión</label>
            <input type="text" placeholder="Email">
            <input type="password" placeholder="Contraseña">
            <button type="submit">Iniciar Sesión</button>
        </form>
    </div>
</body>


</html>
