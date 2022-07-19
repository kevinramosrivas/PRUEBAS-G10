
package dao.mysql.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionMysql {
    
    protected Connection conexion;
    
    private final String Driver = "com.mysql.cj.jdbc.Driver";
    private final String Url = "jdbc:mysql://localhost:3307/restaurante";
    
    private final String Usuario = "root";
    private final String password = "mosquito25";
    
    public void conectar() throws Exception
    {
        try
        {
            conexion = (Connection) DriverManager.getConnection(Url, Usuario, password);
            Class.forName(Driver);
            
        }
        catch(Exception e)
        {
            throw e; 
        }
    }
    
    public void desconectar() throws SQLException 
    {
        if(conexion!=null)
        {
            if(!conexion.isClosed())
            {
                conexion.close();
            }
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    
}
