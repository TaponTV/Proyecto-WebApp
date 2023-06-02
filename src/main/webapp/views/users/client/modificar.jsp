<%-- 
    Document   : modificar
    Created on : 2 jun 2023, 08:36:38
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
            Mascota data = (Mascota) request.getSession().getAttribute("dataPet");
            Map<Integer, String> hashSpecie = (Map<Integer, String>) request.getSession().getAttribute("hashSpecie");
            if (data != null) {
        %>
        <h1>Datos: <%= data.getNombre()%></h1>
        <a href="<%= request.getContextPath()%>/DataPet?id=<%= data.getIdMascota()%>"><button>Regresar</button></a>
        <form action="<%= request.getContextPath()%>/ConfirmController?action=modifyPet&pet=<%=data.getIdMascota()%>" method="post">
            <p>Nombre: <input type="text" value="<%= data.getNombre()%>" name="namePet"></p>
            <p>Edad: <input type="number" value="<%= data.getEdad()%>" name="agePet"></p>
            <p>Fecha Nacimiento: <input type="date" value="<%= data.getFechaNac()%>" name="date"></p>
            <p>Raza: <input type="text" value="<%= data.getRaza()%>" name="raza"></p>
            <p>Especie: 
                <select name="specie">
                    <%
                        for (Map.Entry<Integer, String> entry : hashSpecie.entrySet()) {
                            if (data.getIdEspecie() == entry.getKey()) {

                    %>
                    <option selected><%= entry.getValue()%></option>
                    <%
                    } else {
                    %>
                    <option><%= entry.getValue()%></option>
                    <%
                            }
                        }
                    %>
                </select>
            </p>
            <input type="submit">
        </form>
        <%
            }
        %>
    </body>
</html>
