
package Config;

import java.sql.*;

public class Conexion {
    Connection con;
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/desarrolloweb", "root", "");
        } catch (Exception e){
            System.err.println("Error "+e);
        }
    }
    public Connection getConnection(){
        return con;
    }
}
