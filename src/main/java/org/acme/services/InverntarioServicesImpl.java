/*
 * Copyright (c) 2022.
 * Todos los derechos reservados.
 * Esta obra está protegida por derechos de autor y no puede ser reproducida sin el permiso de Leandro.
 * Este archivo se puede usar para fines personales, no comerciales.
 */

package org.acme.services;

import org.acme.model.CategoriaEnum;
import org.acme.model.Inventario;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InverntarioServicesImpl implements InverntarioServices {
    @Override
    public Inventario actualizarProducto(String nombreDeProducto, Long cantidad, CategoriaEnum categoria, String proveedores, Double precioPorUnidad) {
        return null;
    }

    @Override
    public Inventario borrarProducto(Long id, String nombreDeProducto, Long cantidad, CategoriaEnum categoria, String proveedores, Double precioPorUnidad) {
        return null;
    }

    @Override
    public Inventario crearProducto(String nombreDeProducto, Long cantidad, CategoriaEnum categoria, String proveedores, Double precioPorUnidad) {
        return null;
    }

    @Override
    public Inventario buscarProducto(String nombreDeProducto) {
        return null;
    }
}
