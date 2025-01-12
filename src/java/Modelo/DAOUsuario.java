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
public class DAOUsuario {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    int r;

    public int AgregarUsuario(Usuario usu) {
        String sql = "insert into usuario ( usuario,clave,f_creacion_user,estado_user,id_empleados_user) values (?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, usu.getUsuario());
            ps.setString(2, usu.getClave());
            ps.setDate(3, usu.getF_creacion_user());
            ps.setInt(4, usu.getEstado_user());
            ps.setString(5, usu.getId_empleados_user());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public List listar() {
        String sql = "select u.id_usuario,u.usuario,u.clave,u.f_creacion_user,u.estado_user,e.nombre_empleado "
                + "from usuario u inner join empleado e on u.id_empleados_user=e.id_empleado";
        List<Usuario> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId_usuario(rs.getInt(1));
                usu.setUsuario(rs.getString(2));
                usu.setClave(rs.getString(3));
                usu.setF_creacion_user(rs.getDate(4));
                usu.setEstado_user(rs.getInt(5));
                usu.setId_empleados_user(rs.getString(6));
                lista.add(usu);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public Usuario listarid(int id) {
        Usuario usu = new Usuario();
        String sql = "select * from usuario where id_usuario= " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                usu.setUsuario(rs.getString(2));
                usu.setClave(rs.getString(3));
                usu.setF_creacion_user(rs.getDate(4));
                usu.setEstado_user(rs.getInt(5));
                usu.setId_empleados_user(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return usu;
    }

    public int actualizar(Usuario usu) {
        String sql = "update usuario set usuario=?,clave=?,f_creacion_user=?,estado_user=?,id_empleados_user=?"
                + "where id_usuario=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getUsuario());
            ps.setString(2, usu.getClave());
            ps.setDate(3, usu.getF_creacion_user());
            ps.setInt(4, usu.getEstado_user());
            ps.setString(5, usu.getId_empleados_user());
            ps.setInt(6, usu.getId_usuario());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public void Eliminar(int id) {
        String sql = "delete from usuario where id_usuario=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
