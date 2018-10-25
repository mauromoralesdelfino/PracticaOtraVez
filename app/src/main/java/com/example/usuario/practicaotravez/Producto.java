package com.example.usuario.practicaotravez;

public class Producto {

    private String nombre;
    private Double precio;
    private String id;
    private Integer cantidad;

    public Producto() {

    }

    public Producto(String nombre, Double precio, String id, Integer cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.id = id;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
