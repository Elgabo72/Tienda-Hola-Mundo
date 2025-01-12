
package Modelo;

import java.sql.Date;


public class Usuario {
    int id_usuario;
    String usuario;
    String clave;
    Date f_creacion_user;
    int estado_user;
    String id_empleados_user;

    public Usuario() {
    }

    public Usuario(int id_usuario, String usuario, String clave, Date f_creacion_user, int estado_user, String id_empleados_user) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.clave = clave;
        this.f_creacion_user = f_creacion_user;
        this.estado_user = estado_user;
        this.id_empleados_user = id_empleados_user;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getF_creacion_user() {
        return f_creacion_user;
    }

    public void setF_creacion_user(Date f_creacion_user) {
        this.f_creacion_user = f_creacion_user;
    }

    public int getEstado_user() {
        return estado_user;
    }

    public void setEstado_user(int estado_user) {
        this.estado_user = estado_user;
    }

    public String getId_empleados_user() {
        return id_empleados_user;
    }

    public void setId_empleados_user(String id_empleados_user) {
        this.id_empleados_user = id_empleados_user;
    }

   
   
    
}
