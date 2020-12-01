/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.recurso;

import cc.nuvu.api.dao.ClienteDao;
import cc.nuvu.api.dao.ImpCliente;
import cc.nuvu.api.modelo.Cliente;
import cc.nuvu.api.servicio.ImpServicioCliente;
import cc.nuvu.api.servicio.ServicioCliente;
import com.mysql.jdbc.log.LogFactory;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Yio
 */
@Path("/usuarios")
public class RecursoCliente {

    ServicioCliente servicioCliente = new ImpServicioCliente();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarClientes() {
        List<Cliente> lista = servicioCliente.listar();
        return Response.ok(lista).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cc}")
    public Response buscarCliente(@PathParam("cc") long cc) {
        Cliente cliente = servicioCliente.buscarCliente(cc);
        if (cliente != null) {
            return Response.ok(cliente).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @POST
    @Path("/agregar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response anadir(Cliente cliente) {
        boolean respuesta = servicioCliente.agregar(cliente);
        if (respuesta == true) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/modificar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modificar(Cliente cliente) {
        boolean respuesta = servicioCliente.modificar(cliente.getNombre(),
                cliente.getApellidos(), cliente.getTelefono(), cliente.getContrasena(),cliente.getCedula());
        if (respuesta == true) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    

}
