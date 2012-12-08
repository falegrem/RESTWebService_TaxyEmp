package pe.edu.upc.dsd.cliente.taxiempresarial.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import pe.edu.upc.dsd.cliente.taxiempresarial.rest.dominio.Calificacion;
import pe.edu.upc.dsd.cliente.taxiempresarial.rest.dominio.CalificacionLista;

@Controller
public class RestClienteController {
	
	private RestTemplate restTemplate = new RestTemplate();
	protected static Logger logger = Logger.getLogger("controller");
	
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String getPerson(@RequestParam("cod_reserva") int cod_reserva, Model model) {
		logger.debug("devuelve el codigo de reserva: " + cod_reserva);
		
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<Calificacion> entity = new HttpEntity<Calificacion>(headers);

		// Send the request as GET
		try {
			ResponseEntity<Calificacion> result = restTemplate.exchange("http://localhost:8080/REST-TaxiEmpresarial/encuesta/calificaciones/{cod_reserva}", HttpMethod.GET, entity, Calificacion.class, cod_reserva);
			// Add to model
			model.addAttribute("calificaciones", result.getBody());
			
		} catch (Exception e) {
			logger.error(e);
		}
		
		// This will resolve to /WEB-INF/jsp/getcalificacion.jsp
		return "getcalificacion";
	}
	
	@RequestMapping(value = "/getCalificaciones", method = RequestMethod.GET)
	public String getAll(Model model) {
		logger.debug("retorna todas las calificaciones");
		
		// Prepare acceptable media type
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<Calificacion> entity = new HttpEntity<Calificacion>(headers);

		// Send the request as GET
		try {
			ResponseEntity<CalificacionLista> result = 
					restTemplate.exchange("http://localhost:8080/REST-TaxiEmpresarial/encuesta/calificacion",
							HttpMethod.GET, entity, CalificacionLista.class);
			// Add to model
			model.addAttribute("calificacion", result.getBody().getData());
			
		} catch (Exception e) {
			logger.error(e);
		}
		
		// This will resolve to /WEB-INF/jsp/calificacionLista.jsp
		return "calificacionLista";
	}
	
	
	  @RequestMapping(value = "/update", method = RequestMethod.GET)
	    public String getUpdatePage(@RequestParam(value="cod_reserva", required=true) Integer cod_reserva, Model model) {
	    	logger.debug("recibe la edicacion para la encuesta");
	    
	    	// Retrieve existing Person and add to model
	    	// Prepare acceptable media type
			List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
			acceptableMediaTypes.add(MediaType.APPLICATION_XML);
			
			// Prepare header
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(acceptableMediaTypes);
			HttpEntity<Calificacion> entity = new HttpEntity<Calificacion>(headers);

			// Send the request as GET
			try {
				ResponseEntity<Calificacion> result = restTemplate.exchange("http://localhost:8080/REST-TaxiEmpresarial/encuesta/calificaciones/{cod_reserva}", HttpMethod.GET, entity, Calificacion.class, cod_reserva);
				// Add to model
				model.addAttribute("calificacionAttribute", result.getBody());
				
			} catch (Exception e) {
				logger.error(e);
			}
	    	
	    	// This will resolve to /WEB-INF/jsp/grabaCalificacion.jsp
	    	return "grabaCalificacion";
		}

	  @RequestMapping(value = "/update", method = RequestMethod.POST)
	    public String UpdateCaificacion(@RequestParam(value="cod_reserva", required=true) Integer cod_reserva, Model model) {
	    	logger.debug("actualiza la encuenta con codigo de reserva seleccionado");
	    
	    	// Retrieve existing calificacion
	    	// Prepare acceptable media type
			List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
			acceptableMediaTypes.add(MediaType.APPLICATION_XML);
			
			// Prepare header
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(acceptableMediaTypes);
			HttpEntity<Calificacion> entity = new HttpEntity<Calificacion>(headers);

			// Send the request as GET
			try {
				ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/REST-TaxiEmpresarial/encuesta/calificaciones/{cod_reserva}", HttpMethod.PUT, entity, String.class, cod_reserva);
				// Add to model
				
			} catch (Exception e) {
				logger.error(e);
			}
	    	
	    	// This will resolve to /WEB-INF/jsp/grabaCalificacion.jsp
	    	return "resultPage";
		}
}
