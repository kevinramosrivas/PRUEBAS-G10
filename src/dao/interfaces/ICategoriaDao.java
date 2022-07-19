/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import Modelo.Categoria;

/**
 *
 * @author Frank Pizarro
 */
public interface ICategoriaDao {
    
    public Categoria devolverCategoria(String nombreCategoria) throws Exception;
}
