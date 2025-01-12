/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.registrarcompra;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class DAORegistrarProductos implements usuarioIDAO{
  @Override
    public boolean Registrar(regcompra objreg) {
        Connection con;
        Conexion cn = new Conexion();
        PreparedStatement ps ;
        ResultSet rs;
       Boolean respuesta = false;
       
        String sql="insert into cliente (nombre_cliente,apellido_cliente,dni_cliente,telefono_cliente,correo_cliente,edad_cliente,direccion_cliente) "
                + "values (?,?,?,?,?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
           
            ps.setString(1, objreg.getNombre());
            ps.setString(2, objreg.getApellido());
            ps.setString(3, objreg.getDni());
            ps.setString(4, objreg.getTelefono());
            ps.setString(5, objreg.getCorreo());
            ps.setString(6, objreg.getEdad());
            ps.setString(7, objreg.getDireccion());
            ps.executeUpdate();
            respuesta=ps.getUpdateCount() > 0;
       } catch (Exception e) {
        }
        return respuesta;

               
              
    }
       
    
}
