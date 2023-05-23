<div class="header-actions">
    <form action="<%= request.getContextPath()%>/GetData?action=2&option=1" method="post">
        <button type="submit">
            <span class="las la-spinner"></span>
            Regresar
        </button>
    </form>
    <form action="<%= request.getContextPath()%>/logout" method="post">
        <button type="submit" value ="Cerrar Sesion">
            <span class="las la-sign-out-alt"></span>
            Cerrar Sesión
        </button>
    </form>
</div>