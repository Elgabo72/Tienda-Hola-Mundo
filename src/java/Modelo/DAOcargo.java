/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DAOcargo {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    int r;

    public List listar() {
        String sql = "select * from cargo";
        List<Cargo> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cargo car = new Cargo();
                car.setId_cargo(rs.getInt(1));
                car.setNombre_cargo(rs.getString(2));
                car.setDesc_cargo(rs.getString(3));
                car.setSueldo_cargo(rs.getDouble(4));
                lista.add(car);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int Agregar(Cargo car) {
        String sql = "insert into cargo (nombre_cargo,descripcion_cargo,sueldo_cargo) values (?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, car.getNombre_cargo());
            ps.setString(2, car.getDesc_cargo());
            ps.setDouble(3, car.getSueldo_cargo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public Cargo listarid(int id) {
        Cargo car = new Cargo();
        String sql = "select * from cargo where id_cargo=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                car.setNombre_cargo(rs.getString(2));
                car.setDesc_cargo(rs.getString(3));
                car.setSueldo_cargo(rs.getDouble(4));
            }
        } catch (Exception e) {
        }
        return car;
    }

    public int Actualizar(Cargo car) {
        String sql = "update cargo set nombre_cargo=?,descripcion_cargo=?,sueldo_cargo=? where id_cargo=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, car.getNombre_cargo());
            ps.setString(2, car.getDesc_cargo());
            ps.setDouble(3, car.getSueldo_cargo());
            ps.setInt(4, car.getId_cargo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public void Eliminar(int id) {
        String sql = "delete from cargo where id_cargo=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
