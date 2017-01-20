package com.propellerads.utils.teamcity.build;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Properties;

@Path("/test")
public class BuildResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuildResource.class);

    private static Properties settings = new Properties();

    private Response.Status status;
    private String errorMessage;

    public BuildResource() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            // load a properties file
            settings.load(loader.getResourceAsStream("build.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Path("/example")
    @POST
    public Response runTeamcityBuildByGet(@QueryParam("param") String param){
        return Response.ok().build();
    }
}
