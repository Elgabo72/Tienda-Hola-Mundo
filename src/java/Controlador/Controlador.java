/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cargo;
import Modelo.Categoria;
import Modelo.DAOCategoria;
import Modelo.DAOEditorial;
import Modelo.DAOEmpleado;
import Modelo.DAOLibros;
import Modelo.DAOUsuario;
import Modelo.DAOcargo;
import Modelo.Editorial;
import Modelo.Empleado;
import Modelo.Libros;
import Modelo.Usuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author CRISTIAN-PC
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
@MultipartConfig
public class Controlador extends HttpServlet {

    Categoria ca = new Categoria();
    DAOCategoria cdao = new DAOCategoria();
    int idc;

    Libros li = new Libros();
    DAOLibros daoli = new DAOLibros();
    int idl;

    Editorial ed = new Editorial();
    DAOEditorial edao = new DAOEditorial();
    int ide;

    Empleado em = new Empleado();
    DAOEmpleado daoe = new DAOEmpleado();
    int idem;

    Usuario usu = new Usuario();
    DAOUsuario daou = new DAOUsuario();
    int idu;

    Cargo car = new Cargo();
    DAOcargo daoc = new DAOcargo();
    int idca;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("HomeAlmacen")) {
            switch (accion) {
                case "Listar":
                    List lista = daoli.listar();
                    request.setAttribute("libros", lista);
                    break;
                case "Agregar":
                    //int id = Integer.parseInt(request.getParameter("txtcodigo"));
                    String titulo = request.getParameter("txttitulo");
                    String autor = request.getParameter("txtautor");
                    Date fechapub = Date.valueOf(request.getParameter("txtfechapub"));
                    int numpag = Integer.parseInt(request.getParameter("txtnumpag"));
                    double precio = Double.parseDouble(request.getParameter("txtprecio"));
                    String sinopsis = request.getParameter("txtsinopsis");
                    Part part = request.getPart("fileImagen");
                    InputStream inputstream = part.getInputStream();
                    Date fechared = Date.valueOf(request.getParameter("txtfechareg"));
                    int estado = Integer.parseInt(request.getParameter("txtestado"));
                    String editorial = request.getParameter("txteditorial");
                    String categoria = request.getParameter("txtcategoria");
                    int stock = Integer.parseInt(request.getParameter("txtstock"));

                    li.setPortada_libro(inputstream);
                    //li.setId_libro(id);
                    li.setTitulo_libro(titulo);
                    li.setAutor_libro(autor);
                    li.setF_publicacion_libro(fechapub);
                    li.setNum_paginas_libro(numpag);
                    li.setPrecio_libro(precio);
                    //li.setPrecio_libro(precio);
                    li.setSinopsis_libros(sinopsis);
                    li.setF_registro_libro(fechared);
                    li.setEstado_libro(estado);
                    li.setId_editoriales_lib(editorial);
                    li.setId_categorias_lib(categoria);
                    li.setStock(stock);

                    daoli.AgregarLibros(li);
                    request.getRequestDispatcher("Controlador?menu=HomeAlmacen&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idl = Integer.parseInt(request.getParameter("id"));
                    Libros l = daoli.listarId(idl);
                    request.setAttribute("libro", l);
                    request.getRequestDispatcher("Controlador?menu=HomeAlmacen&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String titulo2 = request.getParameter("txttitulo");
                    String autor2 = request.getParameter("txtautor");
                    Date fechapub2 = Date.valueOf(request.getParameter("txtfechapub"));
                    int numpag2 = Integer.parseInt(request.getParameter("txtnumpag"));
                    double precio2 = Double.parseDouble(request.getParameter("txtprecio"));
                    String sinopsis2 = request.getParameter("txtsinopsis");
                    Part part2 = request.getPart("fileImagen");
                    InputStream inputstream2 = part2.getInputStream();
                    Date fechared2 = Date.valueOf(request.getParameter("txtfechareg"));
                    int estado2 = Integer.parseInt(request.getParameter("txtestado"));
                    String editorial2 = request.getParameter("txteditorial");
                    String categoria2 = request.getParameter("txtcategoria");
                    int stock2 = Integer.parseInt(request.getParameter("txtstock"));

                    li.setTitulo_libro(titulo2);
                    li.setAutor_libro(autor2);
                    li.setF_publicacion_libro(fechapub2);
                    li.setNum_paginas_libro(numpag2);
                    li.setPrecio_libro(precio2);
                    li.setSinopsis_libros(sinopsis2);
                    li.setPortada_libro(inputstream2);
                    li.setF_registro_libro(fechared2);
                    li.setEstado_libro(estado2);
                    li.setId_editoriales_lib(editorial2);
                    li.setId_categorias_lib(categoria2);
                    li.setStock(stock2);
                    li.setId_libro(idl);
                    daoli.Actualizar(li);
                    request.getRequestDispatcher("Controlador?menu=HomeAlmacen&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idl = Integer.parseInt(request.getParameter("id"));
                    daoli.Eliminar(idl);
                    request.getRequestDispatcher("Controlador?menu=HomeAlmacen&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("HomeAlmacen.jsp").forward(request, response);
        }

        if (menu.equals("HomeCategoria")) {
            switch (accion) {
                case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("categorias", lista);
                    break;

                case "Agregar":
                    String nomcat = request.getParameter("txtnombre");
                    String descat = request.getParameter("txtdescripcion");
                    ca.setNomcat(nomcat);
                    ca.setDescat(descat);
                    cdao.agregarCat(ca);
                    request.getRequestDispatcher("Controlador?menu=HomeCategoria&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    Categoria c = cdao.listarId(idc);
                    request.setAttribute("categoria", c);
                    request.getRequestDispatcher("Controlador?menu=HomeCategoria&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String nomcatt = request.getParameter("txtnombre");
                    String descatt = request.getParameter("txtdescripcion");
                    ca.setNomcat(nomcatt);
                    ca.setDescat(descatt);
                    ca.setId(idc);
                    cdao.actualizar(ca);
                    request.getRequestDispatcher("Controlador?menu=HomeCategoria&accion=Listar").forward(request, response);
                    break;

                case "Delete":
                    idc = Integer.parseInt(request.getParameter("id"));
                    cdao.Delite(idc);
                    request.getRequestDispatcher("Controlador?menu=HomeCategoria&accion=Listar").forward(request, response);
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("HomeCategoria.jsp").forward(request, response);
        }

        if (menu.equals("HomeEditorial")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("editoriales", lista);
                    break;

                case "Agregar":
                    String nomedi = request.getParameter("txtnombre");
                    String diredi = request.getParameter("txtdireccion");
                    String conedi = request.getParameter("txtcontacto");
                    String teledi = request.getParameter("txttelefono");
                    String coredi = request.getParameter("txtcorreo");
                    ed.setNomedi(nomedi);
                    ed.setDiredi(diredi);
                    ed.setConedi(conedi);
                    ed.setTeledi(teledi);
                    ed.setCoredi(coredi);
                    edao.agregarEdt(ed);
                    request.getRequestDispatcher("Controlador?menu=HomeEditorial&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Editorial e = edao.listarId(ide);
                    request.setAttribute("editorial", e);
                    request.getRequestDispatcher("Controlador?menu=HomeEditorial&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String nomedii = request.getParameter("txtnombre");
                    String diredii = request.getParameter("txtdireccion");
                    String conedii = request.getParameter("txtcontacto");
                    String teledii = request.getParameter("txttelefono");
                    String coredii = request.getParameter("txtcorreo");
                    ed.setNomedi(nomedii);
                    ed.setDiredi(diredii);
                    ed.setConedi(conedii);
                    ed.setTeledi(teledii);
                    ed.setCoredi(coredii);
                    ed.setId(ide);
                    edao.actualizar(ed);
                    request.getRequestDispatcher("Controlador?menu=HomeEditorial&accion=Listar").forward(request, response);
                    break;

                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.Delite(ide);
                    request.getRequestDispatcher("Controlador?menu=HomeEditorial&accion=Listar").forward(request, response);
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("HomeEditorial.jsp").forward(request, response);
        }
        if (menu.equals("HomeEmpleado")) {
            switch (accion) {
                case "Listar":
                    List lista = daoe.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtnombre");
                    String apellidos = request.getParameter("txtapellidos");
                    String dni = request.getParameter("txtdni");
                    Date fechanac = Date.valueOf(request.getParameter("txtfechanac"));
                    String direccion = request.getParameter("txtdireccion");
                    String correo = request.getParameter("txtcorreo");
                    String celular = request.getParameter("txtcelular");
                    String tel_ref = request.getParameter("txttelref");
                    Date fecha_ing = Date.valueOf(request.getParameter("txtfechaing"));
                    int estado = Integer.parseInt(request.getParameter("txtestado"));
                    String cargo = request.getParameter("txtcargo");
                    em.setNombre_empleado(nombre);
                    em.setApellidos_empleado(apellidos);
                    em.setDni_empleado(dni);
                    em.setFe_nacimiento_empleado(fechanac);
                    em.setDireccion_empleado(direccion);
                    em.setCorreo_empleado(correo);
                    em.setCelular_empleado(celular);
                    em.setRef_telefono_empleado(tel_ref);
                    em.setFe_ingreso_empleado(fecha_ing);
                    em.setEst_empleado(estado);
                    em.setId_cargo(cargo);

                    daoe.AgregarEmpleado(em);
                    request.getRequestDispatcher("Controlador?menu=HomeEmpleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idem = Integer.parseInt(request.getParameter("id"));
                    Empleado emp = daoe.listarid(idem);
                    request.setAttribute("empleado", emp);
                    request.getRequestDispatcher("Controlador?menu=HomeEmpleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombre2 = request.getParameter("txtnombre");
                    String apellidos2 = request.getParameter("txtapellidos");
                    String dni2 = request.getParameter("txtdni");
                    Date fecha_nac2 = Date.valueOf(request.getParameter("txtfechanac"));
                    String direccion2 = request.getParameter("txtdireccion");
                    String correo2 = request.getParameter("txtcorreo");
                    String celular2 = request.getParameter("txtcelular");
                    String tel_ref2 = request.getParameter("txttelref");
                    Date fecha_ing2 = Date.valueOf(request.getParameter("txtfechaing"));
                    int estado2 = Integer.parseInt(request.getParameter("txtestado"));
                    String cargo2 = request.getParameter("txtcargo");
                    em.setNombre_empleado(nombre2);
                    em.setApellidos_empleado(apellidos2);
                    em.setDni_empleado(dni2);
                    em.setFe_nacimiento_empleado(fecha_nac2);
                    em.setDireccion_empleado(direccion2);
                    em.setCorreo_empleado(correo2);
                    em.setCelular_empleado(celular2);
                    em.setRef_telefono_empleado(tel_ref2);
                    em.setFe_ingreso_empleado(fecha_ing2);
                    em.setEst_empleado(estado2);
                    em.setId_cargo(cargo2);
                    em.setId_empleado(idem);
                    daoe.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=HomeEmpleado&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idem = Integer.parseInt(request.getParameter("id"));
                    daoe.Eliminar(idem);
                    request.getRequestDispatcher("Controlador?menu=HomeEmpleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("HomeEmpleado.jsp").forward(request, response);
        }
        if (menu.equals("HomeUsuarios")) {
            switch (accion) {
                case "Listar":
                    List lista = daou.listar();
                    request.setAttribute("usuarios", lista);
                    break;
                case "Agregar":
                    String usuario = request.getParameter("txtusuario");
                    String clave = request.getParameter("txtclave");
                    Date fecha_cre = Date.valueOf(request.getParameter("txtfechacre"));
                    int estado = Integer.parseInt(request.getParameter("txtestado"));
                    String empleado = request.getParameter("txtempleado");
                    usu.setUsuario(usuario);
                    usu.setClave(clave);
                    usu.setF_creacion_user(fecha_cre);
                    usu.setEstado_user(estado);
                    usu.setId_empleados_user(empleado);
                    daou.AgregarUsuario(usu);
                    request.getRequestDispatcher("Controlador?menu=HomeUsuarios&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idu = Integer.parseInt(request.getParameter("id"));
                    Usuario u = daou.listarid(idu);
                    request.setAttribute("usuario", u);
                    request.getRequestDispatcher("Controlador?menu=HomeUsuarios&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String usuario2 = request.getParameter("txtusuario");
                    String clave2 = request.getParameter("txtclave");
                    Date fecha_cre2 = Date.valueOf(request.getParameter("txtfechacre"));
                    int estado2 = Integer.parseInt(request.getParameter("txtestado"));
                    String empleado2 = request.getParameter("txtempleado");
                    usu.setUsuario(usuario2);
                    usu.setClave(clave2);
                    usu.setF_creacion_user(fecha_cre2);
                    usu.setEstado_user(estado2);
                    usu.setId_empleados_user(empleado2);
                    usu.setId_usuario(idu);
                    daou.actualizar(usu);
                    request.getRequestDispatcher("Controlador?menu=HomeUsuarios&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idu = Integer.parseInt(request.getParameter("id"));
                    daou.Eliminar(idu);
                    request.getRequestDispatcher("Controlador?menu=HomeUsuarios&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("HomeUsuarios.jsp").forward(request, response);
        }
        if (menu.equals("HomeCargos")) {
            switch (accion) {
                case "Listar":
                    List lista = daoc.listar();
                    request.setAttribute("cargos", lista);
                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtnombre");
                    String descripcion = request.getParameter("txtdescripcion");
                    Double sueldo = Double.parseDouble(request.getParameter("txtsueldo"));
                    car.setNombre_cargo(nombre);
                    car.setDesc_cargo(descripcion);
                    car.setSueldo_cargo(sueldo);
                    daoc.Agregar(car);
                    request.getRequestDispatcher("Controlador?menu=HomeCargos&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idca = Integer.parseInt(request.getParameter("id"));
                    Cargo c = daoc.listarid(idca);
                    request.setAttribute("cargo", c);
                    request.getRequestDispatcher("Controlador?menu=HomeCargos&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombre2 = request.getParameter("txtnombre");
                    String descripcion2 = request.getParameter("txtdescripcion");
                    Double sueldo2 = Double.parseDouble(request.getParameter("txtsueldo"));
                    car.setNombre_cargo(nombre2);
                    car.setDesc_cargo(descripcion2);
                    car.setSueldo_cargo(sueldo2);
                    car.setId_cargo(idca);
                    daoc.Actualizar(car);
                    request.getRequestDispatcher("Controlador?menu=HomeCargos&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idca = Integer.parseInt(request.getParameter("id"));
                    daoc.Eliminar(idca);
                    request.getRequestDispatcher("Controlador?menu=HomeCargos&accion=Listar").forward(request, response);
                    
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("HomeCargos.jsp").forward(request, response);
        }
       

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
