/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yio
 */
public class Conexion {

    private final String URL = "jdbc:mysql://localhost:3306/nuvu_db";

    public static Conexion conexion;
    private Connection con;

    private Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, "root", "root");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Conexion estadoConexion() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    public Connection getConexion() {
        return con;
    }

    public void cerrarConexion() {
        conexion = null;
    }
}
