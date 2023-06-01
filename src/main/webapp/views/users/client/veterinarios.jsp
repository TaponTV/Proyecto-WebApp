<%-- 
    Document   : veterinarios
    Created on : 28 may 2023, 14:16:15
    Author     : Admin
--%>

<%@page import="java.util.Map"%>
<%@page import="models.Veterinario"%>
<%@page import="java.util.List"%>
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
                request.getSession().setAttribute("msg", null);
            }

        %>
        <h1>Veterinarios de PetColoria</h1>
        <a href="<%=request.getContextPath()%>/views/users/client/menu.jsp"><button>Regresar</button></a>
        <%
            List<Veterinario> data = (List<Veterinario>) request.getSession().getAttribute("veterinarios");
            Map<String, Integer> hashScore = (Map<String, Integer>) request.getSession().getAttribute("hashScore");
            if (data != null && hashScore != null) {
                if (!data.isEmpty()) {
        %>
        <table>
            <thead>
                <tr>
                    <td>Cedula</td>
                    <td>Nombre</td>
                    <td>Especialidad</td>
                    <td>Universidad</td>
                    <td>telefono</td>
                    <td>Calificación Promedio </td>
                    <td> Detalles </td>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Veterinario datac : data) {
                %>
                <tr>
                    <td><%= datac.getCedula()%></td>
                    <td><%= datac.getNombre() + datac.getApPaterno() + datac.getApMaterno()%></td>
                    <td><%= datac.getEspecialidad()%></td>
                    <td><%= datac.getUniversidad()%></td>
                    <td><%= datac.getTelefono()%></td>
                    <td>
                        <%
                            int score = hashScore.get(datac.getCedula());
                            if (score == 0) {
                                out.print("Sin calificación");
                            } else {
                                out.print(score);
                            }

                        %>
                    </td>
                    <td>
                        <a href="<%=request.getContextPath()%>/views/users/client/registrarsolicitud.jsp?id=<%= datac.getCedula()%>"><button>Registrar Solicitud</button></a>
                        <a href="<%=request.getContextPath()%>/Comentarios?id=<%= datac.getCedula()%>"><button>Ver Comentarios</button></a>
                    </td>
                </tr>
                <%
                    }
                } else {
                %>
            <p>No existe ningún veterinario registrado cerca de tu zona, lo sentimos :( </p>
            <%
                    }
                }

            %>
        </tbody>
    </table>
</body>
</html>
