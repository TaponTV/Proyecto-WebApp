<%@page import="models.Mascota"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@page import = "java.io.*"%>
<%@page import = "java.util.*" %>
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
        <title>Dashboard - Conexiones</title>
    </head>
    <body>
        <jsp:include page="../content/sidebar.jsp"/>
        <div class="main-content">
            <jsp:include page="../content/header.jsp"/>
            <main>
                <div class="page-header">
                    <div>
                        <h1>Mascotas</h1>
                            <small> Registro de Mascotas ID Usuario: <%= request.getParameter("id")%></small>
                    </div>
                </div>
                <table>
                    <thead>
                        <tr>
                            <td> Mascota ID </td>
                            <td> Nombre </td>
                            <td> Edad </td>
                            <td> Raza </td>
                            <td> Operaciones </td>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            List<Mascota> data = (List<Mascota>) request.getSession().getAttribute("DataPet");
                            if (data != null) {
                                for (Mascota datac : data) {
                        %>
                        <tr>
                            <td><%= datac.getIdMascota()%></td>
                            <td><%= datac.getNombre()%></td>
                            <td><%= datac.getEdad()%></td>
                            <td><%= datac.getRaza()%></td>
                            <td>
                                <form method="post" action="<%= request.getContextPath()%>/ConfirmController?action=deletepet">
                                    <input type="text" value="<%= datac.getIdMascota()%>" name="InfoID" hidden>
                                    <button type="submit">Eliminar Mascota</button>
                                </form>
                            </td>
                        </tr>
                        <%
                                }
                            }

                        %>
                    </tbody>
                </table>
            </main>
        </div>

    </body>
</html>