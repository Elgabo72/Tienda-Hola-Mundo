/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class DAOLibros {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps ;
    ResultSet rs;
    int r;
    
   public List listar(){
       String sql = "SELECT l.id_libro,l.titulo_libro,l.autor_libro,l.f_publicacion_libro,l.num_paginas_libro,l.precio_libro,\n"
                                            + "l.sinopsis_libro,l.portada_libro,l.f_registro_libro,l.estado_libro,e.nombre_editorial,c.nombre_categoria,l.stock FROM libro l \n"
                                            + "INNER JOIN editorial e on l.id_editoriales_lib=e.id_editorial \n"
                                            + "INNER JOIN categoria c on l.id_categorias_lib=c.id_categoria";
       List<Libros> lista = new ArrayList<>();
       try {
           con = cn.Conexion();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Libros lib = new Libros();
               lib.setId_libro(rs.getInt(1));
               lib.setTitulo_libro(rs.getString(2));
               lib.setAutor_libro(rs.getString(3));
               lib.setF_publicacion_libro(rs.getDate(4));
               lib.setNum_paginas_libro(rs.getInt(5));
               lib.setPrecio_libro(rs.getDouble(6));
               lib.setSinopsis_libros(rs.getString(7));
               lib.setPortada_libro(rs.getBinaryStream(8));
               lib.setF_registro_libro(rs.getDate(9));
               lib.setEstado_libro(rs.getInt(10));
               lib.setId_editoriales_lib(rs.getString(11));
               lib.setId_categorias_lib(rs.getString(12));
               lib.setStock(rs.getInt(13));
               lista.add(lib);
           }
       } catch (Exception e) {
       }
       return lista;
   }
    
    public Libros listarId(int id){
        String sql ="select * from libro where id_libro="+id;
        Libros lib = new Libros();
        try {
            con = cn.Conexion();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()) {                
                lib.setId_libro(rs.getInt(1));
                lib.setTitulo_libro(rs.getString(2));
                lib.setAutor_libro(rs.getString(3));
                lib.setF_publicacion_libro(rs.getDate(4));
                lib.setNum_paginas_libro(rs.getInt(5));
                lib.setPrecio_libro(rs.getDouble(6));
                lib.setSinopsis_libros(rs.getString(7));
                lib.setPortada_libro(rs.getBinaryStream(8));
                lib.setF_registro_libro(rs.getDate(9));
                lib.setEstado_libro(rs.getInt(10));
                lib.setId_editoriales_lib(rs.getString(11));
                lib.setId_categorias_lib(rs.getString(12));
                lib.setStock(rs.getInt(13));
                
            }
        } catch (Exception e) {
        }
        return lib;
    }
    
    
    public void listarImg(int idlib, HttpServletResponse response ){
        String sql="select*from libro where id_libro="+idlib;
        InputStream inputstream = null;
        OutputStream outputstream = null;
        BufferedInputStream bufferesinputstream = null;
        BufferedOutputStream bufferedoutputstream = null;
        
        try {
            outputstream = response.getOutputStream();
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                inputstream = rs.getBinaryStream("portada_libro");
            }
            bufferesinputstream = new BufferedInputStream(inputstream);
            bufferedoutputstream = new BufferedOutputStream(outputstream);
            int i=0;
            while ((i=bufferesinputstream.read())!=-1) {
                bufferedoutputstream.write(i);
                
            }
        } catch (Exception e) {
        }
    }
    
   
    
 public int AgregarLibros(Libros lib){
     String sql = "insert into libro (titulo_libro,autor_libro,f_publicacion_libro,num_paginas_libro,"
             + "precio_libro,sinopsis_libro,portada_libro,f_registro_libro,estado_libro,"
             + "id_editoriales_lib,id_categorias_lib,stock) values(?,?,?,?,?,?,?,?,?,?,?,?)";
     try {
         con=cn.Conexion();
         ps=con.prepareStatement(sql);
         //ps.setInt(1, lib.getId_libro());
         ps.setString(1, lib.getTitulo_libro());
         ps.setString(2, lib.getAutor_libro());
         ps.setDate(3, lib.getF_publicacion_libro());
         ps.setInt(4, lib.getNum_paginas_libro());
         ps.setDouble(5, lib.getPrecio_libro());
         ps.setString(6, lib.getSinopsis_libros());
         ps.setBlob(7, lib.getPortada_libro());
         ps.setDate(8, lib.getF_registro_libro());
         ps.setInt(9, lib.getEstado_libro());
         ps.setString(10, lib.getId_editoriales_lib());
         ps.setString(11, lib.getId_categorias_lib());
         ps.setInt(12, lib.getStock());
         ps.executeUpdate();
     } catch (Exception e) {
     }
     return r;
 }
 
   public int Actualizar(Libros lib){
       String sql ="update libro set titulo_libro=?, autor_libro=?, f_publicacion_libro=?,num_paginas_libro=?,"
               + "precio_libro=?,sinopsis_libro=?,portada_libro=?,f_registro_libro=?,estado_libro=?,"
               + "id_editoriales_lib=?,id_categorias_lib=?,stock=? where id_libro=?";
       try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, lib.getTitulo_libro());
            ps.setString(2, lib.getAutor_libro());
            ps.setDate(3, lib.getF_publicacion_libro());
            ps.setInt(4, lib.getNum_paginas_libro());
            ps.setDouble(5, lib.getPrecio_libro());
            ps.setString(6, lib.getSinopsis_libros());
            ps.setBinaryStream(7, lib.getPortada_libro());
            ps.setDate(8, lib.getF_registro_libro());
            ps.setInt(9, lib.getEstado_libro());
            ps.setString(10, lib.getId_editoriales_lib());
            ps.setString(11, lib.getId_categorias_lib());
            ps.setInt(12, lib.getStock());
            ps.setInt(13, lib.getId_libro());
            ps.executeUpdate();
       } catch (Exception e) {
       }
       return r;
   }
   
   public void Eliminar(int id){
       String sql ="delete from libro where id_libro="+id;
       try {
           con = cn.Conexion();
           ps = con.prepareStatement(sql);
           ps.executeUpdate();
           
       } catch (Exception e) {
       }
   }
    
}
