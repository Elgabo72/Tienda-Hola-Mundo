/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DAOEmpleado {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    int r;

    public int AgregarEmpleado(Empleado em) {
        String sql = "insert into empleado (nombre_empleado,apellidos_empleado,dni_empleado,"
                + "f_nacimiento_empleado,direccion_empleado,correo_empleado,celular_empleado,referencia_telf_empleado,"
                + "f_ingreso_empleado,estado_empleado,id_cargos) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getNombre_empleado());
            ps.setString(2, em.getApellidos_empleado());
            ps.setString(3, em.getDni_empleado());
            ps.setDate(4, em.getFe_nacimiento_empleado());
            ps.setString(5, em.getDireccion_empleado());
            ps.setString(6, em.getCorreo_empleado());
            ps.setString(7, em.getCelular_empleado());
            ps.setString(8, em.getRef_telefono_empleado());
            ps.setDate(9, em.getFe_ingreso_empleado());
            ps.setInt(10, em.getEst_empleado());
            ps.setString(11, em.getId_cargo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public List listar() {
        String sql = "select*from empleado";
        List<Empleado> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId_empleado(rs.getInt(1));
                em.setNombre_empleado(rs.getString(2));
                em.setApellidos_empleado(rs.getString(3));
                em.setDni_empleado(rs.getString(4));
                em.setFe_nacimiento_empleado(rs.getDate(5));
                em.setDireccion_empleado(rs.getString(6));
                em.setCorreo_empleado(rs.getString(7));
                em.setCelular_empleado(rs.getString(8));
                em.setRef_telefono_empleado(rs.getString(9));
                em.setFe_ingreso_empleado(rs.getDate(10));
                em.setEst_empleado(rs.getInt(11));
                em.setId_cargo(rs.getString(12));
                lista.add(em);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public Empleado listarid(int id) {
        Empleado emp = new Empleado();
        String sql = "select * from empleado where id_empleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setNombre_empleado(rs.getString(2));
                emp.setApellidos_empleado(rs.getString(3));
                emp.setDni_empleado(rs.getString(4));
                emp.setFe_nacimiento_empleado(rs.getDate(5));
                emp.setDireccion_empleado(rs.getString(6));
                emp.setCorreo_empleado(rs.getString(7));
                emp.setCelular_empleado(rs.getString(8));
                emp.setRef_telefono_empleado(rs.getString(9));
                emp.setFe_ingreso_empleado(rs.getDate(10));
                emp.setEst_empleado(rs.getInt(11));
                emp.setId_cargo(rs.getString(12));
            }
        } catch (Exception e) {
        }
        return emp;
    }

    public int actualizar(Empleado emp) {
        String sql = "update empleado set nombre_empleado=?,apellidos_empleado=?,dni_empleado=?,f_nacimiento_empleado=?,"
                + "direccion_empleado=?,correo_empleado=?,celular_empleado=?,referencia_telf_empleado=?,f_ingreso_empleado=?,"
                + "estado_empleado=?,id_cargos=? where id_empleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombre_empleado());
            ps.setString(2, emp.getApellidos_empleado());
            ps.setString(3, emp.getDni_empleado());
            ps.setDate(4, emp.getFe_nacimiento_empleado());
            ps.setString(5, emp.getDireccion_empleado());
            ps.setString(6, emp.getCorreo_empleado());
            ps.setString(7, emp.getCelular_empleado());
            ps.setString(8, emp.getRef_telefono_empleado());
            ps.setDate(9, emp.getFe_ingreso_empleado());
            ps.setInt(10, emp.getEst_empleado());
            ps.setString(11, emp.getId_cargo());
            ps.setInt(12, emp.getId_empleado());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public void Eliminar(int id) {
        String sql = "delete from empleado where id_empleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
