<%-- 
    Document   : HomeCargos
    Created on : 21-ene-2021, 21:03:50
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Cargos</title>
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
                   
                    <a class="text-menu" href='Controlador?menu=HomeEmpleado&accion=Listar'>EMPLEADOS</a>
                    <a class="text-menu" href='Controlador?menu=HomeUsuarios&accion=Listar'>USUARIOS</a>
                    <a class="text-menu" href='Controlador?menu=HomeCargos&accion=Listar'>CARGOS</a>
                    <a class="text-menu" href='Controller?action=ReporteVentas'>REPORTE VENTAS</a>
                </form>
            </div>
        </div>
          <div class="container-fluid">
            <div class="col-md-12" id="FondoListaCategoria">
                <div class="d-flex">
                    <div class="col-sm-4">
                        <h2>Registro de Cargos</h2> 
                        <br>
                        <div class="form-boby">
                            <form action="Controlador?menu=HomeCargos" method="POST">
                                <div class="form-group">
                                    <label style="text-align: left">Nombre</label>
                                    <input type="text" value="${cargo.getNombre_cargo()}" name="txtnombre" class="form-control" placeholder="Solo letras" required pattern="[A-Za-z]">
                                </div>
                                <div class="form-group">
                                    <label>Descripcion</label>
                                    <input type="text" value="${cargo.getDesc_cargo()}" name="txtdescripcion" class="form-control">
                                </div> 
                                <div class="form-group">
                                    <label>Sueldo</label>
                                    <input type="number" value="${cargo.getSueldo_cargo()}" name="txtsueldo" class="form-control">
                                </div>
                               
                               
                                <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                                <input type="submit" name="accion" value="Actualizar" class="btn btn-warning">
                            </form>  
                        </div>
                    </div> 
                    <div class="col-lg-8"> 
                        <h2>Lista</h2>
                        <br>
                        <table class="table table-striped" id="centrar">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Cargo</th>
                                    <th>Descripcion</th>
                                    <th>Sueldo</th>
                                  
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="car" items="${cargos}">
                                <tr>
                                        <td>${car.getId_cargo()}</td>
                                        <td>${car.getNombre_cargo()}</td>
                                        <td>${car.getDesc_cargo()}</td>
                                        <td>${car.getSueldo_cargo()}</td>
                                        
                                        <td>
                                            <a class="btn btn-warning" href="Controlador?menu=HomeCargos&accion=Editar&id=${car.getId_cargo()}">Editar</a>
                                            <a class="btn btn-danger" href="Controlador?menu=HomeCargos&accion=Eliminar&id=${car.getId_cargo()}">Eliminar</a>
                                        </td>
                                    </tr>
                            </c:forEach>
                            </tbody>
                        </table>
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
    </body>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

</html>