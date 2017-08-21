<%-- 
    Document   : index
    Created on : 11-08-2017, 10:32:35 AM
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    HttpSession sesion= request.getSession();
    sesion.removeAttribute("usuario");
    sesion.removeAttribute("user");
    sesion.invalidate();
    
    //String usuario = (String) (request.getSession().getAttribute("usuario"));
    //if (usuario == null) {
    //    response.sendRedirect("index.jsp");
    //}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Sorteo Aleatorio</title>
        <meta charset="utf-8">
        <meta name="description" content="Sistema de Control de Ventas">
        <meta name="author" content="GCasas">
        <meta name="keyword" content="CASAS">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <link rel="shortcut icon" href="imgs/todavia.png">

        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
        <style>
            .container{margin-top:10%}
            .container{margin-left: 20%}
            .container{margin-right: 20%}
        </style>
    </head>
    <body>
        <div class="container">
            <form class="form-inline" action="login" method="post">
                <div class="form-group">
                    <label for="usuario" class="col-lg-1 control-label">Usuario</label><br>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="g_usuario" id="usuario" placeholder="Nombre de Usuario" required="true">
                    </div>
                </div>
                <div class="form-group">
                    <label for="clave" class="col-lg-1 control-label">Contraseña</label><br>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="g_clave" id="clave" placeholder="Contraseña de Usuario" required="true">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-lg btn-default" id="iniciar">Iniciar</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>