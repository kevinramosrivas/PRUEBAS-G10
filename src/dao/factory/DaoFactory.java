
package dao.factory;

import dao.mysql.Impl.ProductoMysqlDao;
import dao.mysql.Impl.ClienteMysqlDao;
import dao.mysql.Impl.PagoMysqlDao;
import dao.mysql.Impl.OrdenCompraMysqlDao;
import dao.interfaces.*;
import dao.mysql.Impl.CategoriaMysqlDao;
import dao.mysql.Impl.TicketVirtualMysqlDao;
import dao.sqlserver.Impl.ClienteSQLSERVERDao;
import dao.sqlserver.Impl.OrdenCompraSQLSERVERDao;
import dao.sqlserver.Impl.PagoTarjetaSQLSERVERDao;
import dao.sqlserver.Impl.ProductoSQLSERVERDao;

public class DaoFactory {
    
    private static DaoFactory daoFac = new DaoFactory();

    public static DaoFactory getinstance()
    {
        return daoFac;
    }
    
    public IClienteDao getClienteDao(String nombreBaseDatos)
    {
        if(nombreBaseDatos.equals("mysql"))
        {
            return new ClienteMysqlDao();
        }
        else if(nombreBaseDatos.equals("sqlserver"))
        {
            return new ClienteSQLSERVERDao();
        }
        else
        {
            return null;
        }
        
    }
    
    public IOrdenCompraDao getOrdenCompraDao(String nombreBaseDatos)
    {
        if(nombreBaseDatos.equals("mysql"))
        {
            return new OrdenCompraMysqlDao();
        }
        else if(nombreBaseDatos.equals("sqlserver"))
        {
            return new OrdenCompraSQLSERVERDao();
        }
        else
        {
            return null;
        }
            
        
    }
    
    public IPagoDao getPagoDao(String nombreBaseDatos)
    {
        if(nombreBaseDatos.equals("mysql"))
        {
            return new PagoMysqlDao();
        }
        else if(nombreBaseDatos.equals("sqlserver"))
        {
            return new PagoTarjetaSQLSERVERDao();
        }
        else
        {
            return null;
        }
            
        
    }
    
    public IProductoDao getProductoDao(String nombreBaseDatos)
    {
        if(nombreBaseDatos.equals("mysql"))
        {
            return new ProductoMysqlDao();
        }
        else if(nombreBaseDatos.equals("sqlserver"))
        {
            return new ProductoSQLSERVERDao();
        }
        else
        {
            return null;
        }
    }
    
    public ICategoriaDao getCategoriaDao(String nombreBaseDatos)
    {
        if(nombreBaseDatos.equals("mysql"))
        {
            return new CategoriaMysqlDao();
        }
        /*else if(nombreBaseDatos.equals("sqlserver"))
        {
            return new ProductoSQLSERVERDao();
        }*/
        else
        {
            return null;
        }
    }
    
    public ITicketVirtualDao getTicketVirtualDao(String nombreBaseDatos)
    {
        if(nombreBaseDatos.equals("mysql"))
        {
            return new TicketVirtualMysqlDao();
        }
        /*else if(nombreBaseDatos.equals("sqlserver"))
        {
            return new ProductoSQLSERVERDao();
        }*/
        else
        {
            return null;
        }
    }
    
    
    
}
