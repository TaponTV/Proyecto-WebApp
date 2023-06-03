<h1>Agregar Medicina a receta</h1>
<form method="post" action="<%=request.getContextPath()%>/RecetaryController">
    <%
        int idmeet = 0;
        idmeet = Integer.parseInt(request.getParameter("idMeet"));
        if(idmeet == 0){
            response.sendRedirect(request.getContextPath()+"/views/users/vet/menu.jsp?section=5");
        }
    %>
    <input type="number" name="idmeet" value="<%= idmeet %>" hidden>
    <p>Medicamento: <input type="text" name="medicine" placeholder="Medicamento"></p>
    <p>Administración: <input type="text" name="aplicacion" placeholder="Tipo de aplicación"></p>
    <p>Horarios: </p><textarea type="text" name="times" placeholder="Horarios" rows="10" cols="60" ></textarea>
    <p>Detalles: </p><textarea type="text" name="details" placeholder="Instrucciones" rows="10" cols="60" ></textarea><br>
    <input type="submit"  value="Agregar a la receta">
    
</form>