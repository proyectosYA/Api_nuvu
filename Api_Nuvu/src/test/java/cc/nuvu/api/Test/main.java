/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.nuvu.api.Test;

import cc.nuvu.api.dao.ClienteDao;
import cc.nuvu.api.dao.ImpCliente;
import cc.nuvu.api.modelo.Cliente;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Yio
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LocalDate diaSolicitudTarjeta = LocalDate.now();
        LocalDate localDate = diaSolicitudTarjeta.plusYears(8);
        String fechaVencimiento = localDate.format(DateTimeFormatter.ISO_DATE);

        //---------------------CVV---------------------
        StringBuilder cvv = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int numero = (int) (Math.random() * 9 + 1);
            cvv.append(numero);
        }
            String codigoCvv = cvv.substring(0, 4); 
        //--------------------------------------------
        //-------------------TARGETA---------------------
        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int numero = (int) (Math.random() * 9 + 1); 
            sB.append(numero); 
            
        }  
        
        //-----------------------------------------------

        
        ClienteDao cli = new ImpCliente();
       
        boolean respuesta = cli.login("pedrinchi", "qerty1");
        
        if(respuesta){
            System.out.println("existe usuario");
        }else{
            System.out.println("no existe usuario");
        }
        
    }

}
