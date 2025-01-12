<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Modelo.Conexion"%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@ page session="true" %>

<%
    String usuario = "";
    HttpSession sesionOk = request.getSession();
    if (sesionOk.getAttribute("username") == null) {
%>
<jsp:forward page="HomeCatalogo.jsp">
    <jsp:param name="error" value="Es obligatorio identificarse"/>
</jsp:forward>
<%
    } else {
        usuario = (String) sesionOk.getAttribute("username");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="iso-8859-1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link  rel = "shortcut icon"  href = "images/iconotitulologoHM.png"> 
        <link  rel = "icon"  href = "images/iconotitulologoHM.png">
        <title>Almacen</title>
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
                    <a class="text-menu" href='Controlador?menu=HomeAlmacen&accion=Listar'>LIBROS</a>
                    <a class="text-menu" href='Controlador?menu=HomeCategoria&accion=Listar'>CATEGORIAS</a>
                    <a class="text-menu" href='Controlador?menu=HomeEditorial&accion=Listar'>PROVEEDORES</a>
                    
                </form>
            </div>
        </div>

        <div class="container-fluid">
            <div id="FondoRegistroLibro">
                <form action="Controlador?menu=HomeAlmacen" method="POST" enctype="multipart/form-data">
                    <div class="row">
                        <h2>AÑADIR DATOS DE LIBRO</h2>
                        <div class="col-md-6">
                            <div class="col-md-12">
                                <div class="col-md-4">
                                    <p>Titulo</p>
                                </div>
                                <div class="col-md-6">
                                    <input type="text" value="${libro.getTitulo_libro()}" class="form-control" name="txttitulo" required >
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="col-md-4">
                                    <p>Autor</p>
                                </div>
                                <div class="col-md-6">
                                    <input type="text" value="${libro.getAutor_libro()}" class="form-control" name="txtautor" required>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="col-md-4">
                                    <p>Fecha de Publicacion</p>
                                </div>
                                <div class="col-md-6">
                                    <input type="date" value="${libro.getF_publicacion_libro()}" class="form-control" name="txtfechapub" required>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="col-md-4">
                                    <p>Numero de paginas</p>
                                </div>
                                <div class="col-md-6">
                                    <input type="number" value="${libro.getNum_paginas_libro()}" class="form-control" name="txtnumpag" required>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="col-md-4">
                                    <p>Precio</p>
                                </div>
                                <div class="col-md-6">
                                    <input type="text" value="${libro.getPrecio_libro()}" class="form-control" name="txtprecio" required>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="col-md-4">
                                    <p>Sinopsis</p>
                                </div>
                                <div class="col-md-6">
                                    <textarea class="form-control" value="${libro.getSinopsis_libros()}" name="txtsinopsis" required></textarea >
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="col-md-4">
                                    <p>Imagen de Portada</p>
                                </div>
                                <div class="col-md-6">
                                    <input type="file" value="${libro.getId_libro()}" name="fileImagen">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="col-md-12">
                                <div class="col-md-4">
                                    <p>Fecha de Registro</p>
                                </div>
                                <div class="col-md-6">
                                    <input type="date" value="${libro.getF_registro_libro()}" class="form-control" name="txtfechareg" required>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="col-md-4">
                                    <p>Estado</p>
                                </div>
                                <div class="col-md-6">
                                    <input type="text" value="${libro.getEstado_libro()}" class="form-control" name="txtestado" required>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="col-md-4">
                                    <p>Editorial</p>
                                </div>
                                <div class="col-md-6">

                                    <select name="txteditorial"  id="editorial" class="form-control" required>
                                        <%
                                            Conexion cn2 = new Conexion();
                                            Connection con2;
                                            PreparedStatement ps2;
                                            ResultSet rs2;

                                            try {
                                                con2 = cn2.Conexion();
                                                String sql = "SELECT id_editorial,nombre_editorial FROM editorial";
                                                ps2 = con2.prepareStatement(sql);
                                                rs2 = ps2.executeQuery();
                                                if (!rs2.next()) {
                                                    out.println("<OPTION VALUE=\"0\" SELECTED>No hay datos</OPTION>");
                                                } else {
                                                    do {
                                                        out.println("<OPTION VALUE=\"" + rs2.getString(1) + "\">" + rs2.getString(2) + "</OPTION>");
                                                    } while (rs2.next());
                                                }
                                                System.out.println("Conexion realizada");
                                            } catch (Exception e) {

                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="col-md-4">
                                    <p>Categoria</p>
                                </div>
                                <div class="col-md-6">
                                    <select name="txtcategoria" id="editorial" class="form-control" required>

                                        <%
                                            Conexion cn3 = new Conexion();
                                            Connection con3;
                                            PreparedStatement ps3;
                                            ResultSet rs3;

                                            try {
                                                con3 = cn3.Conexion();
                                                String sql = "SELECT id_categoria,nombre_categoria FROM categoria";
                                                ps3 = con3.prepareStatement(sql);
                                                rs3 = ps3.executeQuery();
                                                if (!rs3.next()) {
                                                    out.println("<OPTION VALUE=\"0\" SELECTED>No hay datos</OPTION>");
                                                } else {
                                                    do {
                                                        out.println("<OPTION VALUE=\"" + rs3.getString(1) + "\">" + rs3.getString(2) + "</OPTION>");
                                                    } while (rs3.next());
                                                }
                                                System.out.println("Conexion realizada");
                                            } catch (Exception e) {

                                            }
                                        %>


                                    </select>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="col-md-4">
                                    <p>Stock</p>
                                </div>
                                <div class="col-md-6">
                                    <input type="number" value="${libro.getStock()}" class="form-control" name="txtstock" required>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <input style="float: right;margin-right: 19%; margin-top: 5%" type="submit" class="btn btn-success"  value="Agregar" name="accion" >
                                <input style="float: right;margin-right: 22%; margin-top: 5%" type="submit" name="accion" value="Actualizar" class="btn btn-warning">
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="container-fluid">
            <div class="col-md-12" id="FondoRegistroLibro">
                
                <div class="col-md-12">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Titulo</th>
                                <th>Autor</th> 
                                <th>Publicacion</th> 
                                <th>Paginas</th> 
                                <th>Precio</th>
                                <th>Sinopsis</th>
                                <th>Portada</th>
                                <th>Registro</th>
                                <th>Estado</th>
                                <th>Editorial</th>
                                <th>Categoria</th>
                                <th>Stock</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="li" items="${libros}">
                                <tr>
                                    <td>${li.getId_libro()}</td>
                                    <td>${li.getTitulo_libro()}</td>
                                    <td>${li.getAutor_libro()}</td>
                                    <td>${li.getF_publicacion_libro()}</td>
                                    <td>${li.getNum_paginas_libro()}</td>
                                    <td>${li.getPrecio_libro()}</td>
                                    <td><textarea class="txt-sinopsis" disabled>${li.getSinopsis_libros()}</textarea></td>
                                    <td><img style="width: 20px;height: 30px" src="ControllerIMG?id=${li.getId_libro()}"></td>
                                    <td>${li.getF_registro_libro()}</td>
                                    <td>${li.getEstado_libro()}</td>
                                    <td>${li.getId_editoriales_lib()}</td>
                                    <td>${li.getId_categorias_lib()}</td>
                                    <td>${li.getStock()}</td>
                                    <td>
                                        <a class="btn btn-warning" href="Controlador?menu=HomeAlmacen&accion=Editar&id=${li.getId_libro()}">Editar</a>
                                        <a class="btn btn-danger" href="Controlador?menu=HomeAlmacen&accion=Eliminar&id=${li.getId_libro()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <div class="container-fluid">
        <div class="row" align="center">
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



    
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

</html>
