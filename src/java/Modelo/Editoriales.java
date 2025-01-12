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
public class Editoriales {
    int id_editorial;
    String nombre_editorial;
    String direccion_editorial;
    String contacto_editorial;
    String telefono_editorial;
    String correo_editorial;

    public Editoriales() {
    }

    public Editoriales(int id_editorial, String nombre_editorial, String direccion_editorial, String contacto_editorial, String telefono_editorial, String correo_editorial) {
        this.id_editorial = id_editorial;
        this.nombre_editorial = nombre_editorial;
        this.direccion_editorial = direccion_editorial;
        this.contacto_editorial = contacto_editorial;
        this.telefono_editorial = telefono_editorial;
        this.correo_editorial = correo_editorial;
    }

    public int getId_editorial() {
        return id_editorial;
    }

    public void setId_editorial(int id_editorial) {
        this.id_editorial = id_editorial;
    }

    public String getNombre_editorial() {
        return nombre_editorial;
    }

    public void setNombre_editorial(String nombre_editorial) {
        this.nombre_editorial = nombre_editorial;
    }

    public String getDireccion_editorial() {
        return direccion_editorial;
    }

    public void setDireccion_editorial(String direccion_editorial) {
        this.direccion_editorial = direccion_editorial;
    }

    public String getContacto_editorial() {
        return contacto_editorial;
    }

    public void setContacto_editorial(String contacto_editorial) {
        this.contacto_editorial = contacto_editorial;
    }

    public String getTelefono_editorial() {
        return telefono_editorial;
    }

    public void setTelefono_editorial(String telefono_editorial) {
        this.telefono_editorial = telefono_editorial;
    }

    public String getCorreo_editorial() {
        return correo_editorial;
    }

    public void setCorreo_editorial(String correo_editorial) {
        this.correo_editorial = correo_editorial;
    }
    
    
}
