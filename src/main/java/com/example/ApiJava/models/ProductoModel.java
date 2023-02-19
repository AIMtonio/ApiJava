package com.example.ApiJava.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cat_producto")

public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String imagen;
    private int tipo_categoria;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getImagen() {
        return imagen;
    }  
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public Integer getTipo_categoria() {
        return tipo_categoria;
    }
    public void setTipo(Integer tipo_categoria) {
        this.tipo_categoria = tipo_categoria;
    }
  
}
