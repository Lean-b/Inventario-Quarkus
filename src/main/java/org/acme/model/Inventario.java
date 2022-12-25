/*
 * Copyright (c) 2022.
 * Todos los derechos reservados.
 * Esta obra está protegida por derechos de autor y no puede ser reproducida sin el permiso de Leandro.
 * Este archivo se puede usar para fines personales, no comerciales.
 */

package org.acme.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre_de_producto", nullable = false)
    @NotBlank(message = "Nombre de producto")
    @Size(max = 100)
    private String nombreDeProducto;

    @Column(name = "cantidad", nullable = false)
    @NotBlank(message = "Cantidad de productos")
    @Min(value = 0)
    private Long cantidad;

    @Column(name = "categoria", nullable = false)
    @NotBlank(message = "Categoria de productos")
    private CategoriaEnum categoria;

    @Column(name = "proveedores", nullable = false)
    @NotBlank(message = "Proveedores de productos")
    @Size(max = 100)
    private String proveedores;

    @Column(name = "precio_por_unidad", nullable = false)
    @NotBlank(message = "Precio por unidad (Valor de un solo producto)")
    @Min(value = 0)
    private Double precioPorUnidad;


    //Constructor
    public Inventario() {
    }

    public Inventario(Long id, String nombreDeProducto, Long cantidad, CategoriaEnum categoria, String proveedores, Double precioPorUnidad) {
        this.id = id;
        this.nombreDeProducto = nombreDeProducto;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.proveedores = proveedores;
        this.precioPorUnidad = precioPorUnidad;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setPrecioPorUnidad(Double precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }

    public String getProveedores() {
        return proveedores;
    }

    public void setProveedores(String proveedores) {
        this.proveedores = proveedores;
    }



    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreDeProducto() {
        return nombreDeProducto;
    }

    public void setNombreDeProducto(String nombreDeProducto) {
        this.nombreDeProducto = nombreDeProducto;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "id=" + id +
                ", nombreDeProducto='" + nombreDeProducto + '\'' +
                ", cantidad=" + cantidad +
                ", categoria=" + categoria +
                ", proveedores='" + proveedores + '\'' +
                ", precioPorUnidad=" + precioPorUnidad +
                '}';
    }
}