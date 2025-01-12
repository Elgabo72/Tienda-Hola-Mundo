<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="iso-8859-1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>HolaMundo Libros</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/estilos.css" rel="stylesheet">

    </head>
    <body>
        <nav class="navbar navbar-default navbar-static-top">
            <div class="container-fluid">  <!-- container solo tiene margen en la pagina container con fluid extiende en todo el ancho de la pagina-->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><img class="logo" src="images/logoHM.png"></a>                    
                </div>
                <div id="navbar" class="navbar-collapse collapse" style="float: right">
                    <ul class="nav navbar-nav">
                        <li id="navbar"><a href="#">¿QUIENES SOMOS?</a></li>
                        <li id="navbar"><a href="#">CONTACTO</a></li>
                        <li><a href="javascript:abrir()"><button type="submit" class="btn-IS" name="login"><span style="font-size: 18px" class="glyphicon glyphicon-user" aria-hidden="true"></span> INICIAR SESION</button></a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>
