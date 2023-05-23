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
        <title>Dashboard - Usuarios</title>
    </head>
    <body>
        <jsp:include page="../content/sidebar.jsp"/>
        <div class="main-content">
            <jsp:include page="../content/header.jsp"/>
            <%
                int typeUser = Integer.parseInt(request.getParameter("typeUser"));
                switch (typeUser) {
                    case 1:
            %>
            <jsp:include page="vet/UserVetData.jsp"/>
            <%
                    break;
                case 2:
            %>
            <jsp:include page="client/UserClientData.jsp"/>
            <%
                        break;
                }
            %>

        </div>

    </body>
</html>