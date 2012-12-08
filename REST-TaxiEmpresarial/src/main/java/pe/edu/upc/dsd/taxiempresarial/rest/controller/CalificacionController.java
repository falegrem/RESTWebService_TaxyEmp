
package pe.edu.upc.dsd.taxiempresarial.rest.controller;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.upc.dsd.taxiempresarial.rest.dominio.Calificacion;
import pe.edu.upc.dsd.taxiempresarial.rest.dominio.CalificacionLista;
import pe.edu.upc.dsd.taxiempresarial.rest.service.CalificacionService;

@Controller
public class CalificacionController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="calificacionService")
	private CalificacionService calificacionService;
	
	
	@RequestMapping(value="/calificaciones/{cod_reserva}",method=RequestMethod.GET,
			        headers="Accept=application/xml, appication/json")
	private @ResponseBody CalificacionLista getCalificaciones(@PathVariable("cod_reserva")int cod_reserva)
	{
		CalificacionLista result = new CalificacionLista();
		result.setData(calificacionService.getCalificacion(cod_reserva));
		return result;
		
	}
	
	
	@RequestMapping(value="/calificacion",method=RequestMethod.GET,
	        headers="Accept=application/xml, appication/json")
	private @ResponseBody CalificacionLista getCalificacion()
	{
		CalificacionLista result = new CalificacionLista();
		result.setData(calificacionService.getCalificacionList());
		return result;
	
	}
		
	@RequestMapping(value = "/calificaciones/{cod_reserva}", method = RequestMethod.PUT, 
			       headers = "Accept=application/xml, application/json")
	public @ResponseBody String updCalificacion(@PathVariable("cod_reserva") int cod_reserva, @RequestBody Calificacion calificacion) {
		logger.debug("Provider has received request to edit calificacion si cod_reserva:" + cod_reserva);

		// Call service here
		calificacion.setCod_reserva(cod_reserva);
		return calificacionService.edit(calificacion).toString();
	}
}

