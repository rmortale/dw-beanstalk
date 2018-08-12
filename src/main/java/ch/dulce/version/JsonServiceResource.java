package ch.dulce.version;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
public class JsonServiceResource {

    private final Client client;

    public JsonServiceResource(Client client) {
        this.client = client;
    }

    @GET
    public String doStuff() {
        return client.target("https://jsonplaceholder.typicode.com")
                .path("posts")
                .request()
                .get(String.class);
    }
}
