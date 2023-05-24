<%-- 
    Document   : confirmpage
    Created on : 23 may 2023, 18:57:00
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            /* 
                1 - ModifyMeetVet
                2 - RipMeetVet
                3 - ModifyBellVet
             */
            String path = "";
            int action = Integer.parseInt(request.getParameter("action"));
            switch (action) {
                case 1:
                    path = request.getContextPath() + "/ModifyMeetVet";
                    break;
                case 2:
                    path = request.getContextPath() + "/RipMeetVet";
                    break;
                case 3:
                    path = request.getContextPath() + "/ModifyBellVet";
                    break;
                case 4:
                    path = request.getContextPath() + "/RipBellVet";
                    break;
            }
        %>
        <div>
            <label>Realmente quieres realizar esta acción?</label>
            <form method="post" action="<%= path%>">
                <button type="submit" name="option" value="yes">Aceptar</button>
            </form>
            <form method="post" action="<%= path%>">
                <button type="submit" name="option" value="no">Cancelar</button>
            </form>
        </div>

    </body>
</html>
