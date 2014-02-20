package org.okbqa.rendering.rest;

import java.io.StringReader;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.okbqa.rendering.Server;
import org.okbqa.rendering.model.Binding;
import org.okbqa.rendering.model.DummyRenderer;
import org.okbqa.rendering.model.QueryResults;
import org.okbqa.rendering.renderer.QueryResultsRenderer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Dummy Web Service
 */
@ApplicationPath(Server.APP_PATH)
@Path("/render")
@Consumes("text/plain")
public class Render {

    @Context
    private UriInfo context;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON})
    public Response postXML(@DefaultValue("") @FormParam("json") String json,
    		@Context HttpServletRequest request) {
//    	json = "{ question : \"How many students does the Free University of Berlin have? \", "
//    			+ "  bindings: [ "
//    			+ "   [ "
//    			+ "   {var : \"?x\",  binding : \"250000\" ,  endpoint : \"http://dbpedia.org/sparql\"},"
//    			+ "   ]"
//    			+ "  ] }";
//    	
//		String exQr = "{'question':'what?', "
//				+ "     'bindings':[ [ "
//				+ "{ 'var': '?x', 'binding': 'http://dbpedia.org/resource/Jeju_City', 'endpoint': 'http://dbpedia.org/sparql'} "
//				+ "]] }";
    	Gson gson = new GsonBuilder().create();
    	QueryResults qr = gson.fromJson(new StringReader(json), QueryResults.class);
    	QueryResultsRenderer renderer = new DummyRenderer();
    	String results = renderer.render(qr);
    	try {
    		return Response.ok().entity(results).header("Access-Control-Allow-Origin","*").build();
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(e).type(MediaType.APPLICATION_JSON).build());
    	}
    }

}
