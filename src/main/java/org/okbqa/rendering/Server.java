package org.okbqa.rendering;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class Server {
		final public static String APP_PATH = "http://localhost:2020/rest/";
	    static String usage = "usage: ";

	    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, ClassNotFoundException {
	        if (args.length>1) {
	        	
	        }
	        URI serverURI = new URI(APP_PATH);

	        final Map<String, String> initParams = new HashMap<String, String>();
	        initParams.put("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
	        initParams.put("com.sun.jersey.config.property.packages", "org.okbqa.rendering.rest");

	        SelectorThread threadSelector = GrizzlyWebContainerFactory.create(serverURI, initParams);
	        threadSelector.start();

	        System.err.println("Server started in " + System.getProperty("user.dir") + " listening on " + serverURI);

	        boolean running = true;
	        while(running) {
	            Thread.sleep(100);
	        }

	        //Stop the HTTP server
	        //server.stop(0);
	        threadSelector.stopEndpoint();
	        System.exit(0);

	    }

}
