<%-- 
    Document   : registrarsolicitud
    Created on : 28 may 2023, 14:39:02
    Author     : Admin
--%>

<%@page import="models.Mascota"%>
<%@page import="java.util.List"%>
<%@page import="models.Cliente"%>
<%@page import="models.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Cliente client = new Cliente();
            String idVet = "";
            idVet = request.getParameter("id");
            Usuario user = ((Usuario) request.getSession().getAttribute("CurrentUser"));
            client.setIdUser(user.getIdUser());
            client.setIdCliente();
            int idcliente = client.getIdCliente();

        %>
        <h1>Registrar Solicitud</h1>
        <form action="<%= request.getContextPath()%>/BusquedaServlet" method="post">
            <input type="submit" value ="Regresar">
        </form>
        <form action="<%= request.getContextPath()%>/RegistrarSolicitud" method="post">
            <input type="text" name="idcliente" value="<%= idcliente%>" hidden>
            <input type="text" name="idvet" value="<%= idVet%>" hidden>
            <label>Fecha para consulta</label>
            <input type ="date" name="date" placeholder="Fecha..."><br>
            <textarea name="details" rows="10" cols="60" placeholder="descripcion"></textarea><br>
            <select name="pets" >
                <%
                    List<Mascota> data = (List<Mascota>) request.getSession().getAttribute("DataPet");
                    if (data != null) {
                        for (Mascota datac : data) {
                %>

                <option>
                    <%
                        request.getSession().setAttribute("idpet", datac.getIdMascota());
                    %>
                    <%=datac.getNombre()%>
                </option>
                <%
                        }
                    }

                %>
            </select><br>
            <button type="submit">Enviar solicitud</button>


        </form>

    </body>
</html>
