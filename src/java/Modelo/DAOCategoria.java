
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOCategoria {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps ;
    ResultSet rs;
    
    int r;
    
    
    
    
    

    public List listar(){
        String sql = "select * from categoria";
        List<Categoria> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria ca = new Categoria();
                ca.setId(rs.getInt(1));
                ca.setNomcat(rs.getString(2));
                ca.setDescat(rs.getString(3));
                lista.add(ca);
      }
        } catch (Exception e) {
        }
        return lista;
    }
    
    
   public int agregarCat (Categoria ca){
        String sql="insert into categoria (nombre_categoria,descripcion_categoria) values (?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ca.getNomcat());
            ps.setString(2, ca.getDescat());
            ps.executeUpdate();
       } catch (Exception e) {
        }
        return r;
    }
   
   public Categoria listarId(int id) {
        Categoria cat = new Categoria();
        String sql = "select * from categoria where id_categoria=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cat.setNomcat(rs.getString(2));
                cat.setDescat(rs.getString(3));
            }
        } catch (Exception e) {
        }
        return cat;
    }
   
   
   
   
    public int actualizar(Categoria ca){
    String sql="update categoria set nombre_categoria=?,descripcion_categoria=? where id_categoria=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ca.getNomcat());
            ps.setString(2, ca.getDescat());
            ps.setInt(3, ca.getId());
            ps.executeUpdate();
       } catch (Exception e) {
        }
        return r;
    }
    
    
    public void Delite(int id){
         String sql = "delete from categoria where id_categoria=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    

}