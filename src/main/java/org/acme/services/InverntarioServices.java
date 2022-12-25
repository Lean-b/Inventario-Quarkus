/*
 * Copyright (c) 2022.
 * Todos los derechos reservados.
 * Esta obra está protegida por derechos de autor y no puede ser reproducida sin el permiso de Leandro.
 * Este archivo se puede usar para fines personales, no comerciales.
 */

package org.acme.services;

import org.acme.model.CategoriaEnum;
import org.acme.model.Inventario;
import org.acme.repository.InventarioRepository;


import javax.inject.Inject;
import javax.transaction.Transactional;


public interface InverntarioServices  {

    @Inject
    InventarioRepository inventarioRepository = null;


    @Transactional
    public default Inventario actualizarProducto(String nombreDeProducto, Long cantidad, CategoriaEnum categoria, String proveedores, Double precioPorUnidad){
        Inventario producto =inventarioRepository.buscarProducto(nombreDeProducto);
        if(producto == null) throw new IllegalArgumentException ("No se encontro el producto");
                producto.setNombreDeProducto(nombreDeProducto);
                producto.setCantidad(cantidad);
                producto.setCategoria(categoria);
                producto.setProveedores(proveedores);
                producto.setPrecioPorUnidad(precioPorUnidad);
                inventarioRepository.actualizarProducto(producto);
        return producto;

    }

    @Transactional
    public default Inventario borrarProducto(Long id, String nombreDeProducto, Long cantidad, CategoriaEnum categoria, String proveedores, Double precioPorUnidad){
       Inventario producto = inventarioRepository.buscarProducto(nombreDeProducto);
       if (producto == null) throw new IllegalArgumentException ("No se encontro el producto");
       producto.setNombreDeProducto(nombreDeProducto);
       producto.setCantidad(cantidad);
       producto.setCategoria(categoria);
       producto.setProveedores(proveedores);
       producto.setPrecioPorUnidad(precioPorUnidad);
       inventarioRepository.delete( nombreDeProducto, cantidad, categoria, proveedores, precioPorUnidad);
       return producto;
    }


    @Transactional
    public default Inventario crearProducto(String nombreDeProducto, Long cantidad, CategoriaEnum categoria, String proveedores, Double precioPorUnidad){
        Inventario producto = new Inventario(null,nombreDeProducto,cantidad,categoria,proveedores, precioPorUnidad);
        return producto;
    }

    @Transactional
    public default Inventario buscarProducto(String nombreDeProducto){
        Inventario producto = inventarioRepository.buscarProducto(nombreDeProducto);
        if(producto == null) throw new IllegalArgumentException ("No se encontro el producto");
        return producto;
    }



}
