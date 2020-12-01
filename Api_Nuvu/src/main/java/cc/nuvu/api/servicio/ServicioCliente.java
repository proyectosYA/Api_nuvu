/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.servicio;

import cc.nuvu.api.modelo.Cliente;
import java.util.List;

/**
 *
 * @author Yio
 */
public interface ServicioCliente {

    boolean agregar(Cliente cliente);

    boolean modificar(String nombre, String apellido, long telefono, String contrasena, long cedula);

    List<Cliente> listar();

    Cliente buscarCliente(long cedula);

    boolean login(String user, String contrasena);

}
