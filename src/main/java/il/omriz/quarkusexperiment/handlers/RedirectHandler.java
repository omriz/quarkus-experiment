package il.omriz.quarkusexperiment.handlers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/r/{alias:.*}")
public class RedirectHandler {
    @GET
    public Response redirect(@PathParam("alias") String alias) {
        if (alias.equals("home")) {
            return Response.seeOther(URI.create("http://www.google.com")).build();
        }
        Response response = Response.status(Response.Status.NOT_FOUND).build();
        return response;
    }
}
