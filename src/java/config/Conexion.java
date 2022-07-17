
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author CristhianACER
 */
public class Conexion {
    Connection con;
    String user="root";
    String pass="";
    String host="localhost";
    String port="3306";
    String database="bd_ventas";
    String classname="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://"+host+":"+port+"/"+database;
    
    //Investiga, debe haber alguna clase que agarre el url de forma dinamica
    //esto servirá cuando se pase al host
    public Connection Conexion() throws SQLException, ClassNotFoundException{
        Connection con = null; 
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
        return con;
    }
   
}
