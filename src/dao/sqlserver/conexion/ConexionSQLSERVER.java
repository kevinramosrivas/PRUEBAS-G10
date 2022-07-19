
package dao.sqlserver.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionSQLSERVER {
    
    
    protected Connection conexion;
    
    private final String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String Url = "jdbc:sqlserver://LAPTOP-1NPUD8BP\\MSSQLSERVER:1433;database=cafeteriaunmsm";
    
    private final String Usuario = "sa";
    private final String password = "resident159";
    
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
