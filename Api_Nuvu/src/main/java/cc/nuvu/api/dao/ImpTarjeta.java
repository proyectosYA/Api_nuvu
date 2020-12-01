/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.dao;

import cc.nuvu.api.conexion.Conexion;
import cc.nuvu.api.modelo.Tarjeta;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yio
 */
public class ImpTarjeta implements TarjetaDao {

    private final String ANADIR = "INSERT INTO tarjeta (fechaVencimiento,"
            + "numeroTargeta,cvv,nombre,identificacion)VALUES (?,?,?,?,?)";

    private final String MODIFICAR = "UPDATE tarjeta SET nombre =? WHERE identificacion = ?";
    private final String BUSCAR = "SELECT * FROM tarjeta WHERE identificacion = ?";
    private final String LISTAR = "SELECT * FROM tarjeta";

    private static final Conexion CONEXION = Conexion.estadoConexion();

    @Override
    public boolean anadir(Tarjeta object) {
        
         
        try {
            PreparedStatement ps = CONEXION.getConexion().prepareStatement(ANADIR);
            ps.setString(1, object.getFechaVencimiento());
            ps.setString(2, object.getNumeroTarjeta());
            ps.setInt(3, object.getCvv());
            ps.setString(4, object.getNombre());
            ps.setLong(5, object.getIdentificacion());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImpTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean modificar(Tarjeta object) {

        try {
            PreparedStatement ps = CONEXION.getConexion().prepareStatement(MODIFICAR);
            ps.setString(1, object.getNombre());
            ps.setLong(2, object.getIdentificacion());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImpTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        }
        return false;
    }

    @Override
    public Tarjeta buscar(long key) {
        Tarjeta t = null;
        try {

            PreparedStatement ps = CONEXION.getConexion().prepareStatement(BUSCAR);
            ps.setLong(1, key);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                t = new Tarjeta();
                t.setIdTarjeta(rs.getInt(1));
                t.setFechaVencimiento(rs.getString(2));
                t.setNumeroTarjeta(rs.getString(3));
                t.setCvv(rs.getInt(4));
                t.setNombre(rs.getString(5));
                t.setIdentificacion(rs.getInt(6));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ImpTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        }
        return t;
    }

    @Override
    public List<Tarjeta> listar() {
        List<Tarjeta> lista = new ArrayList();
        try {
            PreparedStatement ps = CONEXION.getConexion().prepareStatement(LISTAR);
            ResultSet rs = ps.executeQuery();  
            while (rs.next()) {
                Tarjeta t = new Tarjeta();
                //t.setIdTarjeta(rs.getInt(1));
                t.setFechaVencimiento(rs.getString(2));
                t.setNumeroTarjeta(rs.getString(3));
                t.setCvv(rs.getInt(4));
                t.setNombre(rs.getString(5));
                t.setIdentificacion(rs.getInt(6));
                lista.add(t); 
            }
            ps.close(); 
             rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ImpTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            CONEXION.cerrarConexion();
        }
        return lista;
    }

}
