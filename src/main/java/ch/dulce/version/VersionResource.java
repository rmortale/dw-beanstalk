package ch.dulce.version;

import com.google.common.io.CharStreams;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Path("/version")
@Produces(MediaType.APPLICATION_JSON)
public class VersionResource {

    @GET
    public String getVersion() throws IOException {
        InputStream stream = getClass().getResourceAsStream("/git.properties");
        return CharStreams.toString(new InputStreamReader(stream, StandardCharsets.UTF_8));

    }
}