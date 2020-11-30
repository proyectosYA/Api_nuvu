/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.modelo;
 

/**
 *
 * @author Yio
 */
public class Tarjeta {

    private int IdTarjeta;
    private String fechaVencimiento;
    private String numeroTarjeta;
    private int cvv;
    private String nombre;
    private long identificacion;

    public int getIdTarjeta() {
        return IdTarjeta;
    }

    public void setIdTarjeta(int IdTargeta) {
        this.IdTarjeta = IdTargeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

}
