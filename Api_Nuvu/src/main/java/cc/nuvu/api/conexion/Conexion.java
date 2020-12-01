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

    private final String DATABASE_URL = "jdbc:postgresql://ec2-54-237-135-248.compute-1.amazonaws.com:5432/d8i5ajfgkvuobv";

    public static Conexion conexion;
    private Connection con;

    private Conexion(){
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DATABASE_URL, "jqktfptruqdjgl", "12f199914c104febd1b722f94c1ea2ec93ce67bbeebbbc2418920ac31bfebb15");
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
