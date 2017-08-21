<%-- 
    Document   : sorteo
    Created on : 11-08-2017, 10:32:47 AM
    Author     : gabriel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    String usuario = (String) (request.getSession().getAttribute("usuario"));
    if (usuario == null) {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<meta http-equiv="Refresh" content="<%= session.getMaxInactiveInterval() - 2%>;url=index.jsp">-->
        <title>Sistema Sorteo Aleatorio</title>
        <meta http-equiv="refresh" content="">
        <meta charset="utf-8">
        <meta name="description" content="Sistema de Control de Ventas">
        <meta name="author" content="GCasas">
        <meta name="keyword" content="CASAS">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <link rel="shortcut icon" href="imgs/todavia.png">

        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/modern-business.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>    
        <script src="js/jquery.form.js"></script>
        <script src="js/bootstrap.file-input.js"></script>

    </head>
    <body>
        <div class="container">
            <div class="row">
                <nav class="navbar navbar-default navbar-fixed-top animate" role="navigation">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="sorteo.jsp">SistemaSorteosAleatorios</a>
                        </div>

                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav navbar-right">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=usuario%> <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="login"><i class="alert-warning"></i> Salir</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                            <ul class="nav navbar-nav navbar-static-top mobile-bar">
                                <li>
                                    <a href="sorteo.jsp">
                                        <span class="menu-icon fa fa-home"></span>
                                        Inicio
                                    </a>
                                </li>
                                <li>
                                    <a href="#" id="agenda">
                                        <span class="menu-icon fa fa-calendar-o"></span>
                                        Agenda
                                    </a>
                                </li>
                            </ul>
                        </div>

                    </div>
                </nav>
            </div>

            <div class="row text-center">
                <br><br>
                <div id="dato"><p>Estudiante</p></div>
                <button class="btn btn-lg btn-success" id="btniniciar" onclick="iniciar()">iniciar</button>
                <button class="btn btn-lg btn-danger" id="btnalto" onclick="alto()" disabled>alto </button>
            </div>
            <div class="row">
                <div class="col-md-6">

                    <div id="elegido"></div>

                </div>
                <div class="col-md-6">
                    <button onclick="cargarEstudiantes()">cargar</button>
                    <div class="table-responsive">
                        <table  class="table table-condensed table-bordered">
                            <thead>
                                <tr>
                                    <th>CI</th>
                                    <th>RU</th>
                                    <th>Nombre Completo</th>
                                </tr>
                            </thead>
                            <tbody id="estudiante">

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
<script>
    //var datos = ['VICTOR MANUEL OLIVAN JAUREGUI', 'NICOLAS FRANCES GANDIA', 'VICTOR SALES CAMARA', 'JOSE LUIS BUENDIA CHAPARRO', 'JOAN DIOS AZCONA', 'JOSE MIGUEL FONSECA HERNANDO', 'JUAN MANUEL CORONADO PEÑARANDA', 'GABRIEL PUENTES HERMOSILLA', 'ANDRES GRANERO BERNAD', 'MARIA CARMEN QUINTANA BETHENCOURT', 'CONSUELO MULERO DARIAS', 'FRANCISCA VIZCAINO MONTALBAN', 'PATRICIA RIBES PELEGRIN', 'MARIA SANTAMARIA PARES', 'MARIA PILAR MONTAÑA SAN JOSE', 'LAURA ABADIA SALAS', 'TERESA MONTES CABELLO', 'ANGELES BETANCOR BENAVENTE', 'PURIFICACION PUERTAS ARNAIZ', 'CELIA UTRILLA MELO', 'GLORIA LEYVA YAGUE', 'ANA ISABEL HIERRO DORTA'];
    var cont = 0;
    var seguir = true;
    var estudiantes = [];

    function iniciar() {
        $('#btniniciar').attr("disabled", true);
        var al=Math.random() * (estudiantes.length);
        var pos = Math.floor(al);
        //console.log("al: "+al+"    "+pos)
        try {
            var dato = estudiantes[pos];
            $('#btnalto').attr("disabled", false);
            if (seguir) {
                cont = cont + 1;
                $('#dato').empty();
                $('#dato').append("<p>" + dato.nombre_completo + "  " + dato.ci + "  " + dato.ru + "</p>");
                setTimeout("iniciar()", 150);
            } else {
                cont = 0;
                seguir = true;
            }
        } catch (e) {
            alert("Debe Cargar los Datos \n"+e.message+"   "+pos);
        }
    }
    function alto() {
        seguir = false;
        var elegido = document.getElementById('dato').innerHTML;
        $('#elegido').append("<h3>" + elegido + "</h3>");
    }
    function cargarEstudiantes() {
        $('#estudiante').empty();
        var datos = {};
        datos.ci = "";
        $.ajax({
            url: "estudianteController",
            type: 'GET',
            data: datos,
            success: function (data, textStatus, jqXHR) {
                $('#estudiante').empty();
                $.each(data, function (i, val) {
                    var est = {};
                    est.ci = data[i].ci;
                    est.ru = data[i].ru;
                    est.nombre_completo = data[i].nombre_completo;
                    estudiantes.push(est);
                    $('#estudiante').append("<tr>"
                            + "<td>" + data[i].ci + "</td> "
                            + "<td>" + data[i].ru + "</td> "
                            + "<td>" + data[i].nombre_completo + "</td> "
                            + "</tr>");
                });
                console.log(estudiantes);
            }
        });
    }
</script>