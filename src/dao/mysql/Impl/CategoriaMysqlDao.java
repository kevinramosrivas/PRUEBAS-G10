/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql.Impl;

import Modelo.Categoria;
import dao.interfaces.ICategoriaDao;
import dao.mysql.conexion.ConexionMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Frank Pizarro
 */
public class CategoriaMysqlDao extends ConexionMysql implements ICategoriaDao {

    @Override
    public Categoria devolverCategoria(String nombreCategoria) throws Exception {
        
        Categoria cat = new Categoria(null);
        try
        {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from Categoria where nombreCategoria = (?)");
            st.setString(1, nombreCategoria);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                cat.setIdCategoria(rs.getInt("idCategoria"));
                cat.setNombreCategoria(rs.getString("nombreCategoria"));
            }
            st.close();
            rs.close();
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return cat;
    }
    
}
