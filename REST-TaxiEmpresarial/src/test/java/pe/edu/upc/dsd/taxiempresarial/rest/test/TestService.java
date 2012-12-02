package pe.edu.upc.dsd.taxiempresarial.rest.test;

import org.apache.cxf.jaxrs.client.WebClient;
import javax.ws.rs.core.Response;
import org.junit.Test;
import junit.framework.TestCase;

public class TestService extends TestCase {

	    // @Resource(type = UserServiceImpl.class)
	    // private ServiceDefn service;
		//Logger logger = Logger.getLogger(TestService.class);
		String hola = "http://localhost:8080/REST-TaxiEmpresarial/encuesta/calificaciones/3";
	    
	    //public void testGetUsers() {
	    	/*WebClient wc = WebClient.create("http://localhost:8080/cxf-rest/rs/user-service");
	    	wc.accept("application/json");
	    	Response res = wc.path("/users").get();
	    	System.out.println(res.getEntity().toString());*/
	    	
	    	//System.out.println(invokeService("http://localhost:8080/REST-TaxiEmpresarial/encuesta/calificaciones/1"));
	   //}
	    
	    @Test
	    private String invokeService(String hola) {
	        WebClient webClient = WebClient.create(hola);
	        webClient.accept("application/xml");
	        return webClient.get(String.class);
	    }
	}
