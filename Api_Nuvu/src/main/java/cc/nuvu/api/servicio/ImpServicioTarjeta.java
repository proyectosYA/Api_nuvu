/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.servicio;

import cc.nuvu.api.dao.ImpCliente;
import cc.nuvu.api.dao.ImpTarjeta;
import cc.nuvu.api.dao.TarjetaDao;
import cc.nuvu.api.modelo.Tarjeta;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Yio
 */
public class ImpServicioTarjeta implements ServicioTarjeta {

    TarjetaDao tarjetaDao = new ImpTarjeta();

    @Override
    public boolean agregar(String nombre, long cedula) {

        Tarjeta tarjetaActivaCliente = buscarUsuarioTargeta(cedula);

        if (tarjetaActivaCliente != null) {
            return false;
        }
        StringBuilder generaTargeta = new StringBuilder();
        StringBuilder cvv = new StringBuilder();
        Tarjeta tarjetaModelo = new Tarjeta();
        String numeroTarjeta;

        //--------------genero codigo cvv------------- 
        for (int i = 0; i < 4; i++) {
            int numeroCvv = (int) (Math.random() * 9 + 1);
            cvv.append(numeroCvv);
        }
        String codigoCvv = cvv.substring(0, 4);
        //--------------genero numero targeta --------
        for (int i = 0; i < 16; i++) {
            int numeroAleatorio = (int) (Math.random() * 9 + 1);
            generaTargeta.append(numeroAleatorio);
        }
        numeroTarjeta = generaTargeta.substring(0, 16);

        //-----------fecha vencimiento targeta---------
        LocalDate diaSolicitudTarjeta = LocalDate.now();
        LocalDate localDate = diaSolicitudTarjeta.plusYears(8);
        String fechaVencimiento = localDate.format(DateTimeFormatter.ISO_DATE);

        //-----------info targeta-------------------
        tarjetaModelo.setFechaVencimiento(fechaVencimiento);
        tarjetaModelo.setCvv(Integer.parseInt(codigoCvv));
        tarjetaModelo.setNumeroTarjeta(numeroTarjeta);
        tarjetaModelo.setNombre(nombre);
        tarjetaModelo.setIdentificacion(cedula);

        boolean respuesta = tarjetaDao.anadir(tarjetaModelo);

        return respuesta;
    }

    @Override
    public List<Tarjeta> listar() {
        List<Tarjeta> lista = tarjetaDao.listar();
        return lista;
    }

    @Override
    public Tarjeta buscarUsuarioTargeta(long cedula) {
        Tarjeta tarjeta = tarjetaDao.buscar(cedula);
        return tarjeta;
    }

    @Override
    public boolean modificar(String nombre, long cedula) {
         
        Tarjeta usuarioTarjeta = buscarUsuarioTargeta(cedula);
        if (usuarioTarjeta != null) {
            Tarjeta tarjeta = new Tarjeta();
            tarjeta.setNombre(nombre);
            tarjeta.setIdentificacion(cedula);

             boolean respuesta = tarjetaDao.modificar(tarjeta);
             return respuesta;
        }

        return false;
    }

}
