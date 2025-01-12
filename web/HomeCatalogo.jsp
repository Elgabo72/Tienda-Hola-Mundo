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
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/estilos.css" rel="stylesheet">
    </head>

    <body>
        <nav class="navbar navbar-default navbar-static-top">
            <div class="container-fluid">  <!-- container solo tiene margen en la pagina container con fluid extiende en todo el ancho de la pagina-->
                <div class="navbar-header col-md-6">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand col-sm-3" href="HomeCatalogo.jsp"><img class="logo" src="images/logoHM.png"></a>
                </div>
                <div id="navbar" class="navbar-collapse collapse col-md-6">
                    <ul class="nav navbar-nav">
                        <li id="navbar"><a href="#Pie-Pagina">¿QUIENES SOMOS?</a></li>
                        <li id="navbar"><a href="#Pie-Pagina">CONTACTO</a></li>
                        <li><a href="javascript:abrir()"><button type="submit" class="btn-IS" name="login"><span style="font-size: 18px" class="glyphicon glyphicon-user" aria-hidden="true"></span> INICIAR SESION</button></a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <%  if (request.getParameter("error") != null) {
                out.println(request.getParameter("error"));
            }
        %>
        <div id='menu-categoria'>
            <div class="container">
                <form action="HomeCatalogo.jsp" method="post">
                    <%
                        if (true) {
                            Conexion cn = new Conexion();
                            Connection con;
                            PreparedStatement ps;
                            ResultSet rs;
                            String sql = "select * from categoria";
                            con = cn.Conexion();
                            ps = con.prepareStatement(sql);
                            rs = ps.executeQuery();
                    %>
                    <%
                        while (rs.next()) {
                    %>
                    <a class="text-menu"><input style="background-color: transparent; border: 0px;padding: 0px 2px 6px;margin-top: -3px" type="submit" value="<%= rs.getString(2)%>" name="Categoria"></a>

                    <%     }
                        }
                    %>
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
                            <a style=" text-decoration: none; color: white" href="Controller?action=Carrito">
                                <p style="font-size: calc(0.6em + 0.6vw);text-align: center; margin-top: -21px;">CARRITO DE COMPRAS ${contador}</p>
                            </a> 
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div align="center">
                <img style="margin-top: 20px;border: white 10px solid;width: 100%;" src="images/BANNER-NOVEDADES-NOV.png"/>
            </div>
            <%
                if (request.getParameter("Categoria") != null) {
                    Conexion cn = new Conexion();
                    Connection con;
                    PreparedStatement ps;
                    ResultSet rs;
                    String buscar = request.getParameter("Categoria");
                    String sql = "SELECT l.id_libro,l.titulo_libro,l.autor_libro,l.f_publicacion_libro,l.num_paginas_libro,l.precio_libro,\n"
                            + "l.sinopsis_libro,l.portada_libro,l.f_registro_libro,l.estado_libro,e.nombre_editorial,c.nombre_categoria,l.stock FROM libro l \n"
                            + "INNER JOIN editorial e on l.id_editoriales_lib=e.id_editorial \n"
                            + "INNER JOIN categoria c on l.id_categorias_lib=c.id_categoria where nombre_categoria ='" + buscar + "'";
                    con = cn.Conexion();
                    ps = con.prepareStatement(sql);
                    rs = ps.executeQuery();
            %>
            <%
                while (rs.next()) {
            %>   

            <div class="col-md-3" align="center">
                <br><br>
                <img style="width: 160px;height: 250px" src="ControllerIMG?id=<%= rs.getString(1)%>" >
                <p align="center" style="font-weight: bold;margin-top: 10px"><%= rs.getString(2)%></p>
                <p style="font-weight: bold;margin-top:-10px;margin-left: 10px ;color: green"><%= rs.getString(3)%></p>
                <label class="btn-LT"><%= rs.getString(12)%></label><p class="txt-precio">S/. <%= rs.getString(6)%></p>
                <a class="btn-CP" href="Controller?action=AgregarCarrito&id=<%= rs.getString(1)%>" >Comprar</a>
            </div>

            <%     }
            } else if (request.getParameter("Buscar") != null) {
                Conexion cn = new Conexion();
                Connection con;
                PreparedStatement ps;
                ResultSet rs;
                String buscar = request.getParameter("txtbuscar");
                String sql = "SELECT l.id_libro,l.titulo_libro,l.autor_libro,l.f_publicacion_libro,l.num_paginas_libro,l.precio_libro,\n"
                        + "l.sinopsis_libro,l.portada_libro,l.f_registro_libro,l.estado_libro,e.nombre_editorial,c.nombre_categoria,l.stock FROM libro l \n"
                        + "INNER JOIN editorial e on l.id_editoriales_lib=e.id_editorial \n"
                        + "INNER JOIN categoria c on l.id_categorias_lib=c.id_categoria where titulo_libro LIKE '%" + buscar + "%' or autor_libro LIKE '%" + buscar + "%'";
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
            %>


            <%
                while (rs.next()) {
            %>   

            <div class="col-md-3" align="center">
                <br><br>
                <img style="width: 160px;height: 250px" src="ControllerIMG?id=<%= rs.getString(1)%>" >
                <p align="center" style="font-weight: bold;margin-top: 10px"><%= rs.getString(2)%></p>
                <p style="font-weight: bold;margin-top:-10px;margin-left: 10px ;color: green"><%= rs.getString(3)%></p>
                <label class="btn-LT"><%= rs.getString(12)%></label><p class="txt-precio">S/. <%= rs.getString(6)%></p>
                <a class="btn-CP" href="Controller?action=AgregarCarrito&id=<%= rs.getString(1)%>" >Comprar</a>
            </div>

            <%     }
            } else if (true) {
                Conexion cn = new Conexion();
                Connection con;
                PreparedStatement ps;
                ResultSet rs;
                String sql = "SELECT l.id_libro,l.titulo_libro,l.autor_libro,l.f_publicacion_libro,l.num_paginas_libro,l.precio_libro,\n"
                        + "l.sinopsis_libro,l.portada_libro,l.f_registro_libro,l.estado_libro,e.nombre_editorial,c.nombre_categoria,l.stock FROM libro l \n"
                        + "INNER JOIN editorial e on l.id_editoriales_lib=e.id_editorial \n"
                        + "INNER JOIN categoria c on l.id_categorias_lib=c.id_categoria";
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
            %>

            <%
                while (rs.next()) {
            %>   

            <div class="col-md-3" align="center">
                <br><br>
                <img style="width: 160px;height: 250px" src="ControllerIMG?id=<%= rs.getString(1)%>" >
                <p align="center" style="font-weight: bold;margin-top: 10px"><%= rs.getString(2)%></p>
                <p style="font-weight: bold;margin-top:-10px;margin-left: 10px ;color: green"><%= rs.getString(3)%></p>
                <label class="btn-LT"><%= rs.getString(12)%></label><p class="txt-precio">S/. <%= rs.getString(6)%></p>
                <a class="btn-CP" href="Controller?action=AgregarCarrito&id=<%= rs.getString(1)%>" >Comprar</a>
            </div>

            <%     }
                }
            %>
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