/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.Test;

import cc.nuvu.api.dao.ClienteDao;
import cc.nuvu.api.dao.ImpCliente;
import cc.nuvu.api.modelo.Cliente;
import java.util.List;
import junit.framework.Assert;
import static org.hamcrest.CoreMatchers.equalTo;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Yio
 */
public class TestCliente {

    private ClienteDao clienteDao;
    private Cliente cliente1;

    @Before
    public void inicio() {

        clienteDao = new ImpCliente();
        cliente1 = new Cliente();
    }

    //metodo que busca cliente por cedula
    @Test
    public void buscarCliente() {

        Cliente cliente1 = clienteDao.buscar(34543213);
        Assert.assertNotNull(cliente1);
    }

    @Test
    public void listar() {

        List<Cliente> lista = clienteDao.listar();
        MatcherAssert.assertThat(lista.isEmpty(), equalTo(false));
    }

    /* @Test
    public void anadir() {
        cliente1.setCedula(32122012);
        cliente1.setNombre("ramon");
        cliente1.setApellido("valdez");
        cliente1.setTelefono(318338732);
        cliente1.setUsuario("ramonV42");
        cliente1.setContrasena("Ramon456");
        
        boolean respuesta = clienteDao.anadir(cliente1);
        
        Assert.assertTrue(respuesta);
    }
    
    @Test
    public void modificar() { 
        cliente1.setNombre("Sofia");  
        cliente1.setUsuario("Sofi1342");
        cliente1.setContrasena("sofi202_007");
        
        boolean respuesta = clienteDao.anadir(cliente1);
        
        Assert.assertTrue(respuesta);
    }*/
    @Test
    public void login() {
        boolean respuesta = clienteDao.login("pedrinchi", "qwerty1");
        Assert.assertTrue(respuesta);
    }

}
