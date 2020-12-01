package cc.nuvu.api.recurso;

import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author yio
 */
@Provider
@PreMatching
public class Interceptor implements ContainerRequestFilter {
     

    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        String url = request.getUriInfo().getAbsolutePath().toString();

        if (url.contains("/api/signin")) 
            return;
        

        String token = request.getHeaderString("Authorization");
       
        if (token == null) {

            JsonObject jo = Json.createObjectBuilder().add("mensaje",
                    "¡Necesita un token valido para acceder a este recurso!").build();

            request.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity(jo).type(MediaType.APPLICATION_JSON).build());
            return;
        }

        if (!token.equals(RecursoLogin.jwtGenerado)) {

            JsonObject jo = Json.createObjectBuilder().add("mensaje ",
                    "¡Token incorrecto para acceder al recurso!").build();

            request.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity(jo).type(MediaType.APPLICATION_JSON).build());
            
        }

    }

}
