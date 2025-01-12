/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Empleado {
    int id_empleado;
    String nombre_empleado;
    String apellidos_empleado;
    String dni_empleado;
    Date fe_nacimiento_empleado;
    String direccion_empleado;
    String correo_empleado;
    String celular_empleado;
    String ref_telefono_empleado;
    Date fe_ingreso_empleado;
    int est_empleado;
    String Id_cargo;

    public Empleado() {
    }

    public Empleado(int id_empleado, String nombre_empleado, String apellidos_empleado, String dni_empleado, Date fe_nacimiento_empleado, String direccion_empleado, String correo_empleado, String celular_empleado, String ref_telefono_empleado, Date fe_ingreso_empleado, int est_empleado, String Id_cargo) {
        this.id_empleado = id_empleado;
        this.nombre_empleado = nombre_empleado;
        this.apellidos_empleado = apellidos_empleado;
        this.dni_empleado = dni_empleado;
        this.fe_nacimiento_empleado = fe_nacimiento_empleado;
        this.direccion_empleado = direccion_empleado;
        this.correo_empleado = correo_empleado;
        this.celular_empleado = celular_empleado;
        this.ref_telefono_empleado = ref_telefono_empleado;
        this.fe_ingreso_empleado = fe_ingreso_empleado;
        this.est_empleado = est_empleado;
        this.Id_cargo = Id_cargo;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellidos_empleado() {
        return apellidos_empleado;
    }

    public void setApellidos_empleado(String apellidos_empleado) {
        this.apellidos_empleado = apellidos_empleado;
    }

    public String getDni_empleado() {
        return dni_empleado;
    }

    public void setDni_empleado(String dni_empleado) {
        this.dni_empleado = dni_empleado;
    }

    public Date getFe_nacimiento_empleado() {
        return fe_nacimiento_empleado;
    }

    public void setFe_nacimiento_empleado(Date fe_nacimiento_empleado) {
        this.fe_nacimiento_empleado = fe_nacimiento_empleado;
    }

    public String getDireccion_empleado() {
        return direccion_empleado;
    }

    public void setDireccion_empleado(String direccion_empleado) {
        this.direccion_empleado = direccion_empleado;
    }

    public String getCorreo_empleado() {
        return correo_empleado;
    }

    public void setCorreo_empleado(String correo_empleado) {
        this.correo_empleado = correo_empleado;
    }

    public String getCelular_empleado() {
        return celular_empleado;
    }

    public void setCelular_empleado(String celular_empleado) {
        this.celular_empleado = celular_empleado;
    }

    public String getRef_telefono_empleado() {
        return ref_telefono_empleado;
    }

    public void setRef_telefono_empleado(String ref_telefono_empleado) {
        this.ref_telefono_empleado = ref_telefono_empleado;
    }

    public Date getFe_ingreso_empleado() {
        return fe_ingreso_empleado;
    }

    public void setFe_ingreso_empleado(Date fe_ingreso_empleado) {
        this.fe_ingreso_empleado = fe_ingreso_empleado;
    }

    public int getEst_empleado() {
        return est_empleado;
    }

    public void setEst_empleado(int est_empleado) {
        this.est_empleado = est_empleado;
    }

    public String getId_cargo() {
        return Id_cargo;
    }

    public void setId_cargo(String Id_cargo) {
        this.Id_cargo = Id_cargo;
    }
    
    
}
