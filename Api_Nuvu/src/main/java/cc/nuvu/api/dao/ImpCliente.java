/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.dao;

import cc.nuvu.api.conexion.Conexion;
import cc.nuvu.api.modelo.Cliente; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yio
 */
public class ImpCliente implements ClienteDao {

    private final String ANADIR = "INSERT INTO cliente (cedula,nombre,apellidos,"
            + "telefono,usuario,contrasena)VALUES (?,?,?,?,?,?)";
    private final String MODIFICAR = "UPDATE cliente SET nombre =?, apellidos=?, telefono=?"
            + ",contrasena=? WHERE cedula = ?";
    private final String BUSCAR = "SELECT * FROM cliente WHERE cedula = ?";
    private final String LISTAR = "SELECT * FROM cliente";

    private final String LOGIN = "SELECT usuario, contrasena FROM cliente WHERE usuario = ? AND contrasena=?";

    private static final Conexion CONEXION = Conexion.estadoConexion();

    @Override
    public boolean anadir(Cliente object) {

        try {
            PreparedStatement ps = CONEXION.getConexion().prepareStatement(ANADIR);
            ps.setLong(1, object.getCedula());
            ps.setString(2, object.getNombre());
            ps.setString(3, object.getApellidos());
            ps.setLong(4, object.getTelefono());
            ps.setString(5, object.getUsuario());
            ps.setString(6, object.getContrasena());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImpCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean modificar(Cliente object) {
        try {
            PreparedStatement ps = CONEXION.getConexion().prepareStatement(MODIFICAR);

            ps.setString(1, object.getNombre());
            ps.setString(2, object.getApellidos());
            ps.setLong(3, object.getTelefono());
            ps.setString(4, object.getContrasena());
            ps.setLong(5, object.getCedula());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImpCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.cerrarConexion();
        }
        return false;
    }

    @Override
    public Cliente buscar(long key) {
        Cliente c = null;
        try {

            PreparedStatement ps = CONEXION.getConexion().prepareStatement(BUSCAR);
            ps.setLong(1, key);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                c = new Cliente();
                c.setCedula(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setTelefono(rs.getInt(4));
                c.setUsuario(rs.getString(5));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ImpTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.cerrarConexion();
        }
        return c;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList();
        try {
            PreparedStatement ps = CONEXION.getConexion().prepareStatement(LISTAR);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCedula(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setTelefono(rs.getInt(4));
                c.setUsuario(rs.getString(5));
                lista.add(c);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ImpTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.cerrarConexion();
        }
        return lista;
    }

    @Override
    public boolean login(String usuario, String contrasena) {
        Cliente cLogin = new Cliente(); 
        try {
            PreparedStatement ps = CONEXION.getConexion().prepareStatement(LOGIN);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) { 
                cLogin.setUsuario(rs.getString(1));
                cLogin.setContrasena(rs.getString(2));
            }
            
            
            if (cLogin.getUsuario().equals(usuario) && cLogin.getContrasena().equals(contrasena)) {
                return true;
            }
        } catch (SQLException ex ){
            Logger.getLogger(ImpCliente.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch(NullPointerException e){
            return false;
        }finally {
            CONEXION.cerrarConexion();
        } 
        return false;
    }

}
