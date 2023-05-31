<%-- 
    Document   : comentariosveterinario
    Created on : 28 may 2023, 14:17:21
    Author     : Admin
--%>

<%@page import="java.util.Map"%>
<%@page import="models.Calificacion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Comentarios: </h1>
        <a href="<%=request.getContextPath()%>/views/users/client/veterinarios.jsp"><button>Regresar</button></a>
        <%
            List<Calificacion> list = (List<Calificacion>) request.getSession().getAttribute("dataList");
            Map<Integer, String> hash = (Map<Integer, String>) request.getSession().getAttribute("hashClient");
            if (list != null && hash != null) {
                if (!list.isEmpty()) {
                    for (Calificacion data : list) {

        %>
        <p><%= hash.get(data.getIdCliente())%></p>
        <p><%= data.getCalificacion()%></p>
        <p><%= data.getComentario()%></p>
        <%
            }
        } else {
        %>
        <p>No se han encontrado resultados para este veterinario</p>
        <%
                }
            }
        %>
    </body>
</html>
