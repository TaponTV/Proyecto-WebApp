
<h1>Dashboard</h1>

<div class="cards">   

    <div class="card-single">
        <div class="card-flex">
            <div class="card-info">
                <div class="card-head">
                    <span>Consultas</span>
                    <small>Numero de registros</small>
                </div>
                <h2><%= request.getSession().getAttribute("consultas")%></h2>
            </div>
            <div class="card-chart c1">
                <span class="las la-chart-line"></span>
            </div>
        </div>
    </div>

    <div class="card-single">
        <div class="card-flex">
            <div class="card-info">
                <div class="card-head">
                    <span>Solicitudes</span>
                    <small>Numero de registros</small>
                </div>
                <h2><%= request.getSession().getAttribute("solicitudes")%></h2>
            </div>
            <div class="card-chart c1">
                <span class="las la-chart-line"></span>
            </div>
        </div>
    </div>

</div>