/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.recurso;
 
import cc.nuvu.api.modelo.Tarjeta;
import cc.nuvu.api.servicio.ImpServicioTarjeta;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import cc.nuvu.api.servicio.ServicioTarjeta; 
import javax.ws.rs.PUT;

/**
 *
 * @author Yio
 */
@Path("/tarjetas")
public class RecursoTarjeta {

    ServicioTarjeta servicioTarjeta = new ImpServicioTarjeta();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTargetas() {
        List<Tarjeta> lista = servicioTarjeta.listar();
        if (!lista.isEmpty()) {
            return Response.ok(lista).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{cc}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarUsuarioTargeta(@PathParam("cc") long cc) {
        Tarjeta usuarioConTarjeta = servicioTarjeta.buscarUsuarioTargeta(cc);

        if (usuarioConTarjeta != null) {
            return Response.ok(usuarioConTarjeta).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/agregar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response anadirTargeta(Tarjeta tarjeta) {

        boolean respuesta = servicioTarjeta.agregar(tarjeta.getNombre(),tarjeta.getIdentificacion()
                                                     );
        if (respuesta) {
            return Response.status(Response.Status.CREATED).build();
        }
          final int BAD_REQUEST = 400;
        
          return Response.status(BAD_REQUEST ,"¡Usted ya tiene asignada una targeta!").build();

    }
    
    @PUT
    @Path("/modificar")
    @Consumes(MediaType.APPLICATION_JSON) 
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarTargeta(Tarjeta tarjeta) {

        boolean respuesta = servicioTarjeta.modificar(tarjeta.getNombre(),
                                                        tarjeta.getIdentificacion());
        if (respuesta) {
            return Response.status(Response.Status.CREATED).build(); 
            //return Response.ok(tarjeta).build();
        } 
        
          return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();

    }

}
