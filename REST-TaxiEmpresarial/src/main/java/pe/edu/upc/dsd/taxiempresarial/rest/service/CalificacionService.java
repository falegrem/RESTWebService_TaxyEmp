package pe.edu.upc.dsd.taxiempresarial.rest.service;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.DatatypeFactory;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import pe.edu.upc.dsd.taxiempresarial.rest.util.*;
import pe.edu.upc.dsd.taxiempresarial.rest.dominio.Calificacion;

@Service("calificacionService")
public class CalificacionService {
	
	protected static Logger logger = Logger.getLogger("Service");

	private List<Calificacion> calificaciones = new ArrayList<Calificacion>();
	private List<Calificacion> calificacionesList = new ArrayList<Calificacion>();
	
	public List<Calificacion> getCalificacion(int codReserva){
		logger.debug("conectando BD y obteniendo calificaciones con con SP");
		
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		    try {
		        //con SQLServer
		    	//cstmt = JdbcUtils.getConnectionMSSQL().prepareCall("{ call usp_ConsultaEncuenta(?) }");
		    	
		    	//con MySQL
		    	cstmt = JdbcUtils.getConnectionMySQL().prepareCall("{ call usp_ConsultaEncuesta(?) }");
		        cstmt.setInt(1, codReserva);
		        rs = cstmt.executeQuery();
		        int rowsAffected = 0;
        // Protects against lack of SET NOCOUNT in stored prodedure
		       
		        while (rs.next()) {
		            Calificacion calificacion = new Calificacion();
		            		calificacion.setCal_cod(rs.getInt("cal_cod"));
		            		calificacion.setCod_reserva(rs.getInt("cod_reserva"));
		            		calificacion.setCal_fecha_ini(rs.getDate("cal_fecha_ini"));
		            		calificacion.setCal_fecha_fin(rs.getDate("cal_fecha_fin"));
		            		calificacion.setCal_preg1(rs.getString("cal_preg01"));
		            		calificacion.setCal_preg2(rs.getString("cal_preg02"));
		            		calificacion.setCal_estado(rs.getInt("cal_estado"));
		               calificaciones.add(calificacion);
		        }
		        rs.close();
		        cstmt.close();
		        
		    } catch (Exception ex) {
		    	ex.printStackTrace();
		        
		    } 
		    return calificaciones;
        }
	
public List<Calificacion> getCalificacionList(){
	
		logger.debug("recuperar todas las personas");
		
		String qry = "SELECT * From tb_calificacion";
		Statement cstmt = null;
		ResultSet rs = null;
		
		//JdbcUtils formatter = new JdbcUtils();
		//GregorianCalendar date1 = new GregorianCalendar();

         //date1.setTime(formatter.fromStringToDate("01-12-2012"));	//'dd-mm-aaaa'
         //XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(date1);
		
		    try {
		        //con sqlServer
		    	//cstmt = JdbcUtils.getConnectionMSSQL().createStatement();
		        //con mysql
		    	cstmt = JdbcUtils.getConnectionMySQL().createStatement();	
		        rs = cstmt.executeQuery(qry);
		        int rowsAffected = 0;
        // Protects against lack of SET NOCOUNT in stored prodedure
	             while (rs.next()) {
		        	        Calificacion calificacion = new Calificacion();
		            		calificacion.setCal_cod(rs.getInt("cal_cod"));
		            		calificacion.setCod_reserva(rs.getInt("cod_reserva"));
		            		calificacion.setCal_fecha_ini(rs.getDate("cal_fecha_ini"));
		            		calificacion.setCal_fecha_fin(rs.getDate("cal_fecha_fin"));
		            		calificacion.setCal_preg1(rs.getString("cal_preg01"));
		            		calificacion.setCal_preg2(rs.getString("cal_preg02"));
		            		calificacion.setCal_estado(rs.getInt("cal_estado"));
		            		calificacionesList.add(calificacion);
		        }
		        rs.close();
		        cstmt.close();
		        
		    } catch (Exception ex) {
		    	ex.printStackTrace();
		        
		    } 
		    return calificacionesList;
	
        }

/**
 * Editar encuesta
 */
public Boolean edit(Calificacion calificacion) {
	logger.debug("Editing person with id: " + calificacion.getCal_cod());
	
	try {
		for (Calificacion p:calificaciones) {
			if (p.getCal_cod() == calificacion.getCal_cod()) {
				logger.debug("Found record");
				calificaciones.remove(p);
				calificaciones.add(calificacion);
				return true;
			}
		}
		
		logger.debug("No records found");
		return false;
		
	} catch (Exception e) {
		logger.error(e);
		return false;
	}
}

}
