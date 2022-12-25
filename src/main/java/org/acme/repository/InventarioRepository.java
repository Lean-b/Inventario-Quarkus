/*
 * Copyright (c) 2022.
 * Todos los derechos reservados.
 * Esta obra está protegida por derechos de autor y no puede ser reproducida sin el permiso de Leandro.
 * Este archivo se puede usar para fines personales, no comerciales.
 */

package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.model.Inventario;

import javax.inject.Inject;
import javax.persistence.*;

public class InventarioRepository implements PanacheRepository<Inventario> {

    @Inject
    private EntityManager entityManager;


    public void actualizarProducto(Inventario producto) {
        entityManager.merge(producto);
    }


    public  Inventario  buscarProducto(String nombreDeProducto) {
        Inventario producto = entityManager
                .createQuery("SELECT p FROM Inventario p WHERE p.nombreDeProducto = :nombre", Inventario.class)
                .setParameter("nombre", nombreDeProducto)
                .getSingleResult();
        return producto;
    }
}

