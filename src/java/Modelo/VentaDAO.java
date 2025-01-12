/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class VentaDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    int r;

    public int GenerarVenta(Venta venta) {
        
        int idventa;
        String sql ="insert into venta(fecha_venta,id_cliente_venta,monto,estado_venta)"
                    + "values(?,?,?,?)";
        try {
            
            
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
           
            ps.setString(1, venta.getFecha());
            ps.setInt(2, venta.getCliente().getId());
            
            ps.setDouble(3, venta.getMonto());
            ps.setInt(4, venta.getEstado());
            r=ps.executeUpdate();
            
            sql = "Select @@IDENTITY id_venta";
            rs = ps.executeQuery(sql);
            rs.next();
            idventa=rs.getInt("id_venta");
            rs.close();
            
            for (Carrito detalle : venta.getDetallecompras()) {
                sql ="insert into detalle_venta(id_venta,id_libro,cantidad,total_venta)values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1,idventa);
                ps.setInt(2, detalle.getId_libro());
                ps.setInt(3, detalle.getCantidad());
                ps.setDouble(4, detalle.getPrecio());
                r=ps.executeUpdate();
            }
            
        } catch (Exception e) {
        }
        return r;
    }

}
