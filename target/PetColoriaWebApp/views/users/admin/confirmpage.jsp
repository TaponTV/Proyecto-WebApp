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
            String path = "";
            int action = Integer.parseInt(request.getParameter("action"));
            switch (action) {
                case 1:
                    path = request.getContextPath() + "/ModifyMeetController";
                    break;
                case 2:
                    path = request.getContextPath() + "/RipMeetController";
                    break;
                case 3:
                    path = request.getContextPath() + "/ModifyBellController";
                    break;
                case 4:
                    path = request.getContextPath() + "/RipBellController";
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
