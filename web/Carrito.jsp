<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Modelo.Conexion"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="iso-8859-1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link  rel = "shortcut icon"  href = "images/iconotitulologoHM.png"> 
        <link  rel = "icon"  href = "images/iconotitulologoHM.png">
        <title>HolaMundo Libros</title>
        <script src="js/jquery.min.js" type="text/javascript"></script>
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
                    <a class="navbar-brand" href="Controller?action=home"><img class="logo" src="images/logoHM.png"></a>

                </div>
                <div id="navbar" class="navbar-collapse collapse" style="float: right">
                    <ul class="nav navbar-nav">
                        <li id="navbar"><a href="#Pie-Pagina">¿QUIENES SOMOS?</a></li>
                        <li id="navbar"><a href="#Pie-Pagina">CONTACTO</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div id='menu-categoria'>
            <div class="container">
                <form action="HomeCatalogo.jsp" method="post">
                    <a class="text-menu" href='#'><input style="background-color: transparent; border: 0px; padding: 5px;margin-top: -3px" type="submit" value="TERROR" name="Categoria"></a>
                    <a class="text-menu" href='#'><input style="background-color: transparent; border: 0px; padding: 5px;margin-top: -3px" type="submit" value="DRAMA" name="Categoria"></a>
                    <a class="text-menu" href='#'><input style="background-color: transparent; border: 0px; padding: 5px;margin-top: -3px" type="submit" value="ROMANCE" name="Categoria"></a>
                    <a class="text-menu" href='#'><input style="background-color: transparent; border: 0px; padding: 5px;margin-top: -3px" type="submit" value="MISTERIO" name="Categoria"></a>
                    <a class="text-menu" href='#'><input style="background-color: transparent; border: 0px; padding: 5px;margin-top: -3px" type="submit" value="COMEDIA" name="Categoria"></a>
                </form>
            </div>
        </div>
        <div class="barra-buscar">
            <div class="container">
                <div class="row">
                    <div class="col-md-9">
                        <form action="HomeCatalogo.jsp" method="post">
                            <input id='input_bc' type="search" class="txt-buscar col-md-10" name="txtbuscar" placeholder="BUSCAR POR TITULO/AUTOR">
                            <input type="submit" class="btn-BC col-md-2"  value="Buscar" name="Buscar">
                        </form>
                    </div>
                    <div class="col-md-3">
                        <button class="btn-CC" >
                            <span style="font-size: calc(0.6em + 0.6vw);;color: black;margin-left:-90% " class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
                            <a style=" text-decoration: none; color: white" href="Controller?action=Home">
                                <p style="font-size: calc(0.6em + 0.6vw);text-align: center; margin-top: -21px;">SEGUIR COMPRANDO</p>
                            </a>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="col-md-12" id="FondoRegistroLibro">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8">
                            <h2>PRODUCTOS A SOLICITAR</h2>
                            <br>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Item</th>
                                        <th>Imagen</th>
                                        <th>Nombre</th>
                                        <th>Sinopsis</th>
                                        <th>Precio</th>
                                        <th>Cant</th>
                                        <th>Subtotal</th>
                                        <th>Acciones</th>
                                    </tr>
                                <script>
                                    let subtotal=[];
                                </script>
                                
                                <tbody><%int contador=0;%>
                                    <c:forEach var="car" items="${carrito}">
                                        <tr>
                                            <td>${car.getItem()}
                                                <input type="hidden" value="${car.getItem()}" id="txtitem">
                                            </td>

                                            <td><img style="width: 20px;height: 30px" src="ControllerIMG?id=${car.getId_libro()}"></td>

                                            <td>${car.getNombre()}</td>
                                            <td><textarea class="txt-sinopsis" disabled>${car.getDescripcion()}</textarea></td>
                                            <td>S/. ${car.getPrecio()}</td>
                                            <td>
                                                <input type="hidden" id="idpro" value="${car.getId_libro()}">
                                                <input type="number" id="Cantidad" value="${car.getCantidad()}" class="form-control text-center" min="1">
                                            </td>
                                            <td>${car.getSubtotal()}
                                            <input type="hidden" id="<%=contador%>" value="${car.getSubtotal()}"/></td>
                                            <td>
                                                <input type="hidden" id="idp" value="${car.getId_libro()}">
                                                <a href="#" id="btnDelete">Eliminar</a>
                                            </td>
                                    <script>
                                        subtotal.push({'id':${car.getItem()},'subtotal':${car.getSubtotal()},'producto':'${car.getNombre()}'});
                                        localStorage["SUBTOTAL"]=JSON.stringify(subtotal);
                                    </script>

                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                        <div class="col-sm-4">
                            <div class="card">
                                <div class="card-header">
                                    <h3>TOTAL A PAGAR</h3>
                                </div>
                                <div class="card-body">


                                    <input type="text" value="S/${totalPagar}0" readonly="" id="total" class="form-control">
                                </div>
                                <div class="card-footer">
                                    <a href="javascript:abrirC()" class="btn btn-info btn-block">Realizar Pedido</a>
                                    
                                </div>
                            </div>
                                <script>
                                    var total =${totalPagar};
                                    //$('#total').val();
                                    localStorage.setItem('TOTAL',total);
                                </script>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="container-fluid">
            <div id="Pie-Pagina" class="row" align="center">
                <div class="col-md-12">
                    <div class="col-md-6">
                        <img src="images/logoHM.png" class="logo-PiePagina"><br><br>
                        <p style="margin-left: 9%; font-weight: bold">AV SANTA ANITA NUMERO 06</p>
                        <p style="margin-left: 9%; font-weight: bold">CONTACTO: HOLAMUNDO@GMAIL.COM</p>
                        <p style="margin-left: 9%; font-weight: bold">TELEFONO: 923588992</p>
                    </div>
                    <div class="col-md-6">
                        <p align="justify" style="margin-right: 1%; font-weight: bold; width: 80%;margin-top:3%">
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
            </div>
        </div>
        <div class="ventanaCompra" id="ventC">
            <div id="cerrar">
                <a href="javascript:cerrarC()"><img style="float: right; margin-top: -20px"  src="images/cerrar.png"> </a>
            </div>
            <div>

                <form action="Controller?action=GenerarVenta" method="POST" >
                    <div class="row">
                        <h2>Solicitud de Pedido</h2> 
                        <div class="col-md-6">
                            <div class="col-md-12">
                                <div class="col-md-8">
                                    <p>Nombre</p>
                                </div>
                                <div class="col-md-12">
                                    <input type="text" value="" id="txtnombrecli" name="txtnombrecli" class="form-control">
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="col-md-8">
                                    <p>Apellidos</p>
                                </div>
                                <div class="col-md-12">
                                    <input type="text" value="" id="txtapellidocli" name="txtapellidocli" class="form-control">

                                </div>
                            </div> 
                            <div class="col-md-12">
                                <div class="col-md-8">
                                    <p>DNI</p>
                                </div>
                                <div class="col-md-12">
                                    <input type="text" value="" id="txtdnicli" name="txtdnicli" class="form-control">

                                </div>
                            </div>



                        </div>

                        <div class="col-md-6">

                            <div class="col-md-12">
                                <div class="col-md-8">
                                    <p>Telefono</p>
                                </div>
                                <div class="col-md-12">
                                    <input type="text" value="" id="txttelefonocli" name="txttelefonocli" class="form-control">

                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="col-md-8">
                                    <p>Correo</p>
                                </div>
                                <div class="col-md-12">
                                    <input type="text" id="txtcorreocli" value="" name="txtcorreocli" class="form-control">

                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="col-md-8">
                                    <p>Edad</p>
                                </div>
                                <div class="col-md-12">
                                    <input type="number" id="txtedadcli" value="" name="txtedadcli" class="form-control">

                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="col-md-8">
                                    <p>Direccion</p>
                                </div>
                                <div class="col-md-12">
                                    <input type="text" id="txtdireccion" value="" name="txtdireccion" class="form-control">

                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="alert alert-info" role="alert" style="margin-top: 15px">
                        Metodo de pago: Contra Entrega
                    </div>
                    <div class="alert alert-warning" role="alert" style="margin-top: 15px">
                        Espere a nuestra llamada para la confirmacion. Gracias
                    </div>
                    <input class="btn btn-info btn-block" id="enviar" style="margin-top:10px" value="Enviar" name="action" type="submit" >
                </form>

            </div>
        </div>

    </body>
    <script type="text/javascript">
        function abrirC() {
            document.getElementById("ventC").style.display = "block";
        }
        function cerrarC() {
            document.getElementById("ventC").style.display = "none";
        }

    </script>



    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="js/funciones.js" type="text/javascript"></script>
    <script src="js/registrarcompra.js" type="text/javascript"></script>
    <script src="js/Comprobante.js" type="text/javascript"></script>
</html>
