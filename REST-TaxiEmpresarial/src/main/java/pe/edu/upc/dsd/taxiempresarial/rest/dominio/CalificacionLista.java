package pe.edu.upc.dsd.taxiempresarial.rest.dominio;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="calificaciones")
public class CalificacionLista {
	
	private List<Calificacion> data;

	public List<Calificacion> getData() {
		return data;
	}

	public void setData(List<Calificacion> data) {
		this.data = data;
	}
	
}
