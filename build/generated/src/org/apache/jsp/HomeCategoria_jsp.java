package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HomeCategoria_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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

      out.write('\n');
      out.write('\n');

    String usuario = "";
    HttpSession sesionOk = request.getSession();
    if (sesionOk.getAttribute("username") == null) {

      out.write('\n');
      if (true) {
        _jspx_page_context.forward("HomeCatalogo.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("error", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("Es obligatorio identificarse", request.getCharacterEncoding()));
        return;
      }
      out.write('\n');

    } else {
        usuario = (String) sesionOk.getAttribute("username");
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"iso-8859-1\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link  rel = \"shortcut icon\"  href = \"images/iconotitulologoHM.png\"> \n");
      out.write("        <link  rel = \"icon\"  href = \"images/iconotitulologoHM.png\">\n");
      out.write("        <title>Categoria</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/estilos.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-default navbar-static-top\">\n");
      out.write("            <div class=\"container-fluid\">  <!-- container solo tiene margen en la pagina container con fluid extiende en todo el ancho de la pagina-->\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n");
      out.write("                        <span class=\"sr-only\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"HomeCatalogo.jsp\"><img class=\"logo\" src=\"images/logoHM.png\"></a>                    \n");
      out.write("                </div>\n");
      out.write("                <div id=\"navbar\" class=\"navbar-collapse collapse\" style=\"float: right\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li>\n");
      out.write("                            <form action=\"ControllerCerrarSesion\" method=\"post\">\n");
      out.write("                                <button type=\"submit\" class=\"btn-IS\" name=\"login\">CERRAR SESION</button>\n");
      out.write("                            </form>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div id=\"menu-categoria\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <form action=\"HomeCatalogo.jsp\" method=\"post\">\n");
      out.write("                    <a class=\"text-menu\" href='Controlador?menu=HomeAlmacen&accion=Listar'>LIBROS</a>\n");
      out.write("                    <a class=\"text-menu\" href='Controlador?menu=HomeCategoria&accion=Listar'>CATEGORIAS</a>\n");
      out.write("                    <a class=\"text-menu\" href='Controlador?menu=HomeEditorial&accion=Listar'>PROVEEDORES</a>\n");
      out.write("                   \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"col-md-12\" id=\"FondoListaCategoria\">\n");
      out.write("                <div class=\"d-flex\">\n");
      out.write("                    <div class=\"col-sm-4\">\n");
      out.write("                        <h2>Registro</h2> \n");
      out.write("                        <br>\n");
      out.write("                        <div class=\"form-boby\">\n");
      out.write("                            <form action=\"Controlador?menu=HomeCategoria\" method=\"POST\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label style=\"text-align: left\">Categoria</label>\n");
      out.write("                                    <input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${categoria.getNomcat()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"txtnombre\" class=\"form-control\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Descripcion</label>\n");
      out.write("                                    <input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${categoria.getDescat()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"txtdescripcion\" class=\"form-control\">\n");
      out.write("                                </div> \n");
      out.write("\n");
      out.write("                                <input type=\"submit\" name=\"accion\" value=\"Agregar\" class=\"btn btn-primary\">\n");
      out.write("                                <input type=\"submit\" name=\"accion\" value=\"Actualizar\" class=\"btn btn-warning\">\n");
      out.write("                            </form>  \n");
      out.write("                        </div>\n");
      out.write("                    </div> \n");
      out.write("                    <div class=\"col-lg-8\"> \n");
      out.write("                        <h2>Lista</h2>\n");
      out.write("                        <br>\n");
      out.write("                        <table class=\"table table-striped\" id=\"centrar\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>ID</th>\n");
      out.write("                                    <th>Categoria</th>\n");
      out.write("                                    <th>Descripcion</th>\n");
      out.write("                                    <th>Acciones</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div> \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
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
      out.write("    </body>\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\" integrity=\"sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("ca");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${categorias}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                    <tr>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ca.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ca.getNomcat()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ca.getDescat()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                        <td>\n");
          out.write("                                            <a class=\"btn btn-warning\" href=\"Controlador?menu=HomeCategoria&accion=Editar&id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ca.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Editar</a>\n");
          out.write("                                            <a class=\"btn btn-danger\" href=\"Controlador?menu=HomeCategoria&accion=Delete&id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ca.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Eliminar</a>\n");
          out.write("                                        </td>\n");
          out.write("                                    </tr>\n");
          out.write("                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
