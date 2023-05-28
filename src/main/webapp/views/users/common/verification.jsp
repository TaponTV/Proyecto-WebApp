<%@page import="models.Usuario"%>
<%
    String name="";
    if (response.isCommitted()) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    } else if (request.getSession(false) == null || request.getSession().getAttribute("CurrentUser") == null) {
        request.getRequestDispatcher("/CheckController").forward(request, response);
    } else {
        Usuario currentUser = (Usuario) request.getSession().getAttribute("CurrentUser");
        if (currentUser != null && currentUser.getIdRol() == 2) {
            name = currentUser.getNombre() + " " + currentUser.getApPaterno() + currentUser.getApMaterno();
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
    }
%>