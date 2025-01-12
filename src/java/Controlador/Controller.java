/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Carrito;
import Modelo.DAOLibros;
import Modelo.Libros;
//import Modelo.DAOEditoriales;
import Modelo.Editoriales;
import Modelo.Empleado;
import Modelo.Fecha;
import Modelo.Venta;
import Modelo.VentaDAO;
import Modelo.regcompra;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
@MultipartConfig
public class Controller extends HttpServlet {

    DAOLibros ldao = new DAOLibros();

    Libros l = new Libros();
    Editoriales e = new Editoriales();
    List<Libros> listarlibro = new ArrayList<>();
    List<Carrito> listacarrito = new ArrayList<>();
    int item;
    double total_pagar = 0.0;
    int cantidad = 1;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {

                case "AgregarCarrito":
                    Agregarcarrito(request, response);
                    break;

                case "Delete":
                    Delete(request, response);
                    break;
                case "ActualizarCantidad":
                    ActualizarCantidad(request, response);

                    break;
                case "Carrito":
                    total_pagar = 0.0;
                    request.setAttribute("carrito", listacarrito);
                    for (int i = 0; i < listacarrito.size(); i++) {
                        total_pagar = total_pagar + listacarrito.get(i).getSubtotal();

                    }
                    request.setAttribute("totalPagar", total_pagar);
                    request.getRequestDispatcher("Carrito.jsp").forward(request, response);
                    break;
                case "GenerarVenta":
                    Generarventa(request, response);
                    break;
                case "ReporteVentas":
                    request.getRequestDispatcher("ReporteVentas.jsp").forward(request, response);
                    break;

                default:
                    request.getRequestDispatcher("HomeCatalogo.jsp").forward(request, response);
            }
        } catch (Exception e) {
        }
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
        doGet(request, response);

    }

    public void Agregarcarrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pos = 0;
        cantidad = 1;
        int idp = Integer.parseInt(request.getParameter("id"));
        l = ldao.listarId(idp);
        if (listacarrito.size() > 0) {
            for (int i = 0; i < listacarrito.size(); i++) {
                if (idp == listacarrito.get(i).getId_libro()) {
                    pos = i;
                }
            }
            if (idp == listacarrito.get(pos).getId_libro()) {
                cantidad = listacarrito.get(pos).getCantidad() + cantidad;
                double subtotal = listacarrito.get(pos).getPrecio() * cantidad;
                listacarrito.get(pos).setCantidad(cantidad);
                listacarrito.get(pos).setSubtotal(subtotal);
            } else {
                item = item + 1;
                Carrito car = new Carrito();
                car.setItem(item);
                car.setId_libro(l.getId_libro());
                car.setNombre(l.getTitulo_libro());
                car.setPrecio(l.getPrecio_libro());
                car.setDescripcion(l.getSinopsis_libros());
                car.setCantidad(cantidad);
                car.setSubtotal(cantidad * l.getPrecio_libro());
                listacarrito.add(car);
            }

        } else {
            item = item + 1;
            Carrito car = new Carrito();
            car.setItem(item);
            car.setId_libro(l.getId_libro());
            car.setNombre(l.getTitulo_libro());
            car.setPrecio(l.getPrecio_libro());
            car.setDescripcion(l.getSinopsis_libros());
            car.setCantidad(cantidad);
            car.setSubtotal(cantidad * l.getPrecio_libro());
            listacarrito.add(car);
        }

        request.setAttribute("contador", listacarrito.size());
        request.getRequestDispatcher("Controller?action=home").forward(request, response);

    }

    public void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idlibro = Integer.parseInt(request.getParameter("idp"));
        for (int i = 0; i < listacarrito.size(); i++) {
            if (listacarrito.get(i).getId_libro() == idlibro) {
                listacarrito.remove(i);
            }
        }
    }

    public void ActualizarCantidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idpro = Integer.parseInt(request.getParameter("idp"));
        int cant = Integer.parseInt(request.getParameter("Cantidad"));
        for (int i = 0; i < listacarrito.size(); i++) {
            if (listacarrito.get(i).getId_libro() == idpro) {
                listacarrito.get(i).setCantidad(cant);
                double st = listacarrito.get(i).getPrecio() * cant;
                listacarrito.get(i).setSubtotal(st);
            }
        }
    }

    public void Generarventa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        regcompra cliente = new regcompra();
        cliente.setId(25);
        VentaDAO daov = new VentaDAO();
        Venta venta = new Venta(Fecha.FechaBD(), cliente, total_pagar, 1, listacarrito);
        int res = daov.GenerarVenta(venta);
        if (res != 0 && total_pagar > 0) {
            request.getRequestDispatcher("Comprobante.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("HomeCatalogo.jsp").forward(request, response);
        }
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
