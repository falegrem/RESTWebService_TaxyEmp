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
	
	
	@RequestMapping(value="/calificaciones/{codReserva}",method=RequestMethod.GET,
			        headers="Accept=application/xml, appication/json")
	private @ResponseBody CalificacionLista getCalificaciones(@PathVariable("codReserva")int codReserva)
	{
		CalificacionLista result = new CalificacionLista();
		result.setData(calificacionService.getCalificacion(codReserva));
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
		
	@RequestMapping(value = "/calificacion/{cal_cod}", method = RequestMethod.PUT, 
			       headers = "Accept=application/xml, application/json")
	public @ResponseBody String updCalificacion(@PathVariable("cal_cod") int cal_cod, @RequestBody Calificacion calificacion) {
		logger.debug("Provider has received request to edit person with id:" + cal_cod);

		// Call service here
		calificacion.setCal_cod(cal_cod);
		return calificacionService.edit(calificacion).toString();
	}
}

