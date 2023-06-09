<%-- 
    Document   : datosmascotas
    Created on : 28 may 2023, 14:16:29
    Author     : Admin
--%>

<%@page import="java.util.Map"%>
<%@page import="models.Mascota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
             String msg = "";
            if (request.getSession().getAttribute("msg") != null) {
                msg = request.getSession().getAttribute("msg").toString();
                out.print(msg);
                request.getSession().removeAttribute("msg");
            }
            Mascota data = (Mascota) request.getSession().getAttribute("dataPet");
            Map<Integer, String> hashSpecie = (Map<Integer, String>) request.getSession().getAttribute("hashSpecie");
            if (data != null) {
        %>
        <h1>Datos: <%= data.getNombre()%></h1>
        <a href="<%= request.getContextPath()%>/views/users/client/mascotas.jsp"><button>Regresar</button></a>
        
        <p>Nombre: <%= data.getNombre()%></p>
        <p>Edad: <%= data.getEdad()%></p>
        <p>Fecha Nacimiento: <%= data.getFechaNac()%></p>
        <p>Raza: <%= data.getRaza()%></p>
        <p>Especie: <%= hashSpecie.get(data.getIdEspecie()) %></p>
        <%
            }
        %>
        <a href="<%= request.getContextPath()%>/views/users/client/modificar.jsp"><button>Modificar Datos</button></a>
        <a href="<%= request.getContextPath()%>/ConfirmController?action=deletepet&InfoID=<%=data.getIdMascota()%>"><button>Borrar Mascota</button></a>
    </body>
</html>
