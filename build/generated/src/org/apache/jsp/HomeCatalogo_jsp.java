package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import Modelo.Conexion;
import java.util.List;

public final class HomeCatalogo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=iso-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"iso-8859-1\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link  rel = \"shortcut icon\"  href = \"images/iconotitulologoHM.png\"> \n");
      out.write("        <link  rel = \"icon\"  href = \"images/iconotitulologoHM.png\">\n");
      out.write("        <title>HolaMundo Libros</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/estilos.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-default navbar-static-top\">\n");
      out.write("            <div class=\"container-fluid\">  <!-- container solo tiene margen en la pagina container con fluid extiende en todo el ancho de la pagina-->\n");
      out.write("                <div class=\"navbar-header col-md-6\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n");
      out.write("                        <span class=\"sr-only\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand col-sm-3\" href=\"HomeCatalogo.jsp\"><img class=\"logo\" src=\"images/logoHM.png\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"navbar\" class=\"navbar-collapse collapse col-md-6\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li id=\"navbar\"><a href=\"#Pie-Pagina\">¿QUIENES SOMOS?</a></li>\n");
      out.write("                        <li id=\"navbar\"><a href=\"#Pie-Pagina\">CONTACTO</a></li>\n");
      out.write("                        <li><a href=\"javascript:abrir()\"><button type=\"submit\" class=\"btn-IS\" name=\"login\"><span style=\"font-size: 18px\" class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span> INICIAR SESION</button></a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        ");
  if (request.getParameter("error") != null) {
                out.println(request.getParameter("error"));
            }
        
      out.write("\n");
      out.write("        <div id='menu-categoria'>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <form action=\"HomeCatalogo.jsp\" method=\"post\">\n");
      out.write("                    ");

                        if (true) {
                            Conexion cn = new Conexion();
                            Connection con;
                            PreparedStatement ps;
                            ResultSet rs;
                            String sql = "select * from categoria";
                            con = cn.Conexion();
                            ps = con.prepareStatement(sql);
                            rs = ps.executeQuery();
                    
      out.write("\n");
      out.write("                    ");

                        while (rs.next()) {
                    
      out.write("\n");
      out.write("                    <a class=\"text-menu\"><input style=\"background-color: transparent; border: 0px;padding: 0px 2px 6px;margin-top: -3px\" type=\"submit\" value=\"");
      out.print( rs.getString(2));
      out.write("\" name=\"Categoria\"></a>\n");
      out.write("\n");
      out.write("                    ");
     }
                        }
                    
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("       <div class=\"barra-buscar\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-9\">\n");
      out.write("                        <form action=\"HomeCatalogo.jsp\" method=\"post\">\n");
      out.write("                            <input id='input_bc' type=\"search\" class=\"txt-buscar col-md-10\" name=\"txtbuscar\" placeholder=\"BUSCAR POR TITULO/AUTOR\">\n");
      out.write("                            <input type=\"submit\" class=\"btn-BC col-md-2\"  value=\"Buscar\" name=\"Buscar\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                        <button class=\"btn-CC\" >\n");
      out.write("                            <span style=\"font-size: calc(0.6em + 0.6vw);;color: black;margin-left:-90% \" class=\"glyphicon glyphicon-shopping-cart\" aria-hidden=\"true\"></span>\n");
      out.write("                            <a style=\" text-decoration: none; color: white\" href=\"Controller?action=Carrito\">\n");
      out.write("                                <p style=\"font-size: calc(0.6em + 0.6vw);text-align: center; margin-top: -21px;\">CARRITO DE COMPRAS ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contador}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                            </a> \n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div align=\"center\">\n");
      out.write("                <img style=\"margin-top: 20px;border: white 10px solid;width: 100%;\" src=\"images/BANNER-NOVEDADES-NOV.png\"/>\n");
      out.write("            </div>\n");
      out.write("            ");

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
            
      out.write("\n");
      out.write("            ");

                while (rs.next()) {
            
      out.write("   \n");
      out.write("\n");
      out.write("            <div class=\"col-md-3\" align=\"center\">\n");
      out.write("                <br><br>\n");
      out.write("                <img style=\"width: 160px;height: 250px\" src=\"ControllerIMG?id=");
      out.print( rs.getString(1));
      out.write("\" >\n");
      out.write("                <p align=\"center\" style=\"font-weight: bold;margin-top: 10px\">");
      out.print( rs.getString(2));
      out.write("</p>\n");
      out.write("                <p style=\"font-weight: bold;margin-top:-10px;margin-left: 10px ;color: green\">");
      out.print( rs.getString(3));
      out.write("</p>\n");
      out.write("                <label class=\"btn-LT\">");
      out.print( rs.getString(12));
      out.write("</label><p class=\"txt-precio\">S/. ");
      out.print( rs.getString(6));
      out.write("</p>\n");
      out.write("                <a class=\"btn-CP\" href=\"Controller?action=AgregarCarrito&id=");
      out.print( rs.getString(1));
      out.write("\" >Comprar</a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
     }
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
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");

                while (rs.next()) {
            
      out.write("   \n");
      out.write("\n");
      out.write("            <div class=\"col-md-3\" align=\"center\">\n");
      out.write("                <br><br>\n");
      out.write("                <img style=\"width: 160px;height: 250px\" src=\"ControllerIMG?id=");
      out.print( rs.getString(1));
      out.write("\" >\n");
      out.write("                <p align=\"center\" style=\"font-weight: bold;margin-top: 10px\">");
      out.print( rs.getString(2));
      out.write("</p>\n");
      out.write("                <p style=\"font-weight: bold;margin-top:-10px;margin-left: 10px ;color: green\">");
      out.print( rs.getString(3));
      out.write("</p>\n");
      out.write("                <label class=\"btn-LT\">");
      out.print( rs.getString(12));
      out.write("</label><p class=\"txt-precio\">S/. ");
      out.print( rs.getString(6));
      out.write("</p>\n");
      out.write("                <a class=\"btn-CP\" href=\"Controller?action=AgregarCarrito&id=");
      out.print( rs.getString(1));
      out.write("\" >Comprar</a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
     }
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
            
      out.write("\n");
      out.write("\n");
      out.write("            ");

                while (rs.next()) {
            
      out.write("   \n");
      out.write("\n");
      out.write("            <div class=\"col-md-3\" align=\"center\">\n");
      out.write("                <br><br>\n");
      out.write("                <img style=\"width: 160px;height: 250px\" src=\"ControllerIMG?id=");
      out.print( rs.getString(1));
      out.write("\" >\n");
      out.write("                <p align=\"center\" style=\"font-weight: bold;margin-top: 10px\">");
      out.print( rs.getString(2));
      out.write("</p>\n");
      out.write("                <p style=\"font-weight: bold;margin-top:-10px;margin-left: 10px ;color: green\">");
      out.print( rs.getString(3));
      out.write("</p>\n");
      out.write("                <label class=\"btn-LT\">");
      out.print( rs.getString(12));
      out.write("</label><p class=\"txt-precio\">S/. ");
      out.print( rs.getString(6));
      out.write("</p>\n");
      out.write("                <a class=\"btn-CP\" href=\"Controller?action=AgregarCarrito&id=");
      out.print( rs.getString(1));
      out.write("\" >Comprar</a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
     }
                }
            
      out.write("\n");
      out.write("        </div> \n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div id=\"Pie-Pagina\" class=\"row\" align=\"center\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <img src=\"images/logoHM.png\" class=\"logo-PiePagina\"><br><br>\n");
      out.write("                        <p style=\"margin-left: 9%; font-weight: bold\">AV SANTA ANITA NUMERO 06</p>\n");
      out.write("                        <p style=\"margin-left: 9%; font-weight: bold\">CONTACTO: HOLAMUNDO@GMAIL.COM</p>\n");
      out.write("                        <p style=\"margin-left: 9%; font-weight: bold\">TELEFONO: 923588992</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <p align=\"justify\" style=\"margin-right: 1%; font-weight: bold; width: 80%;margin-top:3%\">\n");
      out.write("                            LA LIBRERIA \"HOLA MUNDO\", ES UNA EMPRESA FAMILIAR,\n");
      out.write("                            CUENTAN CON UNA SUCURSAL, TIENE EL DESEO DE CRECER\n");
      out.write("                            Y CONSEGUIR EXPANSION COMERCIAL EXITOSA LOS LLEVO A\n");
      out.write("                            PENSAR EN LA IMPLEMENTACION DE UNA APLICACION WEB DE\n");
      out.write("                            SU TIENDA DONDE LA ADQUISICION DE LIBROS SEA COMODA,\n");
      out.write("                            SENCILLA Y FAMILIAR CON PROCESOS SIMPLES.\n");
      out.write("                            LO QUE LA EMPRESA NECESITA ES UNA TIENDA VIRTUAL\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"ventanaLogin\" id=\"vent\">\n");
      out.write("            <div id=\"cerrar\">\n");
      out.write("                <a href=\"javascript:cerrar()\"><img style=\"float: right; margin-top: -20px\"  src=\"images/cerrar.png\"> </a>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <h2 align=\"center\">Inicio de Sesion</h2>\n");
      out.write("                <form method=\"post\" action=\"ControllerLogin\">\n");
      out.write("                    <input type=\"text\" class=\"form-control\" style=\"margin-top:25px\" placeholder=\"Usuario\" name=\"username\">\n");
      out.write("                    <input type=\"password\" class=\"form-control\" style=\"margin-top:10px\" placeholder=\"Contraseña\" name=\"userpass\">\n");
      out.write("                    <button class=\"btn-BC\" style=\"margin-top:10px\" type=\"submit\">Ingresar</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        function abrir() {\n");
      out.write("            document.getElementById(\"vent\").style.display = \"block\";\n");
      out.write("        }\n");
      out.write("        function cerrar() {\n");
      out.write("            document.getElementById(\"vent\").style.display = \"none\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\" integrity=\"sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T\" crossorigin=\"anonymous\"></script>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
