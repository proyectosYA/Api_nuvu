/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.recurso;

import cc.nuvu.api.modelo.Cliente;
import cc.nuvu.api.servicio.ImpServicioCliente;
import cc.nuvu.api.servicio.ServicioCliente;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Yio
 */
@Path("/signin")
public class RecursoLogin {

    final String KEY = "mi_clave";
    final String MSJ = "Usuario o contraseña incorrectos";
    public static String jwtGenerado;
    
    ServicioCliente servicioCliente = new ImpServicioCliente();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Cliente cliente) {

        boolean respuesta = servicioCliente.login(cliente.getUsuario(), cliente.getContrasena());
        if (respuesta) {

            //TOKEN 
            long tiempo = System.currentTimeMillis();
            String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, KEY)
                    .setSubject("pepe").setIssuedAt(new Date(tiempo))
                    .setExpiration(new Date(tiempo + 900000))
                    .claim("email", "miemail@xxx.com.co").compact();
            jwtGenerado = jwt;
            JsonObject jo = Json.createObjectBuilder().add("JWT", jwt).build();

            return Response.status(Response.Status.CREATED).entity(jo).build();
        } else {

            JsonObject jo = Json.createObjectBuilder().add("mensaje: ", MSJ).build();
            return Response.status(Response.Status.UNAUTHORIZED).entity(jo).build();
        }
    }
}
