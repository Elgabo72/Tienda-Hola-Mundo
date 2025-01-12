package Controlador;

import Modelo.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

      String user = request.getParameter("username");
        String pass = request.getParameter("userpass");

        try {
            Conexion cn = new Conexion();
            Connection con;
            PreparedStatement ps;
            PreparedStatement ps2;
            ResultSet rs;
            ResultSet rs2;
            String sql = "SELECT U.usuario, U.clave, C.id_cargo \n"
                    + "FROM usuario U INNER JOIN empleado E\n"
                    + "ON U.id_empleados_user=E.id_empleado \n"
                    + "INNER JOIN cargo C ON E.id_cargos=C.id_cargo \n"
                    + "where U.usuario='"+user+"' AND U.clave='"+pass+"' AND C.id_cargo=1";
            String sql2 = "SELECT U.usuario, U.clave, C.id_cargo \n"
                    + "FROM usuario U INNER JOIN empleado E\n"
                    + "ON U.id_empleados_user=E.id_empleado \n"
                    + "INNER JOIN cargo C ON E.id_cargos=C.id_cargo \n"
                    + "where U.usuario='"+user+"' AND U.clave='"+pass+"' AND C.id_cargo=2";
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps2 = con.prepareStatement(sql2);
            rs = ps.executeQuery();
            rs2 = ps2.executeQuery();
            if (rs.next()) {

                HttpSession sesionOk = request.getSession();
                sesionOk.setAttribute("username", user);
                RequestDispatcher rd = request.getRequestDispatcher("Controlador?menu=HomeEmpleado&accion=Listar");
                rd.forward(request, response);

            } else if (rs2.next()) {

                HttpSession sesionOk = request.getSession();
                sesionOk.setAttribute("username", user);
                RequestDispatcher rd = request.getRequestDispatcher("Controlador?menu=HomeAlmacen&accion=Listar");
                rd.forward(request, response);
            
            }
            else {
                HttpSession sesionOk = request.getSession();
                sesionOk.invalidate();
                out.print("<div style=\"margin:0px;\" class=\"alert alert-danger alert-dismissable\">\n"
                        + "<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>\n"
                        + "<strong>¡Usuario o Contraseña incorrecta!</strong>\n"
                        + "</div>");
                RequestDispatcher rd = request.getRequestDispatcher("HomeCatalogo.jsp");
                rd.include(request, response);
            }

        } catch (Exception e) {
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
