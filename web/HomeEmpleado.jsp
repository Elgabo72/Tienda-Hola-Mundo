<%-- 
    Document   : HomeEmpleado
    Created on : 21-ene-2021, 21:03:22
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Modelo.Conexion"%>
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
        <title>Empleados</title>
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
            <div  id="FondoRegistroLibro">


                
                    <form action="Controlador?menu=HomeEmpleado" method="POST">
                        <div class="row">
                            <h2>Registro de Empleados</h2> 
                            <div class="col-md-6">
                                <div class="col-md-12">
                                    <div class="col-md-4">
                                        <p>Nombre</p>
                                    </div>
                                    <div class="col-md-6">
                                        <input type="text" value="${empleado.getNombre_empleado()}" name="txtnombre" class="form-control" required pattern="[A-Za-z]">
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-4">
                                        <p>Apellidos</p>
                                    </div>
                                    <div class="col-md-6">
                                        <input type="text" value="${empleado.getApellidos_empleado()}" name="txtapellidos" class="form-control">

                                    </div>
                                </div> 
                                <div class="col-md-12">
                                    <div class="col-md-4">
                                        <p>DNI</p>
                                    </div>
                                    <div class="col-md-6">
                                        <input type="number" value="${empleado.getDni_empleado()}" name="txtdni" class="form-control">

                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-4">
                                        <p>Fecha de Nacimiento</p>
                                    </div>
                                    <div class="col-md-6">
                                        <input type="date" value="${empleado.getFe_nacimiento_empleado()}" name="txtfechanac" class="form-control">

                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-4">
                                        <p>Direccion</p>
                                    </div>
                                    <div class="col-md-6">
                                        <input type="text" value="${empleado.getDireccion_empleado()}" name="txtdireccion" class="form-control">

                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-4">
                                        <p>Correo</p>
                                    </div>
                                    <div class="col-md-6">
                                        <input type="email" value="${empleado.getCorreo_empleado()}" name="txtcorreo" class="form-control">

                                    </div>
                                </div>
                            </div>

                            <div class="col-md-6">

                                <div class="col-md-12">
                                    <div class="col-md-4">
                                        <p>Celular</p>
                                    </div>
                                    <div class="col-md-6">
                                        <input type="text" value="${empleado.getCelular_empleado()}" name="txtcelular" class="form-control">

                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-4">
                                        <p>Telefono ref.</p>
                                    </div>
                                    <div class="col-md-6">
                                        <input type="text" value="${empleado.getRef_telefono_empleado()}" name="txttelref" class="form-control">

                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-4">
                                        <p>Fecha de Ingreso</p>
                                    </div>
                                    <div class="col-md-6">
                                        <input type="date" value="${empleado.getFe_ingreso_empleado()}" name="txtfechaing" class="form-control">

                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-4">
                                        <p>Estado</p>
                                    </div>
                                    <div class="col-md-6">
                                        <input type="text" value="${empleado.getEst_empleado()}" name="txtestado" class="form-control">

                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="col-md-4">
                                        <p>Cargo</p>
                                    </div>
                                    <div class="col-md-6">
                                        <select name="txtcargo"  id="cargo" class="form-control" required>
                                            <%
                                                Conexion cn2 = new Conexion();
                                                Connection con2;
                                                PreparedStatement ps2;
                                                ResultSet rs2;

                                                try {
                                                    con2 = cn2.Conexion();
                                                    String sql = "SELECT id_cargo,nombre_cargo FROM cargo";
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
                                    <input style="float: right;margin-right: 19%; margin-top: 3%" type="submit" name="accion" value="Agregar" class="btn btn-primary">
                                    <input style="float: right;margin-right: 22%; margin-top: 3%" type="submit" name="accion" value="Actualizar" class="btn btn-warning">
                                </div>

                            </div>

                        </div>


                    </form>  
                

            </div>
        </div>
        <div class="container-fluid">
            <div class="col-md-12" id="FondoRegistroLibro">
                <div class="col-md-12"> 
                    <h2>Lista</h2>
                    <br>
                    <table class="table table-striped" id="centrar">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Apellidos</th>
                                <th>DNI</th>
                                <th>Fecha de Nacimento</th>
                                <th>Direccion</th>
                                <th>Correo</th>
                                <th>Celular</th>
                                <th>Tel. Ref.</th>
                                <th>Fecha de Ingreso</th>
                                <th>Estado</th>
                                <th>Cargo</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="em" items="${empleados}">
                                <tr>
                                    <td>${em.getId_empleado()}</td>
                                    <td>${em.getNombre_empleado()}</td>
                                    <td>${em.getApellidos_empleado()}</td>
                                    <td>${em.getDni_empleado()}</td>
                                    <td>${em.getFe_nacimiento_empleado()}</td>
                                    <td>${em.getDireccion_empleado()}</td>
                                    <td>${em.getCorreo_empleado()}</td>
                                    <td>${em.getCelular_empleado()}</td>
                                    <td>${em.getRef_telefono_empleado()}</td>
                                    <td>${em.getFe_ingreso_empleado()}</td>
                                    <td>${em.getEst_empleado()}</td>
                                    <td>${em.getId_cargo()}</td>

                                    <td>
                                        <a class="btn btn-warning" href="Controlador?menu=HomeEmpleado&accion=Editar&id=${em.getId_empleado()}">Editar</a>
                                        <a class="btn btn-danger" href="Controlador?menu=HomeEmpleado&accion=Eliminar&id=${em.getId_empleado()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
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

    </body>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

</html>
