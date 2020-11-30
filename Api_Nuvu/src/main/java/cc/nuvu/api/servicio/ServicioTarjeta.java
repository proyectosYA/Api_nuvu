/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.servicio;

import cc.nuvu.api.modelo.Tarjeta;
import java.util.List;

/**
 *
 * @author Yio
 */
public interface ServicioTarjeta {

    public boolean agregar(String nombre, long cedula);

    public List<Tarjeta> listar();

    public Tarjeta buscarUsuarioTargeta(long cedula);

    public boolean modificar(String nombre, long cedula);
}
