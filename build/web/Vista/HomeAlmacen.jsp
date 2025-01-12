<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>HolaMundo Libros</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/estilos.css" rel="stylesheet">


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
                    <a class="navbar-brand" href="#"><img class="logo" src="../images/logoHM.png"></a>                    
                </div>
                <div class="navbar-collapse collapse" style="float: right">
                    <ul class="nav navbar-nav">
                        <li id="navbar"><a href="#">¿QUIENES SOMOS?</a></li>
                        <li id="navbar"><a href="#">CONTACTO</a></li>
                        <li><a href="javascript:abrir()"><button type="submit" class="btn-IS" name="login"><span style="font-size: 18px" class="glyphicon glyphicon-user" aria-hidden="true"></span> INICIAR SESION</button></a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div id='menu-categoria'>
            <p class="text-menu">
                <a class="text-menu" href='#'>LITERATURA</a>
                <a class="text-menu" href='#'>INFANTIL</a>
                <a class="text-menu" href='#'>COMIC Y MANGAS</a>
                <a class="text-menu" href='#'>EMPRESAS</a>
                <a class="text-menu" href='#'>IDIOMAS Y EDUCACION</a>
            </p>
        </div>
        
        
    </body>
    <div id="Pie-Pagina">
        <div align="left">
            <div>
                <div align="left">
                    <img style="width: 400px;margin-left: 80px;margin-top: 30px" src="../images/logoHM.png">
                </div>
                <div align="right">
                    <p align="justify" style="margin-right: 100px; font-weight: bold; width: 500px;margin-top: -90px">
                        LA LIBRERIA "HOLA MUNDO", ES UNA EMPRESA FAMILIAR,
                        CUENTAN CON UNA SUCURSAL, TIENE EL DESEO DE CRECER
                        Y CONSEGUIR EXPANSION COMERCIAL EXITOSA LOS LLEVO A
                        PENSAR EN LA IMPLEMENTACION DE UNA APLICACION WEB DE
                        SU TIENDA DONDE LA ADQUISICION DE LIBROS SEA COMODA,
                        SENCILLA Y FAMILIAR CON PROCESOS SIMPLES.
                        LO QUE LA EMPRESA NECESITA ES UNA TIENDA VIRTUAL
                    </p>
                </div>

            </div>
            <div align="left" style="margin-top: -50px;height: 100px">
                <p style="margin-left: 120px; font-weight: bold">AV SANTA ANITA NUMERO 06</p>
                <p style="margin-left: 120px; font-weight: bold">CONTACTO: HOLAMUNDO@GMAIL.COM</p>
                <p style="margin-left: 120px; font-weight: bold">TELEFONO: 923588992</p>
            </div>

        </div>


    </div>
    
    <div class="ventanaAsientos" id="vent">
            <div id="cerrar">
                <a href="javascript:cerrar()"><img style="float: right; margin-top: -20px"  src="../images/cerrar.png"> </a>
            </div>
        <div>
            <form method="post" action="../ControllerLogin">
            <input type="text" class="form-control" style="margin-top:25px" placeholder="Usuario" name="username">
            <input type="password" class="form-control" style="margin-top:10px" placeholder="Contraseña" name="userpass">
            <button class="btn-BC" style="margin-top:10px" type="submit">Ingresar</button>
            <input type="submit" value="login"></form>
        </div>

        </div>
    
    <script type="text/javascript">
        function abrir() {
            document.getElementById("vent").style.display = "block";
        }
        function cerrar() {
            document.getElementById("vent").style.display = "none";
        }
    </script>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

</html>
