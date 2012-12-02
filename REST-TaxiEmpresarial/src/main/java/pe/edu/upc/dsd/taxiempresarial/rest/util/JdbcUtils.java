package pe.edu.upc.dsd.taxiempresarial.rest.util;

import java.sql.Connection;
//import java.sql.Date;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import java.sql.ResultSetMetaData;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

//import com.microsoft.sqlserver.jdbc.*;


public class JdbcUtils {

  	//private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  	
  	//para MySQL
  	private static final String DRIVER = "com.mysql.jdbc.Driver";

  	public static Connection getConnectionMSSQL() {
        Connection connection = null;
        try {
          //Class.forName(DRIVER).newInstance();
          //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver() );
          connection = DriverManager.getConnection("jdbc:sqlserver://MTC30:1433;databaseName=TAXY_EMP","sa","admin");
         /*  SQLServerDataSource ds = new SQLServerDataSource();
           ds.setUser("sa");
           ds.setPassword("admin");
           ds.setServerName("MTC30");
           ds.setPortNumber(1433);
           ds.setDatabaseName("TAXY_EMP");
           connection = ds.getConnection();    */  
           
           System.out.println ("Connection successful");
        } catch (Exception e) {
            throw new IllegalStateException("Error al obtener Connectionf",e);
        }
        return connection;
       
    }
  	
  	public static Connection getConnectionMySQL() {
        Connection connection = null;
        try {
           Class.forName(DRIVER).newInstance();
           connection = DriverManager.getConnection("jdbc:mysql://localhost/taxiempresarial","root","admin");
           System.out.println ("Connection successful");
        } catch (Exception e) {
            throw new IllegalStateException("Error al obtener Connectionf",e);
        }
        return connection;
       
    }
  	
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error al cerrar Connection", e);
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error al cerrar Statement", e);
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error al cerrar ResultSet", e);
        }
    }
    
    public static synchronized java.util.Date fromStringToDate(String date)
    {
       SimpleDateFormat formatOfText = new SimpleDateFormat("dd-MM-yyyy");
       Date dateToSend = null;
       
       try {
           dateToSend = formatOfText.parse(date);
           return dateToSend;
       } catch (ParseException ex) {
           ex.printStackTrace();
           return null;
       }
    }
}
