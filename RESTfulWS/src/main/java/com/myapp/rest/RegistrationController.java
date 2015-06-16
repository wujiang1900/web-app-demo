package com.myapp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;

import com.myapp.domain.User;


public class RegistrationController {

    /**
     * @return String that will be returned as a json response.
     */
    @GET
//    @Produces(MediaType.APPLICATION_JSON_TYPE)
    @Path("/users/{userName}")
    public Response getUser(@QueryParam("userName") String userName) {
    //    String userJson = "{\"name\":\"John\"}";
        return Response.status(200).entity(new User()).build();
    }
}
