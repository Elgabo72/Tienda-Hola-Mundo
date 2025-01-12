/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ADMIN
 */
public class Cargo {
    int id_cargo;
    String nombre_cargo;
    String desc_cargo;
    double sueldo_cargo;

    public Cargo() {
    }

    public Cargo(int id_cargo, String nombre_cargo, String desc_cargo, double sueldo_cargo) {
        this.id_cargo = id_cargo;
        this.nombre_cargo = nombre_cargo;
        this.desc_cargo = desc_cargo;
        this.sueldo_cargo = sueldo_cargo;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }

    public String getDesc_cargo() {
        return desc_cargo;
    }

    public void setDesc_cargo(String desc_cargo) {
        this.desc_cargo = desc_cargo;
    }

    public double getSueldo_cargo() {
        return sueldo_cargo;
    }

    public void setSueldo_cargo(double sueldo_cargo) {
        this.sueldo_cargo = sueldo_cargo;
    }
    
    
    
}
