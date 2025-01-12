
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOEditorial {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps ;
    ResultSet rs;
    
    int r;
    int rr;

public List listar(){
        String sql = "select * from editorial";
        List<Editorial> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Editorial ed = new Editorial();
                ed.setId(rs.getInt(1));
                ed.setNomedi(rs.getString(2));
                ed.setDiredi(rs.getString(3));
                ed.setConedi(rs.getString(4));
                ed.setTeledi(rs.getString(5));
                ed.setCoredi(rs.getString(6));
                lista.add(ed);
      }
        } catch (Exception e) {
        }
        return lista;
    }

public int agregarEdt (Editorial ed){
        String sql="insert into editorial (nombre_editorial, direccion_editorial, contacto_editorial,"
                + " telefono_editorial, correo_editorial) values (?,?,?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ed.getNomedi());
            ps.setString(2, ed.getDiredi());
            ps.setString(3, ed.getConedi());
            ps.setString(4, ed.getTeledi());
            ps.setString(5, ed.getCoredi());
            ps.executeUpdate();
       } catch (Exception e) {
        }
        return rr;
}

public Editorial listarId(int id) {
        Editorial edi = new Editorial();
        String sql = "select * from editorial where id_editorial=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                edi.setNomedi(rs.getString(2));
                edi.setDiredi(rs.getString(3));
                edi.setConedi(rs.getString(4));
                edi.setTeledi(rs.getString(5));
                edi.setCoredi(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return edi;
    }

public int actualizar(Editorial ed){
    String sql="update editorial set nombre_editorial=?, direccion_editorial=?, contacto_editorial=?, "
            + "telefono_editorial=?, correo_editorial=? where id_editorial=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ed.getNomedi());
            ps.setString(2, ed.getDiredi());
            ps.setString(3, ed.getConedi());
            ps.setString(4, ed.getTeledi());
            ps.setString(5, ed.getCoredi());
            ps.setInt(6, ed.getId());
            ps.executeUpdate();
       } catch (Exception e) {
        }
        return rr;
}

public void Delite(int id){
         String sql = "delete from editorial where id_editorial=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
}
}