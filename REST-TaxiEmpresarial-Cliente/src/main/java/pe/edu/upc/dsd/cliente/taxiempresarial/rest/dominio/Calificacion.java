package pe.edu.upc.dsd.cliente.taxiempresarial.rest.dominio;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="calificacion")
public class Calificacion {
	
	private int cal_cod;
	private int cod_reserva;
	private Date cal_fecha_ini;
	private Date cal_fecha_fin;
	private String cal_preg1;
	private String cal_preg2;
	private int cal_estado;
	
	public int getCal_cod() {
		return cal_cod;
	}
	public void setCal_cod(int cal_cod) {
		this.cal_cod = cal_cod;
	}
	public int getCod_reserva() {
		return cod_reserva;
	}
	public void setCod_reserva(int cod_reserva) {
		this.cod_reserva = cod_reserva;
	}
	public Date getCal_fecha_ini() {
		return cal_fecha_ini;
	}
	public void setCal_fecha_ini(Date cal_fecha_ini) {
		this.cal_fecha_ini = cal_fecha_ini;
	}
	public Date getCal_fecha_fin() {
		return cal_fecha_fin;
	}
	public void setCal_fecha_fin(Date cal_fecha_fin) {
		this.cal_fecha_fin = cal_fecha_fin;
	}
	public String getCal_preg1() {
		return cal_preg1;
	}
	public void setCal_preg1(String cal_preg1) {
		this.cal_preg1 = cal_preg1;
	}
	public String getCal_preg2() {
		return cal_preg2;
	}
	public void setCal_preg2(String cal_preg2) {
		this.cal_preg2 = cal_preg2;
	}
	public int getCal_estado() {
		return cal_estado;
	}
	public void setCal_estado(int cal_estado) {
		this.cal_estado = cal_estado;
	}
	@Override
	public String toString() {
		return "Calificacion [cal_cod=" + cal_cod + ", cod_reserva="
				+ cod_reserva + ", cal_fecha_ini=" + cal_fecha_ini
				+ ", cal_fecha_fin=" + cal_fecha_fin + ", cal_preg1="
				+ cal_preg1 + ", cal_preg2=" + cal_preg2 + ", cal_estado="
				+ cal_estado + "]";
	}

}
