/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.dao;
 
import cc.nuvu.api.modelo.Cliente;
import java.util.List;


/**
 *
 * @author Yio
 */
public interface ClienteDao extends CRUD<Cliente> {
    
    boolean login(String usuario, String Contraseña);

}
