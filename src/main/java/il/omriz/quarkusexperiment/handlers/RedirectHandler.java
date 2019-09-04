package il.omriz.quarkusexperiment.handlers;

import il.omriz.quarkusexperiment.database.LinksDBInterface;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/r/{alias:.*}")
public class RedirectHandler {
    @Inject
    LinksDBInterface linksDBInterface;

    @GET
    public Response redirect(@PathParam("alias") String alias) {
        URI redirectURI = linksDBInterface.getLink(alias);
        if (redirectURI == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.seeOther(redirectURI).build();
    }
}
