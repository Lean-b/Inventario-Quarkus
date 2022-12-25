/*
 * Copyright (c) 2022.
 * Todos los derechos reservados.
 * Esta obra está protegida por derechos de autor y no puede ser reproducida sin el permiso de Leandro.
 * Este archivo se puede usar para fines personales, no comerciales.
 */

package org.acme.resource;




import org.acme.model.Inventario;
import org.acme.services.InverntarioServices;


import javax.inject.Inject;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("./inventario")
public class InventarioResource {

    @Inject
    private InverntarioServices service;



    @PUT
    public Response update(@PathParam("id") Long id,Inventario inventario){
        service.actualizarProducto(inventario.getNombreDeProducto(),inventario.getCantidad(),inventario.getCategoria(), inventario.getProveedores(), inventario.getPrecioPorUnidad());
        return Response.ok().build();
    }

    @DELETE
    public Response delete(@PathParam("id") Long id,Inventario inventario){
        service.borrarProducto(inventario.getId(),inventario.getNombreDeProducto(),inventario.getCantidad(),inventario.getCategoria(), inventario.getProveedores(), inventario.getPrecioPorUnidad());
        return Response.ok().build();
    }



    @POST
    public Response add(Inventario  inventario){
        service.crearProducto(inventario.getNombreDeProducto(),inventario.getCantidad(),inventario.getCategoria(),inventario.getProveedores(),inventario.getPrecioPorUnidad());
        return Response.ok().build();
    }

    @GET
    public Response seach(String nombreDeProducto){
        Inventario producto = service.buscarProducto(nombreDeProducto);
        if(producto == null) throw new IllegalArgumentException ("No se encontro el producto");
        return Response.ok().build();
    }


}
