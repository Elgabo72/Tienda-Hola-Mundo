
package Modelo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Conexion {
    java.sql.Connection con;
    String url = "jdbc:mysql://localhost/hola_mundo_vs1";
    String user = "root";
    String pass = "";

    public java.sql.Connection Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
        }
        return con;
    }
   
}
