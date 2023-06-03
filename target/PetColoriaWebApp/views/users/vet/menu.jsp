<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- BOX ICONS -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- CUSTOM CSS -->
        <link rel="stylesheet" href="../../../assets/css/vet/sidebar.css">
        <!-- CUSTOM JS -->
        <script src="../../../assets/js/appVet.js" defer></script>
        <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
        <!-- SIDEBAR -->
        <title>PetColoria </title>
    </head>
    <jsp:include page="../common/verification.jsp"/>
    <body>
        <jsp:include page="content/sidebar.jsp"/>
        <jsp:include page="content/navbar.jsp"/>

        <%
            String msg = "";
            if (request.getSession().getAttribute("msg") != null) {
                msg = request.getSession().getAttribute("msg").toString();
                out.print(msg);
                request.getSession().removeAttribute("msg");
            }
        %>
        <section id="content">
            <main>
                <%
                    int section = Integer.parseInt(request.getParameter("section"));
                    switch (section) {
                        case 1:
                %>
                <jsp:include page="data/dashboard.jsp"/>
                <%
                        break;
                    case 2:
                %>
                <jsp:include page="data/meets.jsp"/>
                <%
                        break;
                    case 3:
                %>
                <jsp:include page="data/datameet.jsp"/>
                <%
                        break;
                    case 4:
                %>
                <jsp:include page="data/solicitudes.jsp"/>
                <%
                            break;
                    }
                %>
            </main>


        </section>
    </body>
</html>
