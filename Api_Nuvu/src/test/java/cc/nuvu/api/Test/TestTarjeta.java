/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.Test;

import cc.nuvu.api.dao.ImpTarjeta;
import cc.nuvu.api.modelo.Cliente;
import cc.nuvu.api.modelo.Tarjeta;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import cc.nuvu.api.dao.TarjetaDao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import org.hamcrest.MatcherAssert;

/**
 *
 * @author Yio
 */
public class TestTarjeta {

    private TarjetaDao tarjetaDao;
    private Tarjeta tarjeta;

    @Before
    public void iniciar() {
        tarjetaDao = new ImpTarjeta();
        tarjeta = new Tarjeta();
    }

   /* 
    public void anadir() { 
        tarjeta.setNumeroTargeta("1234567809870987");
        tarjeta.setNombre("pedro");
        tarjeta.setCvv(3456);
        tarjeta.setIdentificacion(32122012);
        tarjeta.setFechaVencimiento("2020-11-15");

        boolean respuesta = tarjetaDao.anadir(tarjeta);
        
        Assert.assertTrue(respuesta);
    }
    
     
    public void modificar() {
         
        tarjeta.setNombre("Pedro"); 
        tarjeta.setIdentificacion(32122012);
         boolean respuesta = tarjetaDao.modificar(tarjeta);
        
        Assert.assertTrue(respuesta);
    }*/

    @Test
    public void buscarPorCedula() {
       Tarjeta t = tarjetaDao.buscar(32122012);
       Assert.assertNotNull(t);
    }

    @Test
    public void listar() {
        List<Tarjeta> lista = tarjetaDao.listar();
        MatcherAssert.assertThat(lista.isEmpty(), equalTo(false));
    }
    
    
}
