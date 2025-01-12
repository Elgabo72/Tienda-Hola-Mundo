<%-- 
    Document   : Comprobante
    Created on : 06-feb-2021, 14:39:19
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comprobante de Pago</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link  rel = "icon"  href = "images/iconotitulologoHM.png">
        <link href="css/estilos.css" rel="stylesheet">
    </head>
    <body>
        <div class="container" style="background-color:#fff; margin-top: 25px ">
            <div>
                <img  style="width: 230px; height: 50px; margin-top: 50px " src="images/logoHM.png">
                <h1 style="text-align: center; ">Comprobante de Pago</h1>
                <p style=" font-weight: bold; text-align: center">DIRECCION: AV SANTA ANITA NUMERO 06</p>

                <p style=" font-weight: bold;text-align: center">CONTACTO: HOLAMUNDO@GMAIL.COM</p>
                <p style=" font-weight: bold;text-align: center">TELEFONO: 923588992</p>
            </div>





            <table class="table table-success table-striped">
                <thead>
                <th>ID</th>
                <th>Nombre Libro</th>
                <th>Fecha</th>
                <th>Subtotal</th>

                </thead>

                <tbody id="factura" >

                </tbody>
            </table>
            <div style="text-align: end">
                <label>Total a pagar:</label>
                <span id="total"></span>   
            </div>
            <div>
                <a href="Controller?action=home" style="border-bottom: 10px" class="btn btn-success">Terminar Proceso</a>

            </div>

        </div>

    </body>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/Comprobante.js" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</html>
