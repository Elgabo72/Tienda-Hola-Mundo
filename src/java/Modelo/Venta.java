/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Venta {
    
    int id_venta;
    String fecha;
    regcompra cliente;
    double monto;
    int estado;
    
    List<Carrito>detallecompras;

    public Venta() {
    }

    public Venta( String fecha, regcompra cliente,  double monto, int estado, List<Carrito> detallecompras) {
        
        this.fecha = fecha;
        this.cliente = cliente;
        
        this.monto = monto;
        this.estado = estado;
        this.detallecompras = detallecompras;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public regcompra getCliente() {
        return cliente;
    }

    public void setCliente(regcompra cliente) {
        this.cliente = cliente;
    }

    

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<Carrito> getDetallecompras() {
        return detallecompras;
    }

    public void setDetallecompras(List<Carrito> detallecompras) {
        this.detallecompras = detallecompras;
    }

   

   
    
}
