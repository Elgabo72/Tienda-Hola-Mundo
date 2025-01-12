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
        <title>Reporte Ventas</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/estilos.css" rel="stylesheet">
        <style>
            @media print{
                #menu-categoria,#Pie-Pagina,#menu-buscar{
                    display: none;
                }
            }
        </style>
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
                    <a class="navbar-brand" href="HomeCatalogo.jsp"><img class="logo" src="images/logoHM.png"></a>                    
                </div>
                <div id="navbar" class="navbar-collapse collapse" style="float: right">
                    <ul class="nav navbar-nav">
                        <li>
                            <form action="ControllerCerrarSesion" method="post">
                                <button type="submit" class="btn-IS" name="login">CERRAR SESION</button>
                            </form>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div id="menu-categoria">
            <div class="container">
                <form action="HomeCatalogo.jsp" method="post">

                    <a class="text-menu" href='Controlador?menu=HomeEmpleado&accion=Listar'>EMPLEADOS</a>
                    <a class="text-menu" href='Controlador?menu=HomeUsuarios&accion=Listar'>USUARIOS</a>
                    <a class="text-menu" href='Controlador?menu=HomeCargos&accion=Listar'>CARGOS</a>
                    <a class="text-menu" href='Controller?action=ReporteVentas'>REPORTE VENTAS</a>
                </form>
            </div>
        </div>
        <div class="container">
            <div id="FondoRegistroLibro" class="row">
                <div class="form-group" id="menu-buscar">
                    <form action="ReporteVentas.jsp" method="post" class="col-sm-12">
                        <div class="col-sm-2">
                            <label style="margin-top: 10px">Filtro de Fecha: </label>
                        </div>
                        <div class="col-sm-10">
                            <input class="txt-buscar-fecha" type="date" name="fecha">
                            <input class="btn-BC" type="submit" name="buscar" value="buscar">
                            <a onclick="print()" href="" class="btn-CP">REPORTE</a>
                        </div>
                    </form>
                </div>
                <div > 
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th >ID VENTA</th>  
                                <th >CLIENTE</th> 
                                <th >LIBRO</th>
                                <th >MONTO</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                if (request.getParameter("buscar") != null) {
                                    Conexion cn = new Conexion();
                                    Connection con;
                                    PreparedStatement ps;
                                    ResultSet rs;
                                    String buscar = request.getParameter("fecha");
                                    String sql = "select distinct  v.id_venta,c.nombre_cliente, c.apellido_cliente, l.titulo_libro, v.monto "
                                            + "from venta v INNER JOIN cliente c ON v.id_cliente_venta=c.id_cliente "
                                            + "INNER JOIN detalle_venta d ON d.id_venta=v.id_venta INNER JOIN libro l ON l.id_libro=d.id_libro"
                                            + " where v.fecha_venta='" + buscar + "'";
                                    con = cn.Conexion();
                                    ps = con.prepareStatement(sql);
                                    rs = ps.executeQuery();
                            %>
                            <%
                                while (rs.next()) {
                            %>   
                        <td><%= rs.getString(1)%></td>
                        <td><%= rs.getString(2)%>&nbsp;<%= rs.getString(3)%></td>
                        <td><%= rs.getString(4)%></td>
                        <td>S/. <%= rs.getString(5)%></td>
                        </tbody>
                        <%     }
                            }
                        %>
                        
                    </table>
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
        <div class="ventanaLogin" id="vent">
            <div id="cerrar">
                <a href="javascript:cerrar()"><img style="float: right; margin-top: -20px"  src="images/cerrar.png"> </a>
            </div>
            <div>
                <h2 align="center">Inicio de Sesion</h2>
                <form method="post" action="ControllerLogin">
                    <input type="text" class="form-control" style="margin-top:25px" placeholder="Usuario" name="username">
                    <input type="password" class="form-control" style="margin-top:10px" placeholder="Contraseña" name="userpass">
                    <button class="btn-BC" style="margin-top:10px" type="submit">Ingresar</button>
            </div>
        </div>
    </body>


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
