/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.servicio;

import cc.nuvu.api.dao.ClienteDao;
import cc.nuvu.api.dao.ImpCliente;
import cc.nuvu.api.modelo.Cliente;
import java.util.List;

/**
 *
 * @author Yio
 */
public class ImpServicioCliente implements ServicioCliente {

    ClienteDao clienteDao = new ImpCliente();

    @Override
    public boolean agregar(Cliente cliente) {
        //String passNocifrada = cliente.getContrasena();
        //String passCifrada = ContrasenaHash.md5(passNocifrada);
        //cliente.setContrasena(passCifrada);
        
        boolean respuesta = clienteDao.anadir(cliente);
        return respuesta;
    }

    @Override
    public boolean modificar(String nombre, String apellido, long telefono, String contrasena, long cedula) {
        Cliente cliente = buscarCliente(cedula);
        boolean respuesta = false;
        if (cliente != null) {
            cliente.setNombre(nombre);
            cliente.setApellidos(apellido);
            cliente.setTelefono(telefono);
            cliente.setContrasena(contrasena);
            cliente.setCedula(cliente.getCedula());
            respuesta = clienteDao.modificar(cliente);
            return respuesta;
        }
        return respuesta;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> lista = clienteDao.listar();
        return lista;
    }

    @Override
    public Cliente buscarCliente(long cedula) {
        Cliente cliente = clienteDao.buscar(cedula);
        return cliente;
    }

    @Override
    public boolean login(String user, String contrasena) {
        boolean respuesta = clienteDao.login(user, contrasena);
        return respuesta;
    }

    
}
