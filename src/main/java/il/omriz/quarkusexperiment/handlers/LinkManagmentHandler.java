package il.omriz.quarkusexperiment.handlers;

import il.omriz.quarkusexperiment.database.LinkEntry;
import il.omriz.quarkusexperiment.database.LinksDBInterface;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.net.URI;

@Path("/api/links")
@Consumes(MediaType.APPLICATION_JSON)
public class LinkManagmentHandler {

    @Inject
    LinksDBInterface linksDBInterface;

    @POST
    public Response setLink(LinkEntry entry) {
        linksDBInterface.setLink(entry.getAlias(), URI.create(entry.getTarget()));
        return Response.ok().build();
    }
}
