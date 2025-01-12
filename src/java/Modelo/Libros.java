/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import javax.persistence.Lob;
import javax.servlet.http.Part;

/**
 *
 * @author ADMIN
 */
public class Libros {
    int id_libro;
    String titulo_libro;
    String autor_libro;
    Date f_publicacion_libro;
    int num_paginas_libro;
    double precio_libro;
    String sinopsis_libros;
    
    InputStream portada_libro;
    Date f_registro_libro;
    int estado_libro;
    String id_editoriales_lib;
    String id_categorias_lib;
    int stock;
    
    public Libros() {
    }

    
    
    public Libros(int id_libro, String titulo_libro, String autor_libro, Date f_publicacion_libro, int num_paginas_libro, double precio_libro, String sinopsis_libros, InputStream portada_libro, Date f_registro_libro, int estado_libro, String id_editoriales_lib, String id_categorias_lib, int stock) {
        this.id_libro = id_libro;
        this.titulo_libro = titulo_libro;
        this.autor_libro = autor_libro;
        this.f_publicacion_libro = f_publicacion_libro;
        this.num_paginas_libro = num_paginas_libro;
        this.precio_libro = precio_libro;
        this.sinopsis_libros = sinopsis_libros;
        this.portada_libro = portada_libro;
        this.f_registro_libro = f_registro_libro;
        this.estado_libro = estado_libro;
        this.id_editoriales_lib = id_editoriales_lib;
        this.id_categorias_lib = id_categorias_lib;
        this.stock = stock;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo_libro() {
        return titulo_libro;
    }

    public void setTitulo_libro(String titulo_libro) {
        this.titulo_libro = titulo_libro;
    }

    public String getAutor_libro() {
        return autor_libro;
    }

    public void setAutor_libro(String autor_libro) {
        this.autor_libro = autor_libro;
    }

    public Date getF_publicacion_libro() {
        return f_publicacion_libro;
    }

    public void setF_publicacion_libro(Date f_publicacion_libro) {
        this.f_publicacion_libro = f_publicacion_libro;
    }

    public int getNum_paginas_libro() {
        return num_paginas_libro;
    }

    public void setNum_paginas_libro(int num_paginas_libro) {
        this.num_paginas_libro = num_paginas_libro;
    }

    public double getPrecio_libro() {
        return precio_libro;
    }

    public void setPrecio_libro(double precio_libro) {
        this.precio_libro = precio_libro;
    }

    public String getSinopsis_libros() {
        return sinopsis_libros;
    }

    public void setSinopsis_libros(String sinopsis_libros) {
        this.sinopsis_libros = sinopsis_libros;
    }

    public InputStream getPortada_libro() {
        return portada_libro;
    }

    public void setPortada_libro(InputStream portada_libro) {
        this.portada_libro = portada_libro;
    }

    public Date getF_registro_libro() {
        return f_registro_libro;
    }

    public void setF_registro_libro(Date f_registro_libro) {
        this.f_registro_libro = f_registro_libro;
    }

    public int getEstado_libro() {
        return estado_libro;
    }

    public void setEstado_libro(int estado_libro) {
        this.estado_libro = estado_libro;
    }

    public String getId_editoriales_lib() {
        return id_editoriales_lib;
    }

    public void setId_editoriales_lib(String id_editoriales_lib) {
        this.id_editoriales_lib = id_editoriales_lib;
    }

    public String getId_categorias_lib() {
        return id_categorias_lib;
    }

    public void setId_categorias_lib(String id_categorias_lib) {
        this.id_categorias_lib = id_categorias_lib;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
    
    
}
