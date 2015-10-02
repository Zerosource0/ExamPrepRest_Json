/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import generator.Generator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Marc
 */
@Path("gen")
public class ApiGenerator {

    @Context
    private UriInfo context;

    
    private String fName;
    private String lName;
    private String address;
    private String city;

    public ApiGenerator(String fName, String lName, String address, String city) {
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.city = city;
    }

    public ApiGenerator() {
        
    }


    @GET
    @Produces("application/json")
    @Path("{amount}/{values}")
    public String getJson(@PathParam("amount")int amount, @PathParam("values")String values) {
        Generator gen = new Generator();
        return gen.getData(amount, values);
    }

    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
